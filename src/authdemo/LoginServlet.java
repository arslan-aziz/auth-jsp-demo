package authdemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		HttpSession session = req.getSession();
		
		//if the user has not logged in yet and has not entered the login form, redirect them to the form.
		//if the user has not logged in yet but has entered the login form, store their session data.
		//else the user has logged in so redirect them to welcome
		if(session.getAttribute("uname") == null && session.getAttribute("form") == null) {
			//redirect to form
			resp.sendRedirect("login.jsp");
		}
		else if(session.getAttribute("uname") == null){
			//store session
			String uname = req.getParameter("uname");
			session.setAttribute("uname", uname);
			resp.sendRedirect("welcome.jsp");
		}
		else {
			resp.sendRedirect("welcome.jsp");
		}
			
	}
}
