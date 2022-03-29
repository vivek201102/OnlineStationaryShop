<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="<c:url value="resources/css/signup.css"/> ">
</head>
<body>
<br>
<div class="container">

    <form id="signup" action="adduser" method="post">

        <div class="header">
        <br>
            <h3>Sign Up</h3>
            <br>
            
            <p>You Have to fill out this form</p>
            
        </div>
        
        <div class="sep"></div>

        <div class="inputs">
        
            <input type="text" placeholder="Enter Your Name" autofocus name="name" required/>
            <span style="color:red; font-size:12px;">${error }</span>
            <input type="email" placeholder="Enter Your E-mail"  name="email" required/>
            <input type="text" placeholder="Enter Your Mobile No." name="mobile" required/>
            <input type="text" placeholder="Enter Your House No" name="hNo" required/>
            <input type="text" placeholder="Enter Your Address Line1" name="add1" required/>
            <input type="text" placeholder="Enter Your Address Line2" name="add2" required/>
            <input type="text" placeholder="Enter Your City" name="city" required/>
            <input type="text" placeholder="Enter Your PinCode" name="pincode" required/>
            <input type="password" id="password" placeholder="Enter Your Password" name="password"required/>
            <input type="password" id="conform" placeholder="Enter Your Confirm Password" required/>
            <span id="message"></span>
            <button id="submit" type="submit">submit</button>
            <a id="submit"  href="login">Already User?</a>
        
        </div>

    </form>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script type="text/javascript">
$('#password, #conform').on('keyup', function () {
	  if ($('#password').val() == $('#conform').val()) {
	    $('#message').html('Matching').css('color', 'green');
	    document.getElementById("submit").disabled = false;
	  } 
	  else 
	  {
	    $('#message').html('Not Matching').css('color', 'red');
	    document.getElementById("submit").disabled = true;
	  }
	});

</script>

</body>
</html>
​