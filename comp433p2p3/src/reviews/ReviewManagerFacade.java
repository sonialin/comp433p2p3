package reviews;


public class ReviewManagerFacade{

	/**
	 * This class manages reviews for puoducts from cutomers
	 */
	ReviewsDAO rdao = new ReviewsDAO();
	
	public void writeReview(String customerusername, String productID, String reviewcontent,int rate){
			
		rdao.writeReview(customerusername, productID, reviewcontent, rate);			
		
	}
	
	public void displayReview(String Poductname){
		
		rdao.displayReview(Poductname);
		
	}
	
	

}
