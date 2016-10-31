package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.order.Order;
import model.product.Product;

public class OrderDAO extends Databaseoperation{
	
	private static Set<Order> orders = new HashSet<Order>();
	
	public OrderDAO() {
		super();
	}
	
	public Set<Order> getAllOrders(){
		return orders;
		// To do: select * from orders and add to set for return
	}
	
	public Order getOrder(int orderID) {
		Order order = new Order();
		String getquery = "SELECT OrderID, `OrderPrice`, `Customer_Username`, `OrderDate`, `OrderStatus_StatusID` FROM Order WHERE OrderID = ?;";
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
	
//	public void createOrder(float amount, String username, String orderdate){
//		String addquery = "INSERT INTO `Order` (`OrderPrice`, `Customer_Username`, `OrderDate`, `OrderStatus_StatusID`, `Cart_CartID`) VALUES (?,?,?,?,?);";
//
//		// To do: add shipping address to the address table with association to the created order
//		
//		Connection connection = super.getConnection();
//		Statement stmt = null;
//
//		try {
//			stmt = connection.createStatement();
//
//			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(addquery);
//			preStatement.setFloat(1, amount);
//			preStatement.setString(2, username);
//			preStatement.setString(3, orderdate);
//			preStatement.setInt(4, 1);
//			preStatement.setInt(5, 1); // To do: properly associate order with cart
//			
//			ResultSet rs = preStatement.executeQuery();
//
//			stmt.close();
//			rs.close();
//
//		} catch (SQLException e) {
//			System.out.println(e.toString());
//		}
//
//		super.closeConnection(connection); 
//	}
//	
	
	public void payOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 1 WHERE OrderID = " + orderID;
				
		super.accessDatabase(updateOrderQuery);
	}
	
	public void fullfillOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 2 WHERE OrderID = " + orderID;
		
		super.accessDatabase(updateOrderQuery);
	}
	
	public void shipOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 3 WHERE OrderID = " + orderID;
		
		super.accessDatabase(updateOrderQuery);
	}
	
	public void deliverOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 4 WHERE OrderID = " + orderID;
		
		super.accessDatabase(updateOrderQuery);
	}
	
	public void cancelOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 5 WHERE OrderID = " + orderID;
		
		super.accessDatabase(updateOrderQuery);
	}

	public void refund(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 6 WHERE OrderID = " + orderID;
		
		super.accessDatabase(updateOrderQuery);
	}
	
	public String getOrderStatus(int orderID){
		String searchquery = "SELECT OrderStatus.StatusName FROM OrderStatus INNER JOIN Order on Order.OrderStatus_StatusID = OrderStatus.StatusID WHERE Order.OrderID = " + orderID; 
        super.accessDatabase(searchquery);
        return (String) super.resultlist.get(1);  //return getOrderStatus
	}
	
	public void getProductDetail(int ProductID){
		
		String searchquery = "SELECT ProductName, ProductDecription, ProductPrice ProductOwner FROM product where ProductID =" +ProductID +";";               
        super.accessDatabase(searchquery);
        
	}
	
	public void getCustomerDetail(String customerusername){
		
		String searchquery = "SELECT Username, Firstname, LastName, Address, PhoneNumber, Email FROM customer where Username =" + customerusername + ";";              
        super.accessDatabase(searchquery);
	}
}
