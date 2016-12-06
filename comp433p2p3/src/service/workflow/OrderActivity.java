package service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.link.Link;
import model.order.Order;
import model.order.OrderManagerFacade;
import service.representation.order.OrderRepresentation;

public class OrderActivity {
	
	private static OrderManagerFacade omf = new OrderManagerFacade();
	
	public Set<OrderRepresentation> getAllOrders() {
		
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
          orderRepresentation.setproductname(order.getproductname());
          orderRepresentation.setproductqty(order.getproductqty());
          orderRepresentation.settotalprice(order.gettotalprice());
          orderRepresentation.settax(order.gettax());
          orderRepresentation.setamount(order.getamount());
          orderRepresentation.setshippingaddress(order.getshippingaddress());			
          orderRepresentation.setorderstatus(order.getorderstatus());
          
          //now add this representation in the list
          orderRepresentations.add(orderRepresentation);
          setLinks(orderRepresentation);
        }
		return orderRepresentations;
	}
	
	public OrderRepresentation getOrder(int orderID) {
		
		Order order = omf.getOrder(orderID);
		
		OrderRepresentation orderRepresentation = new OrderRepresentation();
		orderRepresentation.setorderID(order.getorderID());
        orderRepresentation.setorderdate(order.getorderdate());
        orderRepresentation.setusername(order.getusername());
        orderRepresentation.setproductname(order.getproductname());
        orderRepresentation.setproductqty(order.getproductqty());
        orderRepresentation.settotalprice(order.gettotalprice());
        orderRepresentation.settax(order.gettax());
        orderRepresentation.setamount(order.getamount());
        orderRepresentation.setshippingaddress(order.getshippingaddress());			
        orderRepresentation.setorderstatus(order.getorderstatus());
        
        setLinks(orderRepresentation);
		
		return orderRepresentation;

	}
	
	public OrderRepresentation createOrder(String username, String productname, float amount, int productqty) {	
		Order order = omf.createOrder(username, productname, amount, productqty);
		OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setamount(order.getamount());
		orderRep.setusername(order.getusername());
		orderRep.setproductqty(order.getproductqty());
		
		return orderRep;
	}
	
	public void payOrder(int orderID){	
		omf.payOrder(orderID);
	}
	
	public void fulfillOrder(int orderID){
		omf.fulfillOrder(orderID);
	}
	
	public String shipOrder(int orderID){
		omf.shipOrder(orderID);
		
		return "OK";
	}
	
	public void deliverOrder(int orderID){
		omf.deliverOrder(orderID);
	}
	
	public String cancelOrder(int orderID){
		omf.cancelOrder(orderID);
		
		return "OK";
	}

	public void refundOrder(int orderID){
		omf.refundOrder(orderID);
	}
	
	public String getOrderStatus(int orderID){
		return omf.getOrderStatus(orderID);
	}
	
	public String deleteOrder(int orderID) {	
		omf.deleteOrder(orderID);
		
		return "OK";
	}
	
	private void setLinks(OrderRepresentation orderRep) {
		// Set up the activities that can be performed on orders
		Link cancel = new Link("patch","APPLICATION_JSON","Cancel", 
				"http://localhost:8082/orderservice/cancelorder/");	
		orderRep.setLinks(cancel);
	}

}
