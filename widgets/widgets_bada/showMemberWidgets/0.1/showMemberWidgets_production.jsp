
<html>
<head>
<title></title>
</head>
<body>
<%
	WbdProductionHelper helper = null;
	JspHelper jh = null;
	String snippetVar_myProperty;
	String snippetVar_thisNavpoint;
%>
<!--START-->
<%@page import="com.dinaa.data.XNodes"%>
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.bada.productionHelpers.ShowMemberWidgetsProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	ShowMemberWidgetsProductionHelper h = (ShowMemberWidgetsProductionHelper) helper;
	XData data = h.getData(jh);
	String htmlContent="<h1>Member List</h1><hr><table class=myTable width=100% >";
	htmlContent+="<tr><td class=myHeader style=\"padding:6\">Username</td><td  class=myHeader style=\"padding:6\">Name</td><td  class=myHeader style=\"padding:6\">Email</td><td class=myHeader  style=\"padding:6\">Skype</td></tr>";
	for(h.getAccounts().first();h.getAccounts().next();)
	{
		XNodes allAccounts = h.getAccounts().getNodes("*");
		htmlContent+="<tr><td style=\"padding:6\">"+allAccounts.getNode(0).getTextContent()+"</td><td style=\"padding:6\">"
			+allAccounts.getNode(4).getTextContent()+", "+
				allAccounts.getNode(5).getTextContent()+" "+
					allAccounts.getNode(6).getTextContent()+
					"</td><td style=\"padding:6\">"+allAccounts.getNode(7).getTextContent()+"</td><td style=\"padding:6\">"+allAccounts.getNode(8).getTextContent()+"</td></tr>";
	}
	htmlContent+="</table>";
%>

<!-- ********** INSERT HTML HERE ********** -->
<%
out.print(htmlContent);

%>



<!--END-->
</body>
</html>
