package com.example.khaled.login.user.dao;

import java.sql.*;

import com.example.khaled.login.db.connection.ConnectionManager;
import com.example.khaled.login.user.UserBean;

public class UserDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;

	public static UserBean login(UserBean userBean) {

		Statement stmt = null;

		String userName = userBean.getUserName();
		String userPassword = userBean.getPassword();

		String searchQuery = "select * from users where userName='" + userName
				+ "' and UserPassword='" + userPassword + "'";

		System.out.println("Your user name is " + userName);
		System.out.println("Xour password is " + userPassword);
		System.out.println("Query: " + searchQuery);

		// connect to db
		currentCon = ConnectionManager.getConnection();
		try {
			stmt = currentCon.createStatement();

			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			// User does not exist in the db
			if (!more) {
				System.out
						.println("Sorry, your username or your password are incorrect");
				userBean.setValid(false);
			} else if (more) {
				userBean.setFirstName(rs.getString("FirstName"));
				userBean.setLastName(rs.getString("LastName"));
				userBean.setValid(true);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			System.out
					.println("trying to close connection and statement and resultset");

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					rs = null;
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					stmt = null;
				}
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (SQLException e) {
					currentCon = null;
				}
			}
		}
		return userBean;
	}

}