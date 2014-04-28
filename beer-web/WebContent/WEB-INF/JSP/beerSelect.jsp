<%@page import="com.exmaple.khaled.login.user.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Beer Select</title>
</head>
<body>

<%
	UserBean loggedUser = (UserBean)session.getAttribute("currentSessionUser");
%>

<h1 align="center">Beer Selection Page hallo <% loggedUser.getFirstName(); %></h1>
<form method="post" action="SelectBeer.do">
	Select beer characteristics<p>
	Color:
	<select name="color" size="1">
		<option value="light">light</option>
		<option value="amber">amber</option>
		<option value="brown">brown</option>
		<option value="dark">dark</option>
	</select>
	<br><br>
	<input type="checkbox" name="sizes" value="1oz" id="1oz"><label for="1oz">1oz</label><br>
	<input type="checkbox" name="sizes" value="2oz" id="2oz"><label for="2oz">2oz</label><br>
	<input type="checkbox" name="sizes" value="3oz" id="3oz"><label for="3oz">3oz</label><br>
	<center>
		<input type="submit">
		<input type="reset">
	</center>
	<a href="download.do">click</a>
</form>

<form action="PrintParams?param1=First0" method="post">
	<input type="hidden" name="param1" value="First" />
	<input type="text" name="param1" value="Second" />
	<input type="radio" name="param1" value="Third" />
	<input type="submit" />
</form>

</body>
</html>