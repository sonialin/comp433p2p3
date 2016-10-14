package partner;

import database.Databaseoperation;
import product.Product;

public class PartnerManagerFacade{
	
	PartnerDAO ptdao = new PartnerDAO();
	
	
	public void addPartner(int partnerID, String partnerusername, String partnerpassword, String partnertype, 
			String partnername, String partneraddress, String partnerphonenumber){
		
		ptdao.addPartner(partnerID, partnerusername, partnerpassword, partnertype,
				partnername, partneraddress, partnerphonenumber);
		
	}

	public void deletePartner(int partnerID){
		ptdao.deletePartner(partnerID);
	}
	
	public Boolean verifyPartner(int partnerusername, String partnerpassword){
		return ptdao.verifyPartner(partnerusername, partnerpassword);
	}
	
	public void notifyPartnersofsale(){
		ptdao.notifyPartnersofsale();
	}
	
	public void addPartnerProducts(){
         ptdao.addPartnerProducts();
	}
	
	public void settleAccount(){
		ptdao.settleAccount();
	}
	
	public void generateReport(){
		ptdao.generateReport();
	}
}
