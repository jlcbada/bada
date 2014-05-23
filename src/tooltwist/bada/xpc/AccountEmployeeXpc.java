package tooltwist.bada.xpc;

import tooltwist.misc.MiscInternal;

import com.dinaa.data.XData;
import com.dinaa.sql.DatabaseContext;
import com.dinaa.sql.SelectPluggin;
import com.dinaa.xpc.XpcException;
import com.dinaa.xpc.XpcSecurity;


public class AccountEmployeeXpc extends SelectPluggin
{

	@Override
	public DatabaseContext getContext(XpcSecurity securityDetails) throws XpcException {
		return MiscInternal.getContextFromSecurity(securityDetails);
	}

	@Override
	public void initialize(XpcSecurity arg0, XData arg1) throws XpcException {
		
		//select from clientEmployee left outer join person on clientEmployee.personId = person.personId
		
		mapEntity("phinza.V.accountEmployee");
		
		addLevel("employee");
		
		mapTable("account", "account", null);
		mapColumn("USERNAME", "username", "username", false, false);
		mapColumn("PASSWORD", "password", "password", false, false);
		mapColumn("PERSON_ID", "accountPersonId", "accountPersonId", false, false);
		
	
		
		mapTable("person", "person", null);
		mapColumn("person_id", "personId", "personId", false, false);
		mapColumn("LAST_NAME", "lastName", "lastName", false, false);
		mapColumn("FIRST_NAME", "firstName", "firstName", false, false);
		mapColumn("MIDDLE_NAME", "middleName", "middleName", false, false);
		mapColumn("EMAIL", "email", "email", false, false);
		mapColumn("SKYPE_ID", "skypeId", "skypeId", false, false);
		
		
		
		addJoin("account", "accountPersonId", "person", "personId");
	
	}
	

}
