package tooltwist.bada.xpc;

import tooltwist.misc.MiscInternal;

import com.dinaa.data.XData;
import com.dinaa.sql.DatabaseContext;
import com.dinaa.sql.SelectPluggin;
import com.dinaa.xpc.XpcException;
import com.dinaa.xpc.XpcSecurity;


public class ClientEmployeeXpc extends SelectPluggin
{

	@Override
	public DatabaseContext getContext(XpcSecurity securityDetails) throws XpcException {
		return MiscInternal.getContextFromSecurity(securityDetails);
	}

	@Override
	public void initialize(XpcSecurity arg0, XData arg1) throws XpcException {
		
		//select from clientEmployee left outer join person on clientEmployee.personId = person.personId
		
		mapEntity("phinza.V.clientEmployee");
		
		addLevel("employee");
		
		mapTable("clientEmployee", "clientEmployee", null);
		mapColumn("CE_ID", "ceId", "ceId", false, false);
		mapColumn("person_id", "clientPersonId", "clientPersonId", false, false);
		mapColumn("CLIENT_ID", "thisClientId", "thisClientId", false, false);
		
		mapTable("client", "client", null);
		mapColumn("CLIENT_ID", "clientId", "clientId", false, false);
		mapColumn("name", "name", "name", false, false);
		
		mapTable("person", "person", null);
		mapColumn("person_id", "personId", "personId", false, false);
		mapColumn("LAST_NAME", "lastName", "lastName", false, false);
		mapColumn("FIRST_NAME", "firstName", "firstName", false, false);
		mapColumn("MIDDLE_NAME", "middleName", "middleName", false, false);
		mapColumn("EMAIL", "email", "email", false, false);
		mapColumn("SKYPE_ID", "skypeId", "skypeId", false, false);
		
		
		
		addJoin("clientEmployee", "clientPersonId", "person", "personId");
		addJoin("clientEmployee", "thisClientId", "client", "clientId");
	}
	

}
