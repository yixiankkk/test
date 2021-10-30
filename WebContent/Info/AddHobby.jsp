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
		String stdNameStr = request.getParameter("stdName");
		String stdName = "";
		if (stdNameStr != null && !stdNameStr.equals("")) {
			stdName = new String(stdNameStr.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}
		String stdNoStr = request.getParameter("stdNo");
		String stdNo = "";
		if (stdNameStr != null && !stdNoStr.equals("")) {
			stdNo = new String(stdNoStr.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}

		String MajorStr = request.getParameter("Major");
		String Major = "";
		if (MajorStr != null && !MajorStr.equals("")) {
			Major = new String(MajorStr.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}
		String HobbyStr = request.getParameter("Hobby");
		String Hobby = "";
		if (HobbyStr != null && !HobbyStr.equals("")) {
			Hobby = new String(HobbyStr.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}
		String stdAgeStr = request.getParameter("stdAge");
		String stdAge = "";
		if (stdAgeStr != null && !stdAgeStr.equals("")) {
			stdAge = new String(stdAgeStr.getBytes("ISO-8859-1"), "utf-8");//转码，防止出现中文乱码
		}
	%>
	<form id="formStd" name="formStd" method="post"
		action="<%=request.getContextPath()%>/AddStdHobby">
		<table width="367" border="1">
			<tr>
				<td align="right">学号</td>
				<%
					if (stdNo != null && !stdNo.equals("")) {
				%>
				<td><input type="text" name="stdNo" id="stdNo"
					value="<%=stdNo%>"></td>
				<%
					} else {
				%>
				<td><input type="text" name="stdNo" id="stdNo"></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td align="right" width="80">姓名</td>
				<%
					if (stdName != null && !stdName.equals("")) {
				%>
				<td width="160"><input type="text" name="stdName" id="stdName"
					value="<%=stdName%>" /></td>
				<%
					} else {
				%>
				<td width="160"><input type="text" name="stdName" id="stdName" /></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td align="right">兴趣</td>
				<%
					if (HobbyStr != null && !HobbyStr.equals("")) {
				%>
				<td><input type="text" name="Hobby" id="Hobby"
					value="<%=Hobby%>" /></td>
				<%
					} else {
				%>
				<td><input type="text" name="Hobby" id="Hobby" /></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td align="right">专业</td>
				<%
					if (Major != null && !Major.equals("")) {
				%>
				<td><input type="text" name="Major" id="Major"
					value="<%=Major%>" /></td>
				<%
					} else {
				%>
				<td><input type="text" name="Major" id="Major" /></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td align="right">年龄</td>
				<%
					if (stdAgeStr != null && !stdAgeStr.equals("")) {
				%>
				<td><input type="text" name="stdAge" id="stdAge"
					value="<%=stdAge%>" /></td>
				<%
					} else {
				%>
				<td><input type="text" name="stdAge" id="stdAge" /></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					name="stdsave" id="stdsave" value="保存" onclick='mycheck()' /></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		function mycheck() {
			var af = document.formStd;
			var stdNoCtl = document.getElementById("stdNo");
			var stdNoV = stdNoCtl.value;
			stdNoV = trimStr(stdNoV);
			if (stdNoV == "") {
				alert("学号不为空");
				stdNoCtl.value = "";//清空空格
				stdNoCtl.focus();
				return;
			}

			af.submit();
		}

		function trimStr(str) {
			return str.replace(/(^\s*)|(\s*$)/g, "");
		}
	</script>
</body>
</html>