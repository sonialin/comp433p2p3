package model.order;

import dal.Databaseoperation;
import dal.OrderDAO;
import model.product.Product;

public class OrderManagerFacade{
	
	OrderDAO odao = new OrderDAO();

	public void createOrder(int orderID, String orderdate, String shipingaddress, 
		     float totalprice, float tax, double amount, int orderstatus){
		        
		odao.createOrder(orderID, orderdate, shipingaddress, totalprice, tax, amount, orderstatus);
	    
	}
	
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
