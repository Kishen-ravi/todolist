<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Login page</title>
  <link rel="stylesheet" type="text/css" href="todo.css">
 
</head>
<body>
  <h1 class = "signup">TODO Signup</h1>
  <form action="/todo1" method="POST" onsubmit="return validate()">
 	 <div class = "form signup" >
 	   <p style = "color: red; display:none;"><%=request.getAttribute("Name")%></p>
 	 
    <h3>Name</h3>
    <input type = "text" id="name" name="name" class = "details"  placeholder = "Name"></input>
    <h3>Email address</h3>
    <input type = "text" id="email" name="email" class = "details" placeholder = "Email Address"></input>
    <h3>Password</h3>
    <input type = "password" id="password" name="password" class = "details" placeholder = "Password"></input>
    <h3>Re-enter Password</h3>
    <input type = "password" id="repass" class = "details" placeholder = "Re-enter Password"></input>
    <p></p>
    <button class = "adding" > Signup</button>
    <p>Have an acount! <a href = "index.jsp"> Login here... </a></p>
  </div>
 </form>
 <script src="todosignup.js"></script>
</body>
</html>