package tooltwist.bada.requestHandlers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.dinaa.DinaaException;
import com.dinaa.data.XData;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcException;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "accountHandler" - Account Handler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=widget_bada.accountWidget.accountHandler
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class AccountHandlerRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		HttpServletRequest request = uh.getRequest();
		if  (request.getParameter("txtusername")!=null)
		{
			try {
				Xpc xpc = uh.getXpc();
				xpc.start("phinza.D.person", "insert");//insert to table person
				xpc.attrib("lastName", request.getParameter("lastName"));
				xpc.attrib("firstName", request.getParameter("middleName"));
				xpc.attrib("middleName", request.getParameter("middleName"));
				xpc.attrib("email", request.getParameter("email"));
				xpc.attrib("skypeId", request.getParameter("skypeId"));
				xpc.run();
				xpc.end();
				xpc.start("phinza.D.person", "select");// get personId of the inserted person
				xpc.attrib("lastName", request.getParameter("lastName"));
				xpc.attrib("firstName", request.getParameter("middleName"));
				xpc.attrib("middleName", request.getParameter("middleName"));
				xpc.attrib("email", request.getParameter("email"));
				xpc.attrib("skypeId", request.getParameter("skypeId"));
				XData data = xpc.run();
				String personId = data.getText("/select/person/personId");//store person Id
				xpc.end();
				xpc.start("phinza.D.account", "insert");//insert personId and account info to table account
				xpc.attrib("username", request.getParameter("txtusername"));
				xpc.attrib("password", sha1(request.getParameter("txtpassword")));
				xpc.attrib("personId",personId);
				xpc.run();
				uh.reply("Member's account added successfully");
			//	xpc.attrib("txtpassword", value)
						
						
						
						
			} catch (XpcException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DinaaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (request.getParameter("cmbClient")!=null)
		{
			Xpc xpc;
			try {
				xpc = uh.getXpc();
				xpc.start("phinza.D.person", "insert");//insert to table person
				xpc.attrib("lastName", request.getParameter("lastName"));
				xpc.attrib("firstName", request.getParameter("firstName"));
				xpc.attrib("middleName", request.getParameter("middleName"));
				xpc.attrib("email", request.getParameter("email"));
				xpc.attrib("skypeId", request.getParameter("skypeId"));
				xpc.run();
				xpc.end();
				xpc.start("phinza.D.person", "select");// get personId of the inserted person
				xpc.attrib("lastName", request.getParameter("lastName"));
				xpc.attrib("firstName", request.getParameter("firstName"));
				xpc.attrib("middleName", request.getParameter("middleName"));
				xpc.attrib("email", request.getParameter("email"));
				xpc.attrib("skypeId", request.getParameter("skypeId"));
				XData data = xpc.run();
				String personId = data.getText("/select/person/personId");//store person Id
				xpc.end();
				xpc.start("phinza.D.clientEmployee", "insert");//insert personId and account info to table account
				xpc.attrib("clientId", request.getParameter("cmbClient"));
				xpc.attrib("personId", personId);
				xpc.run();
				uh.reply("Contact infos added successfully");
			} catch (XpcException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DinaaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		return true;
	}
	public String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
}
