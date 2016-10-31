package model.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import dal.Databaseoperation;
import dal.OrderDAO;
import model.product.Product;

public class OrderManagerFacade{
	
<<<<<<< HEAD
	private static OrderDAO odao = new OrderDAO();
	
	public Set<Order> getAllOrders(){
		return odao.getAllOrders();
	}
	
	public Order getOrder(int id) {
		return odao.getOrder(id);
=======
	OrderDAO odao = new OrderDAO();

	public void createOrder(int orderID, String orderdate, String shipingaddress, 
		     float totalprice, float tax, double amount, int orderstatus){
		        
		odao.createOrder(orderID, orderdate, shipingaddress, totalprice, tax, amount, orderstatus);
	    
>>>>>>> f5c8211606d58d7cf9e7c4a72b8895ebb5bbcce8
	}

//	public void createOrder(float amount, String username, String orderdate){
//		        
//		odao.createOrder(amount, username, orderdate);
//	}
	
	public void payOrder(int orderID){
		odao.payOrder(orderID);
	}
	
	public void fullfillOrder(int orderID){
		odao.fullfillOrder(orderID);
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
	
	public String getOrderStatus(int orderID){
		return odao.getOrderStatus(orderID);
	}
	
	public void getProductDetail(int ProductID){
		odao.getProductDetail(ProductID);
	}
	
	public void getCustomerDetail(String customerusername){
		odao.getCustomerDetail(customerusername);
	}
}
