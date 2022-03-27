<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Calculator</title>
<link rel="stylesheet" href="<c:url value="resources/css/view_product.css" /> ">
</head>
<body>
<header class="header">

    <a href="home" class="logo">  Your Stationary </a>

    <nav class="navbar">
        <a href="home.jsp">Home</a>
        <a href="view_product.jsp">Product</a>
        <a href="view_past_order.jsp">Past Order</a>
        <a href="cart.jsp">View Cart</a>
        <a href="#">LogOut</a>
    </nav>
</header>
<br><br><br><br><br><br>
<table class="demotbl">
  <tr>
      <th>Product ID</th>
      <th>Product Name</th>
      <th>Product Description</th>
      <th>Company name</th>
      <th>Price</th>
      <th>Stock</th>
      <th>Type</th>
      <th>Image</th>
      <th>Add to Cart</th>
  </tr>

  <tr>
  <c:forEach var="calc" items="${calcs}">
      <td>${ calc.getpId()}</td>
      <td>${ calc.getpName()}</td>
      <td>${calc.getDes() }</td>
      <td>${calc.getCompName() }</td>
      <td>${ calc.getPrice()}</td>
      <td>${ calc.getStock()}</td>
      <td>${ calc.getType()}</td>
      <td><img src="${calc.getImage() }" height="250" width="200"></td>
            <td class="${calc.getpId() }" style="display:none;"><button class="btn" onclick="return removeFromCart(['${calc.getpId() }','${calc.getpName() }', '${calc.getPrice() }', '1'])">Remove From Cart</button></td>
      <td class="${calc.getpId() }"><button class="btn" onclick="return addToCart(['${calc.getpId() }','${calc.getpName() }', '${calc.getPrice() }', '1'])">Add To Cart</button></td>
  </tr>
  </c:forEach>

</table>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
	function addToCart(a)
	{
		var x = document.getElementsByClassName(a[0]);
		
		$.ajax({
			type:"POST",
			url:"addtocart",
			data:{
				name:a[1],
				id:a[0],
				price:a[2],
				qty:a[3],
			},
			
			success:function(data){
				x[0].style.display = "grid";
				x[1].style.display="none";
			}
		})
	}
</script>

</body>

</html>



