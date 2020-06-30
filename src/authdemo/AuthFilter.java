package authdemo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/","/gallery.jsp","/welcome.jsp"})
public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		HttpSession session = httpReq.getSession();
		String pathInfo = ((HttpServletRequest) request).getServletPath();
		
		System.out.println();
		System.out.println(pathInfo);
		System.out.println("Hit Filter");
		System.out.println(session.getAttribute("uname"));
		
		
		if(session.getAttribute("uname") == null) {
			httpResp.sendRedirect("login");
			System.out.println("Redirecting to login");
		}
		else {
			System.out.println("filter pass");
			
			if(pathInfo.equals("/"))
				httpResp.sendRedirect("welcome.jsp");
			else
				chain.doFilter(request, response);
		}
		
	}
	
	
}
