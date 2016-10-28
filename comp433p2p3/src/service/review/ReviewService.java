package service.review;

import java.util.Set;

import javax.jws.WebService;

import service.representation.review.ReviewRepresentation;
import service.representation.review.ReviewRequest;

@WebService
public interface ReviewService {

	//public String writeReview(String customerusername, String productID, String reviewcontent,int rate);
	public String writeReview(ReviewRequest ReviewRequest);
	public ReviewRepresentation displayReview(String Poductname) ;



}
