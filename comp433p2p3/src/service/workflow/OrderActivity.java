package service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import dal.OrderDAO;
import model.order.Order;
import model.order.OrderManagerFacade;
import service.representation.order.OrderRepresentation;

public class OrderActivity {
	
	private static OrderManagerFacade omf = new OrderManagerFacade();
	
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

}
