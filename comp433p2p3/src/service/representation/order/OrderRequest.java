package service.representation.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class OrderRequest {
	int orderID;
	String orderdate;
	String username;
	String productname;
	int productqty;		
	float totalprice;
	float tax;
	float amount;
	String shippingaddress;
	String orderstatus;	
	

	
	public int getorderID(){
		return orderID;
	}
	
	
	public void setorderID(int orderID){
		this.orderID = orderID;
	}
		
	public String getorderdate(){
		return orderdate;
	}
	
	
	public void setorderdate(String orderdate){
		this.orderdate = orderdate;
	}
	
	
	
	public String getusername(){
		return username;
	}
	
	
	public void setusername(String username){
		this.username = username;
	}
	
	public String getproductname(){
		return productname;
	}
	
	
	public void setproductname(String productname){
		this.productname = productname;
	}
	
	public int getproductqty(){
		return productqty;
	}
	
	
	public void setproductqty(int productqty){
		this.productqty = productqty;
	}
	
	
	public float gettotalprice(){
		return totalprice;
	}
	
	
	public void settotalprice(float totalprice){
		this.totalprice = totalprice;
	}
	
	public float gettax(){
		return tax;
	}
	
	
	public void settax(float tax){
		this.tax = tax;
	}
	
	public float getamount(){
		return amount;
	}
	
	
	public void setamount(float amount){
		this.amount = amount;
	}
	
	
	
	public String getshippingaddress(){
		return shippingaddress;
	}
	
	
	public void setshippingaddress(String shippingaddress){
		this.shippingaddress = shippingaddress;
	}
	
	public String getorderstatus(){
		return orderstatus;
	}
	
	
	public void setorderstatus(String orderstatus){
		this.orderstatus = orderstatus;
	}
}
