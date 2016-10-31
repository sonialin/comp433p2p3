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
	float amount;
	
	public OrderRequest(){ }
	
	public int getorderID(){
		return orderID;
	}
	
	public void setorderID(int orderID){
		this.orderID = orderID;
	}
	
	public double getamount(){
		return amount;
	}
	
	public void setamount(float amount){
		this.amount = amount;
	}
}
