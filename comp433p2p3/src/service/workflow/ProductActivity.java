package service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.product.Product;
import model.product.ProductManagerFacade;
import service.representation.product.ProductRepresentation;

public class ProductActivity {

	private static ProductManagerFacade pm = new ProductManagerFacade();

	public Set<ProductRepresentation> searchProduct(String productName) {

		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> ProductRepresentations = new HashSet<ProductRepresentation>();

		products = pm.searchProduct(productName);

		Iterator<Product> it = products.iterator();
		while (it.hasNext()) {
			Product pdt = (Product) it.next();
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation.setProductID(pdt.getProductID());
			productRepresentation.setProductName(pdt.getProductname());
			productRepresentation.setProductdecription(pdt.getProductdecription());
			productRepresentation.setProductownerID(pdt.getProductownerID());
			productRepresentation.setProductprice(pdt.getProductprice());

			// now add this representation in the list
			ProductRepresentations.add(productRepresentation);
		}
		return ProductRepresentations;
	}

	public ProductRepresentation getProduct(int id) {

		Product pdt = pm.getProduct(id);

		ProductRepresentation pdtRep = new ProductRepresentation();
		pdtRep.setProductID(pdt.getProductID());
		pdtRep.setProductName(pdt.getProductname());
		pdtRep.setProductdecription(pdt.getProductdecription());
		pdtRep.setProductprice(pdt.getProductprice());
		pdtRep.setProductownerID(pdt.getProductownerID());
		pdtRep.setProductquantity(pdt.getProductquantity());

		return pdtRep;
	}

	public ProductRepresentation addProduct(String productname, String productdecription, float productprice, 
			                 int productownerID,	int productquantity) {

		pm.addProduct(productname, productdecription, productprice, productownerID, productquantity);
		return null;

		
	}

	public String deleteProduct(int id) {

		pm.deleteProduct(id);

		return "OK";
	}
}
