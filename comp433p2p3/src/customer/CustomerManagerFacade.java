package customer;

public class CustomerManagerFacade{
	
	private static CustomerDAO cdao = new CustomerDAO();
	

	public void addCustomer(String customerusername, String customerpassword,
			                String customerfirstname, String customerlastname,
			                String customeremail){
		cdao.addCustomer(customerusername,customerpassword, customerfirstname, customerlastname, customeremail);
		
	}	
	public void deleteCustomer(String customerusername,String customerpassword){
		cdao.deleteCustomer(customerusername, customerpassword);
	}
	
	/**
	 * Verify if cutomer's username matches password when login
	 * @return
	 */
	public Boolean verifyCustomer(String customerusername, String customerpassword){
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
