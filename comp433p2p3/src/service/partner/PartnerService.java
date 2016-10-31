package service.partner;

import java.sql.SQLException;

import javax.jws.WebService;
import javax.ws.rs.core.Response;


import service.representation.partner.PartnerRepresentation;
import service.representation.partner.PartnerRequest;

@WebService
public interface PartnerService {
	
	public PartnerRepresentation getPartner(int partnerID) throws SQLException;
	public PartnerRepresentation addPartner(PartnerRequest partnerRequest) throws SQLException;
	public Response deletePartner(int partnerID) throws SQLException;

}
