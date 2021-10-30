package Deal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Check.Scorecheck;
import dao.Scoredao;
import model.Score;

/**
 * Servlet implementation class AddScore
 */
@WebServlet("/AddScore")
public class AddScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddScore() {
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
		String existreturl = request.getContextPath() + "/StdInfo/score.jsp";// 记录存在，返回添加页面
		String addedreturl = request.getContextPath() + "/StdInfo/stdinfolist.jsp";// 记录添加成功，返回列表页面
		// 接收客户端请求参数
		try{
			int pk_score =Integer.parseInt(request.getParameter("pk_score"));
			String stdName = request.getParameter("stdName");
			String stdNo = request.getParameter("stdNo");
			String math_score = request.getParameter("math_score");
			String english_score = request.getParameter("english_score");
			String chinese_score = request.getParameter("chinese_score");
			String term = request.getParameter("select");
		
		
		// 检查上传、接收参数是否正确
		System.out.println("pk_score: " + pk_score);
		System.out.println("stdName: " + stdName);
		System.out.println("stdNo: " + stdNo);
		System.out.println("math_score: " + math_score);
		System.out.println("chinese_score: " + chinese_score);
		System.out.println("english_score: " + english_score);

		PrintWriter out = response.getWriter();
		//转换读入分数的类型
		Float Math_score=Float.parseFloat(math_score);
		Float Chinese_score=Float.parseFloat(chinese_score);
		Float English_score=Float.parseFloat(english_score);
		
		// 检查数据有效性
		Scorecheck mych = new Scorecheck();
		if (mych.checkstdScore(Math_score,Chinese_score,English_score) == 0) {
			System.out.println("Score: "+"超出成绩范围！");
			out.println("Score: "+"超出成绩范围！");
			String validurl = existreturl+"?pk_score="+pk_score+"&stdNo="+stdNo+"&stdName="+stdName+"&math_score="+math_score
					+"&english_score="+english_score+"&chinese_score="+chinese_score+"&term="+term;
			response.sendRedirect(validurl);
			return;
		}
		if(mych.checkstdName(stdName))
		{
			System.out.println("名字不能为空");
			out.println("名字不能为空");
			String validurl = existreturl+"?pk_score="+pk_score+"&stdNo="+stdNo+"&stdName="+stdName+"&math_score="+math_score
					+"&english_score="+english_score+"&chinese_score="+chinese_score+"&term="+term;
			response.sendRedirect(validurl);
			return;
		}

		Score myScore = new Score();
		myScore.setPk_score(pk_score);
		myScore.setStdNo(stdNo);
		myScore.setStdName(stdName);
		myScore.setMath_score(math_score);
		myScore.setChinese_score(chinese_score);
		myScore.setEnglish_score(english_score);
		myScore.setTerm(term);
		
		// 添加记录处理
		// 判断数据库表中是否有相同的记录，如果有，则返回前台，提示用户该记录已存在，如果没有，插入到数据表中。
		Scoredao mystddao = new Scoredao();
		int reCrdNumber;
		try {
			//reCrdNumber = mystddao.CheckRepeatRcd(stdNo, stdName,stdAge,stdMajor);
			reCrdNumber = mystddao.CheckRepeatRcd(myScore);
		} catch (Exception e1) {
			e1.printStackTrace();
			out.print("数据库操作失败！请与管理员联系。");
			return;
		}
		// 根据记录重复性检查结果进行处理
		if (reCrdNumber > 0) {
			//System.out.println("已存在相同记录!请重新录入数据。");
			out.print("<script language='javascript'>alert('已存在相同记录!请重新录入数据。');window.location.href='" + existreturl
					+ "';</script>");
			return;
		}
		// 当数据表中没有相同的记录时，向数据库表添加新记录
		boolean issuc = false;
		try {
			issuc = mystddao.addStdInfo(myScore);
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
		catch(Exception e)
		{
			System.out.println("数据输入有误，请重新输入！");
			response.sendRedirect(existreturl);
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
