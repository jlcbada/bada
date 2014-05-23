package tooltwist.bada.productionHelpers;

import java.util.Properties;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.misc.JspHelper;
import tooltwist.wbd.WbdProductionHelper;
import tooltwist.wbd.WbdSession;

import com.dinaa.data.XData;
import com.dinaa.data.XNodes;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcSecurity;

public class ViewClientsWidgetProductionHelper extends WbdProductionHelper
{
	/*
	private String client;
	private String email;
	private String website;
	private String address;
	private String description;
	*/
	private XNodes myNode;
	

	public ViewClientsWidgetProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		Xpc xpc = ud.getXpc();
		xpc.start("phinza.D.client", "select");
		XData data = xpc.run();
		setMyNode(data.getNodes("/select/client"));
		
		
		
		return null;
	}
/*
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
*/

	public XNodes getMyNode() {
		return myNode;
	}

	public void setMyNode(XNodes myNode) {
		this.myNode = myNode;
	}

}
