package servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import Bean.User;
import DB.DBdao;
import DB.DBdaoImpl;
@WebServlet(asyncSupported = true, urlPatterns = { "/getUser" })
public class getUser extends HttpServlet {
    
	private DBdao dao;//数据库操作
	private Gson gson;//gson对象
	public getUser() {
		dao = new DBdaoImpl();
		gson =new Gson();//创建gson,将字符串解析成javabean对象
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		response.setCharacterEncoding("utf-8");//防止输出中文乱码
		//变量
		User user =new User();//用户对象
		String ACTION = "";//用户动作
		PrintWriter pw = response.getWriter();
		// 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            //如果不是则执行普通方式 key -- values
    		user = gson.fromJson(request.getParameter("user"), User.class);
    		ACTION = request.getParameter("ACTION");//动作
    		System.out.println("ACTION"+ACTION);
        }
		//逻辑
		System.out.println("action:"+ACTION);
		//登录
		if(ACTION.equals("LOGIN")) {
			try {
				int oldaccount =user.getAccount();
		    	String oldpassword =user.getPassword();
		    	user = dao.findByaccAndpass(user);//新的user对象
				if(user.getAccount()==oldaccount&&user.getPassword().equals(oldpassword)) {
					//将用户完整信息返回
					user.setPassword("");//密码置空返回
					String gsonString = gson.toJson(user);
					System.out.println(gsonString);
					pw.write(gsonString);
				}
				else 
				{
					pw.write("loginfail");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//获取账号信息
		if(ACTION.equals("GETUSERBYTASK")) {
			try {
				user =dao.findByacc(user.getAccount());
				pw.println(gson.toJson(user));
				System.out.println("action:"+ACTION+gson.toJson(user));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//注册
		else if(ACTION.equals("REGISTER")) {
			try {
				User u =dao.findByacc(user.getAccount());
				boolean exists = false;
				if(u.getAccount()==0) {//账号不存在
					exists = true;					
				}
				System.out.println(exists);
				if (exists) {
					dao.add(user);//添加用户
					pw.write("successregister");
				}
				else {
					pw.write("exists");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		//完善或修改
		if (ServletFileUpload.isMultipartContent(request))  {
			int isupload =0;
			//检测为多媒体上传
			System.out.println("多媒体上传文件");
			FileItemFactory factory = new DiskFileItemFactory();//创建文件上传的工厂对象
			ServletFileUpload upload = new ServletFileUpload(factory);//文件上传解析器
//			Map<String,String> saveValues =new HashMap<String, String>();//存储非文件参数和值
			try {
				List<FileItem> lstForms;
				lstForms= (List<FileItem>) upload.parseRequest(request);
				String path=System.getProperty("catalina.home");//获取tomcat根目录位置
				for (FileItem fileItem : lstForms) {					
					if (fileItem.isFormField()) {
						// 判断每一个表单元素是否是普通表单,存储表单文件的值
						//客户端放在文件前，防止先获取的文件没有参数
//						saveValues.put(fileItem.getFieldName(),fileItem.getString("UTF-8"));	
						if(fileItem.getFieldName().equals("user")) {
							//处理上传的用户信息
							System.out.println(fileItem.getString("UTF-8"));
							user =gson.fromJson(fileItem.getString("UTF-8"), User.class);//防中文乱码
							user.setPath(path+"\\"+
							user.getPath().substring(user.getPath().lastIndexOf("/")+1));//获取文件名
							dao.update(user);
							isupload =1;
						}
					}
					else {
//						String path=this.getServletContext().getRealPath("/")+"files/";\
						fileItem.getFieldName();//获取key
						String filename = fileItem.getName();//获取文件名
						//第一种创建文件方式
//						File file =new File(path+filename); 
//						if(!file.exists()) {
//							file.createNewFile();
//						}
//						fileItem.write(file);
						//io流写入文件方式
						InputStream in =fileItem.getInputStream();//根据文件获取输入流
						BufferedInputStream bir = new BufferedInputStream(in);
						File dir = new File(path, "images");
						if (!dir.exists()) {
							dir.mkdirs();
						}
						// 存储目录
						byte[] bytes = new byte[4 * 1024];
						File file = new File(dir, filename);
						if (!file.exists()) {
							file.createNewFile();
						}
						FileOutputStream out = new FileOutputStream(file);
						int len = 0;
						while ((len = bir.read(bytes)) != -1) {
							out.write(bytes, 0, len);
							out.flush();
						}
						in.close();
						out.close();
						bir.close();
						fileItem.delete();//删除临时文件，防止缓冲区满
						if(isupload==1) {
							isupload=2;//当用户信息更改后
						}
						System.out.println("这是文件名："+filename+"这是存储路径："+path+"这是io流信息"+dir);
					}

				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(isupload==2) {
				pw.print("successperfect");
			}
		}
	}
	@Override
	public void destroy() {
		//回收资源
		try {
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
