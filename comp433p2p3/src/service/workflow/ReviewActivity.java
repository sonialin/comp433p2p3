package service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import dal.ReviewDAO;
import model.review.Review;
import service.representation.review.ReviewRepresentation;



public class ReviewActivity {
	private static ReviewDAO dao = new ReviewDAO();
	// private static ReviewManager em = new ReviewManager();

	public void writeReview(String customerusername, String productID, String reviewcontent,int rate) {

		// Review rw = dao.addReview(firstName, lastName);
		dao.writeReview(reviewcontent, reviewcontent, reviewcontent, rate);
	}

	public ReviewRepresentation displayReview(String Poductname) {

		// Review rw = dao.getReview(id);
		Review rw = dao.displayReview(Poductname);

		ReviewRepresentation rwRep = new ReviewRepresentation();
		rwRep.setCustomerusername(rw.getCustomerusername());
		rwRep.setProductproductID(rw.getProductproductID());
		rwRep.setProductreviewcontent(rw.getProductreviewcontent());
		rwRep.setRating(rw.getRating());

		return rwRep;
	}

	


}
