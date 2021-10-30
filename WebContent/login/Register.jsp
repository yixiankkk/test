<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</style> 
  <link rel="stylesheet" href="SignUpStyle.css">
  <style type="text/css">
  body{text-align:center;} 
.divcss1{margin:0 auto;} 
  body {
  background: darkslategrey;
  font-family: sans-serif;
}
 
.mainbody {
  height: 440px;
  width: 400px;
}
 
/*居中效果*/
.middle {
  /*使左上角对应到父元素的中心*/
  top: 50%;
  left: 50%;
  position: absolute;
  /*向左向上偏移50%*/
  transform: translate(-50%, -50%);
}
 
.form-box {
  width: 100%;
  height: 100%;
  margin: auto;
  background: darkcyan;
  /* 我觉得这个圆角大小刚刚好 */
  border-radius: 40px;
}
 
.input-normal {
  width: 220px;
  height: 38px;
  margin: 30px auto;
  padding: 0;
  text-align: center;
  border-radius: 20px;
  outline: none;
  display: block;
  transition: 0.3s;
  border: 1px solid #e6e6e6;
}
 
.btn-submit {
  width: 100px;
  height: 36px;
  margin: auto;
  font-size: 18px;
  text-align: center;
  color: white;
  border-radius: 20px;
  display: block;
  background: darkslategrey;
  transition: 0.3s;
}
p {
  margin: 15px auto;
  padding: 0;
  font-size: 16px;
  color: white;
  display: block;
  text-align: center;
}
a {
  color: aqua;
  cursor: pointer;
}
</style>
</head>
<body>
  <form class="form-box back" action="<%=request.getContextPath()%>/AddRegister" method="post" >
      <div>
        <h1>Register</h1>
      </div>
      <div>
        <input class="input-normal" type="text" placeholder="UserAccount" name="Uname" id="Uname" />
        <input class="input-normal" type="password" placeholder="PassWord"  name="Upwd" id="Upwd"/>
        <button class="btn-submit" type="submit">
          Register
        </button>
      </div>
      <div>
        <p style="margin-top: 40px">Have a account ? You can</p>
        <p>Click here to <a id="login" href="Login-main.jsp">Log in</a></p>
      </div>
    </form>
</body>
</html>