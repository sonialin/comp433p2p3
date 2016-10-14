package order;

import database.Databaseoperation;
import product.Product;

public class OrderDAO extends Databaseoperation{
	
	public OrderDAO(){
		super();
	}
	
	
	public void createOrder(int orderID, String orderdate, String shipingaddress, 
		     float totalprice, float tax, double amount){
		        
		String addquery = "INSERT INTO order VALUES (" + orderID + "," + orderdate +","+ shipingaddress+ "," 
	               + totalprice+","+tax+","+ amount+")";
	
	    super.accessDatabase(addquery);
	    
	}
	
	public void payOrder(){
		//TO DO
	}
	
	public void fullfillOrder(){
		//TO DO
	}
	
	public void shipOrder(){
		//TO DO
	}
	
	public void cancelOrder(int orderID){
		String deletequery = "DELETE FROM order WHERE orderID =" + orderID + ";"; 
		super.accessDatabase(deletequery);
	}

	public void refund(){
		//TO DO
	}
	
	public String getOrderStatus(int orderID){
		String searchquery = "SELECT OrderStatus FROM order where orderID = ?;"; 
        super.accessDatabase(searchquery);
        return (String) super.resultlist.get(1);  //return getOrderStatus
	}
	
	public void getProductDetail(int ProductID){
		
		String searchquery = "SELECT ProductName, ProductDecription, ProductPrice ProductOwner FROM product where ProductID =" +ProductID +";";               
        super.accessDatabase(searchquery);
        
	}
	
	public void getCustomerDetail(String customerusername){
		
		String searchquery = "SELECT Username, Firstname, LastName, Address, PhoneNumber, Email FROM customer where Username =" + customerusername + ";";              
        super.accessDatabase(searchquery);
	}
}
