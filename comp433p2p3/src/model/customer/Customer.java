package model.customer;
/**
 * This Class is to set and get customer information
 * @author developer
 *
 */

public class Customer {
	
		String customerusername;
		String customerpassword;
		String customerfirstname;
		String customerlastname;
		String customeremail;
	
	public Customer(String customerusername, String customerpassword,String customerfirstname,
	                String customerlastname, String customeremail){
		
		this.customerusername = customerusername;
		this.customerpassword = customerpassword;	
		this.customerfirstname = customerfirstname;
		this.customerlastname = customerlastname;	
		this.customeremail = customeremail;
	
	}
	
	public String getCustomerUsername(){
	
	    return customerusername;
	    
	}
	
	public String getCustomerPassword(){
		
	    return customerpassword;
	    
	}
	
	public String getCustomerFirstname(){
		
	    return customerfirstname;
	    
	}
	
	public String getCustomerLastname(){
		
		return customerlastname;
	    
	}

	public String getCustomerEmail(){
		
	    return customeremail;
	    
	}
	    		
}
