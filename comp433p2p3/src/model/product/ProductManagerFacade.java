package model.product;

import dal.Databaseoperation;
import dal.ProductDAO;
import model.order.Order;
import model.partner.Partner;
import model.product.Product;

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
	public void addProduct(String productname, String productdecription,
	        float productprice, int productownerID, int productquantity){
	       pdao.addProduct(productname, productdecription, productprice, productownerID, productquantity); 
	}
	
	public Product getProduct(int productID){
	      return pdao.getProduct(productID); 
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

