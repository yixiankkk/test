package Deal;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class loginfilter
 */
@WebFilter("/loginfilter")
public class loginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("start filter");
		HttpServletRequest myrequest = (HttpServletRequest)request;
		//System.out.println(myrequest.getContextPath());
		//System.out.println(myrequest.getServletPath());
		System.out.println(myrequest.getRequestURI());
		String creqfullurl=myrequest.getRequestURI();

		if(creqfullurl.contains("Login-Main.jsp")||creqfullurl.contains("loginservlet")){
			chain.doFilter(request, response);
			return;
		}
		// 如果session能够取到，说明用户已经登录
		// 此处不新建session，只是去取已经创建的session
		HttpSession session = ((HttpServletRequest) request).getSession();
		String user = "";
		if (session != null) {
			System.out.println("1");
			user = (String) session.getAttribute("user");
			System.out.println("user:"+user);
			if (user == null || user.equals("")) {
				((HttpServletResponse) response).sendRedirect("/Homework_10/login/Login_main.jsp");
			} else {
				chain.doFilter(request, response);
				return;
			}
		}
		// 否则，说明用户没有登录，跳转到登录页面让用户登录
		else {
			((HttpServletResponse) response).sendRedirect("/Homework_10/login/Login_main.jsp");
			return;
		}
		// pass the request along the filter chain
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
