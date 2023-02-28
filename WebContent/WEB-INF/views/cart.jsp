<%@page import="com.cruds.entity.User"%>
<%@page import="com.cruds.entity.Cart"%>
<%@page import="com.cruds.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
</head>
<body>

	<%
	 String user = (String) session.getAttribute("USERNAME");
	 List<Product> list=(List<Product>)session.getAttribute("CART"); 
	 Double total = (Double) session.getAttribute("TOTAL");
	 %>

	<%
	if(user != null)//if user decides to order again ,so user doesnot have to login again
	{
		//<!-- "WebContent/WEB-INF/views/checkout.jsp" -->
	%>	
	
		<table border="1">
		<thead>
			<tr>
				<td>Product Name</td>
				<td>Price</td>
				<td>Quantity</td>
			</tr>
		</thead>
		<tbody>
			<%
				for(Product p : list)
				{
			%>
			<tr>
				<td><%= p.getPname() %></td>
				<td><%= p.getPrice() %></td>
				<td><%= p.getQuantity() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<br>
		<a href="CheckoutServlet"><button>Buy Now</button> </a>
	<%
	}
	else if(list != null)
		{
	 %>	
	<table border="1">
		<thead>
			<tr>
				<td>Product Name</td>
				<td>Price</td>
				<td>Quantity</td>
			</tr>
		</thead>
		<tbody>
			<%
				for(Product p : list)
				{
			%>
			<tr>
				<td><%= p.getPname() %></td>
				<td><%= p.getPrice() %></td>
				<td><%= p.getQuantity() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

	<br>
	<p>Total <%=total %></p>
	
		
		
		<a href="LoginServlet"><button>Buy Now</button> </a>
		

	<%
	}
	else{
	%>

	<h1>No items in the Cart</h1>
	<%
		}
	%>
	<br><br>
	<a href="index.jsp">Home</a>


</body>
</html>