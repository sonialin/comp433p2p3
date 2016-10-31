package service.resource.order;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import service.representation.order.OrderRepresentation;
import service.representation.order.OrderRequest;

@WebService
public interface OrderService {
	   
	public Set<OrderRepresentation> getAllOrders();
	public OrderRepresentation getOrder(int orderId);
	public OrderRepresentation createOrder(OrderRequest orderRequest);
   
    public Response payOrder(int orderID);
    public Response fulfillOrder(int orderID);
    public Response deliverOrder(int orderID);
    public Response shipOrder(int orderID);
    public Response cancelOrder(int orderID);
    public Response refundOrder(int orderID);
    public String getOrderStatus(int orderID);
    public Response deleteOrder(int orderId);
}