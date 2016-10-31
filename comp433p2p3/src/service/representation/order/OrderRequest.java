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
<<<<<<< HEAD
	String shippingaddress;
	float totalprice;
	float tax;
	float amount;
	int orderstatusID;
	String orderdetails;
	String username;
=======
	String shippingaddress; // to do: check spelling across layers
	float totalprice;
	float tax;
	double amount;
	int orderstatusID;
>>>>>>> f5c8211606d58d7cf9e7c4a72b8895ebb5bbcce8
	
	public OrderRequest(int orderID, String orderdate, String shippingaddress, 
			     float totalprice, float tax, double amount, int orderstatusID){
		
		this.orderID = orderID;
		this.orderdate = orderdate;
		this.shippingaddress = shippingaddress;
		this.totalprice = totalprice;
		this.tax=tax;
		this.amount=amount;
		this.orderstatusID=orderstatusID;
	}
	
	public int getorderID(){
		return orderID;
	}
	
	public String getorderdate(){
		return orderdate;
	}
	
	public String getshippingaddress(){
		return shippingaddress;
	}
	
	public float gettotalprice(){
		return totalprice;
	}
	
	public float gettax(){
		return tax;
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
	
	public int getorderstatus(){
		return orderstatusID;
	}
<<<<<<< HEAD
	
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
=======

>>>>>>> f5c8211606d58d7cf9e7c4a72b8895ebb5bbcce8
}
