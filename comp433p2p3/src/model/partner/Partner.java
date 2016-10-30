package model.partner;

public class Partner {
	
	int partnerID;
	String partnerusername;
	String partnerpassword;
	String partnertype;
    String partnername;
    String partneraddress;
    String partnerphonenumber;
    
    public Partner(){}
    
	public Partner(	int partnerID, String partnerusername, String partnerpassword, String partnertype, 
					String partnername, String partneraddress, String partnerphonenumber){
		this.partnerID = partnerID;
		this.partnerusername = partnerusername;
		this.partnerpassword = partnerpassword;
		this.partnertype = partnertype;
		this.partnername=partnername;
		this.partneraddress=partneraddress;
		this.partnerphonenumber=partnerphonenumber;
	}
	
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
