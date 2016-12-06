package service.workflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Response;

import model.link.Link;
import model.product.Product;
import model.product.ProductManagerFacade;
import service.representation.product.ProductRepresentation;

public class ProductActivity {

	private static ProductManagerFacade pm = new ProductManagerFacade();
	
	public Set<ProductRepresentation> getAllProducts() {
		
		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
		products = pm.getAllProducts();
		
		Iterator<Product> it = products.iterator();
		while(it.hasNext()) {
			Product pdt = (Product) it.next();
			ProductRepresentation productRepresentation = new ProductRepresentation();
                   
			productRepresentation.setProductID(pdt.getProductID());
			productRepresentation.setProductName(pdt.getProductname());
			productRepresentation.setProductprice(pdt.getProductprice());			
			productRepresentation.setProductdescription(pdt.getProductdescription());
			productRepresentation.setProductownerID(pdt.getProductownerID());
			productRepresentation.setProductquantity(pdt.getProductquantity());
          
			//now add this representation in the list
			productRepresentations.add(productRepresentation);
			
			setLinks(productRepresentation);
        }
		return productRepresentations;
	}

	public Set<ProductRepresentation> searchProduct(String productName) {
		System.out.println("searchProduct");
		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> ProductRepresentations = new HashSet<ProductRepresentation>();
		
		products = pm.searchProduct(productName);
		
		System.out.println("size=" + products.size());
		

		Iterator<Product> it = products.iterator();
		while (it.hasNext()) {
			Product pdt = (Product) it.next();
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation.setProductID(pdt.getProductID());
			productRepresentation.setProductName(pdt.getProductname());
			productRepresentation.setProductprice(pdt.getProductprice());			
			productRepresentation.setProductdescription(pdt.getProductdescription());
			productRepresentation.setProductownerID(pdt.getProductownerID());
			productRepresentation.setProductquantity(pdt.getProductquantity());
			

			// now add this representation in the list
			ProductRepresentations.add(productRepresentation);
			System.out.println("pid=" + productRepresentation.getProductID());
			System.out.println("pname=" + productRepresentation.getProductname());
			
			setLinks(productRepresentation);
		}
		return ProductRepresentations;
	}

	public ProductRepresentation getProduct(int id) {

		Product pdt = pm.getProduct(id);

		ProductRepresentation pdtRep = new ProductRepresentation();
		pdtRep.setProductID(pdt.getProductID());
		pdtRep.setProductName(pdt.getProductname());
		pdtRep.setProductdescription(pdt.getProductdescription());
		pdtRep.setProductprice(pdt.getProductprice());
		pdtRep.setProductownerID(pdt.getProductownerID());
		pdtRep.setProductquantity(pdt.getProductquantity());

				
		// Add the links
		setLinks(pdtRep);
		
		return pdtRep;
		
		/**
		 * Sets all the links appropriately, for each kind of representation based on state
		 * @param orderRep
		 */
		
	}
	
	


	public ProductRepresentation addProduct(String productname, String productdecription, float productprice, 
			                 int productownerID,	int productquantity) {

		Product product = pm.addProduct(productname, productdecription, productprice, productownerID, productquantity);
		ProductRepresentation productRep = new ProductRepresentation();
		productRep.setProductName(product.getProductname());
		productRep.setProductdescription(product.getProductdescription());
		productRep.setProductquantity(product.getProductquantity());
		productRep.setProductprice(product.getProductprice());
		productRep.setProductownerID(product.getProductownerID());
		
		return productRep;

	}

	public String deleteProduct(int id) {

		pm.deleteProduct(id);

		return "OK";
	}
	
	private void setLinks(ProductRepresentation productRep) {
		// Set up the activities that can be performed on orders
		Link buy = new Link("post","APPLICATION_JSON","Buy", 
				"http://localhost:8082/orderservice/order?productName=" + productRep.getProductname());	
		productRep.setLinks(buy);
	}
}
