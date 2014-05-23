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

public class ShowProjectWidgetProductionHelper extends WbdProductionHelper
{
	private XNodes nodeForAllProjects;
	private XNodes nodeForProject;
	private XNodes nodeForProjectScrumMaster;
	private XNodes nodeForProjectOwner;
	private XNodes nodeForPositions;
	private XNodes nodeForSelProject;
	private XNodes nodeForProjectMembers;
	

	public ShowProjectWidgetProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		XpcSecurity credentials = ud.getCredentials();
		Xpc xpc = ud.getXpc();
		xpc.start("phinza.V.clientProject", "select");
		XNodes nodes = xpc.run().getNodes("/select/project");
		setNodeForAllProjects(nodes);
		
		if (request.getParameter("sel")!=null)
		{
			xpc.start("phinza.D.project", "select");
			xpc.attrib("projectId", request.getParameter("sel"));
			XData data2 = xpc.run();
			XNodes nodes2 = data2.getNodes("/select/project");
			setNodeForProject(nodes2);
			//scrumMaster select
			xpc.start("phinza.V.accountEmployee", "select");
			XData data3 = xpc.run();
			XNodes nodes3 = data3.getNodes("/select/employee");
			setNodeForProjectScrumMaster(nodes3);
			//projectOwner select
			xpc.start("phinza.V.projectClientEmployee", "select");
			xpc.attrib("projectId", request.getParameter("sel"));
			XData data4 = xpc.run();
			XNodes nodes4 = data4.getNodes("/select/employee");
			setNodeForProjectOwner(nodes4);
			xpc.start("phinza.D.position", "select");
			XData data5 = xpc.run();
			XNodes nodes5 = data5.getNodes("/select/position");
			setNodeForPositions(nodes5);
			xpc.start("phinza.V.clientProject", "select");
			xpc.attrib("projectId", request.getParameter("sel"));
			XNodes nodes6 = xpc.run().getNodes("/select/project");
			setNodeForSelProject(nodes6);
			xpc.start("phinza.V.projectPosition", "select");
			xpc.attrib("thisProjectId", request.getParameter("sel"));
			XData data7 = xpc.run();
			XNodes nodes7 = data7.getNodes("/select/member");
			setNodeForProjectMembers(nodes7);
		}
		return null;
	}

	public XNodes getNodeForAllProjects() {
		return nodeForAllProjects;
	}

	public void setNodeForAllProjects(XNodes nodeForAllProjects) {
		this.nodeForAllProjects = nodeForAllProjects;
	}

	public XNodes getNodeForProject() {
		return nodeForProject;
	}

	public void setNodeForProject(XNodes nodeForProject) {
		this.nodeForProject = nodeForProject;
	}

	public XNodes getNodeForProjectScrumMaster() {
		return nodeForProjectScrumMaster;
	}

	public void setNodeForProjectScrumMaster(XNodes nodeForProjectScrumMaster) {
		this.nodeForProjectScrumMaster = nodeForProjectScrumMaster;
	}

	public XNodes getNodeForProjectOwner() {
		return nodeForProjectOwner;
	}

	public void setNodeForProjectOwner(XNodes nodeForProjectOwner) {
		this.nodeForProjectOwner = nodeForProjectOwner;
	}

	public XNodes getNodeForPositions() {
		return nodeForPositions;
	}

	public void setNodeForPositions(XNodes nodeForPositions) {
		this.nodeForPositions = nodeForPositions;
	}

	public XNodes getNodeForSelProject() {
		return nodeForSelProject;
	}

	public void setNodeForSelProject(XNodes nodeForSelProject) {
		this.nodeForSelProject = nodeForSelProject;
	}

	public XNodes getNodeForProjectMembers() {
		return nodeForProjectMembers;
	}

	public void setNodeForProjectMembers(XNodes nodeForProjectMembers) {
		this.nodeForProjectMembers = nodeForProjectMembers;
	}

}
