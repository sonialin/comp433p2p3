package service.resource.customer;

import java.sql.SQLException;
import javax.jws.WebService;
import javax.ws.rs.core.Response;


import service.representation.customer.CustomerRepresentation;
import service.representation.customer.CustomerRequest;

@WebService
public interface CustomerService {
	
	public CustomerRepresentation getCustomer(String cusUsername) throws SQLException;
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest) throws SQLException;
	public Response deleteCustomer(String cusUsername) throws SQLException;
}