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

public class MyNewVerticalMenuWidgetProductionHelper extends WbdProductionHelper
{
	private Navpoint myNavpoint;
	private String myCurrentNavpoint;
	private UimData ud;

	public MyNewVerticalMenuWidgetProductionHelper(Properties prop)
	{
		super(prop);

		
		String myNavPointProperty = prop.getProperty("myNavp");	
		try {
			setMyCurrentNavpoint(prop.getProperty("myCurrentNavp"));
			Navpoint findNavpoint =WbdCache.findNavPoint(myNavPointProperty,true);
			setMyNavpoint(findNavpoint);
		} catch (WbdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		setUd(ud);



		return null;
	}

	public String getMyCurrentNavpoint() {
		return myCurrentNavpoint;
	}

	public void setMyCurrentNavpoint(String myCurrentNavpoint) {
		this.myCurrentNavpoint = myCurrentNavpoint;
	}

	public Navpoint getMyNavpoint() {
		return myNavpoint;
	}

	public void setMyNavpoint(Navpoint myNavpoint) {
		this.myNavpoint = myNavpoint;
	}

	public UimData getUd() {
		return ud;
	}

	public void setUd(UimData ud) {
		this.ud = ud;
	}


}
