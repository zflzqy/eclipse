package servert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getInitparam
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/getInitparam" },
		initParams= 
		{
			@WebInitParam(name="name",value="zfl"),
			@WebInitParam(name="password",value="123456")
		}
)
public class getInitparam extends HttpServlet {
	private String name;
	private String password;
	
	    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
		public getInitparam() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw =response.getWriter();
		pw.println("”√ªß√˚£∫"+this.getName());
		pw.print("<br>");
		pw.println("√‹¬Î£∫"+this.getPassword());
	}
	@Override
	public void init() throws ServletException {
		this.setName(this.getInitParameter("name"));
		this.setPassword(this.getInitParameter("password"));
	}

}
