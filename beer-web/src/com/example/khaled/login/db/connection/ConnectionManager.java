package com.example.khaled.login.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	static Connection con;
	static String url;

	public static Connection getConnection() {

		url = "jdbc:mysql://localhost/sql_java";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			try {
				con = DriverManager.getConnection(url, "scwcd", "test");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return con;
	}

}
