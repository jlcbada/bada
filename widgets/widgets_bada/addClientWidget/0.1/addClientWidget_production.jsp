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
<%@page import="tooltwist.bada.productionHelpers.AddClientWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	AddClientWidgetProductionHelper h = (AddClientWidgetProductionHelper) helper;
	XData data = h.getData(jh);
	String myHeader = "Add Client"	;
	String myCaption = "Client Registration";
	//out.print(!request.getParameter("clientId").equals(null)+"");
	if(request.getParameter("clientId")!=null)
	{
		myHeader ="Edit Client";
		myCaption = "Client Information";
	}
	
%>

<!-- ********** INSERT HTML HERE ********** -->
 <section id="respond">

               <h3><%=myHeader%></h3>

               <form id="contactform" method="post">
					
                    <div>
                    <p><%=myCaption %></p>
                    </div>
					
					<div>
                    
                    <input type="hidden" value="<%=h.getClientId() %>" id="txtMyId" name="txtMyId" required  disabled>
                    <input type="hidden" value="<%=h.getNexNav() %>" id="nextNav" required name="nextNav" disabled>
                    </div>
                    <div>
                    <label>Client/Company Name <span class="required">*</span></label>
                    <input type="text" value="<%=h.getClientName() %>" id="txtClientName" name="txtClientName" required >
                    </div>

                    <div>
                    <label>Client Email <span class="required">*</span></label>
                    <input type="email" value="<%=h.getClientEmail() %>" id="txtClientEmail" name="txtClientEmail" required>
                    </div>

                    <div>
                    <label>Client Website</label>
                    <input type="text" value="<%=h.getClientWebsite() %>" id="txtClientWebsite" name="txtClientWebsite" required>
                    </div>

                    <div>
                    <label>Client Address</label>
                    <input type="text" value="<%=h.getClientAddress() %>" id="txtClientAddress" name="txtClientAddress" required>
                    </div>

                    <div>
                    <label>Brief Description <span class="required" >*</span></label>
                    <textarea id="clientDesc" cols="50" rows="20" name="clientDesc" ><%=h.getClientDesc() %></textarea>
                    </div>

                    <div>
					         <input type="button" class="button" id="btn-addClient" value="Add/Save">
         			      <input type="reset" class="button" value="Reset">
					      </div>

                </form>

            </section>


         <!-- end main -->

<!--END-->
</body>
</html>
