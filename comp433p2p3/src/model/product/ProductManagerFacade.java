package model.product;

import java.util.List;
import java.util.Set;

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
     * @return 
     */	
	public Set<Product> searchProduct(String ProductName){
		
		return pdao.searchProduct(ProductName);
	}
	
    /**
     * checckAvailability
     */	
	public int checkAvailability(int ProductID){
		return pdao.checkAvailability(ProductID);
	}
	
	/**
     * buy product, that means submit order
     */
	public void buyProduct(int productID, int qty, String username){
		 pdao.buyProduct(productID, qty, username); 
	}
	
	/**
     * getProductOwner
     */
	public int getProductOwner(int productID){
		return pdao.getProductOwner(productID);
	}

}

