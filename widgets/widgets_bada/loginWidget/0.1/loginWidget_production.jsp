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
<%@page import="tooltwist.bada.productionHelpers.LoginWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	LoginWidgetProductionHelper h = (LoginWidgetProductionHelper) helper;
	XData data = h.getData(jh);
%>

<%

if(session.getAttribute("isLogin")!=null)
{
	//out.print("<script>alert(\""+session.getAttribute("isLogin")+"\")</script>");
}
else
{
	
}
if(session.getAttribute("isLogin")!=null)
{
	%>
	<script>window.location.href = "bada-42";</script>
	<%
	}


%>


<!-- ********** INSERT HTML HERE ********** -->
 <section class="container">
    <div class="login">
      <h1>SCRUM Online</h1>
      <form method="post">
        <p><input type="text" name="username" value="" placeholder="Username" required id="username"></p>
        <p><input type="password" name="password" value="" placeholder="Password" required id="password"></p>
    	<div id="warningMessage">
   
    	</div>
        <p class="submit"><input type="button" id="btnLogin"  name="commit" value="Login"></p>
      </form>
    </div>

   
  </section>



<!--END-->
</body>
</html>
