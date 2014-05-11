<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.example.khaled.login.user.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start Seite</title>


<%
	UserBean loggedUser = (UserBean)session.getAttribute("currentSessionUser");
%>

<%
	if(loggedUser == null || !loggedUser.valid){
		response.sendRedirect("login.jsp");
	}
%>

<h1 align="center">Start Page Page hallo <%= loggedUser.getFirstName() %></h1>

<ul>
	<li><a href="<%=request.getContextPath()%>/downup">
			Upload Download
		</a>
	</li>
	<li><a href="beerselection">
			Beer Select
		</a>
	</li>
</ul>

</head>
<body>

</body>
</html>