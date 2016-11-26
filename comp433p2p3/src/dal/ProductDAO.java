package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	 * getProduct, if the product exists, return the product, if not, return null
	 */
	public Product getProduct(int productID) {
		Boolean productexist = null;
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
			productexist = true;
			product.setProductID(productID);			
			product.setProductName(rs.getString(2));			
			product.setProductprice(rs.getFloat(3));
			product.setProductdecription(rs.getString(4));
			product.setProductownerID(rs.getInt(5));
			product.setProductquantity(rs.getInt(6));
			
			}
			
			else
				productexist = false;	
			
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}

		super.closeConnection(connection);
             
		if(productexist)
		         return product;
        else
	             return null;
		
		
		
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
	
	public Set<Product> getAllProducts(){
		String getquery = "SELECT * FROM `product`;";
		Connection connection = super.getConnection();
		Statement stmt = null;
		
		try {
			stmt = connection.createStatement();
			PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(getquery);
			ResultSet rs = preStatement.executeQuery();

			while (rs.next()) {
				Product product = new Product();
	            for (int i = 1; i < rs.getMetaData().getColumnCount() + 1; i++) {
	            	product.setProductID(rs.getInt(1));			
	    			product.setProductName(rs.getString(2));			
	    			product.setProductprice(rs.getFloat(3));
	    			product.setProductdecription(rs.getString(4));
	    			product.setProductownerID(rs.getInt(5));
	    			product.setProductquantity(rs.getInt(6));
	    			products.add(product);
	            }
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
	 * searchProduct,if there're products match the keywords, return the products, if not, return null
	 * 
	 * @return
	 */
	public Set<Product> searchProduct(String ProductName) {
		Boolean productexist = null;
		products.clear();			
		String searchquery = "SELECT * FROM product where ProductName like '%" + ProductName + "%';";
		Connection connection = super.getConnection();
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			//PreparedStatement preStatement = (PreparedStatement) connection.prepareStatement(searchquery);
			//preStatement.setString(1, ProductName);
			//ResultSet rs = preStatement.executeQuery();
			ResultSet rs = stmt.executeQuery(searchquery);
			
			
			while (rs.next()) {
				productexist = true;
				Product product = new Product();                        //needs to create a new Product Object for every loop, other wise all the "products" will have the same hashcode and thus be considered the same object
				product.setProductID(rs.getInt(1));
				System.out.println("getProductID=" + product.getProductID());
				product.setProductName(rs.getString(2));
				System.out.println("getProductname=" + product.getProductname());
				product.setProductprice(rs.getFloat(3));
				product.setProductdecription(rs.getString(4));				
				product.setProductownerID(rs.getInt(5));
				product.setProductquantity(rs.getInt(6));

				products.add(product);
				System.out.println("size2222222222=" + products.size());
			}

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		super.closeConnection(connection);
		System.out.println("size111111=" + products.size());
		
		if(productexist)
	         return products;
        else
           return null;
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
	 public void buyProduct(int productID, int qty, String username) {
		 
		 OrderDAO odao = new OrderDAO();
		 
	     odao.submitOrder(productID, qty, username);
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
