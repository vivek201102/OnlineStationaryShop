<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Cart</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="<c:url value="resources/css/view_product.css" />" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<header class="header">

    <a href="home.html" class="logo">  Your Stationary </a>

    <nav class="navbar">
        <a href="home.jsp">Home</a>
        <a href="view_product.jsp">Product</a>
        <a href="view_past_order.jsp">Past Order</a>
        <a href="cart.jsp">View Cart</a>
        <a href="#">LogOut</a>
    </nav>
</header>
<br><br><br><br><br><br>
<span id="error"></span>
<table class="demotbl">
  <tr>
      <th>Product ID</th>
      <th>Product Name</th>
      <th>Product price</th>
      <th>Qty</th>
  </tr>
  
  <c:forEach var="cartitem" items="${usercart}">
  <tr>
      <td>${cartitem.getProdId()}</td>
      <td>${cartitem.getProdName()}</td>
      <td>${cartitem.getProdPrice() }</td>
      <td>
     <c:set var="qty" value="${cartitem.getProdCount()}"></c:set>
 
      <button class="btn ${cartitem.getProdId()}" onclick="decrementqty('${cartitem.getProdId()}')">-</button>

     
      <input type="text" id="${cartitem.getProdId() }" value="${cartitem.getProdCount() }" size="6" style="text-align:center;" readonly>
      <button class="btn" onclick="incrementqty('${cartitem.getProdId()}')">+</button>&emsp;
      <a onclick="deleteqty('${cartitem.getProdId()}')"><i class="fa fa-trash-o" style="font-size:24px;color:red"></i></a>
      </td>
  </tr>
  </c:forEach>
	<tr>
	<td colspan="4"><a href="#" class="btn">Generate Bill</a></td>
	</tr>
</table>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
	function incrementqty(a)
	{
		var x = document.getElementById(a);
		var value = parseInt(x.value);
		if(value < 10)
		{
			value = value + 1;
		}
	
		$.ajax({
			url:"changeQty",
			type: "POST",
			data:{
				"id":a,
				"qty":value,
			},
			
			success: function(data){
				x.value=value;
				
			}
		})
	}
</script>

<script type="text/javascript">
	function decrementqty(a)
	{
		var x = document.getElementById(a);
		var value = parseInt(x.value);
		if(value > 1)
		{
			value = value - 1;
		}
			$.ajax({
				url:"changeQty",
				type: "POST",
				data:{
					"id":a,
					"qty":value,
				},
				
				success: function(data){
					x.value=value;
				}
			})
		}
</script>

<script type="text/javascript">
	function deleteqty(a)
	{
		var x = document.getElementById(a);
		
			$.ajax({
				url:"deleteQty",
				type: "POST",
				data:{
					"id":a,
				},
				
				success: function(data){
					window.location.reload();
				}
			})
		}
</script>
</body>
</html>

