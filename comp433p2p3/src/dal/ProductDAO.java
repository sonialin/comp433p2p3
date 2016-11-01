package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.bouncycastle.jcajce.provider.asymmetric.RSA;

import dal.Databaseoperation;
import model.order.Order;

import model.product.Product;

public class ProductDAO extends Databaseoperation {

	public ProductDAO() {
		super();
	}
	
	Set<Product> products = new HashSet<Product>();

	/**
	 * addProduct
	 */
	public Product addProduct(String productname, String productdecription, float productprice, int productownerID,
			int productquantity) {
		Product product = new Product();
		String addquery = "INSERT INTO `Product` (`ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity`) VALUES (?,?,?,?,?);";
		String selectquery = "Select * From Product where ProductID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;
		int productID = 0;

		try {
			stmt = connection.createStatement();

			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(addquery);
			preStatement.setString(1, "ProductName");
			preStatement.setFloat(2, productprice);
			preStatement.setString(3, "ProductDescription");
			preStatement.setInt(4, productownerID);
			preStatement.setInt(5, productquantity);

			preStatement.executeUpdate();
		
			//get the auto generated productID first and then get all the product info
			ResultSet rs = preStatement.getGeneratedKeys();
			productID = rs.getInt(1);
			PreparedStatement preStatement2 = (PreparedStatement) connection.prepareStatement(selectquery);
			preStatement2.setInt(1, productID);
			ResultSet rs1 = preStatement2.executeQuery();
			
			product.setProductID(productID);
			product.setProductName(rs1.getString(2));			
			product.setProductprice(rs1.getFloat(3));
			product.setProductdecription(rs1.getString(4));
			product.setProductownerID(rs1.getInt(5));
			product.setProductquantity(rs1.getInt(6));

			stmt.close();
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
		return product;

	}

	/**
	 * getProduct
	 */
	public Product getProduct(int productID) {
		Product product = new Product();
		String getquery = "SELECT productID, `ProductName`, `ProductPrice`, `ProductDescription`, `ProductOwner_ProductOwnerID`, `ProductQuantity` FROM PRODUCT WHERE productID= ?;";
		
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = connection.prepareStatement(getquery);
			preStatement.setInt(1, productID);
			ResultSet rs = preStatement.executeQuery();
			
			if(rs.next()){
			product.setProductID(productID);			
			product.setProductName(rs.getString(2));			
			product.setProductprice(rs.getFloat(3));
			product.setProductdecription(rs.getString(4));
			product.setProductownerID(rs.getInt(5));
			product.setProductquantity(rs.getInt(6));
			}
			
			

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

		return product;

	}

	/**
	 * deleteProduct
	 */
	public void deleteProduct(int productID) {
		String deletequery = "DELETE FROM product WHERE productID =?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(deletequery);
			preStatement.setInt(1, productID);
			preStatement.executeUpdate();

			stmt.close();
			

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

	}

	/**
	 * searchProduct
	 * 
	 * @return
	 */
	public Set<Product> searchProduct(String ProductName) {
		
		Product product = new Product();
		String searchquery = "SELECT * FROM product where ProductName like '%" + ProductName + "%';";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			//PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(searchquery);
			//preStatement.setString(1, ProductName);
			//ResultSet rs = preStatement.executeQuery();
			ResultSet rs = stmt.executeQuery(searchquery);
			
			ResultSetMetaData rsmd = rs.getMetaData();  
		    int columnCount = rsmd.getColumnCount();  
			for (int i=1; i<=columnCount; i++){  
		        System.out.print(rsmd.getColumnName(i));  
		        System.out.print("(" + rsmd.getColumnTypeName(i) + ")");  
		        System.out.print(" | ");  
		    }  
		    System.out.println();  
		    // Êä³öÊý¾Ý  
		    while (rs.next()){  
		        for (int i=1; i<=columnCount; i++){ 
		        
		            System.out.print(rs.getObject(i) + " | ");  
		        }  
		        System.out.println();  
		    }
			while (rs.next()) {
				product.setProductID(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductprice(rs.getFloat(3));
				product.setProductdecription(rs.getString(4));				
				product.setProductownerID(rs.getInt(5));
				product.setProductquantity(rs.getInt(6));

				products.add(product);
			}

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		super.closeConnection(connection);

		return products;
	}

	/**
	 * checckAvailability
	 */

	public int checkAvailability(int productID) {
		int productquantity = 0;
		String checkavailabilityquery = "SELECT Productquantity FROM product where ProductID = ?";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(checkavailabilityquery);
			preStatement.setInt(1, productID);
			ResultSet rs = preStatement.executeQuery();

			productquantity = rs.getInt(1);
			
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

		return productquantity;
	}



	/**
	 * buy product means create an order
	 */
	 public void buyProduct(Set<Product> products,String username) {
		 
		 OrderDAO odao = new OrderDAO();
		 
	     odao.submitOrder(products, username);
	 }

	/**
	 * getProductOwner
	 */
	public int getProductOwner(int productID) {
		int owenerID = 0;
		String getownerquery = "SELECT ProductOwner_ProductOwnerID FROM product where ProductID=?;";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(getownerquery);
			preStatement.setInt(1, productID);
			ResultSet rs = preStatement.executeQuery();

			owenerID = rs.getInt(1);
			
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);

		return owenerID;
	}

}
