package service.resource.order;

import java.util.Set;

import javax.jws.WebService;
import javax.xml.ws.Response;

import service.representation.order.OrderRepresentation;
import service.representation.order.OrderRequest;

@WebService
public interface OrderService {
	   
	public Set<OrderRepresentation> getOrders();
<<<<<<< HEAD
	public OrderRepresentation getOrder(int orderID);
	//public OrderRepresentation createOrder(OrderRequest orderRequest);
   
    //public Response updateEmployee(EmployeeRequest employeeRequest);
    //public Response deleteEmployee(String employeeId);
=======
	// To do: implement getOrders method across layers
	public OrderRepresentation getOrder(String oderID);
	public OrderRepresentation createOrder(OrderRequest orderRequest);
    public Response updateOrder(OrderRequest orderRequest);
    public Response deleteOrder(int orderId);
>>>>>>> f5c8211606d58d7cf9e7c4a72b8895ebb5bbcce8
}