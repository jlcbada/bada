

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
<%@page import="org.w3c.dom.Node"%>
<%@page import="com.dinaa.data.XNodes"%>
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.bada.productionHelpers.ViewClientsWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	ViewClientsWidgetProductionHelper h = (ViewClientsWidgetProductionHelper) helper;
	XData data = h.getData(jh);
	XNodes nodes = h.getMyNode();
%>

<!-- ********** INSERT HTML HERE ********** -->
<div>
<h1>Client Management</h1>
<hr>
<table class="myTable" width=100%>
<tr><td class="myHeader">ID</td><td class="myHeader">Name</td><td class="myHeader">Email</td><td class="myHeader">Website</td><td class="myHeader">Address</td><td class="myHeader">Description</td><td class="myHeader">edit</td></tr>
<%
for (nodes.first();nodes.next();)
{
	out.print("<tr>");
	for (int i=0; i<nodes.getNodes("*").getNumNodes();i++)
	{
		Node node = nodes.getNode(i);
		out.print("<td>"+nodes.getNodes("*").getNode(i).getTextContent()+"</td>");
	}
	out.print("<td><a href=\"bada-33?clientId="+ nodes.getNodes("*").getNode(0).getTextContent() +"\">edit</a></td>");
	out.print("</tr>");
}

%>



</table>
</div>
<!--END-->
</body>
</html>
