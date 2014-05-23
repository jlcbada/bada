

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
<%@page import="tooltwist.wbd.Navpoint"%>
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XNodes"%>
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.bada.productionHelpers.AddProjectWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	AddProjectWidgetProductionHelper h = (AddProjectWidgetProductionHelper) helper;
	XData data = h.getData(jh);

%>

<!-- ********** INSERT HTML HERE ********** -->


<form method="post">
<input type="hidden" value="widgets_bada.addProjectWidget.addProjectHandler" id="name" name="op" required >
<input type="hidden" value="<%=h.getProjectId()%>"  name="projectId" id="projectId" required >
<input type="hidden" value="<%=h.getNextNavPoint() %>"  name="nextNav" id="nextNav" required >
<div>
<label>Project Name <span class="required">*</span></label>
<input type="text" value="<%=h.getProjectName() %>"  name="txtProjectName" id="txtProjectName" required >
</div>
<div>
<label>Project Client <span class="required">*</span></label>
<select name="cmbClient" id=cmbClient>
<%=h.generateOptions() %>
</select>
</div>
<div>
<label>Project Description <span class="required">*</span></label>
<textarea rows="10" cols="90" name="txtProjectDesc" id=txtProjectDesc><%=h.getProjectDesc() %></textarea>
</div>
<div>
<label>Project Start Date <span class="required">*</span></label>
<input type="date" value="<%=h.getStartDate() %>" max="<%= new java.util.Date() %>"  name="dtpStart" id=dtpStart required >
</div>
<div>
<label>Project End Date <span class="required">*</span></label>
<input type="date" value="<%=h.getEndDate() %>" name="dtpEnd" id=dtpEnd required >
</div>
<div>
<button type="button" id="btn-addProject">Add/Save</button>
<input type="reset" class="button" value="Reset">
</div>
</form>
<!--END-->
</body>
</html>
