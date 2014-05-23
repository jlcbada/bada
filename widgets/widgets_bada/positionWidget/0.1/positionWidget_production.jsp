
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
<%@page import="tooltwist.bada.productionHelpers.PositionWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	PositionWidgetProductionHelper h = (PositionWidgetProductionHelper) helper;
	XData data = h.getData(jh);
	XNodes nodes = h.getMyNodes();
	
%>

<!-- ********** INSERT HTML HERE ********** -->
<section id="respond" class="grid">
<h2>Position Management</h2><hr>
<%
out.print("<table class=\"myTable\" width=\"100%\"><tr>"
	+"<td class=\"myHeader\" width=100% ><b> Position Name</td><td class=\"myHeader\"><b>Edit</b></td></tr>");
for (nodes.first();nodes.next();)
{
	out.print("<tr>");
	XNodes thisNode = nodes.getNodes("*");
	for(int i=1; i<thisNode.getNumNodes();i++)
	{
		out.print("<td>"+thisNode.getNode(i).getTextContent()+"</td>");
		
	}
	out.print("<td><a href=\"?pos="+thisNode.getNode(0).getTextContent()+"\">edit</a></td>");
	out.print("</tr>");
}
out.print("</table>");
%>


</section>
<hr>



<section id="respond" class="grid">
<form id="contactform" method="post">
<input type="hidden" name="op" value="widgets_bada.positionWidget.addPositionHandler">

Add New Position<br>
<input type="text" name="txtPosition" required placeholder="Position Name" value="<%=h.getMyPositionName()%>"><br>
<input type="hidden" name="positionId" value="<%=h.getMyPositionId()%>">
<button type="submit" name="btnAddPosition" >Add/Save</button>
</form>
</section>


<!--END-->
</body>
</html>
