<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
</head>
<body>
<h2>Customers</h2>
<table>
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Mobile</th>
		<th colspan="3">Shipping Address</th>
		
	
	</tr>
	<c:forEach var="user" items="${users}">
	<tr>
			<td>${user.name }</td>
			<td>${user.email }</td>
			<td>${user.mobile }</td>
			<td>${user.address.hNo }, ${user.address.address1 }</td>
			<td>${user.address.address2 }</td>
			<td>${user.address.city } - ${user.address.pincode }</td>

		</tr>
		</c:forEach>
</table>
</body>
</html>