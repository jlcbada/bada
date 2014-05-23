package tooltwist.bada.productionHelpers;

import java.util.Properties;

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

public class ShowMemberWidgetsProductionHelper extends WbdProductionHelper
{

	private XNodes accounts;
	
	public ShowMemberWidgetsProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		Xpc xpc = ud.getXpc();
		xpc.start("phinza.V.accountEmployee", "select");
		XData data = xpc.run();
		XNodes nodes = data.getNodes("/select/employee");
		setAccounts(nodes);
		

		return null;
	}

	public XNodes getAccounts() {
		return accounts;
	}

	public void setAccounts(XNodes accounts) {
		this.accounts = accounts;
	}


}
