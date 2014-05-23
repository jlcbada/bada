


<%@page import="com.dinaa.ui.UimHelper"%>
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
<%@page import="tooltwist.wbd.WbdRequestHandler"%>
<%@page import="com.dinaa.ui.UimData"%>
<%@page import="tooltwist.wbd.Navpoint"%>
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.bada.productionHelpers.MyNewVerticalMenuWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%@page import ="tooltwist.bada.requestHandlers.logHandlers" %>
<%
	// Get the production helper for this widget
	MyNewVerticalMenuWidgetProductionHelper h = (MyNewVerticalMenuWidgetProductionHelper) helper;
	XData data = h.getData(jh);
	Navpoint myNavpoint = h.getMyNavpoint();
	Iterable <Navpoint> children = myNavpoint.getChildren();
if (request.getParameter("logout")!=null)
{
	logHandlers log = new logHandlers();
	log.myHandler(h.getUd().getXpc(), session.getAttribute("isLogin").toString(), "Account Logged out");
	session.setAttribute("isLogin", null);
}
if (session.getAttribute("isLogin")==null)
{
	%>
	<script>windows.location.href="bada-28"</script>
	<%
}


%>

<!-- ********** INSERT HTML HERE ********** -->
<div id='cssmenu' class='grid3 add-margin-top'>
<ul>

<% for (Navpoint nav:children) {
	String myActive="";
	if (h.getMyCurrentNavpoint().equals(nav.getId())) 
		{
		myActive = "active "; 
		}	
	
 	if (nav.hasChildren(true)) { 
 		//out.print("<script>alert(\"goes here\")</script>");
 		Iterable <Navpoint> grandChildren = nav.getChildren(); 
 		int ctr=0;
 		for(Navpoint check:grandChildren)
 		{
 			if (h.getMyCurrentNavpoint().equals(check.getId())) 
 				ctr++;
 		}
 		if(ctr>0)
 		{
 			myActive= "active "; 
 		}
 		
 		%>
		<li class="<%=myActive %>has-sub"><a href='<%= nav.getId() %>'><span><%= nav.getLabel() %></span></a>
			<ul>
			<% 
			for (Navpoint innerNav:grandChildren){ 
				if (innerNav.hasChildren(true)) { 
			 		//out.print("<script>alert(\"goes here\")</script>");
			 		Iterable <Navpoint> grandGrandChildren = innerNav.getChildren(); 
			 		int ctr2=0;
			 		/*
			 		for(Navpoint check:grandGrandChildren)
			 		{
			 			if (h.getMyCurrentNavpoint().equals(check.getId())) 
			 				ctr++;
			 		}
			 		if(ctr>0)
			 		{
			 			myActive= "active "; 
			 		}
			 		*/
			 		%>
					<li class="<%=myActive %>has-sub"><a href='<%= innerNav.getId() %>'><span><%= innerNav.getLabel() %></span></a>
						<ul>
						<% 
						for (Navpoint moreInnerNav:grandGrandChildren){ 
								%> 
										<li><a href='<%=moreInnerNav.getId() %>'><span> <%=moreInnerNav.getLabel() %></span></a></li>				
						<%}	%>
								</ul>
							</li> 
			<% }
				else { 
					//out.print("<script>alert(\"goes here2\")</script>");
				%> 
					<li class="<%=myActive %>"><a href='<%=innerNav.getId() %>'><span><%=innerNav.getLabel() %></span></a></li>
<%  		}
			
			
			}	%>
					</ul>
				</li> 
<% }
					else { 
						//out.print("<script>alert(\"goes here2\")</script>");
					%> 
   					<li class="<%=myActive %>"><a href='<%=nav.getId() %>'><span><%=nav.getLabel() %></span></a></li>
   <%  		}
		   } %> 
</ul>
</div>


<!--END-->
</body>
</html>
