package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.costant.Constant;

public class Databaseoperation {

	protected final List resultlist = new ArrayList();

	public void accessDatabase(String query) {
		try {
			System.out.println("Loading JDBC driver...");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC driver successfully loaded!");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		Connection connection = null;
		Statement stmt = null;

		try {
			System.out.println("Connecting to the MySQL database...");
			connection = DriverManager.getConnection(Constant.URL, Constant.USERNAME, Constant.PASSWORD);
			System.out.println("MySQL Database connected!");
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			// output column name
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rsmd.getColumnName(i));
				System.out.print("(" + rsmd.getColumnTypeName(i) + ")");
				System.out.print(" | ");
			}
			System.out.println();
			
			resultlist.clear();      //clear resultlist first before adding new search results
			// output data
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					resultlist.add(rs.getString(i));        //restore search results into an arraylist
					System.out.print(rs.getObject(i) + " | ");
				}
				System.out.println();
			}
			// while (rs.next()) {
			// System.out.print(rs.getString(1));
			// System.out.print(" ");
			// System.out.println(rs.getString(2));
			// System.out.print(" ");
			// System.out.println(rs.getString(3));
			// }
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("Closing the connection.");
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

}
