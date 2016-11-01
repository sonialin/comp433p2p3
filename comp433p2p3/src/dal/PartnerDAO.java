package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.partner.Partner;

public class PartnerDAO extends Databaseoperation {

	private static Connection con = null;
	private static PreparedStatement pstmt = null;

	public PartnerDAO() {
		super();
	}

	public Partner getPartner(int partnerID) throws SQLException {

		con = getConnection();

		String gethquery = "SELECT pa.*, p.Number, a.StreetAddressLine1 FROM Partner pa, PhoneNumber p, Address a Where pa.PartnerID= '"
				+ partnerID + "'= p.Partner_PartnerID=a.Partner_PartnerID;";

		pstmt = (PreparedStatement) con.prepareStatement(gethquery);
		ResultSet rs = pstmt.executeQuery(gethquery);

		Partner par = new Partner();
		if (rs.next()) {
			par.setpartnerID(rs.getInt(1));
			par.setpartnername(rs.getString(2));
			par.setpartnertype(rs.getString(3));
			par.setpartnerpassword(rs.getString(4));
			par.setpartnerusername(rs.getString(5));
			par.setpartnerphonenumber(rs.getString(7));
			par.setpartneraddress(rs.getString(8));
			con.close();
		}

		return par;

	}

	public Partner addPartner(int partnerID, String partnerusername, String partnerpassword, String partnertype,
			String partnername, String partneraddress, String partnerphonenumber) throws SQLException {

		con = getConnection();

		Partner par = new Partner();
		par.setpartnerID(partnerID);
		par.setpartnername(partnername);
		par.setpartnertype(partnertype);
		par.setpartnerpassword(partnerpassword);
		par.setpartnerusername(partnerusername);
		par.setpartnerphonenumber(partnerphonenumber);
		par.setpartneraddress(partneraddress);

		String addquery = "insert into Partner (PartnerID,PartnerName,PartnerType,Pasword,Username) values(?,?,?,?,?)";

		pstmt = con.prepareStatement(addquery);
		pstmt.setInt(1, par.getpartnerID());
		pstmt.setString(2, par.getpartnername());
		pstmt.setString(3, par.getpartnertype());
		pstmt.setString(4, par.getpartnerpassword());
		pstmt.setString(5, par.getpartnerusername());
		pstmt.executeUpdate();

		String addquery2 = "insert into PhoneNumber (Number,Partner_PartnerID) values(?,?)";
		pstmt = con.prepareStatement(addquery2);
		pstmt.setString(1, par.getpartnerphonenumber());
		pstmt.setInt(2, par.getpartnerID());
		pstmt.executeUpdate();

		String addquery3 = "insert into Address (StreetAddressLine1,Partner_PartnerID) values(?,?)";
		pstmt = con.prepareStatement(addquery3);
		pstmt.setString(1, par.getpartneraddress());
		pstmt.setInt(2, par.getpartnerID());
		pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return par;

	}

	public void deletePartner(int partnerID) throws SQLException {

		con = getConnection();

		String deletequery1 = "SET FOREIGN_KEY_CHECKS = 0;";
		pstmt = con.prepareStatement(deletequery1);
		pstmt.executeUpdate();
		String deletequery2 = "delete pa.*FROM Partner pa Where pa.PartnerID='" + partnerID + "';";
		pstmt = con.prepareStatement(deletequery2);
		pstmt.executeUpdate();
		String deletequery3 = "delete p.*FROM PhoneNumber p Where p.Partner_PartnerID='" + partnerID + "';";
		pstmt = con.prepareStatement(deletequery3);
		pstmt.executeUpdate();
		String deletequery4 = "delete a.* FROM Address a Where a.Partner_PartnerID='" + partnerID + "';";
		pstmt = con.prepareStatement(deletequery4);
		pstmt.executeUpdate();

		con.close();
	}

	/*
	 * public Boolean verifyPartner(int partnerID, String partnerpassword)
	 * throws SQLException{ con=getConnection(); String pwd;
	 * 
	 * String searchquery = "SELECT Password FROM Customer WHERE PartnerID = '"+
	 * partnerID + "';";
	 * 
	 * ResultSet rs = pstmt.executeQuery(searchquery); pwd = rs.getString(1);
	 * 
	 * if(partnerpassword.equals(pwd)){ return true; } else { return false; } }
	 */

	public void notifyPartnersofsale(int orderID) {
		OrderDAO odao = new OrderDAO();

		System.out.println("Order number "+ orderID + " 's new status is "+ odao.getOrderStatus(orderID));
	}

	public void generateReport(int orderID) {
		OrderDAO odao = new OrderDAO();

		odao.fulfillOrder(orderID);
		System.out.println("Generating report for newly fulfilled order number " + orderID);
	}

}
