


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
<%@page import="tooltwist.bada.productionHelpers.ShowClientWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	ShowClientWidgetProductionHelper h = (ShowClientWidgetProductionHelper) helper;
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<%
if (request.getParameter("contact")==null && request.getParameter("client")==null) 
{
%>
				<h1>Contact List</h1><hr>
				<table class="myTable" width=100%><tr><td class="myHeader">Name</td><td class="myHeader">Skype</td><td class="myHeader">Client</td><td class="myHeader">Del</td></tr>
				<%
				XNodes nodes = h.getMyNodes();
				
				
				for(nodes.first();nodes.next();)
				{
					XNodes myNodes = nodes.getNodes("*");
					//nodes.getCurrentNode().toString()
					//SKYPE = 9, ContactClient=5,6,7, client 3
					String skypeId  = myNodes.getNode(10).getTextContent();
					String contactClientId = myNodes.getNode(5).getTextContent();
					String contactClient = myNodes.getNode(6).getTextContent()+", "
							+	myNodes.getNode(7).getTextContent()	+" "
							+myNodes.getNode(8).getTextContent();
					String client = myNodes.getNode(4).getTextContent();
					out.print("<tr><td><a href=\"?contact="+contactClientId+"\">"+contactClient+"</td><td>"+skypeId+"</td><td>"+client
							+"</td><td><a href=\"?del="+myNodes.getNode(0).getTextContent()+"&op=widgets_bada.showClientWidget.contactClientHandler\">delete</a></td></tr>");
				
				}
				
				%>
				</table>
<% 
}
else if (request.getParameter("contact")!=null){
	String myClients = "<table width=100% ><tr height=30 ><td >";
	myClients += "<table width=100% ><tr><td valign=middle><b>Clients</td></tr>"	;
	String clientId="";
	String contactName="";
	String contactEmail="";
	String contactSkype="";

	for(h.getmyContactClientNode().first();h.getmyContactClientNode().next();){
				XNodes myNodes = h.getmyContactClientNode().getNodes("*");
				//out.print(myNodes==null);
				 clientId = myNodes.getNode(2).getTextContent();
				 contactName = myNodes.getNode(6).getTextContent()+", "
				 			+myNodes.getNode(7).getTextContent()+" "
						 			+myNodes.getNode(8).getTextContent();
				 contactEmail = myNodes.getNode(9).getTextContent();
				 contactSkype = myNodes.getNode(10).getTextContent();
				//out.print(myNodes.getNode(3).getTextContent());
				myClients+= "<tr><td align=left ><a href=\"?client="+clientId+"\">"+myNodes.getNode(4).getTextContent()+"</a></td></tr>";
				
	}
	myClients+="</table></td><td><table><tr><td>";
	myClients+="<form method=\"post\">";
	myClients+="<input type=\"hidden\" name=op value=\"widgets_bada.showClientWidget.contactClientHandler\">";
	myClients+="<input type=\"hidden\" name=contactClient id=contactClient value="+request.getParameter("contact")+">";
	myClients+= "<b>Connect to Another Client</b><br><br>";
	XNodes clientsAll=null;
	String containerClientsAll="";
	for(h.getMyClients().first();h.getMyClients().next();)
	{
		clientsAll = h.getMyClients().getNodes("*");
		containerClientsAll += "<option value="+clientsAll.getNode(0).getTextContent()+">"+clientsAll.getNode(1).getTextContent()+"</option>";
		
	}
	myClients+="<select name=clientAll id=clientAll>"+containerClientsAll+"</select>";//clients
	myClients+="<button type=\"button\" id=\"btn-addClient\">Connect</button>";
	myClients+="</form>";
	myClients+="</td></tr></table></td></tr>";
	myClients+="</table>";
	out.print("<table width=100% ><tr height=30 ><td valign=middle><b>Client's Contact Information</td></tr>"	);
	out.print("<table width=100% align=left>");
	out.print("<tr><td>Name: "+ contactName +"</td></tr>");
	out.print("<tr><td>Email: "+ contactEmail +"</td></tr>");
	out.print("<tr><td>Skype: "+ contactSkype +"<hr></td></tr>");
	out.print("<tr><td>"+ myClients +"</td></tr>");
	out.print("</table>");
	
}
else if (request.getParameter("client")!=null)
{
	String clientName ="";
	String clientEmail ="";
	String clientWebsite ="";
	String clientAdress ="";
	String clientDesc ="";
	for(h.getMyClients().first();h.getMyClients().next();){
	XNodes nodes = h.getMyClients().getNodes("*");
	clientName = nodes.getNode(1).getTextContent();
	clientEmail = nodes.getNode(2).getTextContent();
	clientWebsite = nodes.getNode(3).getTextContent();
	clientAdress = nodes.getNode(4).getTextContent();
	clientDesc = nodes.getNode(5).getTextContent();
	}
	String myClient = "<table width=100% ><tr><td>";
	myClient+="<font size=4><table width=100% height=240 >";
	myClient+="<tr><td>Name: "+clientName+"</td></tr>";
	myClient+="<tr><td>Email: "+clientEmail+"</td></tr>";
	myClient+="<tr><td>Website: "+clientWebsite+"</td></tr>";
	myClient+="<tr><td>Address: "+clientAdress+"</td></tr>";
	myClient+="<tr><td>Description: "+clientDesc+"</td></tr>";
	myClient+="</table></font>";
	myClient+="</td><td valign=top><table>";
	myClient+="<tr><td><b>Contacts </td></tr>";	
	for(h.getListOfContactsPerClient().first();h.getListOfContactsPerClient().next();)
	{
			XNodes contactsPerClient = h.getListOfContactsPerClient().getNodes("*");
			 String clientId = contactsPerClient.getNode(1).getTextContent();
			 String contactName = contactsPerClient.getNode(6).getTextContent()+", "
			 			+contactsPerClient.getNode(7).getTextContent()+" "
					 			+contactsPerClient.getNode(8).getTextContent();
			myClient+="<tr><td><a href=\"?contact="+clientId+"\">"+contactName+" </td></tr>";	
	}
	
	myClient+="</table></td></tr></table>";
	out.print(myClient);
}
%>
<!--END-->
</body>
</html>
