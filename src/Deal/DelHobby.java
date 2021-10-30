package Deal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HobbyDao;
import dao.StudDao;

/**
 * Servlet implementation class DelHobby
 */
@WebServlet("/DelHobby")
public class DelHobby extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelHobby() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String StdNo = request.getParameter("stdNo");
		System.out.println(StdNo);

		PrintWriter out = response.getWriter();
		String returl = request.getContextPath() + "/StdInfo/Hobbylist.jsp";// 记录更新成功，返回列表页面

		boolean issuc=false;
		 HobbyDao myStdDao = new HobbyDao();
		try {
			issuc = myStdDao.DeleteStdInfo(StdNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//根据数据库操作结果进行处理，下面的不成功可以修改为跳转到错误提示页面。
		if (!issuc) {
			out.print("<script language='javascript'>alert('删除数据库记录操作失败！请与管理员联系。');window.location.href='"
					+ returl + "';</script>");
			return;
		} else {
			response.sendRedirect(returl);
			return;
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
