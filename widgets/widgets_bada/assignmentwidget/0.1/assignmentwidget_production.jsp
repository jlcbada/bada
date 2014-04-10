
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
<%@page import="tooltwist.bada.productionHelpers.AssignmentwidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	AssignmentwidgetProductionHelper h = (AssignmentwidgetProductionHelper) helper;
	Navpoint myNavpoint = h.getMyNavpoint();
	Iterable <Navpoint> children = myNavpoint.getChildren();
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->


<!--  has-sub, active, last  -->
<div id='cssmenu'>
<ul>

<% for (Navpoint nav:children) {
	String myActive=" ";
	if (h.getMyCurrentNavpoint().equals(nav.getId())) 
		{
		myActive = " active "; 
		}	
	
 	if (nav.hasChildren(true)) { 
 		Iterable <Navpoint> grandChildren = nav.getChildren(); 
 		int ctr=0;
 		for(Navpoint check:grandChildren)
 		{
 			if (h.getMyCurrentNavpoint().equals(check.getId())) 
 				ctr++;
 		}
 		if(ctr>0)
 		{
 			myActive= " active "; 
 		}
 		
 		%>
		<li class="<%=myActive %>has-sub"><a href='<%= nav.getId() %>'><span><%= nav.getLabel() %></span></a>
			<ul>
			<% 
			for (Navpoint innerNav:grandChildren){ 
					%> 
							<li><a href='<%=innerNav.getId() %>'><span> <%=innerNav.getLabel() %></span></a></li>				
			<%}	%>
					</ul>
				</li> 
		<% 	}
					else { %> 
   					<li class="<%=myActive %>"><a href='<%=nav.getId() %>'><span><%=nav.getLabel() %></span></a></li>
   <%  		}
		   } %> 
</ul>
</div>
<!-- 
<div id='cssmenu'>
<ul>
   <li class='active'><a href='#'><span>Home</span></a></li>
   <li class='has-sub'><a href='#'><span>Products</span></a>
      <ul>
         <li class='has-sub'><a href='#'><span>Product 1</span></a>
            <ul>
               <li><a href='#'><span>Sub Item</span></a></li>
               <li class='last'><a href='#'><span>Sub Item</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Product 2</span></a>
            <ul>
               <li><a href='#'><span>Sub Item</span></a></li>
               <li class='last'><a href='#'><span>Sub Item</span></a></li>
            </ul>
         </li>
      </ul>
   </li>
   <li><a href='#'><span>About</span></a></li>
   <li class='last'><a href='#'><span>Contact</span></a></li>
</ul>
</div>
 -->

<!--END-->
</body>
</html>
