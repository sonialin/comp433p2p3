package model.review;

import java.util.Set;

import dal.ReviewDAO;

public class ReviewManagerFacade{

	/**
	 * This class manages reviews for products from customers
	 */
	ReviewDAO rdao = new ReviewDAO();
	
	public void writeReview(String customerusername, int productID, String reviewcontent,int rate){
			
		rdao.writeReview(customerusername, productID, reviewcontent, rate);			
		
	}
	
	public Set<Review> getRelatedReviews(int productID){
		
		return rdao.getRelatedReviews(productID);
		
	}
	
	public Review getReview(int reviewID){
		
		return rdao.getReview(reviewID);
		
	}

}
