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

public class AssignmentwidgetProductionHelper extends WbdProductionHelper
{
	private Navpoint myNavpoint;
	private String myCurrentNavpoint;
	public AssignmentwidgetProductionHelper(Properties prop)
	{
		super(prop);
		String myNavProperty = prop.getProperty("myNavp");	
		setMyCurrentNavpoint(prop.getProperty("myCurrentNavp"));
		try {
			Navpoint findNavpoint =WbdCache.findNavPoint(myNavProperty,true);
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


		return null;
	}

	public Navpoint getMyNavpoint() {
		return myNavpoint;
	}

	public void setMyNavpoint(Navpoint myNavpoint) {
		this.myNavpoint = myNavpoint;
	}

	public String getMyCurrentNavpoint() {
		return myCurrentNavpoint;
	}

	public void setMyCurrentNavpoint(String myCurrentNavpoint) {
		this.myCurrentNavpoint = myCurrentNavpoint;
	}


}
