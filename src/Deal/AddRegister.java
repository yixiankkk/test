package Deal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RegisterDao;
import model.User;

/**
 * Servlet implementation class AddRegister
 */
@WebServlet("/AddRegister")
public class AddRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRegister() {
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

		// 接收客户端请求参数
		String Uname = request.getParameter("Uname");
		String Upwd = request.getParameter("Upwd");
		// 检查上传、接收参数是否正确
		System.out.println("Uname: " + Uname);
		System.out.println("Upwd: " + Upwd);
		String addedreturl = request.getContextPath() + "/login/Login-main.jsp";// 记录添加成功，返回列表页面
		PrintWriter out = response.getWriter();
		// 检查数据有效性
		if (Upwd.equals(null)) {
			System.out.println("密码不能为空！！");
			out.println("密码不能为空！！");	
			return;
		}

		User myuser = new User();
		myuser.setUname(Uname);
		myuser.setUpwd(Upwd);
		// 添加记录处理
		// 判断数据库表中是否有相同的记录，如果有，则返回前台，提示用户该记录已存在，如果没有，插入到数据表中。
		RegisterDao mystddao = new RegisterDao();
		int reCrdNumber;
		try {
			//reCrdNumber = mystddao.CheckRepeatRcd(stdNo, stdName,stdAge,stdMajor);
			reCrdNumber = mystddao.CheckRepeatRcd(myuser);
		} catch (Exception e1) {
			e1.printStackTrace();
			out.print("数据库操作失败！请与管理员联系。");
			return;
		}
		// 根据记录重复性检查结果进行处理
		if (reCrdNumber > 0) {
			System.out.println("已存在相同记录!请重新录入数据。");
			out.print("<script language='javascript'>alert('已存在相同记录!请重新录入数据。');</script>");
			return;
		}
		// 当数据表中没有相同的记录时，向数据库表添加新记录
		boolean issuc = false;
		try {
			// issuc = mystddao.addStdInfo(stdNo, stdName, stdAge, stdMajor);
			issuc = mystddao.addStdInfo(myuser);
		} catch (Exception e) {
			e.printStackTrace();
			String errormsg=e.getMessage();
			//out.print("数据库操作失败！请与管理员联系。");
			out.print(errormsg+"<br>数据库操作失败！请与管理员联系。");
			return;
		}
		if (!issuc) {
			out.print("<script language='javascript'>alert('数据库添加记录操作失败！请与管理员联系。');window.location.href='" + addedreturl
					+ "';</script>");
			return;
		} else {
			out.print("<script language='javascript'>alert('注册成功。');window.location.href='" + addedreturl
					+ "';</script>");
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
