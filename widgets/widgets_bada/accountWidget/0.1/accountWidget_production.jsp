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
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.bada.productionHelpers.AccountWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	AccountWidgetProductionHelper h = (AccountWidgetProductionHelper) helper;
	XData data = h.getData(jh);
			int isMember=0;
			String header="";
			String addClientContact = "bada-39";
			String addMember = "bada-37";
			//39 add client
			//37 add member
			if (request.getParameter("edit")!=null)
			{	
				isMember=3;
				if (request.getRequestURI().contains(addMember))
					header="Edit Member";
				else if (request.getRequestURI().contains(addClientContact))
					header="Edit Client Contact";
			}
			else{
			if (request.getRequestURI().contains(addMember))
			{	
				isMember=1;
				header="Add Member";
			}
			else if (request.getRequestURI().contains(addClientContact))
			{	
				isMember=2;
				header="Add  Client Contact";
			}
				
			}
%>

<!-- ********** INSERT HTML HERE ********** -->
 <section id="respond">
<form id="contactform" method="post" action="" name="thisForm">
<h2><%=header %></h2><hr>
<table style="width:70% !important;">

	<tr>
		<td><input type="hidden" id="nextNav" value=" <%=h.getNextNav()%> "></td>
		<td><input type="text" name="personId" value="" disabled><br></td></tr>
	<tr>
		<td>Name </td>
		<td>
			<input type="text" name="lastName" id="lastName" required placeholder="Last Name" value="">
			<input type="text" name="firstName" id="firstName" required placeholder="First Name" value="">
			<input type="text" name="middleName" id="middleName" required placeholder="Middle Name" value="">
		</td>
	</tr>
	<tr>
		<td>Additional</td>
		<td>
			<input type="text" name="email" id="email" required placeholder="email@email.com" value="">
			<input type="text" name="skypeId" id="skypeId" required placeholder="skype ID" value="">
		</td>
	</tr>
	
	<% if(isMember==1)
			{
				%>
				<tr>
					<td>Username</td>
					<td><input type="text" name="txtusername" id="txtusername" required placeholder="Username" value=""></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="txtpassword"  required placeholder="Password" value="" id="pass1"></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="confirmPassword"  required placeholder="Password" value="" id="pass2"></td>
				</tr>
				
				<%		
			}
	else if (isMember==2)	
	{ 	%>
		<tr>
					<td>Employee of</td>
					<td>
						<select name="cmbClient" id="myDropdown"><%
						for(int i=0; i<h.getClients().length;i++)
						{
							String clientId = h.getClients()[i].split("::")[0];
							String clientName = h.getClients()[i].split("::")[1];
							out.print("<option value=\""+clientId+"\">"+clientName+"</option>");
						}
						
						%>
						</select>
					</td>
				</tr>
	
	<%	} %>
<tr>
		<td colspan=2><button type="button" name="send_data"  id="send_data">Add/Update</button></td>
	</tr>
</table>
</form>

</section>
<!--END-->
</body>
</html>
