package model.product;

import java.util.Set;

import dal.ProductDAO;
import model.order.Order;
import model.product.Product;

/**
 * This class is managing the activities related to Product
 */
public class ProductManagerFacade{
	
	Product product = null;
	Order order;
	
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
	public Set<Product> searchProduct(String ProductName){
		return pdao.searchProduct(ProductName);
	}
	
    /**
     * checckAvailability
     */	
	public int checkAvailability(int productID){
		return pdao.checkAvailability(productID);
	}
	
	/**
     * buy product, that means create an order
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

