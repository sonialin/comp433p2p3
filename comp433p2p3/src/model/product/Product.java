package model.product;

public class Product {
	
	int productID;
	String productname;
	String productdescription;
	float productprice;
	int productownerID;
	int productquantity;
	
	public Product(){}
	
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


