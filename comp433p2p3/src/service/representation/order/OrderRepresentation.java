package service.representation.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class OrderRepresentation {
	int orderID;
	String orderdate;
	String shippingaddress;
	float totalprice;
	float tax;
	float amount;
	int orderstatusID;
	String username;
	
	public OrderRepresentation( ){ }
	
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
	
	public String getshipingaddress(){
		return shippingaddress;
	}
	
	public void setshippingaddress(String shippingaddress){
		this.shippingaddress = shippingaddress;
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
	
	public int getorderstatusID(){
		return orderstatusID;
	}
	
	public void setorderstatusID(int orderstatusID){
		this.orderstatusID = orderstatusID;
	}
	
	public String getusername(){
		return username;
	}
	
	public void setusername(String username){
		this.username = username;
	}

}
