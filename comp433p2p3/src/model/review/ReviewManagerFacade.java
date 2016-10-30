package model.review;

import java.util.Set;

import dal.ReviewDAO;

public class ReviewManagerFacade{

	/**
	 * This class manages reviews for products from customer
	 */
	ReviewDAO rdao = new ReviewDAO();
	
	public void writeReview(String reviewcontent, String productID, String customerusername,int rate){
			
		rdao.writeReview(reviewcontent, rate, reviewcontent, rate);			
		
	}
	
	public Set<Review> getReview(String productname){
		
		return rdao.getReview(productname);
		
	}
	
	

}
