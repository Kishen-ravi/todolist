<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
  <link rel="stylesheet" type="text/css" href="todo.css">
</head>
<body>
<%-- <div>
  <h3 style = "color: white;text-align: right;">Welcome <%=request.getAttribute("User")%></h3>
  </div> --%>
  <div class="dropdown">
  <input type="button" value="<%=request.getAttribute("User")%>" class="dropbtn">
  <div class="dropdown-content">
    <a href="#"><%=request.getAttribute("Email")%></a>
    <a href="index.jsp">Logout</a>
  </div>
</div>
  <div id="myDIV" class="form">
    <h2 style="margin:5px">My To Do List</h2>
    <input type="text" class="details"id="task" placeholder="Add Item..." onkeydown = "if (event.keyCode == 13){add();}"   >
    <!-- <button id="add" class="addBtn">Add</button> -->
    <p></p>
    <ul id="todo"></ul>
    
  </div>
<div id="todos">
</div>

<script src="todo.js"></script>
</body>
</html>

