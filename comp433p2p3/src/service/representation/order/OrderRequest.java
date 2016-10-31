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
	String shippingaddress; // to do: check spelling across layers
	float totalprice;
	float tax;
	double amount;
	int orderstatusID;
	
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
	
	public double getamount(){
		return amount;
	}
	
	public int getorderstatus(){
		return orderstatusID;
	}

}
