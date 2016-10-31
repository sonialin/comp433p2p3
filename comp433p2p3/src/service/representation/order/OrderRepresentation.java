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
	float amount;
	
	public OrderRepresentation(){ }
	
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
	
	public double getamount(){
		return amount;
	}
	
	public void setamount(float amount){
		this.amount = amount;
	}

}
