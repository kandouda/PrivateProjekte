package com.example.khaled;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExceptionHandler
 */
@WebServlet("/handleException")
public class ExceptionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String errorMessage = (String) request
				.getAttribute("javax.servlet.error.message");
		String requestURI = (String) request
				.getAttribute("javax.servlet.error.request_uri");
		int statusCode = (int) request
				.getAttribute("javax.servlet.error.status_code");

		PrintWriter pw = response.getWriter();
		pw.write("<html><body>error message " + errorMessage
				+ "; <br>request uri " + requestURI + "; <br> status code "
				+ statusCode + "</body></html>");
		pw.flush();
		pw.close();
	}

}
