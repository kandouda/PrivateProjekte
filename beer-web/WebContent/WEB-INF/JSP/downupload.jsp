<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.example.khaled.login.user.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>download and upload seite</title>
</head>
<body>

	<%
		UserBean loggedUser = (UserBean) session
				.getAttribute("currentSessionUser");
	%>

	<%
		if (loggedUser == null || !loggedUser.valid) {
			response.sendRedirect("login.jsp");
		}
	%>

	<form method="post" action="updownload.do"
		enctype="multipart/form-data">
		Select File to Upload: <br> <input type="file" size="50"
			style="border: 1px solid red; width: 600px;" name="fileOne">
		<br> <input type="file" size="50"
			style="border: 1px solid red; width: 600px;" name="fileTwo">
		<br> <input type="file" size="50"
			style="border: 1px solid red; width: 600px;" name="fileThree">
		<br> <input type="file" size="50"
			style="border: 1px solid red; width: 600px;" name="fileTFour">
		<br> <input type="submit" value="Upload">
	</form>

</body>
</html>