package model.product;

import dal.Databaseoperation;
import dal.ProductDAO;
import model.order.Order;
import model.partner.Partner;

/**
 * This class is managing the activities related to Product
 */
public class ProductManagerFacade{
	
	Product product = null;
	Order order;
	Partner partner;
 
	ProductDAO pdao = new ProductDAO();
	
     /**
      * addProduct
      */
	public void addProduct(int productID, String productname, String productdecription,
	        float productprice, int productownerID, int productquantity){
	       pdao.addProduct(productID, productname, productdecription, productprice, productownerID, productquantity); 
	}
	
    /**
     * deleteProduct
     */
	public void deleteProduct(int productID){
		pdao.deleteProduct(productID);
	}
	
    /**
     * searchProduct
     */	
	public void searchProduct(String ProductName){
		pdao.searchProduct(ProductName);
	}
	
    /**
     * checckAvailability
     */	
	public int checckAvailability(String ProductName){
		return pdao.checckAvailability(ProductName);
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
		return pdao.getProductOwner(productID);
	}

}

