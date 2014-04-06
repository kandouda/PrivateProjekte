package com.example.khaled;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter out = response.getWriter();
		out.println("Beer selection Advice<br>");
		String color = request.getParameter("color");
		BeerExpert beerExpert = new BeerExpert();
		request.setAttribute("styles", beerExpert.getBrands(color));
		
		String emailAddress = getServletContext().getInitParameter("developerEmailAddress");
		request.setAttribute("developerEmailAddress", emailAddress);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/result.jsp");
		requestDispatcher.forward(request, response);
	}

}
