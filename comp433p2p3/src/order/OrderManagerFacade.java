package order;

import product.Product;
import database.Databaseoperation;

public class OrderManagerFacade{
	
	OrderDAO odao = new OrderDAO();

	public void createOrder(int orderID, String orderdate, String shipingaddress, 
		     float totalprice, float tax, double amount){
		        
		odao.createOrder(orderID, orderdate, shipingaddress, totalprice, tax, amount);
	    
	}
	
	public void payOrder(){
		odao.payOrder();
	}
	
	public void fullfillOrder(){
		odao.fullfillOrder();
	}
	
	public void shipOrder(){
		odao.shipOrder();
	}
	
	public void cancelOrder(int orderID){
		odao.cancelOrder(orderID);
	}

	public void refund(){
		odao.refund();
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
