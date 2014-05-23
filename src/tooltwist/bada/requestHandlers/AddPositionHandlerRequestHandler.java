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
 * Request handler "addPositionHandler" - Add Position Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=widgets_bada.positionWidget.addPositionHandler
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class AddPositionHandlerRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		HttpServletRequest request = uh.getRequest();
		HttpServletResponse response = uh.getResponse();
		String positionName = request.getParameter("txtPosition");
		String positionId = request.getParameter("positionId");
		if(positionId==""){
			try {
				Xpc xpc = uh.getXpc();
				xpc.start("phinza.D.position","insert");
				xpc.attrib("name", positionName);
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
				xpc.start("phinza.D.position","update");
				xpc.attrib("name", positionName);
				xpc.attrib("positionId", positionId);
				xpc.run();
				response.sendRedirect("bada-41"); //widget property, 
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
