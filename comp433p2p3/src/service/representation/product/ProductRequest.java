package service.representation.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class ProductRequest {

	int productID;
	String productname;
	String productdecription;
	float productprice;
	int productownerID;
	int productquantity;

	public void setProductID(int productID){
		this.productID = productID;
	}
	
	public int getProductID(){
		return productID;
	}	
	
	public void setProductName(String productname){
		this.productname = productname;
	}
	
	public String getProductname(){
		return productname;
	}
	
	public void setProductdecription(String productdecription){
		this.productdecription = productdecription;
	}
	
	public String getProductdecription(){
		return productdecription;
	}
	
	public void setProductprice(float productprice){
		this.productprice = productprice;
	}
	
	public float getProductprice(){
		return productprice;
	}
	
	public void setProductownerID(int productownerID){
		this.productownerID = productownerID;
	}
	
	public int getProductownerID(){
		return productownerID;
	}
	
	public void setProductquantity(int productquantity){
		this.productquantity = productquantity;
	}
	
	public int getProductquantity(){
		return productquantity;
	}

}
