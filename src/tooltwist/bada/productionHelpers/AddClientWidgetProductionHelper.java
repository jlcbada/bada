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

public class AddClientWidgetProductionHelper extends WbdProductionHelper
{
	private String clientName;
	private String clientEmail;
	private String clientWebsite;
	private String clientAddress;
	private String clientDesc;
	private String clientId;
	private String nexNav;

	public AddClientWidgetProductionHelper(Properties prop)
	{
		super(prop);
		setNexNav(prop.getProperty("myNavpoint"));
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		
		
		if (request.getParameter("clientId")==null)
			setClientId("");
		else
			setClientId(request.getParameter("clientId"));
		Xpc xpc = ud.getXpc();
		xpc.start("phinza.D.client", "select");
		xpc.attrib("clientId", getClientId());
		XData data = xpc.run();
		setClientName(data.getText("/select/client/name"));
		setClientEmail(data.getText("/select/client/email"));
		setClientWebsite(data.getText("/select/client/website"));
		setClientAddress(data.getText("/select/client/cAdress"));
		setClientDesc(data.getText("/select/client/description"));
		return null;
	}
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientWebsite() {
		return clientWebsite;
	}

	public void setClientWebsite(String clientWebsite) {
		this.clientWebsite = clientWebsite;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientDesc() {
		return clientDesc;
	}

	public void setClientDesc(String clientDesc) {
		this.clientDesc = clientDesc;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getNexNav() {
		return nexNav;
	}

	public void setNexNav(String nexNav) {
		this.nexNav = nexNav;
	}


}
