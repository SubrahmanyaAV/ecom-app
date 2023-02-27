<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
</head>
<body>

	<%
		String error = (String) request.getAttribute("ERROR");
		if (error != null) {
	%>
	<p><%=error%></p>
	<%
		}
	%>

	<form action="LoginServlet" method="post">
		<label>User Name:</label>
		<input type="text" name="userName"/>
		<br/>
		<label>Password:</label>
		<input type="password" name="pwd"/>
		<br/>
		<input type="submit" value="Login"/>
	</form>	   
	
	<b><font size ="4">new user? </font></b>
	<a href="UserServlet" >register</a>


</body>
</html>