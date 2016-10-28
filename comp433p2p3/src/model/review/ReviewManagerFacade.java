package model.review;

import dal.ReviewDAO;

public class ReviewManagerFacade{

	/**
	 * This class manages reviews for puoducts from cutomers
	 */
	ReviewDAO rdao = new ReviewDAO();
	
	public void writeReview(String customerusername, String productID, String reviewcontent,int rate){
			
		rdao.writeReview(customerusername, productID, reviewcontent, rate);			
		
	}
	
	public void displayReview(String Poductname){
		
		rdao.displayReview(Poductname);
		
	}
	
	

}
