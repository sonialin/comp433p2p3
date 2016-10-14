package reviews;

import database.Databaseoperation;

public class ReviewsDAO extends Databaseoperation{
	
	public ReviewsDAO(){
		super();
	}
	
	public void writeReview(String customerusername, String productID, String reviewcontent,int rate){
		
		int productreviewID = 0;
		
		String witereviewquery = "insert into productreview VALUES(max(productreviewID)+1, "
				+ reviewcontent +"," + rate+"," + "currentdate," +productID+"," + customerusername +")";
				
		super.accessDatabase(witereviewquery);		
				

	}
	
	public void displayReview(String Poductname){
		
		String dispalyreviewquery = "Select * from ProductReview where Poductname = "+ Poductname + ";";
		super.accessDatabase(dispalyreviewquery);
		
	}

}
