package tooltwist.bada.productionHelpers;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.misc.JspHelper;
import tooltwist.wbd.Navpoint;
import tooltwist.wbd.WbdCache;
import tooltwist.wbd.WbdProductionHelper;
import tooltwist.wbd.WbdSession;

import com.dinaa.data.XData;
import com.dinaa.data.XNodes;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcSecurity;

public class AddProjectWidgetProductionHelper extends WbdProductionHelper
{
	private XNodes allClients;
	private XNodes nodeForScrumMaster;
	private String projectId="";
	private String projectName="";
	private String projectClient="";
	private String projectDesc="";
	private String startDate;
	private String endDate;
	private String nextNavPoint;
	
	public AddProjectWidgetProductionHelper(Properties prop)
	{
		super(prop);
		setNextNavPoint(prop.getProperty("myNavpoint"));
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
	
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		XpcSecurity credentials = ud.getCredentials();
		Xpc xpc = ud.getXpc();
		xpc.start("phinza.D.client", "select");
		XData data = xpc.run();
		setAllClients(data.getNodes("/select/client"));
		xpc.end();
		if(request.getParameter("edit")==null)
			setProjectId("");
		else
		{
			setProjectId(request.getParameter("edit"));
			xpc.start("phinza.D.project", "select");
			xpc.attrib("projectId", request.getParameter("edit"));
			XData run = xpc.run();
			XNodes nodesForProject = run.getNodes("/select/project");
			for(nodesForProject.first();nodesForProject.next();)
			{
				setProjectName(nodesForProject.getText("name"));
				setProjectClient(nodesForProject.getText("clientId"));
				setStartDate(nodesForProject.getText("startDate"));
				setEndDate(nodesForProject.getText("endDate"));
				setProjectDesc(nodesForProject.getText("description"));
			}
		}
		
		
		return null;
		
	}
	
	public String generateOptions() {
		String clientContainer = "";
		try {
			for (allClients.first();allClients.next();)
			{
				
				XNodes allClientNode = allClients.getNodes("*");
				String isSelect="";
				if (allClientNode.getNode(0).getTextContent().equals(projectClient))
					isSelect="selected";
				
				clientContainer+="<option "+isSelect+" value=\""+allClientNode.getNode(0).getTextContent()+"\">"+allClientNode.getNode(1).getTextContent()+"</option>";
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return clientContainer;
	}

	public XNodes getAllClients() {
		return allClients;
	}

	public void setAllClients(XNodes allClients) {
		this.allClients = allClients;
	}

	public XNodes getNodeForScrumMaster() {
		return nodeForScrumMaster;
	}

	public void setNodeForScrumMaster(XNodes nodeForScrumMaster) {
		this.nodeForScrumMaster = nodeForScrumMaster;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectClient() {
		return projectClient;
	}

	public void setProjectClient(String projectClient) {
		this.projectClient = projectClient;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getNextNavPoint() {
		return nextNavPoint;
	}

	public void setNextNavPoint(String nextNavPoint) {
		this.nextNavPoint = nextNavPoint;
	}


}
