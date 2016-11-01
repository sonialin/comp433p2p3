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

public class ReviewResource implements ReviewService {

	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/Review/{customerusername,productID, reviewcontent,rate}")
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
	@Produces({ "application/xml", "application/json" })
	@Path("/Review/{productID}")
	public Set<ReviewRepresentation> getReview(@PathParam("productID") int productID) {
		System.out.println("GET METHOD Request for selected product reviews .............");
		ReviewActivity rwActivity = new ReviewActivity();
		return rwActivity.getReview(productID);
	}

}
