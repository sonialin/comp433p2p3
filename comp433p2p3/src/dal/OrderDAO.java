package dal;

import model.product.Product;

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
	
	public void payOrder(int orderID){
		String updateOrderQuery = "UPDATE order SET OrderStatus_StatusID = 1 WHERE OrderID = " + orderID;
				
		super.accessDatabase(updateOrderQuery);
	}
	
	public void fullfillOrder(int orderID){
		String updateOrderQuery = "UPDATE order SET OrderStatus_StatusID = 2 WHERE OrderID = " + orderID;
		
		super.accessDatabase(updateOrderQuery);
	}
	
	public void shipOrder(int orderID){
		String updateOrderQuery = "UPDATE order SET OrderStatus_StatusID = 3 WHERE OrderID = " + orderID;
		
		super.accessDatabase(updateOrderQuery);
	}
	
	public void deliverOrder(int orderID){
		String updateOrderQuery = "UPDATE order SET OrderStatus_StatusID = 4 WHERE OrderID = " + orderID;
		
		super.accessDatabase(updateOrderQuery);
	}
	
	public void cancelOrder(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 5 WHERE OrderID = " + orderID;
		
		super.accessDatabase(updateOrderQuery);
	}

	public void refund(int orderID){
		String updateOrderQuery = "UPDATE Order SET OrderStatus_StatusID = 6 WHERE OrderID = " + orderID;
		
		super.accessDatabase(updateOrderQuery);
	}
	
	public String getOrderStatus(int orderID){
		String searchquery = "SELECT OrderStatus.StatusName FROM OrderStatus INNER JOIN Order on Order.OrderStatus_StatusID = OrderStatus.StatusID WHERE Order.OrderID = " + orderID; 
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
