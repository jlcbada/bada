package tooltwist.bada.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.dinaa.DinaaException;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcException;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "addProjectHandler" - Add Project Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=widgets_bada.addProjectWidget.addProjectHandler
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class AddProjectHandlerRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws ServletException, IOException, DinaaException
	{
		HttpServletRequest request = uh.getRequest();
		Xpc xpc = uh.getXpc();
		if (request.getParameter("projectId")=="")
		{
			xpc.start("phinza.D.project", "insert");
			xpc.attrib("name", request.getParameter("txtProjectName"));
			xpc.attrib("clientId",request.getParameter("cmbClient"));
			xpc.attrib("description", request.getParameter("txtProjectDesc"));
			xpc.attrib("startDate", request.getParameter("dtpStart"));
			xpc.attrib("endDate", request.getParameter("dtpEnd"));	
			xpc.run();
			uh.reply("Added Successfully");
		}
		else
		{
		xpc.start("phinza.D.project", "delete");
		xpc.attrib("projectId", request.getParameter("projectId"));
		xpc.run();
		
		xpc.start("phinza.D.project", "insert");
		xpc.attrib("projectId", request.getParameter("projectId"));
		xpc.attrib("name", request.getParameter("txtProjectName"));
		xpc.attrib("clientId",request.getParameter("cmbClient"));
		xpc.attrib("description", request.getParameter("txtProjectDesc"));
		xpc.attrib("startDate", request.getParameter("dtpStart"));
		xpc.attrib("endDate", request.getParameter("dtpEnd"));	
		uh.reply("Updated Successfully");
		xpc.run();
		}
		return true;
	}

}
