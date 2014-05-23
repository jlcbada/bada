package tooltwist.bada.requestHandlers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dinaa.DinaaException;
import com.dinaa.data.XData;
import com.dinaa.data.XNodes;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcException;
import tooltwist.bada.requestHandlers.logHandlers;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "loginHandler" - loginHandler
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=widgets_bada.loginWidget.loginHandler
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class LoginHandlerRequestHandler extends WbdRequestHandler
{

	
	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		String username;
		String password;
		HttpServletRequest request = uh.getRequest();
		HttpServletResponse response = uh.getResponse();
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		try {
			Xpc xpc = uh.getXpc();
			xpc.start("phinza.D.account", "select");
			xpc.attrib("username", username);
			try {
				xpc.attrib("password", sha1(password));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			XData data = xpc.run();
			if (data.getRootType().equals("select")) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", username);
				logHandlers log = new logHandlers();
				log.myHandler(uh, username, "Account Logged in");
				//response.sendRedirect("bada-42"); //widget property, 
				uh.reply("true");
		
			} else {
				uh.reply("false");
			}
			//XNodes myAccount = data.getNodes("/select/account/");

			
		} catch (XpcException e) {
			e.printStackTrace();
		} catch (DinaaException e) {
			e.printStackTrace();
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
