package service.partner;

import java.sql.SQLException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import service.representation.partner.*;
import service.workflow.PartnerActivity;

public class PartnerResource {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{partnerID}")
	public PartnerRepresentation getPartner(@PathParam("partnerID") int partnerID) throws SQLException {
		System.out.println("GET METHOD Request from Client with customerRequest String ............." + partnerID);
		PartnerActivity parActivity = new PartnerActivity();
		return parActivity.getPartner(partnerID);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/partner")
	public PartnerRepresentation addPartner(PartnerRequest partnerRequest) throws SQLException {
		System.out.println("POST METHOD Request from Client with ............." + partnerRequest.getpartnerID() + " " + partnerRequest.getpartnername() + " " + partnerRequest.getpartnertype() + " " + partnerRequest.getpartnerpassword() + "  " + partnerRequest.getpartnerusername() + " " + partnerRequest.getpartnerphonenumber() + " " + partnerRequest.getpartneraddress());
		PartnerActivity parActivity = new PartnerActivity();
		return parActivity.addPartner(partnerRequest.getpartnerID(), partnerRequest.getpartnername(), partnerRequest.getpartnertype(),partnerRequest.getpartnerpassword(),partnerRequest.getpartnerusername(), partnerRequest.getpartnerphonenumber(), partnerRequest.getpartneraddress());
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{customerUsername}")
	public Response deletePartner(@PathParam("partnerID") int partnerID, String partnerpassword) throws SQLException {
		System.out.println("Delete METHOD Request from Client with customerRequest String ............." + partnerID);
		PartnerActivity parActivity = new PartnerActivity();
		String res = parActivity.deletePartner(partnerID, partnerpassword);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}
