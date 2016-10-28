package service.resource.customer;

import javax.jws.WebService;

import service.representation.customer.CustomerRepresentation;
import service.representation.customer.CustomerRequest;

public interface CustomerService {
	
	public CustomerRepresentation getCustomer(String cusUsername);
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest);
	public CustomerRepresentation deleteCustomer(String cusUsername, String cusPassword);
}