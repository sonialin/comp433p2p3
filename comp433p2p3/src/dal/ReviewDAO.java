package dal;

import model.review.Review;

public class ReviewDAO extends Databaseoperation {

	public ReviewDAO() {
		super();
	}

	public void writeReview(String customerusername, String productID, String reviewcontent, int rate) {

		int productreviewID = 0;

		String witereviewquery = "insert into productreview VALUES(" + reviewcontent + "," + rate + "," + "currentdate,"
				+ productID + "," + customerusername + ")";

		super.accessDatabase(witereviewquery);

	}

	public Review displayReview(String Poductname) {

		String dispalyreviewquery = "Select * from ProductReview where Poductname = " + Poductname + ";";
		super.accessDatabase(dispalyreviewquery);
		return review;

	}

}
