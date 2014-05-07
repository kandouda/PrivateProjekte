package com.example.khaled.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.khaled.login.user.UserBean;
import com.example.khaled.login.user.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.check")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserBean loggedUser = (UserBean) request.getSession().getAttribute("currentSessionUser");
		
		if (loggedUser == null || !loggedUser.valid) {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserBean user = new UserBean();
		user.setUserName(request.getParameter("un"));
		user.setPassword(request.getParameter("pw"));

		user = UserDAO.login(user);

		if (user.isValid()) {
			HttpSession session = request.getSession(true);
			session.setAttribute("currentSessionUser", user);
			RequestDispatcher rd = request.getRequestDispatcher("start.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("invalidLogin.jsp");
			rd.forward(request, response);
		}
	}

}
