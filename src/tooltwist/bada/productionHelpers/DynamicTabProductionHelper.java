package tooltwist.bada.productionHelpers;

import java.util.Properties;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.wbd.Navpoint;
import tooltwist.wbd.WbdCache;
import tooltwist.wbd.WbdException;
import tooltwist.wbd.WbdProductionHelper;
import tooltwist.wbd.WbdSession;

import com.dinaa.data.XData;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.XpcSecurity;

public class DynamicTabProductionHelper extends WbdProductionHelper
{
	private Navpoint myTab;
	private String currentNavpoint;
	public DynamicTabProductionHelper(Properties prop)
	{
		super(prop);
		String myNavpoint = prop.getProperty("myNavpoint");
		setCurrentNavpoint(prop.getProperty("myCurrentNavpoint"));
		try {
			Navpoint findNavPoint = WbdCache.findNavPoint(myNavpoint, true);
			setMyTab(findNavPoint);
		} catch (WbdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();



		return null;
	}
	public Navpoint getMyTab()
	{
		return myTab;
	}
	public void setMyTab(Navpoint myTab)
	{
		this.myTab = myTab;
	}

	public String getCurrentNavpoint() {
		return currentNavpoint;
	}

	public void setCurrentNavpoint(String currentNavpoint) {
		this.currentNavpoint = currentNavpoint;
	}

}
