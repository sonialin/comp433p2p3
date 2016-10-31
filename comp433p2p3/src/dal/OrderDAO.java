package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.order.Order;

public class OrderDAO extends Databaseoperation{
	
	public OrderDAO(){
		super();
	}
	
	public void createOrder(float amount, String username, String orderdate){
		String addquery = "INSERT INTO `Order` (`OrderPrice`, `Customer_Username`, `OrderDate`, `OrderStatus_StatusID`, `Cart_CartID`) VALUES (?,?,?,?,?);";

		// To do: add shipping address to the address table with association to the created order
		
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();

			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(addquery);
			preStatement.setFloat(1, amount);
			preStatement.setString(2, username);
			preStatement.setString(3, orderdate);
			preStatement.setInt(4, 1);
			preStatement.setInt(5, 1); // To do: properly associate order with cart
			
			ResultSet rs = preStatement.executeQuery();

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection); 
	}
	
	public Order getOrder(int orderID) {
		Order order = new Order();
		String getquery = "SELECT OrderID, `OrderPrice`, `Customer_Username`, `OrderDate` FROM Order WHERE OrderID = ?;";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(getquery);
			preStatement.setInt(1, orderID);
			ResultSet rs = preStatement.executeQuery();
		
			order.setorderID(orderID);
			order.settotalprice(rs.getFloat(2));
			order.setusername(rs.getString(3));
			order.setorderdate(rs.getString(4));

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

		return order;

	}
	
	public void payOrder(int orderID){
		String updatequery = "UPDATE Order SET OrderStatus_StatusID = 1 WHERE OrderID = ?;";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();

			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updatequery);

			preStatement.setInt(1, orderID);

			ResultSet rs = preStatement.executeQuery();

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
	
	public void fulfillOrder(int orderID){
		String updatequery = "UPDATE Order SET OrderStatus_StatusID = 2 WHERE OrderID = ?;";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();

			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updatequery);

			preStatement.setInt(1, orderID);

			ResultSet rs = preStatement.executeQuery();

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
	
	public void shipOrder(int orderID){
		String updatequery = "UPDATE Order SET OrderStatus_StatusID = 3 WHERE OrderID = ?;";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();

			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updatequery);

			preStatement.setInt(1, orderID);

			ResultSet rs = preStatement.executeQuery();

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
	
	public void deliverOrder(int orderID){
		String updatequery = "UPDATE Order SET OrderStatus_StatusID = 4 WHERE OrderID = ?;";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();

			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updatequery);

			preStatement.setInt(1, orderID);

			ResultSet rs = preStatement.executeQuery();

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
	
	public void cancelOrder(int orderID){
		String updatequery = "UPDATE Order SET OrderStatus_StatusID = 5 WHERE OrderID = ?;";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();

			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updatequery);

			preStatement.setInt(1, orderID);

			ResultSet rs = preStatement.executeQuery();

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}

	public void refund(int orderID){
		String updatequery = "UPDATE Order SET OrderStatus_StatusID = 6 WHERE OrderID = ?;";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();

			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updatequery);

			preStatement.setInt(1, orderID);

			ResultSet rs = preStatement.executeQuery();

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
		
//	public String getOrderStatus(int orderID){
//		String status = "";
//		String selectquery = "SELECT OrderStatus.StatusName FROM OrderStatus INNER JOIN Order on Order.OrderStatus_StatusID = OrderStatus.StatusID WHERE Order.OrderID = ?;";
//		Connection connection = super.getConnection();
//		Statement stmt = null;
//
//		try {
//			stmt = connection.createStatement();
//
//			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(selectquery);
//
//			preStatement.setInt(1, orderID);
//
//			ResultSet rs = preStatement.executeQuery();
//			
//			status = rs.getString(1);
//
//			stmt.close();
//			rs.close();
//
//		} catch (SQLException e) {
//			System.out.println(e.toString());
//		}
//
//		super.closeConnection(connection);
//		return status;
//	}
//	
//	public String getOrderDetails(int orderID){
//		return "some details";
//		// To do: add details attribute and the corresponding methods across layers
//	}
}
