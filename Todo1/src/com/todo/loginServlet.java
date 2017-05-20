package com.todo;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class loginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String pass = "";
		String name = "";
		String mail = "";
//		String login = "";
		
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
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();

				String html="<html><head><title> Wrong login </title></head><body><p>Your have not registered yet... </p><p>To create an account</p><button onclick=\"window.location.href='/todosignup.html'\">click here</button></body></html>";
				out.println(html);
			}
			
		} 
		catch(Exception e){System.out.println("handeled");}  
		if(pass == password)
		{
//			login = "no";
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String html="<html><head><title> Wrong password </title></head><body><p>You have entered the wrong password </p><p>Please login again</p><button onclick=\"window.location.href='/index.html'\">Login</button></body></html>";
			out.println(html);
		}
		else
		{
//			login = "yes";
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String html="<html><head><title> Home </title></head><body><p>Logged in Successfully</p><p>Username : "+name+"</p><p>Email : "+mail+"</p><button onclick=\"window.location.href='/index.html'\">Logout</button></body></html>";
			out.println(html);
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
