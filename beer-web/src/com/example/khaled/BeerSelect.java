package com.example.khaled;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.khaled.model.BeerExpert;

/**
 * Servlet implementation class BeerSelect
 */
public class BeerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/beer-web/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		String userName = request.getParameter("userName");
		session.setAttribute("userName", userName);
		
		PrintWriter out = response.getWriter();
		
		String color = request.getParameter("color");
		BeerExpert beerExpert = new BeerExpert();
		request.setAttribute("styles", beerExpert.getBrands(color));
		
		String emailAddress = getServletContext().getInitParameter("developerEmailAddress");
		request.setAttribute("developerEmailAddress", emailAddress);
		
		System.out.println( "request url before forward " +  request.getRequestURL());
		System.out.println("Query String before " + request.getQueryString());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/JSP/result.jsp?name=khaled");
		requestDispatcher.forward(request, response);
	}

}
