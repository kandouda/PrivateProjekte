package com.example.khaled.servlet.listener;

import java.sql.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent srvCtxt) {

		System.out.println(srvCtxt.getServletContext().getInitParameter(
				"developerEmailAddress"));
	}
}
