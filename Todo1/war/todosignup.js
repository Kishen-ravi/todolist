function validateEmail(email) {
  var re = /^\w+([\.-]?\w+)*@(\w{2,11})+(\.\w{2,11})*(\.\w{2,11})+$/;
  return re.test(email);
}

function validate(){
  var name = document.getElementById("name").value;
  var email = document.getElementById("email").value;
  var pass = document.getElementById("password").value;
  var repass = document.getElementById("repass").value;
  var len = pass.length;
  var atpos = email.indexOf("@");
  var dotpos = email.lastIndexOf(".");
  
  if (name != '' && email != '' && pass != '' && repass != '') {
  if(name == ""){
    alert("Enter name!");
    document.getElementById("name").style.backgroundColor = "red";
    return false;
  }
  else{
    if(email == "" || email == null){
      alert("Enter email address");
      document.getElementById("email").style.backgroundColor = "red";
      return false;
    }
    else {
      var a = validateEmail(email);
      if (a == false) {
        console.log(email);
        document.getElementById("email").style.backgroundColor = "red";
        alert("Not a valid e-mail address");
        return false;
      }
      else {
        document.getElementById("email").style.backgroundColor = "";
        if(pass == "" || pass == null){
            alert("Enter password");
            document.getElementById("password").style.backgroundColor = "red";
            return false;
          }
          else {
            if(len < 6){
              alert("Enter minimum of 6 characters");
              document.getElementById("password").style.backgroundColor = "red";
              return false;
            }
            else {
              document.getElementById("password").style.backgroundColor = "";
              if(repass == "" || repass == null){
            	  alert("Enter confirm password");
            	  document.getElementById("password").style.backgroundColor = "red";
            	  return false;
              }
              else{
            	  if(repass != pass){
            		  alert("Password doesnot match.. Enter again.")
            		  document.getElementById("repass").style.backgroundColor = "red";
            		  return false;
            	  }
            	  else {
            		  document.getElementById("repass").style.backgroundColor = "";
            		  window.location="";
            		  console.log("Success!!");
            	  }
              }
            }
          }
      }
    }
  }
  }
  else{
	  return false;
  }
  
}
