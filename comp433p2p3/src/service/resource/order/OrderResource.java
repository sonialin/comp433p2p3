package service.resource.order;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.CacheControl;

import service.representation.order.OrderRepresentation;
import service.representation.order.OrderRequest;
import service.workflow.OrderActivity;

@Path("/orderservice/")
public class OrderResource implements OrderService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	//@Cacheable(cc="public, maxAge=3600") example for caching
	public Set<OrderRepresentation> getAllOrders() {
		System.out.println("GET METHOD Request for all orders .............");
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getAllOrders();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderID}")
	public OrderRepresentation getOrder(@PathParam("orderID") int orderID) {
		System.out.println("GET METHOD Request from Client with orderRequest int ............." + orderID);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrder(orderID);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/order")
	public OrderRepresentation createOrder(OrderRequest orderRequest) {
		System.out.println("POST METHOD Request from Client with username............." + orderRequest.getusername() );
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.createOrder(orderRequest.getamount(), orderRequest.getusername(), orderRequest.getorderdate());
	}
	
	
	// To do: add patch method 
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderID}")
	public Response deleteOrder(@PathParam("orderID") int orderID) {
		System.out.println("Delete METHOD Request from Client with orderID ............." + orderID);
		OrderActivity orderActivity = new OrderActivity();
		String res = orderActivity.deleteOrder(orderID);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
}
