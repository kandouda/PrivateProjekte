<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form action="login.check" method="post">
		<label>Please enter your username</label>
		<input type="text" name="un" required>
		
		<br>
		<label>Please enter your password</label>
		<input type="password" name="pw" required>
		
		<input type="submit" value="submit">
	</form>
</body>
</html>