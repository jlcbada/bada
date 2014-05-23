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
<%@page import="tooltwist.bada.productionHelpers.PersonMaintenanceProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	PersonMaintenanceProductionHelper h = (PersonMaintenanceProductionHelper) helper;
	XData data = h.getData(jh);
	
%>

<!-- ********** INSERT HTML HERE ********** -->
<form method="post" action="">
<table>
	<tr>
		<td><input type="hidden" name="op" value="widgets_bada.personMaintenance.update"></td>
		<td><input type="text" name="personId" value="<%=h.getPersonId()%>" disabled><br></td></tr>
	<tr>
		<td>Name </td>
		<td>
			<input type="text" name="lastName" required placeholder="Last Name" value="<%=h.getLastName() %>">
			<input type="text" name="firstName" required placeholder="First Name" value="<%=h.getFirstname() %>">
			<input type="text" name="middleName" required placeholder="Middle Name" value="<%=h.getMiddleName() %>">
		</td>
	</tr>
	<tr>
		<td>Additional</td>
		<td>
			<input type="text" name="email" required placeholder="email@email.com" value="<%=h.getEmail() %>">
			<input type="text" name="skypeId" required placeholder="skype ID" value="<%=h.getSkypeId() %>">
		</td>
	</tr>
	<tr>
		<td colspan=2><button type="submit" name="submit">Add/Update</button></td>
	</tr>

</table>

</form>

<!--END-->
</body>
</html>
