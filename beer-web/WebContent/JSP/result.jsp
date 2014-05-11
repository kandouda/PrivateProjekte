<%@page import="org.eclipse.jdt.internal.compiler.ast.WhileStatement"%>
<%@page import="sun.org.mozilla.javascript.internal.ast.WhileLoop"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println("Hallo " + session.getAttribute("userName") + "<br>");
	%>
	<h1>Beer Recommendations JSP</h1>
	<p>

		<%
			List<String> styles = (List) request.getAttribute("styles");

			Iterator<String> it = styles.iterator();
			while (it.hasNext()) {
				out.println("<br>try: " + it.next());
			}

			String[] checkedOz = request.getParameterValues("sizes");
			out.println(Arrays.toString(checkedOz));
			out.println("<br>This is my email address: "
					+ request.getAttribute("developerEmailAddress"));
			System.out.println("request url after forward "
					+ request.getRequestURL());
			System.out
					.println("Query String after " + request.getQueryString());
			System.out
					.println("original request url after forward "
							+ request
									.getAttribute("javax.servlet.forward.request_uri"));
		%>
	
</body>
</html>