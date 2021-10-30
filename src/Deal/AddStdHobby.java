package Deal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Check.Mycheck;
import dao.HobbyDao;
import dao.StudDao;
import model.Hobby;
import model.Student;

/**
 * Servlet implementation class AddStdHobby
 */
@WebServlet("/AddStdHobby")
public class AddStdHobby extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStdHobby() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 接收客户端请求参数
		String StdName = request.getParameter("stdName");
		String StdNo = request.getParameter("stdNo");
		String Major = request.getParameter("Major");
		String Hobby = request.getParameter("Hobby");
		String stdAgeStr = request.getParameter("stdAge");
		String cstr = request.getParameter("c");
		int c=0;
		if(cstr!=null)
		{
			c=Integer.parseInt(cstr);
		}
		int stdAge=0;
		if(stdAgeStr!=null)
		{stdAge = Integer.parseInt(stdAgeStr);}
		// 检查上传、接收参数是否正确
		System.out.println("StdName: " + StdName);
		System.out.println("StdNo: " + StdNo);
		System.out.println("Major: " + Major);
		System.out.println("Hobby: " + Hobby);

		String existreturl = request.getContextPath() + "/StdInfo/AddHobby.jsp";// 记录存在，返回添加页面
		String addedreturl = request.getContextPath() + "/StdInfo/Hobbylist.jsp";// 记录添加成功，返回列表页面
		PrintWriter out = response.getWriter();
		// 检查数据有效性
		Hobby myHobby = new Hobby();
		myHobby.setStdNo(StdNo);
		myHobby.setStdName(StdName);
		myHobby.setMajor(Major);
		myHobby.setHobby(Hobby);
		
		Student myStudent =new Student();
		myStudent.setStdNo(StdNo);
		myStudent.setStdName(StdName);
		myStudent.setStdMajor(Major);
		myStudent.setStdAge(stdAge);
		// 添加记录处理
		// 判断学生数据库表中是否有相同的记录，如果有，则不进行操作，如果没有，则将学生信息插入到学生信息数据表中。
		HobbyDao myhobbydao = new HobbyDao();
		StudDao mystudao =new StudDao();
		if(c!=1)
		{
		int reCrdNumber1;
		int reCrdNumber2;
		try {
			//reCrdNumber = mystddao.CheckRepeatRcd(stdNo, stdName,stdAge,stdMajor);
			reCrdNumber1 = mystudao.CheckRepeatRcd(myStudent);
			reCrdNumber2 = myhobbydao.CheckRepeatRcd(myHobby);
		} catch (Exception e1) {
			e1.printStackTrace();
			out.print("数据库操作失败！请与管理员联系。");
			return;
		}
		// 根据记录重复性检查结果进行处理
		boolean issuc = false;
		try
		{
		//已存在相同记录	
		if(reCrdNumber2>0)
			return;
		if (reCrdNumber1 > 0)
		{
			System.out.println("已存在相同记录!不进行学生信息表数据插入。");
			issuc = myhobbydao.addStdInfo(myHobby);
		}
		
		// 当数据表中没有相同的记录时，向数据库表添加新记录
			// issuc = mystddao.addStdInfo(stdNo, stdName, stdAge, stdMajor);
		else
		{
			issuc = myhobbydao.addStdInfo(myHobby);
			issuc= mystudao.addStdInfo(myStudent);
		}

		}
		catch(Exception e)
		{
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
				issuc = myhobbydao.updateStdinfobyid(myHobby);
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
