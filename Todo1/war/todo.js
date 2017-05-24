function event(id, task){
  sid = "s" + id;
  tid = "t" + id;
  ui = "us" + id;
  var node = document.createElement("LI");
  node.class = "";
  node.id = sid;
  var para = document.createElement("span");
  para.className = "update";
  para.id = id;
  var textBox = document.createElement("INPUT");
  textBox.setAttribute("type", "text");
  textBox.className = "text";
  textBox.id = tid;

  var checkbox = document.createElement('input');
  checkbox.type = "checkbox";
  checkbox.className = 'cb';
  checkbox.id = ui;
  node.appendChild(checkbox);

  var textnode = document.createTextNode(task);
  para.appendChild(textnode);

  var close = document.createElement("BUTTON");
  close.id = id;
  close.className = "remove";
  close.innerText	=	'X';
  para.addEventListener('click',update);


  node.appendChild(para);
  node.appendChild(textBox);

  node.appendChild(close);

  document.getElementById("todo").appendChild(node);


  main();
}

function show() {
  console.log("local storage");
  for (i = 0; i < localStorage.length; i++)   {
    var todo = localStorage.key(i) + "=[" + localStorage.getItem(localStorage.key(i)) + "]";
    console.log(todo);

    var todo1 = localStorage.getItem(localStorage.key(i));
    var tk = JSON.parse(todo1);
    console.log(tk[0].note);
    var uid = localStorage.key(i);
    if(tk[0].removed !== "true")
    {
      event(uid,tk[0].note);
    }
  }
}
if(localStorage.length !== null){
  show();
}

function main() {

  var buttons = document.getElementsByClassName('remove');
  for (var i=0; i < buttons.length; i++) {

      buttons[i].addEventListener('click', remove);
  }
}main();

function add() {
    var task = document.getElementById('task').value;
    var task1 = document.getElementById("task");
    var todos = [];
    var check = "false";
    var delte = "false";
    uid = "id" + Math.random().toString(16).slice(2);
    td = "todo" + uid;
    console.log(td);
    if(task == "")
    {
      task1.style.backgroundColor = "red";
      alert("enter something!!!");
    }
    else
    {
      // todos.push(task);
      // todos.push(td);
      // todos.push(check);
      // todos.push(delte);
      // localStorage.setItem(td, JSON.stringify(todos));

      task1.style.backgroundColor = "";
      push(task,td,check,delte);
      document.getElementById('task').value = "";
      event(td,task);
      console.log(todos);
      console.log(td);
    }

    return false;
}

document.getElementById('add').addEventListener('click', add);



function remove() {
    var id = this.getAttribute('id');
    qid = "us" + id;
    var sid = "s" + id;
    // localStorage.removeItem(id);
    var txt = document.getElementById(id).innerText;
    // var che = "false";
    var del = "true";
    var x = document.getElementById(qid).checked;
    console.log(id);
    document.getElementById(sid).style.display = 'none';
    push(txt,id,x,del);

    return false;
}

function update() {
  var id = this.getAttribute('id');
  var tid = "t" + id;
  var ui = "u" +id;
  var txt;
  var todos = [];
  console.log(id);
  var txt = document.getElementById(id).innerText;
  console.log(txt);
  document.getElementById(id).className = "text";
  document.getElementById(tid).className = "show";

  document.getElementById(tid).value = txt;

  document.getElementById(tid).onkeydown= function(event) {
    if (event.keyCode == 13) {
        updated();
    }

  }
  var ck = "false";
  var rm = "";
  var todo1 = localStorage.getItem(localStorage.key(i));
  var td = JSON.parse(todo1);
  console.log(td);
  function updated(){
    var x = document.getElementById(id).parentNode.id;
    console.log(x);
    var upda = document.getElementById(tid).value;
    console.log(upda);
    if (upda == null || updated == "") {
        txt = todos;
    } else {
        txt = upda;
        console.log(txt);
        push(txt,id,ck,rm);

    // todos.push(txt);
    // todos.push(id);
    // localStorage.setItem(x, JSON.stringify(todos));
    location.reload();
  }
  }

  return false;
}

function push(text,id,check,delte){
  var name = new Object();
  name.note = text;
  name.id = id;
  name.checked = check;
  name.removed = delte;
  var todos = [];
  todos.push(name);
  // todos.push(id);
  // todos.push(check);
  // todos.push(delte);
  localStorage.setItem(id, JSON.stringify(todos));
  console.log(JSON.stringify(todos));
}


var list = document.querySelector('ul');
list.addEventListener('click', function(ev) {
var id = this.getAttribute('id');
  // console.log(id);
  // var txt = document.getElementById(id).innerText;
  // var del = "false";
  // for (i = 0; i < localStorage.length; i++)   {
  //   var todo1 = localStorage.getItem(localStorage.key(i));
  //   var tk = JSON.parse(todo1);
  //   console.log(tk[0].note);
  //   var uid = localStorage.key(i);
  // }
  if (ev.target.className === 'cb') {

      var x = document.getElementsByClassName( 'update' );
      console.log(this);
      ev.target.parentNode.classList.toggle('checked');

      var x = ev.target.parentNode;
      console.log(x);
      console.log(x.id);
      var z  = x.id;

      var y = x.getElementsByClassName('update');
      var qid = y[0].id;
      console.log(y);
      console.log(qid);
      var qwe = "us" + qid;
      var t = document.getElementById(qid).innerText;
      console.log(t);

  //   if(tk[0].id == id){
  //     if(tk[0].checked == "false"){
  //   {
  //     var che = "true";
  //
  //   }
  // }
}
    var x = document.getElementById(qwe).checked;
    console.log(x);
    del = "false";
    push(t,qid,x,del);

  }, false);
