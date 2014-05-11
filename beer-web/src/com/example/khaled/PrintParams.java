package com.example.khaled;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintParams
 */
@WebServlet("/PrintParams")
public class PrintParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		throw new ServletException();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<html>\n<head>\n<title>Print Parameters</title>\n</head>\n<body>");
		String[] params = request.getParameterValues("param1");
		
		for (int i = 0; i < params.length; i++) {
			out.write(params[i] + ":");
		}
		
		Map paramsMap = request.getParameterMap();
		Set s = paramsMap.entrySet();
		
		out.write("\n</body>\n</html>");
		out.close();
	}

}
