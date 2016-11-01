package service.resource.review;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response;

import service.representation.review.ReviewRepresentation;
import service.workflow.ReviewActivity;

@Path("/reviewservice/")
public class ReviewResource implements ReviewService {

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/review/")
	public Response writeReview(@PathParam("customerusername") String customerusername,
			@PathParam("productID") int productID, @PathParam("reviewcontent") String reviewcontent,
			@PathParam("rate") int rate) {
		System.out.println(
				"POST METHOD Request from Client............." + customerusername + productID + reviewcontent + rate);
		ReviewActivity rwActivity = new ReviewActivity();
		String res = rwActivity.writeReview(customerusername, productID, reviewcontent, rate);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;

	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/review/{reviewID}")
	public ReviewRepresentation getReview(@PathParam("reviewID") int reviewID) {
		System.out.println("GET METHOD Request from Client with reviewRequest int ............." + reviewID);
		ReviewActivity reviewActivity = new ReviewActivity();
		return reviewActivity.getReview(reviewID);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
<<<<<<< HEAD
	@Path("/Review/{productID}")
	public Set<ReviewRepresentation> getReview(@PathParam("productID") int productID) {
		System.out.println("GET METHOD Request for selected product reviews .............");
=======
	@Path("/r_reviews/{productID}")
	public Set<ReviewRepresentation> getRelatedReviews(@PathParam("productID") int productID) {
		System.out.println("GET METHOD Request for reviews of product with ID ............." + productID);
>>>>>>> branch 'master' of https://TingLiu6@bitbucket.org/TingLiu6/comp433p2p3.git
		ReviewActivity rwActivity = new ReviewActivity();
<<<<<<< HEAD
		return rwActivity.getReview(productID);
=======
		return rwActivity.getRelatedReviews(productID);
>>>>>>> branch 'master' of https://TingLiu6@bitbucket.org/TingLiu6/comp433p2p3.git
	}

}
