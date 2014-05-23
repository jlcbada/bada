package tooltwist.bada.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinaa.DinaaException;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcException;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "projectHandler" - Project Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=widgets_bada.showProjectWidget.projectHandler
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class ProjectHandlerRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws ServletException, IOException, DinaaException
	{
		
//		HttpServletResponse response = uh.getResponse();
		HttpServletRequest request = uh.getRequest();
		Xpc xpc = uh.getXpc();
		if (request.getParameter("scrumMaster")!=null)
		{
			xpc.start("phinza.D.project", "update");
			xpc.attrib("scrumMaster", request.getParameter("scrumMaster") );
			xpc.attrib("productOwner", request.getParameter("projectOwner"));
			xpc.attrib("projectId", request.getParameter("projectId"));
			xpc.run();
			//response.sendRedirect("bada-36");
			uh.reply("Scrum Master and Product Owner Updated");
		}
		else if (request.getParameter("members")!=null)
		{
			xpc.start("phinza.D.personProject", "insert");
			xpc.attrib("projectId", request.getParameter("projectId"));
			xpc.attrib("personId", request.getParameter("members"));
			xpc.attrib("positionId", request.getParameter("positions"));
			xpc.run();
			uh.reply("New Member for the project Added");
		}
		else if (request.getParameter("rem")!=null)
		{
			xpc.start("phinza.D.personProject", "delete");
			xpc.attrib("personProjectId", request.getParameter("rem"));
			xpc.run();
			uh.reply("Member removed from Project");
		}
		
		return true;
	}

}
