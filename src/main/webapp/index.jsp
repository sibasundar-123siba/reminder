<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-info">
  <div class="container-fluid">
    <a class="navbar-brand btn btn-success" href="#">REMAINDER</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item px-2">
          <a class="nav-link active btn btn-success" aria-current="page" href="#">setRemainder</a>
        </li>
        <li class="nav-item px-2">
          <a class="nav-link active btn btn-success " href="#">Disable</a>
        </li>
         <li class="nav-item px-2">
          <a class="nav-link active btn btn-success" href="#">Enable</a>
        </li>
        <li class="nav-item px-2">
          <a class="nav-link active btn btn-success " href="#">View Remainder</a>
        </li>
       
      </ul>
      
    </div>
  </div>
</nav>
<div  class="container-fluid card"style="width:900px">
<h2 class="bg-success text-center p-2 mt-3">Reaminder set</h2>
<h2>welcome to the remainder application :- ${session_name}</h2>
<h2 id="time"></h2>
<form action="set"method="post"auto-complete="on">
  <div class="row mb-3">
    <label for="name" class="col-sm-2 col-form-label">user Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name"name="username">
    </div>
  </div>
   <div class="row mb-3">
    <label for="book" class="col-sm-2 col-form-label">work-name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"id="book" name="work">
    </div>
    
  </div>
   <div class="row mb-3">
    <label for="book" class="col-sm-2 col-form-label">Address</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"id="book" name="address">
    </div>
    
  </div>
   <div class="row mb-3">
    <label for="book" class="col-sm-2 col-form-label">phone</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"id="book" name="phone">
    </div>
    
  </div>
   <div class="row mb-3">
    <label for="book" class="col-sm-2 col-form-label">email</label>
    <div class="col-sm-10">
      <input type="email" class="form-control"id="book" name="email">
    </div>
    
  </div>
   <div class="row mb-3">
    <label for="book" class="col-sm-2 col-form-label">next-working-day</label>
    <div class="col-sm-10">
      <div class="form-check">
  <input class="form-check-input" type="radio" name="day"value="7 days" id="flexCheckDefault">
  <label class="form-check-label" for="flexCheckDefault">
    7 days
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio"name="day" value="5 days" id="flexCheckChecked" checked>
  <label class="form-check-label" for="flexCheckChecked">
    5 days
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio"name="day" value="3 days" id="flexCheckDefault">
  <label class="form-check-label" for="flexCheckDefault">
    3 days
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio"name="day" value="2 days" id="flexCheckChecked" checked>
  <label class="form-check-label" for="flexCheckChecked">
    2 days
  </label>
</div>
    </div>
    
  </div>
   <div class="row mb-3">
    <label for="book" class="col-sm-2 col-form-label">progress</label>
    <div class="col-sm-10">
      <select class="form-select"name="progress" aria-label="Default select example">
  <option selected>Open this select menu</option>
  <option value="completed">completed</option>
  <option value="notcompleted">notCompleted</option>
  
</select>
    </div>
    
  </div>
  
 

  
   <div class="row mb-3">
    <label for="price" class="col-sm-2 col-form-label">Date</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" id="price"name="date">
    </div>
  </div>
  
    
  <button type="submit" class="btn btn-primary">SetRemainder</button>
  <button type="reset" class="btn btn-danger">Cancel</button>
  <button class="btn btn-light"><a href="remainder"style="text-decoration:none">view remainder</a></button>
  <button class="btn btn-dark"><a href="logout"style="text-decoration:none">LogOut</a></button>
</form>
</div>
<script>
let date=new Date();
document.getElementById('time').innerText="Today is " + date; 


</script 

> 
</body>
</html>