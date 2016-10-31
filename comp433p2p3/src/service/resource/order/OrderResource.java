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
	public Set<OrderRepresentation> getOrders() {
		System.out.println("GET METHOD Request for all orders .............");
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrders();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderId}")
	public OrderRepresentation getOrder(@PathParam("orderId") int id) {
		System.out.println("GET METHOD Request from Client with orderRequest int ............." + id);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrder(id);
	}
	
//	@POST
//	@Produces({"application/xml" , "application/json"})
//	@Path("/employee")
//	public OrderRepresentation createOrder(OrderRequest orderRequest) {
//		System.out.println("POST METHOD Request from Client with ............." + orderRequest.getorderID() );
//		OrderActivity orderActivity = new OrderActivity();
//		return orderActivity.createOrder(orderRequest.getorderID(), orderRequest.getorderdate(), 
//										orderRequest.getshippingaddress(), orderRequest.gettotalprice(),
//										orderRequest.gettax(), orderRequest.getamount(), orderRequest.getorderstatus());
//	}
	// To do: remove order id argument in the creatorder method across layers since it's auto created and incremented
	
	// To do: add patch method 
	
//	@DELETE
//	@Produces({"application/xml" , "application/json"})
//	@Path("/order/{orderId}")
//	public Response deleteOrder(@PathParam("orderId") int id) {
//		System.out.println("Delete METHOD Request from Client with orderRequest int ............." + id);
//		OrderActivity orderActivity = new OrderActivity();
//		orderActivity.cancelOrder(id);
//		return null;
//		// To do: properly return a response to indicate the order has been cancelled
//	}
	
}
