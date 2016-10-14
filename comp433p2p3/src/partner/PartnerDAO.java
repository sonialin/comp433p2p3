package partner;

import database.Databaseoperation;

public class PartnerDAO  extends Databaseoperation{
	
	public PartnerDAO(){
		super();
	}
	
	public void addPartner(int partnerID, String partnerusername, String partnerpassword, String partnertype, 
			String partnername, String partneraddress, String partnerphonenumber){
				
		String addquery = "INSERT INTO partner VALUES (" + partnerID + "," + partnerusername + "," + partnerpassword +","+ partnertype+ "," 
	               + partnername+","+partneraddress+","+ partnerphonenumber+")";
	
		super.accessDatabase(addquery);
		
	}

	public void deletePartner(int partnerID){
		String deletequery = "DELETE FROM partner WHERE partnerID = " + partnerID +";"; 
		super.accessDatabase(deletequery);
	}
	
	public Boolean verifyPartner(int partnerusername, String partnerpassword){
		//if() //(partnerpassword matches partnerusername)
		//return true;
		//else
			//return false;
		return null;
	}
	
	public void notifyPartnersofsale(){
		//TO DO
	}
	
	public void addPartnerProducts(){
         // productowner.addproduct();
	}
	
	public void settleAccount(){
		//TO DO
	}
	
	public void generateReport(){
		//TO DO
	}

}
