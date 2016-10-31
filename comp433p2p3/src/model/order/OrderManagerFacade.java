package model.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import dal.Databaseoperation;
import dal.OrderDAO;
import model.order.Order;

public class OrderManagerFacade{
	
	private static OrderDAO odao = new OrderDAO();
	
	public Set<Order> getAllOrders(){
		return odao.getAllOrders();
	}
	
	public Order getOrder(int id) {
		return odao.getOrder(id);
	}

//	public void createOrder(float amount, String username, String orderdate){
//		        
//		odao.createOrder(amount, username, orderdate);
//	}
	
	public void payOrder(int orderID){
		odao.payOrder(orderID);
	}
	
	public void fullfillOrder(int orderID){
		odao.fulfillOrder(orderID);
	}
	
	public void shipOrder(int orderID){
		odao.shipOrder(orderID);
	}
	
	public void cancelOrder(int orderID){
		odao.cancelOrder(orderID);
	}

	public void refund(int orderID){
		odao.refund(orderID);
	}
	
//	public String getOrderStatus(int orderID){
//		return odao.getOrderStatus(orderID);
//	}
	
}
