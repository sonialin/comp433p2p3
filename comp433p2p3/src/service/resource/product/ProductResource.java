package service.resource.product;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import service.representation.product.ProductRepresentation;
import service.representation.product.ProductRequest;
import service.workflow.ProductActivity;

import javax.ws.rs.core.CacheControl;

@Path("/Productservice/")
public class ProductResource implements ProductService {

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/Product")
	// @Cacheable(cc="public, maxAge=3600") example for caching   
	public Set<ProductRepresentation> searchProduct(String productName) {
		System.out.println("GET METHOD Request for all Products .............");
		ProductActivity pdtActivity = new ProductActivity();
		return pdtActivity.searchProduct(productName);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/Product/{ProductId}")
	public ProductRepresentation getProduct(@PathParam("ProductId") int id) {
		System.out.println("GET METHOD Request from Client with ProductRequest String ............." + id);
		ProductActivity pdtActivity = new ProductActivity();
		return pdtActivity.getProduct(id);
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/Product")
	public ProductRepresentation addProduct(ProductRequest ProductRequest) {
		System.out.println("POST METHOD Request from Client with ............." + ProductRequest.getFirstName() + "  "
				+ ProductRequest.getLastName());
		ProductActivity pdtActivity = new ProductActivity();
		return pdtActivity.createProduct(ProductRequest.getFirstName(), ProductRequest.getLastName());
	}

	@DELETE
	@Produces({ "application/xml", "application/json" })
	@Path("/Product/{ProductId}")
	public Response deleteProduct(@PathParam("ProductId") int id) {
		System.out.println("Delete METHOD Request from Client with ProductRequest String ............." + id);
		ProductActivity pdtActivity = new ProductActivity();
		String res = pdtActivity.deleteProduct(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}



}
