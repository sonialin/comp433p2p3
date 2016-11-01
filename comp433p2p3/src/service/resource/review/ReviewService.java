package service.resource.review;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import service.representation.review.ReviewRepresentation;

@WebService
public interface ReviewService {

	public Response writeReview(String customerusername, int productID, String reviewcontent, int rate);
	public ReviewRepresentation getReview(int reviewID);

<<<<<<< HEAD
	public Set<ReviewRepresentation> getReview(int productID);
=======
	public Set<ReviewRepresentation> getRelatedReviews(int productID);
>>>>>>> branch 'master' of https://TingLiu6@bitbucket.org/TingLiu6/comp433p2p3.git

}
