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
<%--
<%@page import="tooltwist.bada.productionHelpers.HeaderWidgetProductionHelper"%>
--%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
//	HeaderWidgetProductionHelper h = (HeaderWidgetProductionHelper) helper;
//	XData data = h.getData(jh);
%>
<%
if (session.getAttribute("isLogin")!=null)
{
	
}
else
{
	%>
		<script>window.location.href = "bada-28";</script>
	<%
}


%>
<script>
function myFunction()
{
   location.reload();
}

</script>
<!-- ********** INSERT HTML HERE ********** -->
  <!-- Header
      ================================================== -->
      <header class="container">

         <hgroup>
            <h1><a href="#">SCRUM Online</a></h1>
            <h3>Savouring Agility</h3>
         </hgroup>
         <div align="right"><a href="?logout=1" onclick="myFunction()">logout</a></div>
 </header>

<!--END-->
</body>
</html>
