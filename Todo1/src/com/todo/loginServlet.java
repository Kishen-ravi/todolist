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
import com.google.appengine.api.datastore.Text;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.appengine.repackaged.com.google.gson.Gson;

public class loginServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mail = request.getParameter("email");
		String password = request.getParameter("password");
		String pass = "";
		String name = "";		
		String name1 = "";
		String email = mail.toLowerCase();
		String login = "";
		String mail1 = "";
		ArrayList<String> task = new ArrayList<String>();
		
//		request.setAttribute("email" , email ) ;
//		request.setAttribute("password" , password ) ;
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		try{
			try{
				Key emailKey = KeyFactory.createKey("Person", email);
				Entity employee = datastore.get(emailKey);
				pass = (String) employee.getProperty("password");
				name = (String) employee.getProperty("name");
				mail = (String) employee.getProperty("email");
				
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				
				login = "yes";
				
			}
			
		} 
		catch(Exception e){System.out.println("handeled");}  
		System.out.println(pass +"db pass " +password +"customer pass");
		if(login == "yes"){
//			response.setContentType("text/html");
//			response.sendRedirect("todoLogin.jsp"); 
			String testing="<p style=\"color: red;\">You have not registered yet</p>";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("Name", testing); // set your String value in the attribute
			dispatcher.forward( request, response );
		}
		else{
			
		if(pass.equals(password))
		{
			System.out.println("inside");
//			login = "yes";
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//
//			String html="<html><head><title> Home </title></head><body><p>Logged in Successfully</p><p>Username : "+name+"</p><p>Email : "+mail+"</p><button onclick=\"window.location.href='/index.html'\">Logout</button></body></html>";
//			out.println(html);
			try{
				Key taskKey = KeyFactory.createKey("task", email);
				Entity employee = datastore.get(taskKey);
				task =   (ArrayList<String>) employee.getProperty("task");
				name1 = (String) employee.getProperty("name");
				mail1 = (String) employee.getProperty("email");
				System.out.println(task);
			}
			catch(Exception e){
				System.out.println(e);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("todologin.jsp");
			String success="<p></p>";
			request.setAttribute("Success", success);
			request.setAttribute("User", name);
			request.setAttribute("Email", email);
			request.setAttribute("Task", task);
			dispatcher.forward( request, response );
			}
		else
		{

//			login = "no";
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//
//			String html="<html><head><title> Wrong password </title></head><body><p>You have entered the wrong password </p><p>Please login again</p><button onclick=\"window.location.href='/index.html'\">Login</button></body></html>";
//			out.println(html);
			String testing="<p style=\"color: red;\">You have entered the wrong password.</p>";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("Name", testing); // set your String value in the attribute
			dispatcher.forward( request, response );

			}
		}
//		if(login == "no"){
//			
//			
//		}
//		if(login == "yes"){
//			
//		
//		}	
//		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//		try {
//			Entity employee = datastore.get(emailKey);
//			String pass = (String) employee.getProperty("password");
//		} catch (EntityNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		response.getWriter().write(pass);
	
	}
}
