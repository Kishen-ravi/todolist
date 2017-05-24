<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
  <link rel="stylesheet" type="text/css" href="todo.css">
  <script src="todologin.js"></script>
</head>
<body>
  <h1 class = "login">TODO Login</h1>
  <form action="/login" method="post" onsubmit="return validate()">
  <div class = "form login" >
  <p style = "color: red; display:none;"><%=request.getAttribute("Name")%></p>
    <h3>Email address</h3>
    <input type = "text" id="email" name="email" class = "details email" placeholder = "Email Address"></input>
    <h3>Password</h3>
    <input type = "password" id="password" name = "password" class = "details pass" placeholder = "Password"></input>
    <p id="showhide" onclick="toggle_pass();">Show Password</p>
    <button class = "adding" id="add" onkeydown = "if (event.keyCode == 13) document.getElementById('add').click()"> Login</button>
    <p>No account yet!! <a href = "todosignup.jsp"> Create an account. </a></p>
  </div>
</form>
</body>
</html>