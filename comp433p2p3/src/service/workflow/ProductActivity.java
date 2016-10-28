package service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import dal.ProductDAO;
import model.product.Product;
import service.representation.product.ProductRepresentation;

public class ProductActivity {

	private static ProductDAO dao = new ProductDAO();
	// private static ProductManager em = new ProductManager();

	public Set<ProductRepresentation> searchProduct(String productName) {

		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> ProductRepresentations = new HashSet<ProductRepresentation>();
		// Products = dao.getAllProducts();
		products = dao.searchProduct(productName);

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
	
/*
	public ProductRepresentation getProduct(String id) {

		// Product pdt = dao.getProduct(id);
		Product pdt = dao.getProduct(id);

		ProductRepresentation pdtRep = new ProductRepresentation();
		pdtRep.setFirstName(pdt.getFirstName());
		pdtRep.setLastName(pdt.getLastName());
		pdtRep.setGid(pdt.getGid());

		return pdtRep;
	}
*/
	
	public ProductRepresentation addProduct(String productname, String productdecription,
	        float productprice, int productownerID, int productquantity) {

		// Product pdt = dao.addProduct(firstName, lastName);
		Product pdt = dao.addProduct(productname,productdecription,
				                     productprice, productownerID, productquantity);

		ProductRepresentation pdtRep = new ProductRepresentation();
		pdtRep.setProductName(pdt.getProductname());
		pdtRep.setProductdecription(pdt.getProductdecription());
		pdtRep.setProductownerID(pdt.getProductownerID());
		pdtRep.setProductprice(pdt.getProductprice());

		return pdtRep;
	}

	public String deleteProduct(int id) {

		// dao.deleteProduct(id);
		dao.deleteProduct(id);

		return "OK";
	}
}
