<%@page import="java.util.List"%>
<%@page import="com.cruds.entity.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Page</title>
</head>
<body>

	<a href="index.html">Home</a>
	<br>
	<br>

	<%
			String msg = (String) session.getAttribute("MESSAGE");
		%>


	<%
			if (msg != null) {
		%>
	<center>
		<h1><%=msg%></h1>
	</center>
	<%
			}
		%>

	<br>
	<br>
	<a href="OrderItemsServlet">View Orders</a>



</body>
</html>