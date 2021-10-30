<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		request.setCharacterEncoding("utf-8");
		// 接收数据
		String pk_score = request.getParameter("pk_score");
		String pk_score1 = ""; 
		if (pk_score1 != null && !pk_score1.equals("")) {
			pk_score = new String(pk_score1.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}
		String stdName1 = request.getParameter("stdName");
		String stdName = "";
		if (stdName1 != null && !stdName1.equals("")) {
			stdName = new String(stdName1.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}
		String stdNo1 = request.getParameter("stdNo");
		String stdNo = "";
		if (stdNo1 != null && !stdNo1.equals("")) {
			stdNo = new String(stdNo1.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}
		String math_score1 = request.getParameter("math_score");
		String math_score = "";
		if (math_score1 != null && !math_score1.equals("")) {
			math_score = new String(math_score1.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}
		String english_score1 = request.getParameter("english_score");
		String english_score = "";
		if (english_score1 != null && !english_score1.equals("")) {
			english_score = new String(english_score1.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}
		String chinese_score1 = request.getParameter("chinese_score");
		String chinese_score = "";
		if (chinese_score1 != null && !chinese_score1.equals("")) {
			chinese_score = new String(chinese_score1.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}
	%>
<form action="/Homework_10/AddStdInfosvlt" method="post" name="Form"> <!--提交给本页处理-->
		序号：<%
					if (pk_score != null && !pk_score.equals("")) {
				%>
				<input type="text" name="pk_score" id="pk_score"
					value="<%=pk_score%>">
				<%
					} else {
				%>
				<input type="text" name="pk_score" id="pk_score">
				<%
					}
				%>
			
				<br/>
		姓名:<%
					if (stdName != null && !stdName.equals("")) {
				%>
				<input type="text" name="stdName" id="stdName"
					value="<%=stdName%>">
				<%
					} else {
				%>
				<input type="text" name="stdName" id="stdName">
				<%
					}
				%>
				<% 
				try{
					if(stdName!="")
						Integer.parseInt(stdName);	
					}
					catch(Exception e)
					{
						out.print("数据格式错误，请重新输入");
					}
				%>	
				<br/>
		学号:<%
					if (stdNo != null && !stdNo.equals("")) {
				%>
				<input type="text" name="stdNo" id="stdNo"
					value="<%=stdNo%>">
				<%
					} else {
				%>
				<input type="text" name="stdNo" id="stdNo">
				<%
					}
				%>
				<br/>
		请输入语文成绩：<%
					if (chinese_score != null && !chinese_score.equals("")) {
				%>
				<input type="text" name="chinese_score" id="chinese_score"
					value="<%=chinese_score%>">
				<%
					} else {
				%>
				<input type="text" name="chinese_score" id="chinese_score">
				<%
					}
				%>
				<%
					if(chinese_score!="")
						if(Integer.parseInt(chinese_score)<0||Integer.parseInt(chinese_score)>100)
							out.print("输入的数据不符合，请修改");
				%>	
				<br/>
		请输入数学成绩：<%
					if (math_score != null && !math_score.equals("")) {
				%>
				<input type="text" name="math_score" id="math_score"
					value="<%=math_score%>">
				<%
					} else {
				%>
				<input type="text" name="math_score" id="math_score">
				<%
					}
				%>
				<%
				if(math_score!="")	
				if(Integer.parseInt(math_score)<0||Integer.parseInt(math_score)>100)
						out.print("输入的数据不符合，请修改");
				%>	
				
				<br/>
		请输入英语成绩：<%
					if (english_score != null && !english_score.equals("")) {
				%>
				<input type="text" name="english_score" id="english_score"
					value="<%=english_score%>">
				<%
					} else {
				%>
				<input type="text" name="english_score" id="english_score">
				<%
					}
				%>
				<%
				if(english_score!="")		
				if(Integer.parseInt(english_score)<0||Integer.parseInt(english_score)>100)
						out.print("输入的数据不符合，请修改");
				%>	
				<br/>
		请选择学期：第
				<select name="select">
  				<option value="1">一</option>
  				<option value="2">二</option>
  				</select>
				 学期
			
				<br/>
		<input type="submit" value="输入" />	

		</form>
	<p id="input">
	</p>
</body>
</html>