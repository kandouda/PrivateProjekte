<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
<h3>Login successful! </h3>

<!-- variable name is the same of the attribute name user -->
	<!-- userBean in order to get an object named user from the request scope and wen save this object to a variabled valled user -->
	<jsp:useBean id="user" class="org.khaled.javabrains.dto.User" scope="request">
</jsp:useBean>

<%-- Hello <%=user.getUserName()%> --%>
Hello <jsp:getProperty property="userName" name="user"/>

</body>
</html>