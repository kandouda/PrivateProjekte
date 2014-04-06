
package com.example.khaled.servlet.listener;

import java.sql.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	Connection con = null;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent srvCtxt) {

		System.out.println(srvCtxt.getServletContext().getInitParameter(
			"developerEmailAddress"));

		try {
			Class.forName("com.mysql.jdbc.Driver");

		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/world", "scwcd", "test");
		}
		catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		
		srvCtxt.getServletContext().setAttribute("dbCon", con);
	}

}
