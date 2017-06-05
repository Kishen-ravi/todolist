

var x = document.getElementById("form_sample");
var createform = document.createElement('form'); // Create New Element Form
createform.setAttribute("action", "/list"); // Setting Action Attribute on Form
createform.setAttribute("method", "post");// Setting Method Attribute on Form
createform.setAttric
x.appendChild(createform);

var textbox = document.createElement('input');
textbox.setAttribute("type","textbox");
textbox.setAttribute("name","task");
textbox.className="myP";
textbox.id="text";
createform.appendChild(textbox);

var textbox = document.createElement('input');
textbox.setAttribute("type","textbox");
textbox.setAttribute("name","task1");
textbox.className="myP";
textbox.id="text1";
createform.appendChild(textbox);

var textbox = document.createElement('input');
textbox.setAttribute("type","textbox");
textbox.setAttribute("name","task2");
textbox.className="myP";
textbox.id="text2";
createform.appendChild(textbox);

linebreak = document.createElement("p");
linebreak.className = "myP";
createform.appendChild(linebreak);

var submitelement = document.createElement('input'); // Append Submit Button
submitelement.setAttribute("type", "submit");
submitelement.setAttribute("name", "dsubmit");
submitelement.setAttribute("value", "Submit");
submitelement.id = "submit";
createform.appendChild(submitelement);



document.getElementById("text").style.visibility = "hidden";
//document.getElementById('submit').addEventListener('click', show);
//
//var arr= [];
//
//function show() {
//	  console.log("local storage");
//	  for (i = 0; i < localStorage.length; i++)   {
//	    var todo = localStorage.key(i) + "=[" + localStorage.getItem(localStorage.key(i)) + "]";
//	    console.log(todo);
//	    var todo1 = localStorage.getItem(localStorage.key(i));
//	    var tk = JSON.parse(todo1);
//	    console.log(tk[0].user);
//	    var email = tk[0].user;
//	    var name = tk[0].name;
//	    var uid = localStorage.key(i);
//	    var myData = JSON.stringify(tk);
//	    arr.push(myData);
//	  }	    
//	    var data = JSON.stringify(arr);
//	    console.log(data);
//	    $.ajax({
//	 		 type: "POST",
//	 		 url: "/list",
//	 		 data: {"myData": data , "email": email},
//	 		 
//	 		 success: function(msg) {
//	 		        alert(msg.d);
//	 		    },
//	 		    error: function(msg) {
//	 		    alert('error');
//	 		    }
//	 	});
//	}