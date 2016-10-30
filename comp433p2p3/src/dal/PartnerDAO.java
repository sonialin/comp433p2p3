package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.partner.Partner;

public class PartnerDAO  extends Databaseoperation{
	
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	
	public PartnerDAO(){
		super();
	}
	
	public Partner getPartner(int partnerID) throws SQLException{
			
			con=getConnection();
			
			String gethquery = "SELECT pa.*, p.Number, a.StreetAddressLine1 FROM Partner pa, PhoneNumber p, Address a Where pa.PartnerID= '"+ partnerID +"'= p.Partner_PartnerID=a.Partner_PartnerID;";     
			
			pstmt = (PreparedStatement) con.prepareStatement(gethquery);
			ResultSet rs = pstmt.executeQuery(gethquery);
			
			
			Partner par = new Partner();
			par.setpartnerID(rs.getInt(1));
			par.setpartnername(rs.getString(2));
	        par.setpartnertype(rs.getString(3));
	        par.setpartnerpassword(rs.getString(4));
	        par.setpartnerusername(rs.getString(5));
	        par.setpartnerphonenumber(rs.getString(7));
	        par.setpartneraddress(rs.getString(8));
	        con.close();
	        
			return par;
	        
		}

	public Partner addPartner(int partnerID, String partnerusername, String partnerpassword, String partnertype, 
			String partnername, String partneraddress, String partnerphonenumber) throws SQLException{
		
		con=getConnection();
		
		Partner par = new Partner();
		par.setpartnerID(partnerID);
		par.setpartnername(partnername);
        par.setpartnertype(partnertype);
        par.setpartnerpassword(partnerpassword);
        par.setpartnerusername(partnerusername);
        par.setpartnerphonenumber(partnerphonenumber);
        par.setpartneraddress(partneraddress);
		
		String addquery = "insert into Customer (Username,Password,Firstname,Lastname,Email) values(?,?,?,?,?)";
		
		pstmt = con.prepareStatement(addquery);
		pstmt.setString(2, par.getpartnername());
		pstmt.setString(3, par.getpartnertype());
		pstmt.setString(4, par.getpartnerpassword());
		pstmt.setString(5, par.getpartnerusername());
		pstmt.executeUpdate();
		
		String addquery2 = "insert into PhoneNumber (Number,Partner_PartnerID) values(?,?)";
		pstmt = con.prepareStatement(addquery2);
		pstmt.setString(1, par.getpartnerphonenumber());
		pstmt.setInt(2, par.getpartnerID());
		
		String addquery3 = "insert into Address (StreetAddressLine1,Partner_PartnerID) values(?,?)";
		pstmt = con.prepareStatement(addquery3);
		pstmt.setString(1, par.getpartneraddress());
		pstmt.setInt(2, par.getpartnerID());
		
		pstmt.close();
		con.close();		
		
		return par;
	
	}

	public void deletePartner(int partnerID, String partnerpassword) throws SQLException{
		
        con=getConnection();
		
		if(verifyPartner(partnerID,partnerpassword))
		{
		String deletequery = "DELETE FROM Customer WHERE PartnerID = " + partnerID + ";";  // productID will get from keyboard input
		pstmt.executeQuery(deletequery);
		}
		else
			System.out.println("Sorry, you are not able to delete this Partner");
		
		con.close();
	}
	
	public Boolean verifyPartner(int partnerID, String partnerpassword) throws SQLException{
		con=getConnection();
		String pwd;
		
		String searchquery = "SELECT Password FROM Customer WHERE PartnerID = '"+ partnerID + "';";     
		
		ResultSet rs = pstmt.executeQuery(searchquery);
        pwd = rs.getString(1);
        
        if(partnerpassword.equals(pwd)){
        	return true;
        } else {
        	return false;
        }
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
