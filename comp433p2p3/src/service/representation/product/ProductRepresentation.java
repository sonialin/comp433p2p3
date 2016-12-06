package service.representation.product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import service.representation.AbstractRepresentation;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRepresentation extends AbstractRepresentation{

	int productID;
	String productname;
	String productdescription;
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
	
	public void setProductdescription(String productdescription){
		this.productdescription = productdescription;
	}
	
	public String getProductdescription(){
		return productdescription;
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
