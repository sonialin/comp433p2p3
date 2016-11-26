package service.resource.product;

import java.util.List;
import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import service.representation.order.OrderRepresentation;
import service.representation.product.ProductRepresentation;
import service.representation.product.ProductRequest;

@WebService
public interface ProductService {
	
	public Set<ProductRepresentation> getAllProducts();

	public Set<ProductRepresentation> searchProduct(String productName);

	public ProductRepresentation getProduct(int productId);

	public ProductRepresentation addProduct(ProductRequest productRequest);

}
