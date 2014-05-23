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
 * Request handler "update" - Person Update Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=bada_widgets.personMaintenance.update
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class UpdateRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		HttpServletRequest request = uh.getRequest();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String middlName = request.getParameter("middleName");
		String email = request.getParameter("email");
		String skypeId = request.getParameter("skypeId");
		String personId = request.getParameter("personId");
		if (personId==null)
		{
			try {
				Xpc xpc = uh.getXpc();
				xpc.start("phinza.D.person","insert");
				xpc.attrib("lastName", lastName);
				xpc.attrib("firstName", firstName);
				xpc.attrib("middleName", middlName);
				xpc.attrib("email", email);
				xpc.attrib("skypeId", skypeId);
				xpc.run();
				
			} catch (XpcException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DinaaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				Xpc xpc = uh.getXpc();
				xpc.start("phinza.D.person","update");
				xpc.attrib("personId", personId);
				xpc.attrib("lastName", lastName);
				xpc.attrib("firstName", firstName);
				xpc.attrib("middleName", middlName);
				xpc.attrib("email", email);
				xpc.attrib("skypeId", skypeId);
				xpc.run();
				
			} catch (XpcException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DinaaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return false;
	}

}
