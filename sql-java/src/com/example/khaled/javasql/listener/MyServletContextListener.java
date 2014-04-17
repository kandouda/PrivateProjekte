package com.example.khaled.javasql.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent srvCtxt) {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/world",
					"scwcd", "test");
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

		srvCtxt.getServletContext().setAttribute("dbCon", con);
	}

}
