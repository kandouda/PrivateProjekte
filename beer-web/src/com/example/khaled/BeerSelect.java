package com.example.khaled;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelect() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		if(session.isNew()){
			System.out.println("session ist new " + session.getId());
		}	else {
			Date d = new Date(session.getLastAccessedTime() * 1000);
			System.out.println("session ist alt " + session.getId() + " .last accessd time is " + d);
		}
		
		PrintWriter out = response.getWriter();
		out.println("Beer selection Advice<br>");
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
