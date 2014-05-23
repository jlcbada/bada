
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
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XNodes"%>
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.bada.productionHelpers.ShowProjectWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	ShowProjectWidgetProductionHelper h = (ShowProjectWidgetProductionHelper) helper;
	XData data = h.getData(jh);
	String containerforAllProjects="<h1>Project List</h1><hr><table width=100% class=myTable>"
			+"<tr align=center><td class=myHeader><b>Project</b></td><td class=myHeader><b>Client</b></td>"
			+"<td class=myHeader><b>Description</b></td><td class=myHeader><b>Start Date</b></td>"
			+"<td class=myHeader><b>End Date</b></td><td class=myHeader><b>Scrum Master</b></td>"
			+"<td class=myHeader><b>Product Owner</b></td><td class=myHeader><b>Edit</b></td>";
	XNodes allProject=null;
	for(h.getNodeForAllProjects();h.getNodeForAllProjects().next();)
	{
		//out.print(h.getNodeForAllProjects().getText("projectName"));
		//h.getNodeForAllProjects().getText("scrumMaster");
		//allProject = h.getNodeForAllProjects().getNodes("*");
		containerforAllProjects+="<tr><td style=\"padding: 10;\"><a href=\"?sel="+h.getNodeForAllProjects().getText("projectId")+"\">"+h.getNodeForAllProjects().getText("projectName")+"</a></td>"
				+"<td style=\"padding: 10;\">"+h.getNodeForAllProjects().getText("clientName")+"</td>"
				+"<td style=\"padding: 10;\">"+h.getNodeForAllProjects().getText("description")+"</td>"
				+"<td style=\"padding: 10;\">"+h.getNodeForAllProjects().getText("startDate")+"</td>"
				+"<td style=\"padding: 10;\">"+h.getNodeForAllProjects().getText("endDate")+"</td>";
		if (!(h.getNodeForAllProjects().getText("scrumMaster").isEmpty()))
  			containerforAllProjects+="<td style=\"padding: 10;\">"+h.getNodeForAllProjects().getText("slastName")+", "+h.getNodeForAllProjects().getText("sfirstName")+" "+h.getNodeForAllProjects().getText("smiddleName")+"</td>";
  		else
  			containerforAllProjects+="<td style=\"padding: 10;\">not set</td>";
		if (!(h.getNodeForAllProjects().getText("productOwner").isEmpty()))
			containerforAllProjects+="<td style=\"padding: 10;\">"+h.getNodeForAllProjects().getText("plastName")+", "+h.getNodeForAllProjects().getText("pfirstName")+" "+h.getNodeForAllProjects().getText("pmiddleName")+"</td>";
  		else
  			containerforAllProjects+="<td style=\"padding: 10;\">not set</td>";
  		containerforAllProjects+="<td style=\"padding: 10;\"><a href=\"bada-35?edit="+h.getNodeForAllProjects().getText("projectId")+"\">edit</a></td>";
  			
//  				+"<td>"+h.getNodeForAllProjects().getText("plastName")+"</td>";
		containerforAllProjects+="</tr>";
		
	}
	containerforAllProjects+="</table>";
	
	
	//with parameter sel

%>

<!-- ********** INSERT HTML HERE ********** -->


<%
if (request.getParameter("sel")!=null)
{
	String containerForAllAccounts="";
	String projectName="";
	for(h.getNodeForProjectScrumMaster().first();h.getNodeForProjectScrumMaster().next();)
	{
		if (!(h.getNodeForProjectScrumMaster().getText("username").equals("admin")))
		{
			containerForAllAccounts+="<option value=\""+h.getNodeForProjectScrumMaster().getText("personId")+"\">"
				+h.getNodeForProjectScrumMaster().getText("lastName")+", "+h.getNodeForProjectScrumMaster().getText("firstName")+"</option>";
		}
	}
	String containerforPossiblePO="";
	for(h.getNodeForProjectOwner().first();h.getNodeForProjectOwner().next();)
	{
		projectName=h.getNodeForProjectOwner().getText("projectName");
		containerforPossiblePO+="<option value=\""+h.getNodeForProjectOwner().getText("personId")+"\">"
				+h.getNodeForProjectOwner().getText("plastName")+", "
				+h.getNodeForProjectOwner().getText("pfirstName")+" "
				+h.getNodeForProjectOwner().getText("pmiddleName")+"</option>";
		//out.print(h.getNodeForProjectOwner().getText("pmiddleName"));
	}
	String containerForPositions="";
	for(h.getNodeForPositions().first();h.getNodeForPositions().next();)
	{// POSITIONS
		containerForPositions+="<option value=\""+h.getNodeForPositions().getText("positionId")+"\">"+h.getNodeForPositions().getText("name")+"</option>";
	}
	String containerforAccountsAssociatedForThisProject = "";
	for(h.getNodeForSelProject().first();h.getNodeForSelProject().next();)
	{
	containerforAccountsAssociatedForThisProject="<table width=100% >";
	containerforAccountsAssociatedForThisProject+="<tr><td width=20% >Scrum Master :</td>";
	if ((h.getNodeForSelProject().getText("slastName").isEmpty())==false)
		containerforAccountsAssociatedForThisProject+="<td>"+h.getNodeForSelProject().getText("slastName")+", "+h.getNodeForSelProject().getText("sfirstName")+" "+h.getNodeForSelProject().getText("smiddleName")+"</td></tr>";
	else
		containerforAccountsAssociatedForThisProject+="<td>Not set</td></tr>";
	containerforAccountsAssociatedForThisProject+="<tr><td>Product Owner:</td>";
	if ((h.getNodeForSelProject().getText("plastName").isEmpty())==false)
		containerforAccountsAssociatedForThisProject+="<td>"+h.getNodeForSelProject().getText("plastName")+", "+h.getNodeForSelProject().getText("pfirstName")+" "+h.getNodeForSelProject().getText("pmiddleName")+"</td></tr>";
	else
		containerforAccountsAssociatedForThisProject+="<td>Not set</td></tr>";
	
	}
	//out.print(h.getNodeForProjectMembers());
	for (h.getNodeForProjectMembers().first();h.getNodeForProjectMembers().next();)
	{
		containerforAccountsAssociatedForThisProject+="<tr><td><a rel=\""+h.getNodeForProjectMembers().getText("personProjectId")+"\" onClick='removeMember(this)'>(x)</a>"
	+h.getNodeForProjectMembers().getText("positionName")+":</td><td>"
	+h.getNodeForProjectMembers().getText("lastName")+", "
		+h.getNodeForProjectMembers().getText("firstName")+" "
			+h.getNodeForProjectMembers().getText("middleName")+"</td></tr>";
	}
	containerforAccountsAssociatedForThisProject+="</table>";
	
	out.print("<h1>Set  "+ projectName+"</h1><hr>");
	out.print(containerforAccountsAssociatedForThisProject);
	out.print("<hr>");
	out.print("<table class=myTable width=100% ><tr align=center><td class=myHeader><form method=\"post\">"
	+"<input type=hidden id=projectId name=projectId value="+request.getParameter("sel")+">"
	+"<input type=hidden name=op value=widgets_bada.showProjectWidget.projectHandler>");
	out.print("<b>Select Scrum Master: <select id=scrumMaster name=scrumMaster>"+containerForAllAccounts+"</select>");
	out.print("<br>");
	out.print("<b>Select Project Owner: <select id=projectOwner name=projectOwner>"+containerforPossiblePO+"</select>");
	out.print("<button type=button id='btnSetSP'>Set</button>");
	out.print("</form>");
	
	String containerForAddMember="<form method=\"post\">"
		+"<input type=hidden id=projectId2 name=projectId value="+request.getParameter("sel")+">"
		+"<input type=hidden name=op value=widgets_bada.showProjectWidget.projectHandler>";
	containerForAddMember+="<b>Select Member:</b> <select id=members name=members >"+containerForAllAccounts+"</select><br>";
	containerForAddMember+="<b>With the Position:</b><select id=positions name=positions >"+containerForPositions+"</select>";
	containerForAddMember+="<button type='button' id=btnAdd>Add</button></form>";
	out.print("</td><td class=myHeader> "+containerForAddMember+" </td></tr></table>");
	
	//out.print(h.getNodeForProjectOwner().getText("personId"));
	//out.print(h.getNodeForProjectOwner().getCurrentNode().getNodeName());
}
else
{
	out.print(containerforAllProjects);
}


%>

</div>

<!--END-->
</body>
</html>
