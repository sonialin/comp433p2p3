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
	
<<<<<<< HEAD
	public Set<Review> getReview(int productID){
=======
	public Set<Review> getRelatedReviews(int productID){
>>>>>>> branch 'master' of https://TingLiu6@bitbucket.org/TingLiu6/comp433p2p3.git
		
<<<<<<< HEAD
		return rdao.getReview(productID);
=======
		return rdao.getRelatedReviews(productID);
>>>>>>> branch 'master' of https://TingLiu6@bitbucket.org/TingLiu6/comp433p2p3.git
		
	}
	
	public Review getReview(int reviewID){
		
		return rdao.getReview(reviewID);
		
	}

}
