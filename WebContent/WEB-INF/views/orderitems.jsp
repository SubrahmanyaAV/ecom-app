<%@page import="com.cruds.entity.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Orders</title>
</head>
<body>

	<%
	List<Order> list=(List<Order>) session.getAttribute("O");
	%>
	<br>
	<a href="index.jsp">Home</a>
<br><br>
	<table border="1">
		<thead>
			<tr>
				<th>Id </th>
				<th>Order Id</th>
				<th>Order Date</th>
				<th>Delivery Date</th>
				<th>Item Id</th>
				<th>Item Name</th>
				<th>Item Price</th>
				<th>Item Quantity</th>
				<th>Status</th>
			</tr>
		</thead>

		<tbody>
			<%
					if (list != null) {
						for (Order o : list) {
			%>
			<tr>
				<td><%=o.getO_Id() %>
				<td><%=o.getOrderId() %>
				<td><%=o.getOrderDate()%></td>
				<td><%=o.getDlvDate()%>
				<td><%=o.getItemId()%></td>
				<td><%=o.getItemName() %></td>
				<td><%=o.getItemPrice() %></td>
				<td><%=o.getItemQuantity() %></td>
				<td><%=o.getStatus()%></td>

			</tr>
			<%
					}
				}
			%>
		</tbody>
	</table>



</body>
</html>