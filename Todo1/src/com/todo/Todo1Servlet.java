package com.todo;

import java.io.*;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class Todo1Servlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



String email = request.getParameter("email");
String name = request.getParameter("name");
String password = request.getParameter("password");

request.setAttribute("name" , name ) ;
request.setAttribute("email" , email ) ;
request.setAttribute("password" , password ) ;

DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();


Key personKey = KeyFactory.createKey("Person", email);
Entity person = new Entity(personKey);
person.setProperty("name", name);
person.setProperty("email", email);
person.setProperty("password", password);


try{
	
  datastore.put(person);

}catch (Exception e2) 
{
	System.out.println(e2);
	}
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String html="<html><head><title> Login page </title></head><body><p>Username : "+name+"</p><p>Email : "+email+"</p><button onclick=\"window.location.href='/index.html'\">Logout</button></body></html>";
out.println(html);

}


}
