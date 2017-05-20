function validateEmail(email) {
  var re = /^\w+([\.-]?\w+)*@(\w{2,9})+(\.\w{2,3})*(\.\w{2,3})+$/;
  return re.test(email);
}

function validate(){
  var email = document.getElementById("email").value;
  var pass = document.getElementById("password").value;
  var len = pass.length;
  var atpos = email.indexOf("@");
  var dotpos = email.lastIndexOf(".");
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
        }
      }
    }
  }
}

function toggle_pass(){
    var pass = document.getElementById('showhide');
        if(pass.innerHTML=="Show Password")
         {
            document.getElementById('password').type = "text";
            pass.innerHTML = "Hide Password";
         }
        else
         {
            document.getElementById('password').type = "password";
            pass.innerHTML = "Show Password";
         }
}
