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

public class ShowClientWidgetProductionHelper extends WbdProductionHelper
{
	private XNodes Mynodes;
	private XNodes myContactClientNode;
	private XNodes myClients;
	private XNodes listOfContactsPerClient;
	public ShowClientWidgetProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		Xpc xpc = ud.getXpc();
		
		if(request.getParameter("contact")!=null)
		{
			xpc.start("phinza.V.clientEmployee", "select");
			xpc.attrib("personId", request.getParameter("contact"));
			XData data = xpc.run();
			XNodes nodes = data.getNodes("/select/employee");
			setmyContactClientNode(nodes);
			xpc.end();
			xpc.start("phinza.D.client", "select");
			XData data2 = xpc.run();
			XNodes nodesAllClients = data2.getNodes("/select/client");
			setMyClients(nodesAllClients);
			return null;
		}
		else if (request.getParameter("client")!=null)
		{
			xpc.start("phinza.D.client", "select");
			xpc.attrib("clientId",request.getParameter("client"));
			XData data = xpc.run();
			XNodes nodes = data.getNodes("/select/client");
			setMyClients(nodes);	
			xpc.end();
			
			xpc.start("phinza.V.clientEmployee", "select");
			xpc.attrib("clientId", request.getParameter("client"));
			XData data2 = xpc.run();
			XNodes nodes2 = data2.getNodes("/select/employee");
			setListOfContactsPerClient(nodes2);
			return null;
		}
		else
		{
			xpc.start("phinza.V.clientEmployee", "select");
			XData data = xpc.run();
			XNodes nodes = data.getNodes("/select/employee");
			setMyNodes(nodes);
			return data;
		}
		
		//return null;
	}

	public XNodes getMyNodes() {
		return Mynodes;
	}

	public void setMyNodes(XNodes nodes) {
		this.Mynodes = nodes;
	}

	public XNodes getmyContactClientNode() {
		return myContactClientNode;
	}

	public void setmyContactClientNode(XNodes myContactClientNode) {
		this.myContactClientNode = myContactClientNode;
	}

	public XNodes getMyClients() {
		return myClients;
	}

	public void setMyClients(XNodes myClients) {
		this.myClients = myClients;
	}

	public XNodes getListOfContactsPerClient() {
		return listOfContactsPerClient;
	}

	public void setListOfContactsPerClient(XNodes listOfContactsPerClient) {
		this.listOfContactsPerClient = listOfContactsPerClient;
	}

	

	

	

}
