package Deal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Check.Mycheck;
import dao.StudDao;
import model.Student;

/**
 * Servlet implementation class AddStdInfosvlt
 */
@WebServlet("/AddStdInfosvlt")
public class AddStdInfosvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStdInfosvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置环境变量
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");

				// 接收客户端请求参数
				String stdName = request.getParameter("stdName");
				String stdNo = request.getParameter("stdNo");
				String stdAgeStr = request.getParameter("stdAge");
				int stdAge = Integer.parseInt(stdAgeStr);
				String stdMajor = request.getParameter("stdMajor");
				String cstr = request.getParameter("c");
				int c=0;
				if(cstr!=null)
				{
					c=Integer.parseInt(cstr);
				}
				// 检查上传、接收参数是否正确
				System.out.println("stdName: " + stdName);
				System.out.println("stdNo: " + stdNo);
				System.out.println("stdAge: " + stdAge);
				System.out.println("stdMajor: " + stdMajor);
				System.out.println("c: " + c);
				String existreturl = request.getContextPath() + "/StdInfo/AddStdInfo.jsp";// 记录存在，返回添加页面
				String addedreturl = request.getContextPath() + "/StdInfo/stdinfolistModi.jsp";// 记录添加成功，返回列表页面
				PrintWriter out = response.getWriter();
				// 检查数据有效性
				Mycheck mych = new Mycheck();
				if (mych.checkstdAge(stdAge) == 0) {
					System.out.println("stdAge: " + stdAge + "超出学生年龄范围！");
					out.println("年龄: " + stdAge + "超出学生年龄范围10-25！");
					String validurl = existreturl+"?stdName="+stdName+"&stdNo="+stdNo;
					return;
				}

				Student myStudent = new Student();
				myStudent.setStdNo(stdNo);
				myStudent.setStdName(stdName);
				myStudent.setstdAge(stdAge);
				myStudent.setStdmajor(stdMajor);
				StudDao mystddao = new StudDao();
				if(c!=1){
				// 添加记录处理
				// 判断数据库表中是否有相同的记录，如果有，则返回前台，提示用户该记录已存在，如果没有，插入到数据表中。
				int reCrdNumber;
				try {
					//reCrdNumber = mystddao.CheckRepeatRcd(stdNo, stdName,stdAge,stdMajor);
					reCrdNumber = mystddao.CheckRepeatRcd(myStudent);
				} catch (Exception e1) {
					e1.printStackTrace();
					out.print("数据库操作失败！请与管理员联系。");
					return;
				}
				// 根据记录重复性检查结果进行处理
				if (reCrdNumber > 0) {
					System.out.println("已存在相同记录!请重新录入数据。");
					out.print("<script language='javascript'>alert('已存在相同记录!请重新录入数据。');window.location.href='" + existreturl
							+ "';</script>");
					return;
				}
				// 当数据表中没有相同的记录时，向数据库表添加新记录
				boolean issuc = false;
				try {
					// issuc = mystddao.addStdInfo(stdNo, stdName, stdAge, stdMajor);
					issuc = mystddao.addStdInfo(myStudent);
				} catch (Exception e) {
					e.printStackTrace();
					String errormsg=e.getMessage();
					//out.print("数据库操作失败！请与管理员联系。");
					out.print(errormsg+"<br>数据库操作失败！请与管理员联系。");
					return;
				}
				if (!issuc) {
					out.print("<script language='javascript'>alert('数据库添加记录操作失败！请与管理员联系。');window.location.href='" + existreturl
							+ "';</script>");
					return;
				} else {
					response.sendRedirect(addedreturl);
					return;
				}
			}
				else
				{
					boolean issuc = false;
					try {
						// issuc = mystddao.addStdInfo(stdNo, stdName, stdAge, stdMajor);
						issuc = mystddao.updateStdinfobyid(myStudent);
					} catch (Exception e) {
						e.printStackTrace();
						String errormsg=e.getMessage();
						//out.print("数据库操作失败！请与管理员联系。");
						out.print(errormsg+"<br>数据库操作失败！请与管理员联系。");
						return;
					}
					if (!issuc) {
						out.print("<script language='javascript'>alert('数据库添加记录操作失败！请与管理员联系。');window.location.href='" + existreturl
								+ "';</script>");
						return;
					} else {
						response.sendRedirect(addedreturl);
						return;
					}
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
