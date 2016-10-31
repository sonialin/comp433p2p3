package service.resource.order;

import java.util.Set;

import javax.jws.WebService;
import javax.xml.ws.Response;

import service.representation.order.OrderRepresentation;
import service.representation.order.OrderRequest;

@WebService
public interface OrderService {
	   
	public Set<OrderRepresentation> getAllOrders();
	public OrderRepresentation getOrder(int orderId);
	public OrderRepresentation createOrder(OrderRequest orderRequest);
   
    //public Response updateOrder(OrderRequest orderRequest);
    //public Response deleteOrder(int orderId);
}