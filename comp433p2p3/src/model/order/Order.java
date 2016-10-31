package model.order;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	int orderID;
	String orderdate;
	String shippingaddress;
	float totalprice;
	float tax;
	float amount;
	int orderstatusID;
	String orderdetails;
	String username;
	
	public Order(){ }
	
	public int getorderID(){
		return orderID;
	}
	
	public void setorderID(int orderID){
		this.orderID = orderID;
	}
	
	public String getorderdate(){
		return orderdate;
	}
	
	public void setorderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	
	public String getshippingaddress(){
		return shippingaddress;
	}
	
	public void setshippingaddress(String address) {
		this.shippingaddress = address;
	}
	
	public float getamount(){
		return amount;
	}
	
	public void setamount(float amount){
		this.amount = amount;
	}
	
	public float gettax(){
		return tax;
	}
	
	public void settax(float tax){
		this.tax = tax;
	}
	
	public float gettotalprice(){
		return totalprice;
	}
	
	public void settotalprice(float totalprice){
		this.totalprice = totalprice;
	}
	
	public String getorderdetails() {
		return orderdetails;
	}
	
	public void setorderdetails(String orderdetails){
		this.orderdetails = orderdetails;
	}
	
	public String getusername() {
		return orderdetails;
	}
	
	public void setusername(String username){
		this.username = username;
	}

}
