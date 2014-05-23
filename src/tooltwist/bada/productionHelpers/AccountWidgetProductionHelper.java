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
import com.dinaa.data.XNodes;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcSecurity;

public class AccountWidgetProductionHelper extends WbdProductionHelper
{
	private  String[] Clients;
	private String nextNav;
	public AccountWidgetProductionHelper(Properties prop)
	{
		super(prop);
		setNextNav(prop.getProperty("myNavpoint"));
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		//HttpServletRequest request = ((JspHelper)ud).getRequest();
		Xpc xpc = ud.getXpc();
		xpc.start("phinza.D.client", "select");
		XData data = xpc.run();
		XNodes nodes = data.getNodes("/select/client");
		String [] myArClients = new String[nodes.getNumNodes()];
		int ctr=0;
		for (int i=0; i<nodes.getNumNodes();i++)
		{
//			XNodes nameNodes = nodes.getNodes("name");
//			XNodes idNodes = nodes.getNodes("clientId");
			nodes.getNode(i).normalize();
			
			String clientId = nodes.getNode(i).getChildNodes().item(1).getTextContent()+"";
			String clientName = nodes.getNode(i).getChildNodes().item(3).getTextContent()+"";
			myArClients[ctr] = clientId+"::"+clientName;
			ctr++;
			
		}
		setClients(myArClients);		
		
		return null;
	}

	public String[] getClients() {
		return Clients;
	}

	public void setClients(String[] clients) {
		Clients = clients;
	}

	public String getNextNav() {
		return nextNav;
	}

	public void setNextNav(String nextNav) {
		this.nextNav = nextNav;
	}


}
