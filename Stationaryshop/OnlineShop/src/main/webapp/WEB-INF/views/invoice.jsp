<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="resources/css/show.css" />">
    <title>Fabcart</title>
    <style>
    
    
    
.clearfix:after {
  content: "";
  display: table;
  clear: both;
}

a {
  color: #5D6975;
  text-decoration: underline;
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
}

#project span {
  color: #5D6975;
  text-align: right;
  width: 52px;
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
}

table tr:nth-child(2n-1) td {
  background: #F5F5F5;
}

table th,
table td {
  text-align: center;
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
	

    
    
    <div class="clearfix">
      <div id="logo">
        <img src="<c:url value="resources/img/logo.png"/>">
      </div>
      <h1>INVOICE 3-2-1</h1>
      <div id="company" class="clearfix">
        <div>Name - ${user.getName() }</div>
        <div>Email - ${user.getEmail() }</div>
        <div>Moblie - ${user.getMobile() }</div>
        <div>Address - ${user.address.gethNo() }, ${user.address.getAddress1() }, ${user.address.getAddress2() } </div>
        <div>&emsp; ${user.address.getCity() } - ${user.address.getPincode() }</div>
      </div>
      <div id="project">
        <div><span>Invoice No:</span> ${bill.getId() }</div>
        <div><span>Order ID:</span> ${bill.getOrderId() }</div>
        <div><span>Order Date:</span> ${bill.getOrderingDate() }</div>
      </div>
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
        <c:forEach var="ci" items="${cartItem}">
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
      <button><a href="home" style="text-decoration:none;">Home</a></button>
      <button onclick="window.print();">Print</button>
    </main>
    <footer>
      Invoice was created on a computer and is valid without the signature and seal.
    </footer>      

</body>
</html>