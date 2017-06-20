package com.todo;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Todo1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String mail = request.getParameter("email");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String email = mail.toLowerCase();
	String pass = "";
	String name1 = "";
	String login = "";
	ArrayList<String> task = new ArrayList<String>();
	String task1 = "[]";
	task.add(task1);
	request.setAttribute("name" , name ) ;
	request.setAttribute("email" , email ) ;
	request.setAttribute("password" , password ) ;
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	try{
		try{
			Key emailKey = KeyFactory.createKey("Person", email);
			Entity employee = datastore.get(emailKey);
			pass = (String) employee.getProperty("password");
			name1 = (String) employee.getProperty("name");
			mail = (String) employee.getProperty("email");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			login = "yes";
		}
	} 
	catch(Exception e){
		System.out.println("handeled");
	}  
	if(login == "yes")
	{
		Key personKey = KeyFactory.createKey("Person", email);
		Entity person = new Entity(personKey);
		person.setProperty("name", name);
		person.setProperty("email", email);
		person.setProperty("password", password);
		Key taskKey = KeyFactory.createKey("task", email);
		Entity list = new Entity(taskKey);
		list.setProperty("task", task);
		//list.setProperty("email", email);
		list.setProperty("user", name);
		System.out.println(list);
		try{
		  datastore.put(person);
		  datastore.put(list);
		}
		catch (Exception e2) 
		{
			System.out.println(e2);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("todologin.jsp");
		String success="<p></p>";
		request.setAttribute("Success", success);
		request.setAttribute("User", name);
		request.setAttribute("Email", email);
		request.setAttribute("Task", task);
		dispatcher.forward( request, response );
	}
	else{
		String testing="<p style=\"color: red;\">You have already registered</p>";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("todosignup.jsp");
		request.setAttribute("Name", testing); // set your String value in the attribute
		dispatcher.forward( request, response );
	}
	}
	
	
}
