<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

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
    <a href="#" id="qwerty"><%=request.getAttribute("Email")%></a>
    
    <%String email = (String)request.getAttribute("Email");%>
    <%String name = (String)request.getAttribute("User");%>
<%--    	<%String[] task = (String[])request.getAttribute("Task");%>
 --%>   	<%@ page import="java.util.ArrayList" %>
   	<%@ page import="java.util.List" %>
   	<%@ page import="java.util.Arrays;" %>
	<%List<Arrays> list = (ArrayList<Arrays>) request.getAttribute("Task"); %>
	<% String[] array =  list.toArray(new String[0]); %>
	 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
    <a id="logout" href="index.jsp">Logout</a>
  </div>
</div>
<!--   <form action="/list" method="post" >
 -->  <div id="myDIV" class="form">
    <h2 style="margin:5px">My To Do List</h2>
    <button onclick="myFunction()">Try it</button>
    
    <input type="text" class="details"id="task" placeholder="Add Item..." name="task" onkeydown = "if (event.keyCode == 13){add('<%= email %>','<%= name %>');}"   >
    <!-- <button id="add" class="addBtn">Add</button> -->
    <p></p>
    <ul id="todo"></ul>
    
  </div>
<div id="todos">
</div>
<div id="form_sample"></div> <!-- Include JS file here -->
<script src="formjs.js"></script>
<!-- </form>
 --><script src="todo.js"></script>
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
</body>
<script>
function myFunction() {
    console.log(<%= list %>);
    insert();
}

function insert(){
	var temp =  <%= array[0] %>;
	console.log("main array: " + temp);
	var n = temp.length;
	console.log(n);
	for(i=0; i<n ; i++ )
		{
			console.log(temp[i]);
			a = temp[i];
			console.log(a);
			b = JSON.parse(a)
			console.log(typeof(b));
			task = b[0];
			console.log(task);
			push(task.note,task.id,task.checked,task.removed);
			event(task.id,task.note);
		}
}

</script>
</html>

