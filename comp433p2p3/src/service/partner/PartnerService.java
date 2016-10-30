package service.partner;

import javax.jws.WebService;

import service.representation.partner.*;

@WebService
public interface PartnerService {
	
	public PartnerRepresentation getPartner(int partnerID);
	public PartnerRepresentation addPartner(PartnerRequest partnerRequest);
	public PartnerRepresentation deletePartner(String partnerID, String partnerpassword);

}
