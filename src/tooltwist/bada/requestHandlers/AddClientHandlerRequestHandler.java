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
 * Request handler "addClientHandler" - Add Client Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=bada_widgets.addClientWidget.addClientHandler
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class AddClientHandlerRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		HttpServletRequest request = uh.getRequest();
		HttpServletResponse response = uh.getResponse();
		String clientId = request.getParameter("txtMyId");
		String clientName = request.getParameter("txtClientName");
		String clientEmail = request.getParameter("txtClientEmail");
		String clientWebsite = request.getParameter("txtClientWebsite");
		String clientAddress = request.getParameter("txtClientAddress");
		String clientDesc = request.getParameter("clientDesc");
		try {
			Xpc xpc = uh.getXpc();
			if (clientId=="")
			{
				xpc.start("phinza.D.client", "insert");
				xpc.attrib("name", clientName);
				xpc.attrib("email", clientEmail);
				xpc.attrib("website", clientWebsite);
				xpc.attrib("cAdress", clientAddress);
				xpc.attrib("description", clientDesc);
				xpc.run();
				xpc.end();
				uh.reply("Added Successfully");
			}
			else
			{
				xpc.start("phinza.D.client", "update");
				xpc.attrib("clientId", clientId);
				xpc.attrib("name", clientName);
				xpc.attrib("email", clientEmail);
				xpc.attrib("website", clientWebsite);
				xpc.attrib("cAdress", clientAddress);
				xpc.attrib("description", clientDesc);
				xpc.run();
				xpc.end();
				uh.reply("Updated Successfully");
			}
		
		//	response.sendRedirect("bada-32");
		} catch (XpcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DinaaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
