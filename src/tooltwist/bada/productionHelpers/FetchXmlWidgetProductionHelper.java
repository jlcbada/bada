package tooltwist.bada.productionHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.w3c.dom.Element;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.wbd.WbdProductionHelper;
import tooltwist.wbd.WbdSession;

import com.dinaa.data.XData;
import com.dinaa.data.XDataException;
import com.dinaa.data.XNodes;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.XpcSecurity;

public class FetchXmlWidgetProductionHelper extends WbdProductionHelper
{
	private String myAddress;
	private XNodes myResponse;
	
	
	public FetchXmlWidgetProductionHelper(Properties prop)
	{
		super(prop);
		//setMyAddress(prop.getProperty("myURL"));
		
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		XpcSecurity credentials = ud.getCredentials();
		setMyAddress("http://localhost:8983/solr/collection1/select?q=*:*");
		XNodes response = fetchSOLR(myAddress);
		setMyResponse(response);

		return null;
	}
	
	public XNodes fetchSOLR(String myAddress)
	{
		
		XNodes responseBody = null;
		String httpAddress=myAddress;
		HttpClient client = new HttpClient();
		HttpMethod method = new GetMethod(httpAddress);
		try {
		client.executeMethod(method);
		client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		XData data = new XData(method.getResponseBodyAsStream());
		XNodes nodes = data.getNodes("/response/result/doc");
		responseBody = nodes;
		/*for (nodes.first(); nodes.next();) {
			XNodes strNodes = nodes.getNodes("str");
			for (strNodes.first(); nodes.next();) {
				Element str = (Element)strNodes.getCurrentNode();
				String name = str.getAttribute("name");
				String value = str.getTextContent();
			}
			System.out.println(nodes.getText("float"));
		}
		*/
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responseBody;
		
	}

	public String getMyAddress() {
		return myAddress;
	}

	public void setMyAddress(String myAddress) {
		this.myAddress = myAddress;
	}

	public XNodes getMyResponse() {
		return myResponse;
	}

	public void setMyResponse(XNodes myResponse) {
		this.myResponse = myResponse;
	}

}
