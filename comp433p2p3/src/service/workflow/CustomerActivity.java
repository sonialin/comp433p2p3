package service.workflow;

import java.sql.SQLException;

import model.customer.*;
import service.representation.customer.*;

public class CustomerActivity {
	
private static CustomerManagerFacade cmf = new CustomerManagerFacade();
	
	
	public CustomerRepresentation getCustomer(String username) throws SQLException {
		
		Customer cus = cmf.getCustomer(username);
		
		CustomerRepresentation cusRep = new CustomerRepresentation();
		cusRep.setCustomerUsername(cus.getCustomerUsername());
		cusRep.setCustomerPassword(cus.getCustomerPassword());
		cusRep.setCustomerFirstname(cus.getCustomerFirstname());
		cusRep.setCustomerLastname(cus.getCustomerLastname());
		cusRep.setCustomerEmail(cus.getCustomerEmail());
		
		return cusRep;
	}
	
	public CustomerRepresentation createCustomer(String username, String Password, String firstName, String lastName, String Email) throws SQLException {
		
		Customer cus = cmf.addCustomer(username,Password,firstName, lastName,Email);
		
		CustomerRepresentation cusRep = new CustomerRepresentation();
		cusRep.setCustomerUsername(cus.getCustomerUsername());
		cusRep.setCustomerPassword(cus.getCustomerPassword());
		cusRep.setCustomerFirstname(cus.getCustomerFirstname());
		cusRep.setCustomerLastname(cus.getCustomerLastname());
		cusRep.setCustomerEmail(cus.getCustomerEmail());
		
		return cusRep;
	}
	
	public String deleteCustomer(String username) throws SQLException {
		
		cmf.deleteCustomer(username);
		
		return "OK";
	}

}
