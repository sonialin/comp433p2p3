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
	
	public Customer(){}
		
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
	
	public void setCustomerUsername(String customerusername) {
		this.customerusername = customerusername;
	}
	
	public String getCustomerPassword(){
	    return customerpassword;
	}
	
	public void setCustomerPassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}
	
	public String getCustomerFirstname(){
	    return customerfirstname;
	}
	
	public void setCustomerFirstname(String customerfirstname) {
		this.customerfirstname = customerfirstname;
	}
	
	public String getCustomerLastname(){
		return customerlastname;
	}
	
	public void setCustomerLastname(String customerlastname) {
		this.customerlastname = customerlastname;
	}

	public String getCustomerEmail(){
	    return customeremail;
	}
	
	public void setCustomerEmail(String customeremail) {
		this.customeremail = customeremail;
	}
	    		
}
