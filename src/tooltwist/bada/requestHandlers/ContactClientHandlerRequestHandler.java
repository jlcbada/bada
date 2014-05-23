package tooltwist.bada.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinaa.DinaaException;
import com.dinaa.data.XData;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcException;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "contactClientHandler" - Contact Client Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=widgets_bada.showClientWidget.contactClientHandler
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class ContactClientHandlerRequestHandler extends WbdRequestHandler
{
	
	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws ServletException, IOException, DinaaException
	{

		HttpServletRequest request = uh.getRequest();
		HttpServletResponse response = uh.getResponse();
		if (request.getParameter("clientAll")!=null)
		{
				String thisClient=request.getParameter("clientAll");
				String contactClient = request.getParameter("contactClient");
				Xpc xpc = uh.getXpc();
				xpc.start("phinza.D.clientEmployee", "select");
				xpc.attrib("clientId", thisClient);
				xpc.attrib("personId", contactClient);
				XData data = xpc.run();
				if(data.getRootType()=="select")
				{
					//alarm
					uh.reply("true");
				}
				else
				{
					//insert
					uh.reply("false");
					xpc.start("phinza.D.clientEmployee", "insert");
					xpc.attrib("clientId",thisClient);
					xpc.attrib("personId", contactClient);
					xpc.run();
				}
		}
		else if (request.getParameter("del")!=null)
		{
			String clientEmployeeId = request.getParameter("del");
			Xpc xpc = uh.getXpc();
			xpc.start("phinza.D.clientEmployee", "delete");
			xpc.attrib("ceId", clientEmployeeId );
			xpc.run();
			response.sendRedirect("bada-31");
		}
		return true;
	}

}
