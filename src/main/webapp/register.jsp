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
<div class="container-fluid bg-primary p-2 text-center">
 <h1>Register Here....</h1>
</div>
<div class="container bg-secondary bg-gradient
">
<form class="row g-3" action="user"method="post">
<div class="col-md-6">
    <label for="name" class="form-label">Name</label>
    <input type="text" class="form-control" id="inputEmail4"name="name">
  </div>
  <div class="col-md-6">
    <label for="inputEmail4" class="form-label">Email</label>
    <input type="email" class="form-control" id="inputEmail4"name="email">
  </div>
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">Password</label>
    <input type="password" class="form-control" id="inputPassword4"name="pass">
  </div>
   <div class="col-md-6">
    <label for="phone" class="form-label">phone</label>
    <input type="text" class="form-control" id="inputPassword4"name="phone">
  </div>
  <div class="col-md-6">
  <label for="phone" class="form-label">Gender</label><br>
  <input class="form-check-input"value="male" type="radio" name="gender" id="flexRadioDefault1">
  <label class="form-check-label" for="flexRadioDefault1">
    MALE
  </label>
   <input class="form-check-input"value="female" type="radio" name="gender" id="flexRadioDefault1">
  <label class="form-check-label" for="flexRadioDefault1">
    FEMALE
  </label>
  </div>
  <div class="col-12">
    <label for="inputAddress" class="form-label">Address</label>
    <input type="text"name="address" class="form-control" id="inputAddress" placeholder="1234 Main St">
  </div>
  
  <div class="col-md-6">
    <label for="inputCity" class="form-label">City</label>
    <input type="text" class="form-control" id="inputCity"name="city">
  </div>
  

  <div class="col-md-2">
    <label for="inputZip" class="form-label">Zip</label>
    <input type="text" class="form-control" id="inputZip"name="pin">
  </div>
  <div class="col-12">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" id="gridCheck">
      <label class="form-check-label" for="gridCheck">
        Check me out
      </label>
    </div>
  </div>
  <div class="col-12">
    <button type="submit" class="btn btn-primary"onclick="alert('now you can login our page....')">Sign up</button>
    <button type="submit" class="btn btn-primary"><a href="login.jsp" style="text-decoration:none;color:white;">Login</a></button>
  </div>
</form>
</div>
</body>
</html>