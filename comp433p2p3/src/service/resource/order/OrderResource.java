package service.resource.order;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.CacheControl;

import org.apache.cxf.jaxrs.ext.PATCH;

import service.representation.order.OrderRepresentation;
import service.representation.order.OrderRequest;
import service.workflow.OrderActivity;

@Path("/orderservice/")
public class OrderResource implements OrderService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/order")
	//@Cacheable(cc="public, maxAge=3600") example for caching
	public Set<OrderRepresentation> getAllOrders() {
		System.out.println("GET METHOD Request for all orders .............");
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getAllOrders();	
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getorder/{orderID}")
	public OrderRepresentation getOrder(@PathParam("orderID") int orderID) {
		System.out.println("GET METHOD Request from Client with orderRequest int ............." + orderID);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrder(orderID);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/order")
	public OrderRepresentation createOrder(OrderRequest orderRequest) {
//		System.out.println("POST METHOD Request from Client with username............." + orderRequest.getusername() );
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.createOrder(orderRequest.getusername(), orderRequest.getproductname(), orderRequest.getamount(), orderRequest.getproductqty());
	}
	
//	@PATCH
//	@Produces({"application/xml" , "application/json"})
//	@Path("/payorder/{orderID}")
//	public Response payOrder(int orderID) {
//		System.out.println("PATCH METHOD Request from Client with orderID............." + orderID );
//		OrderActivity orderActivity = new OrderActivity();
//		orderActivity.payOrder(orderID);
//		return null;
//	}
//	
//	@PATCH
//	@Produces({"application/xml" , "application/json"})
//	@Path("/order/{orderID}")
//	public Response fulfillOrder(int orderID) {
//		System.out.println("PATCH METHOD Request from Client with orderID............." + orderID );
//		OrderActivity orderActivity = new OrderActivity();
//		orderActivity.fulfillOrder(orderID);
//		return null;
//	}
	
	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/shiporder")
	public Response shipOrder(OrderRequest orderRequest) {
		System.out.println("PATCH METHOD Request from Client with orderID............." + orderRequest.getorderID() );
		OrderActivity orderActivity = new OrderActivity();
		String res = orderActivity.shipOrder(orderRequest.getorderID());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
//	@PATCH
//	@Produces({"application/xml" , "application/json"})
//	@Path("/order/{orderID}")
//	public Response deliverOrder(int orderID) {
//		System.out.println("PATCH METHOD Request from Client with orderID............." + orderID );
//		OrderActivity orderActivity = new OrderActivity();
//		orderActivity.deliverOrder(orderID);
//		return null;
//	}
	
	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/cancelorder")
	public Response cancelOrder(OrderRequest orderRequest) {
		System.out.println("PATCH METHOD Request from Client with orderID............." + orderRequest.getorderID() );
		OrderActivity orderActivity = new OrderActivity();
		orderActivity.cancelOrder(orderRequest.getorderID());
		String res = orderActivity.cancelOrder(orderRequest.getorderID());
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	
//	@PATCH
//	@Produces({"application/xml" , "application/json"})
//	@Path("/order/{orderID}")
//	public Response refundOrder(int orderID) {
//		System.out.println("PATCH METHOD Request from Client with orderID............." + orderID );
//		OrderActivity orderActivity = new OrderActivity();
//		orderActivity.refundOrder(orderID);
//		return null;
//	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/order/{orderID}")
	public String getOrderStatus(@PathParam("orderID") int orderID) {
		System.out.println("GET METHOD Request from Client with orderID ............." + orderID);
		OrderActivity orderActivity = new OrderActivity();
		String res = orderActivity.getOrderStatus(orderID);

		return res;
	}
	
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
