package com.todo;

import java.io.*;

import javax.servlet.RequestDispatcher;
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



String mail = request.getParameter("email");
String name = request.getParameter("name");
String password = request.getParameter("password");
String email = mail.toLowerCase();
String pass = "";
String name1 = "";
String login = "";

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
catch(Exception e){System.out.println("handeled");}  


if(login == "yes"){
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
//response.setContentType("text/html");
//PrintWriter out = response.getWriter();
//
//String html="<html><head><title> Login page </title></head><body><p>Username : "+name+"</p><p>Email : "+email+"</p><button onclick=\"window.location.href='/index.html'\">Logout</button></body></html>";
//out.println(html);
RequestDispatcher dispatcher = request.getRequestDispatcher("todologin.jsp");
request.setAttribute("User", name);
request.setAttribute("Email", email);
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
