package service.customer;

import java.sql.SQLException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import service.representation.customer.*;
import service.workflow.CustomerActivity;

public class CustomerResource {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerusername}")
	public CustomerRepresentation getCustomer(@PathParam("customerusername") String username) throws SQLException {
		System.out.println("GET METHOD Request from Client with customerRequest String ............." + username);
		CustomerActivity cusActivity = new CustomerActivity();
		return cusActivity.getCustomer(username);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest) throws SQLException {
		System.out.println("POST METHOD Request from Client with ............." + customerRequest.getCustomerUsername() + " " + customerRequest.getCustomerPassword() + " " + customerRequest.getCustomerFirstname() + " " + customerRequest.getCustomerLastname() + "  " + customerRequest.getCustomerEmail());
		CustomerActivity cusActivity = new CustomerActivity();
		return cusActivity.createCustomer(customerRequest.getCustomerUsername(), customerRequest.getCustomerPassword(), customerRequest.getCustomerFirstname(),customerRequest.getCustomerLastname(),customerRequest.getCustomerEmail());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerUsername}")
	public Response deleteCustomer(@PathParam("customerUsername") String username, String password) throws SQLException {
		System.out.println("Delete METHOD Request from Client with customerRequest String ............." + username);
		CustomerActivity cusActivity = new CustomerActivity();
		String res = cusActivity.deleteCustomer(username, password);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}