package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.constant.Constant;

public class Databaseoperation {


	public Connection getConnection() {
		try {
			System.out.println("Loading JDBC driver...");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC driver successfully loaded!");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		Connection connection = null;
		//Statement stmt = null;

		try {
			System.out.println("Connecting to the MySQL database...");
			connection = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);			
			System.out.println("MySQL Database connected!");
		}
	    catch (SQLException e) {
		System.out.println(e.toString());
	    }
		return connection;
	 }
	
	public void closeConnection(Connection connection){ 
			System.out.println("Closing the connection.");
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}


