package service.representation.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class CustomerRequest {
	
	String customerusername;
	String customerpassword;
	String customerfirstname;
	String customerlastname;
	String customeremail;
	
	public CustomerRequest() {}
	
	public String getCustomerUsername(){
		
	    return customerusername;
	    
	}
	
	public void setCustomerUsername(String cusUsername) {
		
		this.customerusername = cusUsername;
		
	}
	
	public String getCustomerPassword(){
		
	    return customerpassword;
	    
	}
	
	public void setCustomerPassword(String cusPassword) {
		
		this.customerpassword = cusPassword;
		
	}
	
	public String getCustomerFirstname(){
		
	    return customerfirstname;
	    
	}
	
	public void setCustomerFirstname(String cusFirstname) {
		
		this.customerfirstname = cusFirstname;
		
	}
	
	public String getCustomerLastname(){
		
		return customerlastname;
	    
	}
	
	public void setCustomerLastname(String cusLastname) {
		
		this.customerlastname = cusLastname;
		
	}

	public String getCustomerEmail(){
		
	    return customeremail;
	    
	}
	
	public void setCustomerEmail(String cusEmail) {
		
		this.customeremail = cusEmail;
		
	}

}
