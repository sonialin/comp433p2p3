package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.joda.time.DateTime;

import model.order.Order;
import model.product.Product;

public class OrderDAO extends Databaseoperation{
	
	private static Set<Order> orders = new HashSet<Order>();
	
	public OrderDAO() {
		super();
	}
	
	public Set<Order> getAllOrders(){
		String getquery = "SELECT OrderID, `OrderPrice`, `Customer_Username`, `OrderDate`, `OrderStatus_StatusID` FROM Order;";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(getquery);
			ResultSet rs = preStatement.executeQuery();

			while (rs.next()) {
	            for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
	              orders.add((Order)rs.getObject(i));
	            }
	        }

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

		return orders;
	}
	
	public Order getOrder(int orderID) {
		Order order = new Order();
		String getquery = "SELECT `OrderID`, `OrderPrice`, `Customer_Username`, `OrderDate`, `OrderStatus_StatusID` FROM ecommerce.`Order` WHERE OrderID = ?;";
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
			order.setorderstatusID(rs.getInt(5));

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

		return order;
	}
	
	public Order createOrder(float amount, String username, String orderdate, String orderdetails){
		Order order = new Order();
		order.setamount(amount);
		order.setusername(username);
		order.setorderdate(orderdate);
		order.setorderstatusID(1);
		
		String addquery = "INSERT INTO `Order` (`OrderPrice`, `Customer_Username`, `OrderDate`, `OrderStatus_StatusID`, `Cart_CartID`) VALUES (?,?,?,?,?);";

		// To do: add shipping address to the address table with association to the created order
		// To do: add orderdetails field to db and all order layers
		
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
		return order;
	}
	
	public void payOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 1 WHERE OrderID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updateOrderQuery);
			preStatement.setInt(1, orderID);
			preStatement.executeQuery();

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
	
	public void fulfillOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 2 WHERE OrderID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updateOrderQuery);
			preStatement.setInt(1, orderID);
			preStatement.executeQuery();

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
	
	public void shipOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 3 WHERE OrderID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updateOrderQuery);
			preStatement.setInt(1, orderID);
			preStatement.executeQuery();

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
	
	public void deliverOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 4 WHERE OrderID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updateOrderQuery);
			preStatement.setInt(1, orderID);
			preStatement.executeQuery();

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
	
	public void cancelOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 5 WHERE OrderID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updateOrderQuery);
			preStatement.setInt(1, orderID);
			preStatement.executeQuery();

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}

	public void refundOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 6 WHERE OrderID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(updateOrderQuery);
			preStatement.setInt(1, orderID);
			preStatement.executeQuery();

			stmt.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
	}
	
	public String getOrderStatus(int orderID){
		String status = null;
		String getquery = "SELECT OrderStatus.StatusName FROM OrderStatus INNER JOIN Order on Order.OrderStatus_StatusID = OrderStatus.StatusID WHERE Order.OrderID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(getquery);
			preStatement.setInt(1, orderID);
			ResultSet rs = preStatement.executeQuery();

			status = rs.getString(1);

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

		return status;
		
	}
	
	public String getOrderDetails(){
		// To do
		return null;
	}
	
	public void deleteOrder(int orderID) {
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order order = (Order)it.next();
          if (order.getorderID()==orderID) {
        	  orders.remove(order);
        	  return;
          }
        }
	}
	
	public void submitOrder(Set<Product> products, String username){
		Iterator<Product> it = products.iterator();
		Order order;
		String orderdetails = null;
		float amount = 0; 
		while(it.hasNext()) {
          Product product = (Product)it.next();
          orderdetails += product.getProductID() ;
          orderdetails += product.getProductname();
          amount += product.getProductprice();
        }
		//order.createOrder(amount, username, DateTime.now().toString(), orderdetails);
	}
}