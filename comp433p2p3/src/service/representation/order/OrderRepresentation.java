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
	String shipingaddress;
	float totalprice;
	float tax;
	double amount;
	int orderstatusID;
	
	public OrderRepresentation(int orderID, String orderdate, String shipingaddress, 
			     float totalprice, float tax, double amount, int orderstatusID){
		
		this.orderID = orderID;
		this.orderdate = orderdate;
		this.shipingaddress = shipingaddress;
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
	
	public String getshipingaddress(){
		return shipingaddress;
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

}
