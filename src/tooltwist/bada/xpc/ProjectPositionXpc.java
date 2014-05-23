package tooltwist.bada.xpc;

import tooltwist.misc.MiscInternal;

import com.dinaa.data.XData;
import com.dinaa.sql.DatabaseContext;
import com.dinaa.sql.SelectPluggin;
import com.dinaa.xpc.XpcException;
import com.dinaa.xpc.XpcSecurity;


public class ProjectPositionXpc extends SelectPluggin
{

	@Override
	public DatabaseContext getContext(XpcSecurity securityDetails) throws XpcException {
		return MiscInternal.getContextFromSecurity(securityDetails);
	}

	@Override
	public void initialize(XpcSecurity arg0, XData arg1) throws XpcException {
		
		//select from clientEmployee left outer join person on clientEmployee.personId = person.personId
		
		mapEntity("phinza.V.projectPosition");
		
		addLevel("member");
		
		mapTable("personProject", "personProject", null);
		mapColumn("person_project_id", "personProjectId", "personProjectId", false, false);
		mapColumn("person_id", "memberPersonId", "memberPersonId", false, false);
		mapColumn("project_id", "thisProjectId", "thisProjectId", false, false);
		mapColumn("position_id", "thisPositionId", "thisPositionId", false, false);
		
		mapTable("position", "position", null);
		mapColumn("position_id", "positionId", "positionId", false, false);
		mapColumn("name", "positionName", "positionName", false, false);
	
		mapTable("person", "person", null);
		mapColumn("person_id", "personId", "personId", false, false);
		mapColumn("LAST_NAME", "lastName", "lastName", false, false);
		mapColumn("FIRST_NAME", "firstName", "firstName", false, false);
		mapColumn("MIDDLE_NAME", "middleName", "middleName", false, false);
		mapColumn("EMAIL", "email", "email", false, false);
		mapColumn("SKYPE_ID", "skypeId", "skypeId", false, false);

		
		
		addJoin("personProject", "memberPersonId", "person", "personId");
		addJoin("personProject", "thisPositionId", "position", "positionId");
	}
	

}
