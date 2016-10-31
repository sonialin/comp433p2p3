package service.workflow;

import java.sql.SQLException;


import model.partner.*;
import service.representation.partner.*;

public class PartnerActivity {
	
	private static PartnerManagerFacade pamf = new PartnerManagerFacade();
	
	public PartnerRepresentation getPartner(int partnerID) throws SQLException {
			
		    Partner par = pamf.getPartner(partnerID);
			
		    PartnerRepresentation parRep = new PartnerRepresentation();
		    parRep.setpartnerID(par.getpartnerID());
		    parRep.setpartnername(par.getpartnername());
		    parRep.setpartnertype(par.getpartnertype());
		    parRep.setpartnerpassword(par.getpartnerpassword());
		    parRep.setpartnerusername(par.getpartnerusername());
			parRep.setpartnerphonenumber(par.getpartnerphonenumber());
			parRep.setpartneraddress(par.getpartneraddress());
		    
			return parRep;
		}
	
	public PartnerRepresentation addPartner(int partnerID, String partnerusername, String partnerpassword, String partnertype, 
			String partnername, String partnerphonenumber,String partneraddress) throws SQLException {
			
			Partner par = pamf.addPartner(partnerID, partnerusername, partnerpassword, partnertype,
					partnername, partneraddress, partnerphonenumber);
			
		    PartnerRepresentation parRep = new PartnerRepresentation();
		    parRep.setpartnerID(par.getpartnerID());
		    parRep.setpartnername(par.getpartnername());
		    parRep.setpartnertype(par.getpartnertype());
		    parRep.setpartnerpassword(par.getpartnerpassword());
		    parRep.setpartnerusername(par.getpartnerusername());
			parRep.setpartnerphonenumber(par.getpartnerphonenumber());
			parRep.setpartneraddress(par.getpartneraddress());
			
			return parRep;
		}
	
	public String deletePartner(int partnerID) throws SQLException {
			
			pamf.deletePartner(partnerID);
			
			return "OK";
		}

}
