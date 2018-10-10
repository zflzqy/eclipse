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
    
	private DBdao dao;//���ݿ����
	private Gson gson;//gson����
	public getUser() {
		dao = new DBdaoImpl();
		gson =new Gson();//����gson,���ַ���������javabean����
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		response.setCharacterEncoding("utf-8");//��ֹ�����������
		//����
		User user =new User();//�û�����
		String ACTION = "";//�û�����
		PrintWriter pw = response.getWriter();
		// ����Ƿ�Ϊ��ý���ϴ�
        if (!ServletFileUpload.isMultipartContent(request)) {
            //���������ִ����ͨ��ʽ key -- values
    		user = gson.fromJson(request.getParameter("user"), User.class);
    		ACTION = request.getParameter("ACTION");//����
    		System.out.println("ACTION"+ACTION);
        }
		//�߼�
		System.out.println("action:"+ACTION);
		//��¼
		if(ACTION.equals("LOGIN")) {
			try {
				int oldaccount =user.getAccount();
		    	String oldpassword =user.getPassword();
		    	user = dao.findByaccAndpass(user);//�µ�user����
				if(user.getAccount()==oldaccount&&user.getPassword().equals(oldpassword)) {
					//���û�������Ϣ����
					user.setPassword("");//�����ÿշ���
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
		//��ȡ�˺���Ϣ
		if(ACTION.equals("GETUSERBYTASK")) {
			try {
				user =dao.findByacc(user.getAccount());
				pw.println(gson.toJson(user));
				System.out.println("action:"+ACTION+gson.toJson(user));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//ע��
		else if(ACTION.equals("REGISTER")) {
			try {
				User u =dao.findByacc(user.getAccount());
				boolean exists = false;
				if(u.getAccount()==0) {//�˺Ų�����
					exists = true;					
				}
				System.out.println(exists);
				if (exists) {
					dao.add(user);//����û�
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
		//���ƻ��޸�
		if (ServletFileUpload.isMultipartContent(request))  {
			int isupload =0;
			//���Ϊ��ý���ϴ�
			System.out.println("��ý���ϴ��ļ�");
			FileItemFactory factory = new DiskFileItemFactory();//�����ļ��ϴ��Ĺ�������
			ServletFileUpload upload = new ServletFileUpload(factory);//�ļ��ϴ�������
//			Map<String,String> saveValues =new HashMap<String, String>();//�洢���ļ�������ֵ
			try {
				List<FileItem> lstForms;
				lstForms= (List<FileItem>) upload.parseRequest(request);
				String path=System.getProperty("catalina.home");//��ȡtomcat��Ŀ¼λ��
				for (FileItem fileItem : lstForms) {					
					if (fileItem.isFormField()) {
						// �ж�ÿһ����Ԫ���Ƿ�����ͨ��,�洢���ļ���ֵ
						//�ͻ��˷����ļ�ǰ����ֹ�Ȼ�ȡ���ļ�û�в���
//						saveValues.put(fileItem.getFieldName(),fileItem.getString("UTF-8"));	
						if(fileItem.getFieldName().equals("user")) {
							//�����ϴ����û���Ϣ
							System.out.println(fileItem.getString("UTF-8"));
							user =gson.fromJson(fileItem.getString("UTF-8"), User.class);//����������
							user.setPath(path+"\\"+
							user.getPath().substring(user.getPath().lastIndexOf("/")+1));//��ȡ�ļ���
							dao.update(user);
							isupload =1;
						}
					}
					else {
//						String path=this.getServletContext().getRealPath("/")+"files/";\
						fileItem.getFieldName();//��ȡkey
						String filename = fileItem.getName();//��ȡ�ļ���
						//��һ�ִ����ļ���ʽ
//						File file =new File(path+filename); 
//						if(!file.exists()) {
//							file.createNewFile();
//						}
//						fileItem.write(file);
						//io��д���ļ���ʽ
						InputStream in =fileItem.getInputStream();//�����ļ���ȡ������
						BufferedInputStream bir = new BufferedInputStream(in);
						File dir = new File(path, "images");
						if (!dir.exists()) {
							dir.mkdirs();
						}
						// �洢Ŀ¼
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
						fileItem.delete();//ɾ����ʱ�ļ�����ֹ��������
						if(isupload==1) {
							isupload=2;//���û���Ϣ���ĺ�
						}
						System.out.println("�����ļ�����"+filename+"���Ǵ洢·����"+path+"����io����Ϣ"+dir);
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
		//������Դ
		try {
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
