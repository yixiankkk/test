<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入JQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.9.14/jquery.min.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.9.14/jquery.easyui.min.js"></script>
<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.9.14/locale/easyui-lang-zh_CN.js"></script>
<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.9.14/themes/default/easyui.css" type="text/css"/>
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery-easyui-1.9.14/themes/icon.css" type="text/css"/>
<script type="text/javascript" src="jquery.js"></script>
<style> 
body{text-align:center;} 
.divcss1{margin:0 auto;} 
</style> 
  <link rel="stylesheet" href="SignUpStyle.css">
  <style type="text/css">
  body {
  /*颜色这个看个人喜好*/
  background: darkslategrey;
  /*字体这个看个人喜好*/
  font-family: sans-serif;
}
 
/*主要是规定中间表单尺寸，调整到自己觉得好看就行了*/
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
 
.front {
  transform: rotateY(0deg);
}
 
/* 将back旋转180度，背面朝向用户，我这边选y轴的 */
.back {
  transform: rotateY(-180deg);
}
 
.front,
.back {
  position: absolute;
  /* 然后设置为背面朝向用户时不可见 */
  backface-visibility: hidden;
  /* 我觉得用linear顺滑一点 */
  transition: 0.3s linear;
}
 
/* 将front旋转180度 */
.middle-flip .front {
  transform: rotateY(180deg);
}
/* 将back旋转180度 */
.middle-flip .back {
  transform: rotateY(0deg);
}
 
/* 我调整了一下，感觉还不错的样式，你可以改成其他的好看点的 */
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
 <script type="text/javascript">
// 点击sigup触发翻转样式
$("#signup").click(function() {
  $(".middle").toggleClass("middle-flip");
});
// 点击login触发翻转样式
$("#login").click(function() {
  $(".middle").toggleClass("middle-flip");
});
</script>
</head>
<body>
 <div class="mainbody middle">
    <form class="form-box front" name="form-box front" method="post" action="<%=request.getContextPath()%>/loginservlet">
      <div>
        <h1>Login</h1>
      </div>
      <div>
        <input class="input-normal" type="text" placeholder="UserAccount"  name="UserName" id="UserName" />
        <input class="input-normal" type="password" placeholder="PassWord" name="Passwd" id="Passwd"/>
        <button class="btn-submit" type="submit">
          LOGIN
        </button>
      </div>
      <div>
        <p style="margin-top: 40px">If you don't have account.Please</p>
        <p>Click here to <a id="signup" href="Register.jsp">Sign Up</a></p>
      </div>
    </form>
  </div>

</body>
</html>