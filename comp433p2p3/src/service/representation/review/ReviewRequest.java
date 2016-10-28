package service.representation.review;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ReviewRequest {

	int productreviewID;
	String productreviewcontent;
	int rating;
	Date productreviewDate;
	int productproductID;
	String customerusername;

	public int getProductreviewID() {
		return productreviewID;
	}

	public void setProductreviewID(int productreviewID) {
		this.productreviewID = productreviewID;
	}

	public String getProductreviewcontent() {
		return productreviewcontent;
	}

	public void setProductreviewcontent(String productreviewcontent) {
		this.productreviewcontent = productreviewcontent;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getProductreviewDate() {
		return productreviewDate;
	}

	public void setProductreviewDate(Date productreviewDate) {
		this.productreviewDate = productreviewDate;
	}

	public int getProductproductID() {
		return productproductID;
	}

	public void setProductproductID(int productproductID) {
		this.productproductID = productproductID;
	}

	public String getCustomerusername() {
		return customerusername;
	}

	public void setCustomerusername(String customerusername) {
		this.customerusername = customerusername;
	}


}


