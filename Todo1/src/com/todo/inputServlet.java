package com.todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.labs.repackaged.org.json.JSONException;
//import com.google.appengine.api.datastore.Text;
public class inputServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*try {
			JSONObject jObj = new JSONObject(request.getParameter("myData"));
			
			System.out.println("test:: "+  jObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}*/
		String pass = "";		
		String name1 = "";
		String login = "";
		String mail1 = "";
		ArrayList<String> task = new ArrayList<String>();
		
		String output = request.getParameter("task");
		String email = request.getParameter("task1");
		String name = request.getParameter("task2");
		ArrayList<String> listStrings = new ArrayList<String>();
		listStrings.add(output);
		

//		JSONParser parser = new JSONParser();
//		String s = output;
//		try{
//	         Object obj = parser.parse(s);
//	         JSONArray array = (JSONArray)obj;
//	         System.out.println("array created: " + array);
//		}
//		catch(Exception pe){
//			
//	         System.out.println("position: " + pe);
//	         System.out.println(pe);
//	      }
//	    String output = request.getParameter("myData");
//	    System.out.println("output value " + output);
//	    String mail = request.getParameter("email");
//	    System.out.println("eail value " + mail);
//	    String nam = request.getParameter("email");
//
//
//		String name = (String) request.getAttribute("User");
//		String email = (String) request.getAttribute("Email");
		
//		request.setAttribute("email" , mail ) ;
		request.setAttribute("task" , output ) ;
		
//		if(output != null){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key taskKey = KeyFactory.createKey("task", email);
		Entity list = new Entity(taskKey);
		list.setProperty("task", listStrings);
//		list.setProperty("email", email);
		list.setProperty("user", name);

		
		datastore.put(list);
		
		try{
			Key taskKey1 = KeyFactory.createKey("task", email);
			Entity employee = datastore.get(taskKey1);
			task =   (ArrayList<String>) employee.getProperty("task");
			name1 = (String) employee.getProperty("name");
			mail1 = (String) employee.getProperty("email");
			System.out.println(task);
		}
		catch(Exception e){
			System.out.println(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("todologin.jsp");
		String success="<p style=\"color: red;\">Data Saved!!!</p>";
		request.setAttribute("Success", success);
		request.setAttribute("User", name);
		request.setAttribute("Email", email);
		request.setAttribute("Task", task);
		dispatcher.forward( request, response );
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/todologin.jsp");
////		request.setAttribute("Name", output); // set your String value in the attribute
////		request.setAttribute("User", nam);
////		request.setAttribute("Email", mail);
//		dispatcher.forward( request, response );
////		}
//		else{
//			
//		}
		}
}
