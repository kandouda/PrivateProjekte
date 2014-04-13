package com.khaled.jdbc.tutorial.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMySQLConnection {
	private static JDBCMySQLConnection instance = new JDBCMySQLConnection();
	public static final String URL = "jdbc:mysql://localhost:3306/jdbctutorial";
	public static final String USER = "tutorial";
	public static final String PASSWORD = "prodyna";
	public static final String DRIVER_Class = "com.mysql.jdbc.Driver";

	private JDBCMySQLConnection() {
		try {
			Class.forName(DRIVER_Class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR: Unable to connect to the Database");
		}
		return connection;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}
}
