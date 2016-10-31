package service.resource.order;

import java.util.Set;

import javax.jws.WebService;
import javax.xml.ws.Response;

import service.representation.order.OrderRepresentation;
import service.representation.order.OrderRequest;

@WebService
public interface OrderService {
	   
	public Set<OrderRepresentation> getOrders();
	public OrderRepresentation getOrder(int orderID);
	//public OrderRepresentation createOrder(OrderRequest orderRequest);
   
    //public Response updateEmployee(EmployeeRequest employeeRequest);
    //public Response deleteEmployee(String employeeId);
}