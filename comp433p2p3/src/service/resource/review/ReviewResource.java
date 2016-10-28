package service.resource.review;
package service.;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import service.representation.review.ReviewRepresentation;
import service.representation.review.ReviewRequest;
import service.workflow.ReviewActivity;


public class ReviewResource implements ReviewService{
	
	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/Review/{ReviewId}")
	public ReviewRepresentation displayReview(@PathParam("ProductName") String productName) {
		System.out.println("GET METHOD Request from Client with ReviewRequest String ............." + productName);
		ReviewActivity pdtActivity = new ReviewActivity();
		return pdtActivity.displayReview(productName);
	}

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/Review")
	public String writeReview(ReviewRequest ReviewRequest) {
		System.out.println("POST METHOD Request from Client with ............." + ReviewRequest.getProductreviewcontent() + "  "
				+ ReviewRequest.getRating());
		ReviewActivity pdtActivity = new ReviewActivity();
		return "OK";
	}

}
