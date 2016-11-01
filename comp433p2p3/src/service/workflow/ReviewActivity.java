package service.workflow;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.review.Review;
import model.review.ReviewManagerFacade;
import service.representation.review.ReviewRepresentation;

public class ReviewActivity {
	
	private static ReviewManagerFacade rm = new ReviewManagerFacade();

	public String writeReview(String customerusername, int productID, String reviewcontent,int rate) {

		rm.writeReview(customerusername, productID, reviewcontent, rate);
		
		return "OK";
	}


	public Set<ReviewRepresentation> getReview(int productID) {

		Set<Review> reviews = new HashSet<Review>();
		Set<ReviewRepresentation> reviewRepresentations = new HashSet<ReviewRepresentation>();

		reviews = rm.getReview(productID);

		Iterator<Review> it = reviews.iterator();
		while(it.hasNext()) {
			Review rw = (Review)it.next();
			ReviewRepresentation reviewRepresentation = new ReviewRepresentation();
			reviewRepresentation.setProductreviewID(rw.getProductreviewID());
			reviewRepresentation.setProductreviewcontent(rw.getProductreviewcontent());
			reviewRepresentation.setProductreviewDate(rw.getProductreviewDate());
			reviewRepresentation.setProductproductID(rw.getProductproductID());
			reviewRepresentation.setCustomerusername(rw.getCustomerusername());
          //now add this representation in the list
			reviewRepresentations.add(reviewRepresentation);
        }
		return reviewRepresentations;

	}
	
	
	


}
