package tooltwist.bada.productionHelpers;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.misc.JspHelper;
import tooltwist.wbd.WbdProductionHelper;
import tooltwist.wbd.WbdSession;

import com.dinaa.data.XData;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcSecurity;

public class PersonMaintenanceProductionHelper extends WbdProductionHelper
{
	private String firstname;
	private String middleName;
	private String lastName;
	private String email;
	private String skypeId;
	private String personId;

	public PersonMaintenanceProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		Xpc xpc = ud.getXpc();
		if(request.getParameter("personId")==null)
			setPersonId("");	
		else
			setPersonId(request.getParameter("personId"));
		xpc.start("phinza.D.person", "select");
		xpc.attrib("personId",request.getParameter("personId"));
		XData data = xpc.run();
		setFirstname(data.getText("/select/person/firstName"));
		setLastName(data.getText("/select/person/lastName"));
		setMiddleName(data.getText("/select/person/middleName"));
		setEmail(data.getText("/select/person/email"));
		setSkypeId(data.getText("/select/person/skypeId"));

		return null;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}


}
