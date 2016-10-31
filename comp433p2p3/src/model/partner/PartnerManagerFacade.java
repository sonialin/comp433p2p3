package model.partner;

import java.sql.SQLException;

import dal.Databaseoperation;
import dal.PartnerDAO;
import model.customer.Customer;
import model.product.Product;

public class PartnerManagerFacade{
	
	PartnerDAO ptdao = new PartnerDAO();
	
	public Partner getPartner(int partnerID) throws SQLException{

		return ptdao.getPartner(partnerID);
	}
	
	public Partner addPartner(int partnerID, String partnerusername, String partnerpassword, String partnertype, 
			String partnername, String partnerphonenumber,String partneraddress) throws SQLException{
		
		return ptdao.addPartner(partnerID, partnerusername, partnerpassword, partnertype,
				partnername, partnerphonenumber,partneraddress);
		
	}

	public void deletePartner(int partnerID) throws SQLException{
		ptdao.deletePartner(partnerID);
	}
	
/*	public Boolean verifyPartner(int partnerusername, String partnerpassword) throws SQLException{
		return ptdao.verifyPartner(partnerusername, partnerpassword);
	}*/
	
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
