package tooltwist.bada.xpc;

import tooltwist.misc.MiscInternal;

import com.dinaa.data.XData;
import com.dinaa.sql.DatabaseContext;
import com.dinaa.sql.SelectPluggin;
import com.dinaa.xpc.XpcException;
import com.dinaa.xpc.XpcSecurity;


public class ProjectClientEmployeeXpc extends SelectPluggin
{

	@Override
	public DatabaseContext getContext(XpcSecurity securityDetails) throws XpcException {
		return MiscInternal.getContextFromSecurity(securityDetails);
	}

	@Override
	public void initialize(XpcSecurity arg0, XData arg1) throws XpcException {
		
		//select from clientEmployee left outer join person on clientEmployee.personId = person.personId
		
		mapEntity("phinza.V.projectClientEmployee");
		
		addLevel("employee");
		
		mapTable("project", "project", null);
		mapColumn("PROJECT_ID", "projectId", "projectId", false, false);
		mapColumn("NAME", "projectName", "projectName", false, false);
		mapColumn("CLIENT_ID", "projectClientId", "projectClientId", false, false);
		mapColumn("DESCRIPTION", "description", "description", false, false);
		mapColumn("START_DATE", "startDate", "startDate", false, false);
		mapColumn("END_DATE", "endDate", "endDate", false, false);
		mapColumn("SCRUM_MASTER", "scrumMaster", "scrumMaster", false, false);
		mapColumn("PRODUCT_OWNER", "productOwner", "productOwner", false, false);
		

		mapTable("clientEmployee", "clientEmployee", null);
		mapColumn("CLIENT_ID", "clientId", "clientId", false, false);
		mapColumn("person_id", "clientPersonId", "clientPersonId", false, false);
		
		addJoin("project", "projectClientId", "clientEmployee", "clientId");
		
		mapTable("person", "person", null);
		mapColumn("person_id", "personId", "personId", false, false);
		mapColumn("LAST_NAME", "plastName", "plastName", false, false);
		mapColumn("FIRST_NAME", "pfirstName", "pfirstName", false, false);
		mapColumn("MIDDLE_NAME", "pmiddleName", "pmiddleName", false, false);
	
		addJoin("clientEmployee", "clientPersonId", "person", "personId");
		
		
	}
	

}
