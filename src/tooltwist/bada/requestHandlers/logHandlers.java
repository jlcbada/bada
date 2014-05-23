package tooltwist.bada.requestHandlers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import jxl.write.DateTime;

import com.dinaa.DinaaException;
import com.dinaa.data.XData;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcException;
import tooltwist.wbd.WbdRequestHandler;


public class logHandlers extends WbdRequestHandler
{

	public boolean myHandler(UimHelper uh, String username, String message) throws ServletException, IOException, DinaaException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Xpc xpc = uh.getXpc();
		xpc.start("phinza.D.scrumLogs", "insert");
		xpc.attrib("statusMessage", message);
		xpc.attrib("username", username);
		xpc.attrib("dateTime", dateFormat.format(date));
		xpc.run();

		return true;
	}
	public boolean myHandler(Xpc xpc2, String username, String message) throws ServletException, IOException, DinaaException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Xpc xpc = xpc2;
		xpc.start("phinza.D.scrumLogs", "insert");
		xpc.attrib("statusMessage", message);
		xpc.attrib("username", username);
		xpc.attrib("dateTime", dateFormat.format(date));
		xpc.run();

		return true;
	}

	@Override
	public boolean handler(UimHelper arg0, String arg1, String arg2) throws DinaaException, ServletException, IOException {
		// TODO Auto-generated method stub
		return false;
	}


}
