<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="java.sql.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
		Connection con = (Connection) application.getAttribute("dbCon");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT Name from country where Code='LBN'");

		while (rs.next()) {
			out.println("Ich komme aus " + rs.getString(1));
		}

		stmt.close();
		con.close();
	%>

</body>
</html>