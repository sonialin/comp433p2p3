package model.order;

import dal.Databaseoperation;
import dal.OrderDAO;
import model.order.Order;

public class OrderManagerFacade{
	
	OrderDAO odao = new OrderDAO();

	public void createOrder(float amount, String username, String orderdate){
		        
		odao.createOrder(amount, username, orderdate);
	}
	
	public Order getOrder(int orderID) {
		return odao.getOrder(orderID); 
	}
	
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
