package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.costant.Constant;
import model.customer.Customer;

public class CustomerDAO extends Databaseoperation{
	
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	
	public CustomerDAO(){
		super();
	}
	
	
	
	public Customer getCustomer(String customerusername) throws SQLException{
		
		con=getConnection();
		
		String gethquery = "SELECT * FROM Customer WHERE Username = '"+ customerusername + "';";     
		
		pstmt = (PreparedStatement) con.prepareStatement(gethquery);
		ResultSet rs = pstmt.executeQuery(gethquery);
		
		
		Customer cus = new Customer();
		cus.setCustomerUsername(rs.getString(1));
        cus.setCustomerPassword(rs.getString(2));
        cus.setCustomerFirstname(rs.getString(3));
        cus.setCustomerLastname(rs.getString(4));
        cus.setCustomerEmail(rs.getString(5));
        
        con.close();
        
		return cus;
        
	}
	
	public Customer addCustomer(String customerusername, String customerpassword,
            String customerfirstname, String customerlastname,
            String customeremail) throws SQLException{
		
		con=getConnection();
		
		Customer cus = new Customer();
		cus.setCustomerUsername(customerusername);
		cus.setCustomerPassword(customerpassword);
		cus.setCustomerFirstname(customerfirstname);
		cus.setCustomerLastname(customerlastname);
		cus.setCustomerEmail(customeremail);
		
		String addquery = "insert into Customer (Username,Password,Firstname,Lastname,Email) values(?,?,?,?,?)";
		
		pstmt = con.prepareStatement(addquery);
		pstmt.setString(1, cus.getCustomerUsername());
		pstmt.setString(2, cus.getCustomerPassword());
		pstmt.setString(3, cus.getCustomerFirstname());
		pstmt.setString(4, cus.getCustomerLastname());
		pstmt.setString(5, cus.getCustomerEmail());
		pstmt.executeUpdate();
		pstmt.close();
		con.close();		
		
		return cus;

	}
	
	public void deleteCustomer(String customerusername,String customerpassword) throws SQLException{
		
		con=getConnection();
		
		if(verifyCustomer(customerusername,customerpassword))
		{
		String deletequery = "DELETE FROM Customer WHERE Customerusername = " + customerusername + ";";  // productID will get from keyboard input
		pstmt.executeQuery(deletequery);
		}
		else
			System.out.println("Sorry, you are not able to delete this Customer");
		con.close();
	}
	
	/**
	 * Verify if cutomer's username matches password when login
	 * @return
	 * @throws SQLException 
	 */
	public Boolean verifyCustomer(String customerusername, String customerpassword) throws SQLException{
		
		con=getConnection();
		String pwd;
		
		String searchquery = "SELECT Password FROM Customer WHERE Username = '"+ customerusername + "';";     
		
		ResultSet rs = pstmt.executeQuery(searchquery);
        pwd = rs.getString(1);
        
        if(customerpassword.equals(pwd)){
        	return true;
        } else {
        	return false;
        }
	}
	
	public void addCustomerProfile(){
		
		//update customer information in databases
		
	}
	
	/**
	 * Get Order Details customers submitted from database
	 */
	public void getCustomDetail(String customerusername){
		
     }

}
