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

import model.constant.Constant;
import model.order.Order;
import model.product.Product;

public class OrderDAO extends Databaseoperation{
	
	private static Set<Order> orders = new HashSet<Order>();
	
	public OrderDAO() {
		super();
	}
	
	public Set<Order> getAllOrders(){
		String getquery = "SELECT * FROM `order`;";
		Connection connection = super.getConnection();
		Statement stmt = null;
		orders.clear();
		
		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(getquery);
			ResultSet rs = preStatement.executeQuery();

			while (rs.next()) {
				Order order = new Order();
	            for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
	            	order.setorderID(rs.getInt(1));						
					order.setusername(rs.getString(2));
					order.setorderdate(rs.getString(3));
					order.setproductname(rs.getString(4));
					order.setproductqty(rs.getInt(5));
					order.settotalprice(rs.getFloat(9));
					order.settax(rs.getFloat(8));
					order.setamount(rs.getFloat(6));
					order.setshippingaddress(rs.getString(10));			
					order.setorderstatus(rs.getString(11));
	    			orders.add(order);
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
		String getquery = "SELECT * FROM `order` WHERE orderID =?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(getquery);
			preStatement.setInt(1, orderID);
			ResultSet rs = preStatement.executeQuery();
			
			if(rs.next()){
			    order.setorderID(orderID);			
				order.setusername(rs.getString(2));
				order.setorderdate(rs.getString(3));
				order.setproductname(rs.getString(4));
				order.setproductqty(rs.getInt(5));
				order.settotalprice(rs.getFloat(9));
				order.settax(rs.getFloat(8));
				order.setamount(rs.getFloat(6));
				order.setshippingaddress(rs.getString(10));			
				order.setorderstatus(rs.getString(11));
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

		return order;
	}
	
	public Order createOrder(String username, String productname, int productqty, float amount, int orderstatus){
		Order order = new Order();
		String shippingaddress = null;
		String orderstatusname = null;
		int orderID = 0;
		String getaddressquery = "SELECT `StreetAddressLine1`,`City`,`State`,`Zipcode` FROM address WHERE `Customer_Username`=?";
		String addquery = "INSERT INTO `Order` (`Customer_Username`, `OrderDate`, `ProductName`,`ProductQty`,`ProductPrice`,`Subtotal`,`Tax`,`TotalAmount`,`ShippingAddress`,`OrderStatus`) VALUES (?,CURRENT_TIMESTAMP,?,?,?,?,?,?,?,1)";
		String getdatequery = "SELECT `OrderDate` FROM `order` WHERE `OrderID`=?";
		String getstatusname = "SELECT `StatusName` FROM `ordersatus` WHERE `statusID`=?";
		
		
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			//get shipping address from address table which the user uses
			stmt = connection.createStatement();
			PreparedStatement preStatement1 = (PreparedStatement) connection.prepareStatement(getaddressquery);
			preStatement1.setString(1, username);
			ResultSet rs1 = preStatement1.executeQuery();
			if(rs1.next()){
				shippingaddress = rs1.getString(1)+ ", " + rs1.getString(2)+ ", " +rs1.getString(3)+ ", " + rs1.getString(4);
			} else {
				shippingaddress = "n/a";
			}
			
			//create an order record into order table
			PreparedStatement preStatement2 = (PreparedStatement) connection.prepareStatement(addquery);
			preStatement2.setString(1, username);
			preStatement2.setString(2, productname);
			preStatement2.setInt(3, productqty);
			preStatement2.setFloat(4, amount);
			preStatement2.setFloat(5, amount*productqty);
			preStatement2.setFloat(6, amount*productqty*Constant.TAXRATE);
			preStatement2.setFloat(7, (amount*productqty*(1+Constant.TAXRATE)));
			preStatement2.setString(8, shippingaddress);
//			preStatement2.setInt(8,orderstatus );		
//			
			preStatement2.executeUpdate();
			
			// To do: fix get generated order id and get status name
			
			//get the auto generated orderID first and then get all the order info
//			ResultSet rs2 = preStatement2.getGeneratedKeys();
//			orderID = rs2.getInt(1);
//			PreparedStatement preStatement3 = (PreparedStatement) connection.prepareStatement(getdatequery);
//			preStatement2.setInt(1, orderID);
//			ResultSet rs3 = preStatement3.executeQuery();
			
//			PreparedStatement preStatement4 = (PreparedStatement) connection.prepareStatement(getaddressquery);
//			preStatement4.setInt(1, orderID);
//			ResultSet rs4 = preStatement1.executeQuery();
//			orderstatusname = rs4.getString(1);
			
			// To do: Return correct values instead of dummy ones
						
			order.setorderID(orderID);
			order.setorderdate("20161128");
			order.setusername(username);			
			order.setproductname(productname);
			order.setproductqty(productqty);
			//order.settotalprice(totalprice);
			order.settax(Constant.TAXRATE);
			//order.setamount(totalprice + Constant.TAXRATE);
			order.setshippingaddress(shippingaddress);			
			order.setorderstatus(orderstatusname);

			stmt.close();
			
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
	
	public void submitOrder(int productID, int qty, String username){             //select quantity before buying
		
		String status = null;
		String productname = null;
		float totalprice = 0;
		String getquery = "SELECT `productname`, `productprice` FROM product WHERE productID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(getquery);
			preStatement.setInt(1, productID);
			ResultSet rs = preStatement.executeQuery();

			while (rs.next()) {			
				
				productname = rs.getString(1);
				totalprice = rs.getFloat(2);
						
			}

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

		
		createOrder(username, productname, qty, totalprice, 0);
	}
}