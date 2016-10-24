package model.reviews;

import java.util.Date;

public class Reviews {

	int productreviewID;
	String productreviewcontent; 
	int rating; 
	Date productreviewDate;
	int productproductID; 
	String customerusername;
	
	public Reviews(int productreviewID,	String productreviewcontent, int rating, 
				Date productreviewDate,	int productproductID, String customerusername){
		
		this.productreviewID = productreviewID;
		this.productreviewcontent = productreviewcontent;
		this.rating = rating;
		this.productreviewDate = productreviewDate;
		this.productproductID = productproductID;
		this.customerusername = customerusername;
		
	}
	
	public int getProductreviewID(){
		return productreviewID;
	}
	
	public String getProductreviewcontent(){
		return productreviewcontent;
	}
	
	public int getRating(){
		return rating;
	}
	
	public Date getproductreviewDate(){
		return productreviewDate;
	}
	
	public int getProductproductID(){
		return productproductID;
	}
	
	public String getCustomerusername(){
		return customerusername;
	}

}
