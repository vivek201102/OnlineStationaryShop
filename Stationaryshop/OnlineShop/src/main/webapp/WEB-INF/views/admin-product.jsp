<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Admin Pages</h2>
	
		<h3>Books</h3>
		<a href="bookform">Add Book</a>
		<table>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Publisher</th>
				<th>Author</th>
				<th>No of Pages</th>
				<th>Price</th>
				<th>Stock</th>
				<th>Image</th>
			</tr>
			<tr>

			</tr>


			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.getpId() }</td>
					<td>${book.getpName() }</td>
					<td>${book.getDes() }</td>
					<td>${book.getCompName() }</td>
					<td>${book.getAuthor()}</td>
					<td>${book.getPages()}</td>
					<td>${book.getPrice() }</td>
					<td>${book.getStock() }</td>
					<td><img src="${book.getImage()}" height="100" width="100"></td>
					<form method="post" action="updatebookform">
					<input type="hidden" name="pid" value="${book.getId()}">
					<td><button>Update</button></td>
					</form>
					<form method="post" action="deletebook">
					<input type="hidden" name="pid" value="${book.getId()}">
					<td><button>Remove</button></td>
					</form>
				</tr>
			</c:forEach>
		</table>
		
				<h3>Pens</h3>
		<a href="penform">Add Pen</a>
		<table>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Publisher</th>
				<th>Color</th>
				<th>Price</th>
				<th>Stock</th>
				<th>Image</th>
			</tr>
			<tr>

			</tr>


			<c:forEach var="book" items="${pen}">
				<tr>
					<td>${book.getpId() }</td>
					<td>${book.getpName() }</td>
					<td>${book.getDes() }</td>
					<td>${book.getCompName() }</td>
					<td>${book.getColor()}</td>
					<td>${book.getPrice() }</td>
					<td>${book.getStock() }</td>
					<td><img src="${book.getImage()}" height="100" width="100"></td>
					<form method="post" action="updatepenform">
					<input type="hidden" name="pid" value="${book.getId()}">
					<td><button>Update</button></td>
					</form>
					<form method="post" action="deletebook">
					<input type="hidden" name="pid" value="${book.getId()}">
					<td><button>Remove</button></td>
					</form>
				</tr>
			</c:forEach>
		</table>
		
		
				<h3>Desk</h3>
		<a href="deskform">Add Desk</a>
		<table>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Company Name</th>
				<th>Material</th>
				<th>Price</th>
				<th>Stock</th>
				<th>Image</th>
			</tr>
			<tr>

			</tr>


			<c:forEach var="book" items="${desk}">
				<tr>
					<td>${book.getpId() }</td>
					<td>${book.getpName() }</td>
					<td>${book.getDes() }</td>
					<td>${book.getCompName() }</td>
					<td>${book.getMaterial()}</td>
					<td>${book.getPrice() }</td>
					<td>${book.getStock() }</td>
					<td><img src="${book.getImage()}" height="100" width="100"></td>
					<form method="post" action="updatedeskform">
					<input type="hidden" name="pid" value="${book.getId()}">
					<td><button>Update</button></td>
					</form>
					<form method="post" action="deletedesk">
					<input type="hidden" name="pid" value="${book.getId()}">
					<td><button>Remove</button></td>
					</form>
				</tr>
			</c:forEach>
		</table>
		
		
				<h3>Calculator</h3>
		<a href="calcform">Add calculator</a>
		<table>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Company Name</th>
				<th>Type</th>
				<th>Price</th>
				<th>Stock</th>
				<th>Image</th>
			</tr>
			<tr>

			</tr>


			<c:forEach var="book" items="${calc}">
				<tr>
					<td>${book.getpId() }</td>
					<td>${book.getpName() }</td>
					<td>${book.getDes() }</td>
					<td>${book.getCompName() }</td>
					<td>${book.getType()}</td>
					<td>${book.getPrice() }</td>
					<td>${book.getStock() }</td>
					<td><img src="${book.getImage()}" height="100" width="100"></td>
					<form method="post" action="updatecalcform">
					<input type="hidden" name="pid" value="${book.getId()}">
					<td><button>Update</button></td>
					</form>
					<form method="post" action="deletebook">
					<input type="hidden" name="pid" value="${book.getId()}">
					<td><button>Remove</button></td>
					</form>
				</tr>
			</c:forEach>
		</table>
</body>
</html>