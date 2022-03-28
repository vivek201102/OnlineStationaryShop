<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page isELIgnored="false" %>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />">
<style>
    
    
    
.clearfix:after {
  content: "";
  display: table;
  clear: both;
}



body {
  position: relative;
  width: 21cm;   
  margin: 0 auto; 
  color: #001028;
  background: #FFFFFF; 
  font-family: Arial, sans-serif; 
  font-size: 12px; 
  font-family: Arial;
}

header {
  padding: 10px 0;
  margin-bottom: 30px;
}

#logo {
  text-align: center;
  margin-bottom: 10px;
}

#logo img {
  width: 90px;
}

h1 {
  border-top: 1px solid  #5D6975;
  border-bottom: 1px solid  #5D6975;
  color: #5D6975;
  font-size: 2.4em;
  line-height: 1.4em;
  font-weight: normal;
  text-align: center;
  margin: 0 0 20px 0;
  background: url(dimension.png);
}

#project {
  float: left;
  font-size:20px;
  margin-top:15%;
}

#project span {
  color: #5D6975;
  text-align: right;
  width: 85px;
  margin-right: 10px;
  display: inline-block;
  font-size: 0.8em;
}

#company {
  float: right;
  text-align: right;
}

#project div,
#company div {
  white-space: nowrap;        
}

table {
  width: 100%;
  border-collapse: collapse;
  border-spacing: 0;
  margin-bottom: 20px;
  margin-top:10%;
}

table tr:nth-child(2n-1) td {
  background: #F5F5F5;
}

table th,
table td {
  text-align: center;
  font-size:18px;
}

table th {
  padding: 5px 20px;
  color: #5D6975;
  border-bottom: 1px solid #C1CED9;
  white-space: nowrap;        
  font-weight: normal;
}

table .service,
table .desc {
  text-align: left;
}

table td {
  padding: 20px;
  text-align: right;
}

table td.service,
table td.desc {
  vertical-align: top;
}

table td.unit,
table td.qty,
table td.total {
  font-size: 1.2em;
}

table td.grand {
  border-top: 1px solid #5D6975;;
}

#notices .notice {
  color: #5D6975;
  font-size: 1.2em;
}

footer {
  color: #5D6975;
  width: 100%;
  position: absolute;
  bottom: 0;
  top:120%;
  border-top: 1px solid #C1CED9;
  padding: 8px 0;
  text-align: center;
}
    </style>


</head>
<body>
<header class="header">

    <a href="home.html" class="logo">  Your Stationary </a>

    <nav class="navbar">
        <a href="home">home</a>
        <a href="">Product</a>
        <a href="history">Past Order</a>
        <a href="cart">View Cart</a>
        <a href="#">LogOut</a>
    </nav>
</header>
      <br><br><br><br><br><br>
		<div id="project">
		<div><span>Name:</span>${user.getName() }</div>
        <div><span>Email:</span>${user.getEmail() }</div>
        <div><span>Mobile:</span>${user.getMobile() }</div>
        <div><span>Address:</span>${user.address.gethNo() }, ${user.address.getAddress1() }, ${user.address.getAddress2() }, ${user.address.getCity() } - ${user.address.getPincode() }</div>
		</div>
      
      <br><br><br>
      <c:forEach var="bill" items="${history}">
	<div id="project">
        <div><span>Invoice No:</span> ${bill.getId() }</div>
        <div><span>Order ID:</span> ${bill.getOrderId() }</div>
        <div><span>Order Date:</span> ${bill.getOrderingDate() }</div>
        <br>
        <br>
      </div>
 
    <main>
      <table>
        <thead>
          <tr>
            <th class="service">Product ID</th>
            <th class="desc">Product Name</th>
            <th>PRICE</th>
            <th>QTY</th>
            <th>TOTAL</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="ci" items="${bill.getitemPerOrder()}">
          <tr>
                        <td class="service">${ci.getProdId() }</td>
                        <td class="desc">${ci.getProdName() }</td>
                        <td class="unit">${ci.getProdPrice() }</td>
                        <td class="qty">${ci.getProdCount() }</td>
                        <td class="total">${ci.getProdTotal() }</td>
          </tr>
          </c:forEach>
          <tr>
            <td colspan="4">SUBTOTAL</td>
            <td class="total">${bill.getTotal() }</td>
          </tr>
          <c:set var="total" value="${bill.getTotal() }"></c:set>
                    <c:set var="tax" value="${ total * 0.1 }"></c:set>
                    <fmt:parseNumber var = "i" integerOnly = "true" type = "number" value = "${tax}" />
          <tr>
            <td colspan="4">TAX 10%</td>
            <td class="total"><c:out value="${i}" /></td>
          </tr>
          <tr>
            <td colspan="4" class="grand total">GRAND TOTAL</td>
            <td class="grand total">${bill.getGrandTotal() }</td>
          </tr>
        </tbody>
      </table>
      </main>
      <br><br><br>
      </c:forEach>
</body>
</html>