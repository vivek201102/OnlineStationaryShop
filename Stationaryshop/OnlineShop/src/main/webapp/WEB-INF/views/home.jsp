<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>home</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">

</head>
<body>
<header class="header">

    <a href="home.html" class="logo">  Your Stationary </a>

    <nav class="navbar">
        <a href="home.jsp">home</a>
        <a href="view_product.jsp">Product</a>
        <a href="history">Past Order</a>
        <a href="cart">View Cart</a>
        <a href="#">LogOut</a>
    </nav>
</header>
<section class="home">

    <div class="slides-container">

        <div class="slide active">
            <div class="content">
                <h3>upto 50% off</h3>
                <a href="book" class="btn">View Book Products</a>
            </div>
            <div class="image">
                <img src="<c:url value="/resources/img/1.jpg" />" alt="">
            </div>
        </div>

    </div>

</section>

<section class="banner-container">

    <div class="banner">
        <img src="<c:url value="/resources/img/2.jpg" />" alt="">
        <div class="content">
            <span>limited sales</span>
            <h3>upto 50% off</h3>
            <a href="calc" class="btn">View Calculator Products</a>
        </div>
    </div>

    <div class="banner">
        <img src="<c:url value="/resources/img/3.jpg" />" alt="">
        <div class="content">
            <span>limited sales</span>
            <h3>upto 50% off</h3>
            <a href="desk" class="btn">View Desk Products</a>
        </div>
    </div>

    <div class="banner">
        <img src="<c:url value="/resources/img/4.jpg" />" alt="">
        <div class="content">
            <span>limited sales</span>
            <h3>upto 50% off</h3>
            <a href="pen" class="btn">View Pen Products</a>
        </div>
    </div>

</section>

<script src="js/script.js"></script>
</body>
</html>