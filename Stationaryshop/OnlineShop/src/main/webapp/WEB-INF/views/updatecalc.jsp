<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
<form action="updatecalc" method="POST">
	<input type="text" name="id" id="id" value="${calc.id }" hidden>
	<div class="mb-3">
    	<label for="pid" class="form-label">Product ID</label>
    	<input type="text" class="form-control" id="pId" name="pId" value="${calc.pId}" readonly>
  </div>
  <div class="mb-3">
    	<label for="pname" class="form-label">Product Name</label>
    	<input type="text" class="form-control" id="pName" name="pName" value="${calc.pName }">
  </div>
  <div class="mb-3">
    	<label for="pdesc" class="form-label">Product Description</label>
    	<input type="text" class="form-control" id="des" name="des" value="${calc.des }">
  </div>
  <div class="mb-3">
    	<label for="compname" class="form-label">Company Name</label>
    	<input type="text" class="form-control" id="compName" name="compName" value="${calc.compName }">
  </div>
  <div class="mb-3">
    	<label for="price" class="form-label">Price</label>
    	<input type="number" class="form-control" id="price" name="price" value="${calc.price }">
  </div>
  <div class="mb-3">
    	<label for="stock" class="form-label">Stock</label>
    	<input type="number" class="form-control" id="stock" name="stock" value="${calc.stock }">
  </div>
  <div class="mb-3">
    	<label for="type" class="form-label">Type</label>
    	<input type="text" class="form-control" id="type" name="type" value="${calc.type }">
  </div>
  

  
  <div class="mb-3">
    	<label for="pic" class="form-label">Picture</label>
    	<input type="text" class="form-control" id="image" name="image" value="${calc.image }">
  </div>
  
    <div class="mb-3">
  	<button class="btn btn-success" type="submit">Update</button>
  	</div>
</form>
</div>
</body>
</html>