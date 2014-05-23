package tooltwist.bada.productionHelpers;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;


import org.w3c.dom.Node;



//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.misc.JspHelper;
import tooltwist.wbd.WbdProductionHelper;
import tooltwist.wbd.WbdSession;

import com.dinaa.DinaaException;
import com.dinaa.data.XData;
import com.dinaa.data.XNodes;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcException;
import com.dinaa.xpc.XpcSecurity;

public class PositionWidgetProductionHelper extends WbdProductionHelper
{
	private XNodes myNodes;
	private String myPositionId;
	private String myPositionName;
	public PositionWidgetProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		XpcSecurity credentials = ud.getCredentials();
		XNodes AllNodes = queryData("position","select",ud);
		setMyNodes(AllNodes);
		if(request.getParameter("pos")==null)
		{
			setMyPositionId("");
			setMyPositionName("");
		}
		else
		{
		setMyPositionId(request.getParameter("pos"));
		XNodes specificNode= queryData("position", "select", request.getParameter("pos"),ud);
		String pName = specificNode.getNode(0).getTextContent()+"";
		setMyPositionName(pName);
		}
		
		return null;
	}
	
	public XNodes queryData(String table, String mode, String attrib, UimData ud)
	{
		Xpc xpc;
		XNodes nodes=null;
		try {
			xpc = ud.getXpc();
			xpc.start("phinza.D."+table, mode);
			xpc.attrib("positionId", attrib);
			XData data = xpc.run();
			nodes = data.getNodes("/select/position/name");
		} catch (XpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DinaaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		
		}
		
		return nodes;
		
	}
	public XNodes queryData(String table, String mode, UimData ud)
	{
		Xpc xpc;
		XNodes nodes=null;
		try {
			xpc = ud.getXpc();
			xpc.start("phinza.D."+table, mode);
			XData data = xpc.run();
			nodes = data.getNodes("/select/position");
		} catch (XpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DinaaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		
		}
		
		return nodes;
		
	}


	public XNodes getMyNodes() {
		return myNodes;
	}

	public void setMyNodes(XNodes myNodes) {
		this.myNodes = myNodes;
	}

	public String getMyPositionName() {
		return myPositionName;
	}

	public void setMyPositionName(String myPositionName) {
		this.myPositionName = myPositionName;
	}

	public String getMyPositionId() {
		return myPositionId;
	}

	public void setMyPositionId(String myPositionId) {
		this.myPositionId = myPositionId;
	}

	

}
