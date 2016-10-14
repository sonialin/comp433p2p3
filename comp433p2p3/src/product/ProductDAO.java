package product;

import database.Databaseoperation;

public class ProductDAO extends Databaseoperation {
	
	
	public ProductDAO(){
		super();
	}
	
	  /**
     * addProduct
     */
	public void addProduct(int productID, String productname, String productdecription,
	        float productprice, int productownerID, int productquantity){
		//fetch from addproductlist.txt       
        
		String addquery = "INSERT INTO product VALUES (" + productID + "," + productname +","+ productdecription+ "," 
		               + productprice+","+productownerID+","+productquantity+")";
		
		super.accessDatabase(addquery);
	}
	
   /**
    * deleteProduct
    */
	public void deleteProduct(int productID){
		String deletequery = "DELETE FROM product WHERE productID ="+ productID+";";  // productID will get from keyboard input
		super.accessDatabase(deletequery);
	}
	
   /**
    * searchProduct
    */	
	public void searchProduct(String ProductName){
		String searchquery = "SELECT ProductName, ProductDecription, ProductPrice FROM product where ProductName like "
	                         + "'%?%'"+";";               //the search key words will get from keyboard input
		
		super.accessDatabase(searchquery);
	}
	
   /**
    * checckAvailability
    */	
	public int checckAvailability(String ProductName){
		String checckavailabilityquery = "SELECT Productquantity FROM product where ProductName like "
               + "'%?%'"+";";
		super.accessDatabase(checckavailabilityquery);
		return (int) super.resultlist.get(1);  //return Productquantity
	}
	
	/**
    * buyproduct, that means submitorder
    */
	public void buyProduct(){
		//order.submitOrder();  
	}
	
	/**
    * getProductOwner
    */
	public int getProductOwner(int productID){
		String getownerquery = "SELECT ProductOwner_ProductOwnerID FROM product where ProductID=?;";
		super.accessDatabase(getownerquery);
		return (int) super.resultlist.get(1); //return ProductOwner_ProductOwnerID;
	}

}
