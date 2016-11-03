package model.order;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import java.io.Serializable;

@XmlRootElement(name = "order")
public class Order implements Serializable {
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
	
	public Order( ){ }
	
	public int getorderID(){
		return orderID;
	}
	
	@XmlElement
	public void setorderID(int orderID){
		this.orderID = orderID;
	}
		
	public String getorderdate(){
		return orderdate;
	}
	
	@XmlElement
	public void setorderdate(String orderdate){
		this.orderdate = orderdate;
	}
	
	
	
	public String getusername(){
		return username;
	}
	
	@XmlElement
	public void setusername(String username){
		this.username = username;
	}
	
	public String getproductname(){
		return productname;
	}
	
	@XmlElement
	public void setproductname(String productname){
		this.productname = productname;
	}
	
	public int getproductqty(){
		return productqty;
	}
	
	@XmlElement
	public void setproductqty(int productqty){
		this.productqty = productqty;
	}
	
	
	public float gettotalprice(){
		return totalprice;
	}
	
	@XmlElement
	public void settotalprice(float totalprice){
		this.totalprice = totalprice;
	}
	
	public float gettax(){
		return tax;
	}
	
	@XmlElement
	public void settax(float tax){
		this.tax = tax;
	}
	
	public float getamount(){
		return amount;
	}
	
	@XmlElement
	public void setamount(float amount){
		this.amount = amount;
	}
	
	
	
	public String getshippingaddress(){
		return shippingaddress;
	}
	
	@XmlElement
	public void setshippingaddress(String shippingaddress){
		this.shippingaddress = shippingaddress;
	}
	
	public String getorderstatus(){
		return orderstatus;
	}
	
	@XmlElement
	public void setorderstatus(String orderstatus){
		this.orderstatus = orderstatus;
	}
	
	

}
