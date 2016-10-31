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
	
<<<<<<< HEAD
=======
	public OrderRepresentation createOrder(int orderID, String orderdate, String shipingaddress, 
		     float totalprice, float tax, double amount, int orderstatus){
		        
		omf.createOrder(orderID, orderdate, shipingaddress, totalprice, tax, amount, orderstatus);    
	}
	
>>>>>>> f5c8211606d58d7cf9e7c4a72b8895ebb5bbcce8
	public Set<OrderRepresentation> getOrders() {
		
		Set<Order> orders = new HashSet<Order>();
		Set<OrderRepresentation> orderRepresentations = new HashSet<OrderRepresentation>();
		orders = omf.getAllOrders();
		
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
          Order order = (Order)it.next();
          OrderRepresentation orderRepresentation = new OrderRepresentation();
          orderRepresentation.setorderID(order.getorderID());
          orderRepresentation.setorderdate(order.getorderdate());
          orderRepresentation.setusername(order.getusername());
          orderRepresentation.setamount(order.getamount());
          orderRepresentation.setshippingaddress(order.getshippingaddress());
          orderRepresentation.settax(order.gettax());
          orderRepresentation.settotalprice(order.gettotalprice());
          orderRepresentation.setorderdetails(order.getorderdetails());
          
          //now add this representation in the list
          orderRepresentations.add(orderRepresentation);
        }
		return orderRepresentations;
	}
	
	public OrderRepresentation getOrder(int orderID) {
		
<<<<<<< HEAD
		Order order = omf.getOrder(orderID);
		
		OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setorderID(order.getorderID());
		orderRep.setorderdate(order.getorderdate());
		orderRep.setusername(order.getusername());
		orderRep.setamount(order.getamount());
		orderRep.setshippingaddress(order.getshippingaddress());
		orderRep.settax(order.gettax());
		orderRep.settotalprice(order.gettotalprice());
		orderRep.setorderdetails(order.getorderdetails());
		
		return orderRep;
=======
		//To do
>>>>>>> f5c8211606d58d7cf9e7c4a72b8895ebb5bbcce8
	}
	
//	public OrderRepresentation createOrder(int orderID, String orderdate, String shipingaddress, 
//    float totalprice, float tax, double amount, int orderstatus){
//       
//		omf.createOrder(orderID, orderdate, shipingaddress, totalprice, tax, amount, orderstatus);    
//	}
	
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
<<<<<<< HEAD

=======
	
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
>>>>>>> f5c8211606d58d7cf9e7c4a72b8895ebb5bbcce8
}
