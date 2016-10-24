package dal;

public class CustomerDAO extends Databaseoperation{
	
	public CustomerDAO(){
		super();
	}
	
	public void addCustomer(String customerusername, String customerpassword,
            String customerfirstname, String customerlastname,
            String customeremail){
		
		String addquery = "INSERT INTO Customer VALUES(customerusername,customerpassword, customerfirstname, customerlastname, customeremail)";
		super.accessDatabase(addquery);

	}	
	public void deleteCustomer(String customerusername,String customerpassword){
		if(verifyCustomer(customerusername,customerpassword))
		{
		String deletequery = "DELETE FROM Customer WHERE Customerusername = " + customerusername + ";";  // productID will get from keyboard input
		super.accessDatabase(deletequery);
		}
		else
			System.out.println("Sorry, you are not able to delete this Customer");
	}
	
	/**
	 * Verify if cutomer's username matches password when login
	 * @return
	 */
	public Boolean verifyCustomer(String customerusername, String customerpassword){
		
		//if() //(customerpassword matches customerusername)
		//return true;
		//else
			//return false;
		return null;
		
	}
	
	public void addCustomerProfile(){
		
		//update customer information in databases
		
	}
	
	/**
	 * Get Order Details customers submitted from database
	 */
	public void getOrderDetail(int orderID){
		
		String getorderquery = "SELECT o.OrderID, o.Customer_Username,o.OrderPrice, o.OrderStatus, "
								+"o.OrderDate, o.Shipping Address, cl.CartLineItemQuantity, cl.CartLineItemPrice,"
								+"c.CartPrice, c.Tax " 
                                +"FROM Order as o, Cartlineitem as cl, Cart as c"
								+"WHERE c.CartID = cl.Cart_CartID AND o.OrderID = c.Order_OrderID AND o.orderID = "+ orderID;
		super.accessDatabase(getorderquery);
     }

}
