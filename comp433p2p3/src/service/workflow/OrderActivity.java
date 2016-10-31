package service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.company.hr.Employee;
import com.company.hr.service.representation.EmployeeRepresentation;

import dal.OrderDAO;
import model.order.Order;
import model.order.OrderManagerFacade;
import service.representation.order.OrderRepresentation;

public class OrderActivity {
	
	private static OrderManagerFacade omf = new OrderManagerFacade();
	
	public OrderRepresentation createOrder(int orderID, String orderdate, String shipingaddress, 
		     float totalprice, float tax, double amount, int orderstatus){
		        
		omf.createOrder(orderID, orderdate, shipingaddress, totalprice, tax, amount, orderstatus);    
	}
	
	public Set<OrderRepresentation> getOrders() {
		
		//To do
	}
	
	public OrderRepresentation getOrder(int orderID) {
		
		//To do
	}
	
	public void payOrder(int orderID){	
		omf.payOrder(orderID);
	}
	
	public void fullfillOrder(int orderID){
		omf.fullfillOrder(orderID);
	}
	
	public void shipOrder(int orderID){
		omf.shipOrder(orderID);
	}
	
	public void cancelOrder(int orderID){
		omf.cancelOrder(orderID);
	}

	public void refund(int orderID){
		omf.refund(orderID);
	}
	
	public String getOrderStatus(int orderID){
		return omf.getOrderStatus(orderID);
	}
	
//	public String getProductDetail(int ProductID){
//		omf.getProductDetail(ProductID);
//	}
	// to-do: move this method across layers to the product collection
	
//	public void getCustomerDetail(String customerusername){
//		odao.getCustomerDetail(customerusername);
	}
	// to-do: move this method across layers to the customer collection
}
