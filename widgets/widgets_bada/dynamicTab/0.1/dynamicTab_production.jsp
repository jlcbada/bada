
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
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.bada.productionHelpers.DynamicTabProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	DynamicTabProductionHelper h = (DynamicTabProductionHelper) helper;
	XData data = h.getData(jh);
	Navpoint myNavpoint = h.getMyTab();
	Iterable <Navpoint> children = myNavpoint.getChildren();
%>

<!-- ********** INSERT HTML HERE ********** -->
<div id='cssmenu'>
<ul>
<% for (Navpoint nav:children) { 
		String clazz = "";
		if (h.getCurrentNavpoint().equals(nav.getId()))
		clazz="class=\"active\"";
%>
   <li <%=clazz %>><a href="<%=nav.getId() %>"><span><%=nav.getLabel() %></span></a></li>
   <%} %>
</ul>
</div>

<!-- 
<div id='cssmenu'>
<ul>
   <li class='active'><a href='index.html'><span>Home</span></a></li>
   <li><a href='#'><span>Products</span></a></li>
   <li><a href='#'><span>About</span></a></li>
   <li class='last'><a href='#'><span>Contact</span></a></li>
</ul>
</div>
 -->
<!--END-->
</body>
</html>
