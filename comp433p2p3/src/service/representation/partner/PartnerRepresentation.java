package service.representation.partner;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Partner")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

public class PartnerRepresentation {

	int partnerID;
	String partnerusername;
	String partnerpassword;
	String partnertype;
    String partnername;
    String partneraddress;
    String partnerphonenumber;
	
    public PartnerRepresentation(){}
    
    public int getpartnerID(){
		return partnerID;
	}
	
	public void setpartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	
	public String getpartnerusername(){
		return partnerusername;
	}
	
	public void setpartnerusername(String partnerusername) {
		this.partnerusername = partnerusername;
	}
	
	public String getpartnerpassword(){
		return partnerpassword;
	}
	
	public void setpartnerpassword(String partnerpassword) {
		this.partnerpassword = partnerpassword;
	}
	
	public String getpartnertype(){
		return partnertype;
	}
	
	public void setpartnertype(String partnertype) {
		this.partnertype = partnertype;
	}
	
	public String getpartnername(){
		return partnername;
	}
	
	public void setpartnername(String partnername) {
		this.partnername = partnername;
	}
	
	public String getpartneraddress(){
		return partneraddress;
	}
	
	public void setpartneraddress(String partneraddress) {
		this.partneraddress = partneraddress;
	}
	
	public String getpartnerphonenumber(){
		return partnerphonenumber;
	}
	
	public void setpartnerphonenumber(String partnerphonenumber) {
		this.partnerphonenumber = partnerphonenumber;
	}
	
}
