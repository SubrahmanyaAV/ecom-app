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
	 List<Product> list=(List<Product>)session.getAttribute("CART"); 
	 Double total = (Double) session.getAttribute("TOTAL");
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
				for(Product p : list){
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
	
	<p> Total  <%=total %></p>
	
		<a href="LoginServlet"><button>Buy Now</button> </a>



</body>
</html>