<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Calc</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</head>
<body>
			<div class="container">
	<h3>Add Calc</h3>
		<form action="addcalc" method="post" enctype="multipart/form-data">
			  <div class="form-group">
    <label for="pId">Enter Product ID</label>
    <input type="text" class="form-control" id="pId" placeholder="Product ID" name="pId">
  </div>

  <div class="form-group">
    <label for="pName">Enter Product Name</label>
    <input type="text" class="form-control" id="pName" placeholder="Product Name" name="pName">
  </div>

  <div class="form-group">
    <label for="des">Enter Product Description</label>
    <input type="text" class="form-control" id="des" placeholder="Product Description" name="des">
  </div>

<div class="form-group">
    <label for="pcomp">Enter Product Company</label>
    <input type="text" class="form-control" id="pcomp" placeholder="Product Company" name="compName">
  </div>

<div class="form-group">
    <label for="price">Enter Product Price</label>
    <input type="number" class="form-control" id="price" name="price">
  </div>

<div class="form-group">
    <label for="stock">Enter Product Stock</label>
    <input type="number" class="form-control" id="stock" name="stock">
  </div>

<div class="form-group">
    <label for="type">Enter Type</label>
    <input type="text" class="form-control" id="author" placeholder="Type" name="type">
  </div>


<div class="form-group">
    <label for="pic">Upload Pic</label>
    <input type="text" class="form-control" id="pic" name="image">
  </div>
  <br>
  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		</div>
</body>
</html>