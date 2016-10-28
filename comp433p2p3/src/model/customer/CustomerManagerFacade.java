package model.customer;

import java.sql.SQLException;

import dal.CustomerDAO;

public class CustomerManagerFacade{
	
	private static CustomerDAO cdao = new CustomerDAO();
	
	public Customer getCustomer(String customerusername) throws SQLException{

		return cdao.getCustomer(customerusername);
	}

	public Customer addCustomer(String customerusername, String customerpassword,
			                String customerfirstname, String customerlastname,
			                String customeremail) throws SQLException{
		return cdao.addCustomer(customerusername,customerpassword, customerfirstname, customerlastname, customeremail);
		
	}	
	public void deleteCustomer(String customerusername,String customerpassword) throws SQLException{
		cdao.deleteCustomer(customerusername, customerpassword);
	}
	
	/**
	 * Verify if cutomer's username matches password when login
	 * @return
	 * @throws SQLException 
	 */
	public Boolean verifyCustomer(String customerusername, String customerpassword) throws SQLException{
		return cdao.verifyCustomer(customerusername, customerpassword);
		
	}
	
	public void addCustomerProfile(){
		
		//update customer information in databases
		
	}
	
	/**
	 * Get Order Details customers submitted from database
	 */
	public void getOrderDetail(int orderID){
		
		cdao.getOrderDetail(orderID);
		
    }
}
