package service.resource.review;


import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.review.Review;
import service.representation.review.ReviewRepresentation;
import service.representation.review.ReviewRequest;
import service.workflow.ReviewActivity;


public class ReviewResource implements ReviewService{
	
	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/Review/{ReviewId}")
	public void writeReview(@PathParam("ProductName") String productName) {
		System.out.println("GET METHOD Request from Client with ReviewRequest String ............." + productName);
		ReviewActivity rwActivity = new ReviewActivity();
		return rwActivity.writeReview(productName);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/Review/{ProductName}")
	public Set<Review> getReview(@PathParam("ProductName") String productName) {
		System.out.println("GET METHOD Request for selected product reviews .............");
		ReviewActivity rwActivity = new ReviewActivity();
		return rwActivity.getReview(productName);	
	}
	
	
	
	}
}
