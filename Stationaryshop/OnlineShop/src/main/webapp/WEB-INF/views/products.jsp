<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Products</title>
<link rel="stylesheet" href="<c:url value="resources/css/show.css" />">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<header class="header">

    <a href="home" class="logo">  Your Stationary </a>

    <nav class="navbar">
        <a href="home">Home</a>
        <a href="allprod">Product</a>
        <a href="history">Past Order</a>
        <a href="cart">View Cart</a>
        <a href="#">LogOut</a>
    </nav>
</header>


<div class="heading">
    <h1>our shop</h1>
    <p> <a href="home.jsp">home >></a> shop </p>
</div>


<section class="products">

    <h1 class="title"> our <span>Book products</span>  </h1>

    <div class="box-container">

<c:forEach var="book" items="${books}">

        <div class="box">
            <div class="icons ${book.getpId() }" onclick="return addToCart(['${book.getpId() }','${book.getpName() }', '${book.getPrice() }', '1', '${book.getImage()}'])">
                <a  class="fas fa-shopping-cart"></a>
            </div>
            <div class="icons ${book.getpId() }" style="display:none;" onclick="return removeFromCart(['${book.getpId() }'])">
                <a  class="fa fa-trash-o"></a>
            </div>
            <div class="image">
                <img src="${book.getImage() }" alt="" height="10" width="150">
            </div>
            <div class="content">
                <h3>${book.getpName() }</h3>
                <h2>Publisher : ${book.getCompName() }</h2>
                <h2>Product Description : ${book.getDes() }</h2>
                <h2>Product ID    : ${book.getpId() }</h2>
      <h2>Stock : ${book.getStock() }<h2>
      <h2>Author : ${book.getAuthor() }<h2>
      <h2>Pages : ${book.getPages() }<h2>
                <div class="price">${book.getPrice() } Rs.</div>

            </div>
        </div>
        
        </c:forEach>
  
    </div>
    
        <h1 class="title"> our <span>Pen products</span>  </h1>

    <div class="box-container">

<c:forEach var="pen" items="${pens}">

        <div class="box">
            <div class="icons ${pen.getpId() }" onclick="return addToCart(['${pen.getpId() }','${pen.getpName() }', '${pen.getPrice() }', '1', '${pen.getImage()}'])">
                <a  class="fas fa-shopping-cart"></a>
            </div>
            <div class="icons ${pen.getpId() }" style="display:none;" onclick="return removeFromCart(['${pen.getpId() }'])">
                <a  class="fa fa-trash-o"></a>
            </div>
            <div class="image">
                <img src="${pen.getImage() }" alt="" height="10" width="150">
            </div>
            <div class="content">
                <h3>${pen.getpName() }</h3>
                <h2>Publisher : ${pen.getCompName() }</h2>
                <h2>Product Description : ${pen.getDes() }</h2>
                <h2>Product ID    : ${pen.getpId() }</h2>
      <h2>Stock : ${pen.getStock() }<h2>
      <h2>Color : ${pen.getColor() }<h2>
                <div class="price">${pen.getPrice() } Rs.</div>

            </div>
        </div>
        
        </c:forEach>
  
    </div>
    
        <h1 class="title"> our <span>Desk products</span>  </h1>

    <div class="box-container">

<c:forEach var="desk" items="${desks}">

        <div class="box">
            <div class="icons ${desk.getpId() }" onclick="return addToCart(['${desk.getpId() }','${desk.getpName() }', '${desk.getPrice() }', '1', '${desk.getImage()}'])">
                <a  class="fas fa-shopping-cart"></a>
            </div>
            <div class="icons ${desk.getpId() }" style="display:none;" onclick="return removeFromCart(['${desk.getpId() }'])">
                <a  class="fa fa-trash-o"></a>
            </div>
            <div class="image">
                <img src="${desk.getImage() }" alt="" height="10" width="150">
            </div>
            <div class="content">
                <h3>${desk.getpName() }</h3>
                <h2>Publisher : ${desk.getCompName() }</h2>
                <h2>Product Description : ${desk.getDes() }</h2>
                <h2>Product ID    : ${desk.getpId() }</h2>
      <h2>Stock : ${desk.getStock() }<h2>
      <h2>Material : ${desk.getMaterial() }<h2>
                <div class="price">${desk.getPrice() } Rs.</div>

            </div>
        </div>
        
        </c:forEach>
  
    </div>
    
        <h1 class="title"> our <span>Calculator products</span>  </h1>

    <div class="box-container">

<c:forEach var="calc" items="${calcs}">

        <div class="box">
            <div class="icons ${calc.getpId() }" onclick="return addToCart(['${calc.getpId() }','${calc.getpName() }', '${calc.getPrice() }', '1', '${calc.getImage()}'])">
                <a  class="fas fa-shopping-cart"></a>
            </div>
            <div class="icons ${calc.getpId() }" style="display:none;" onclick="return removeFromCart(['${calc.getpId() }'])">
                <a  class="fa fa-trash-o"></a>
            </div>
            <div class="image">
                <img src="${calc.getImage() }" alt="" height="10" width="150">
            </div>
            <div class="content">
                <h3>${calc.getpName() }</h3>
                <h2>Publisher : ${calc.getCompName() }</h2>
                <h2>Product Description : ${calc.getDes() }</h2>
                <h2>Product ID    : ${calc.getpId() }</h2>
      <h2>Stock : ${calc.getStock() }<h2>
      <h2>Type : ${calc.getType() }<h2>
                <div class="price">${calc.getPrice() } Rs.</div>

            </div>
        </div>
        
        </c:forEach>
  
    </div>

</section>



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
				image:a[4],
			},
			
			success:function(data){
				x[0].style.display = "none";
				x[1].style.display="flex";
			}
		})
	}
</script>
<script>

	function removeFromCart(a)
	{
		var x = document.getElementsByClassName(a[0]);
		
		$.ajax({
			type:"POST",
			url:"deleteQty",
			data:{
				id:a[0],
			},
			
			success:function(data){
				x[0].style.display = "flex";
				x[1].style.display="none";
			}
		})
	}
</script>
</body>
</html>