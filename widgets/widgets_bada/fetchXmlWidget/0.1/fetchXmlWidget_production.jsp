


<html>
<head>
<title></title>
<style>
td{
   max-width:10px
}
</style>

</head>
<body>
<%
	WbdProductionHelper helper = null;
	JspHelper jh = null;
	String snippetVar_myProperty;
	String snippetVar_thisNavpoint;
%>
<!--START-->
<%@page import="org.w3c.dom.Node"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.bada.productionHelpers.FetchXmlWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%@page import="com.dinaa.data.XNodes"%>
<%
	// Get the production helper for this widget
	FetchXmlWidgetProductionHelper h = (FetchXmlWidgetProductionHelper) helper;
	XData data = h.getData(jh);
	XNodes responseBody =h.getMyResponse();
	String temp=" ";
	//int ctr=0;
	String node_id="asd";
	
		//ctr++;
	
				//temp += str.getTextContent();
				//temp += str.getAttribute("name") + "|| id   ";
				

				
			
		//XNodes arrNodes = responseBody.getNodes("arr");
	%> <table border=1 style="table-layout:fixed;"><%	
	
			for(responseBody.first();responseBody.next();)
			{
				/*
				out.print("<tr>");
				XNodes innerNodes = responseBody.getNodes("*");
				for(int i=0;i<innerNodes.getNumNodes();i++)
				{
					Node myNode=innerNodes.getNode(i);
					//if(myNode.getChildNodes().getLength()==1)
					{
						out.print("<td>"+myNode.getAttributes().item(0).getNodeValue()+"</td>");
					}
				}
				*/
				
				if(responseBody.getCurrentNode().hasChildNodes())
				{
					XNodes innerNodes = responseBody.getNodes("*");
					for(int i=0;i<innerNodes.getNumNodes();i++)
					{
						Node myNode=innerNodes.getNode(i);
						if(myNode.getChildNodes().getLength()==1)
						{
							out.print("<tr><td>"+myNode.getAttributes().item(0).getNodeValue()
									+"</td><td>"+myNode.getTextContent().toString()+"</td></tr>");
						}
						else
						{
							
							String  insertHtml = "<tr><td rowspan="+myNode.getChildNodes().getLength()+">"+myNode.getAttributes().item(0).getNodeValue() +"</td>";
							for(int j=0;j<myNode.getChildNodes().getLength();j++)
							{
								String myInnerNode = myNode.getChildNodes().item(j).getTextContent();
								insertHtml +="<td>"+myInnerNode+"</td></tr>";
							}
							out.print(insertHtml);
						}
					}
				}
				
				out.print("</tr>");
			}
				
	
	
	/*
for(responseBody.first();responseBody.next();)
{
	if(responseBody.getCurrentNode().hasChildNodes())
	{
		XNodes innerNodes = responseBody.getNodes("*");
		for(int i=0;i<innerNodes.getNumNodes();i++)
		{
			Node myNode=innerNodes.getNode(i);
			if(myNode.getChildNodes().getLength()==1)
			{
				out.print("<tr><td>"+myNode.getAttributes().item(0).getNodeValue()
						+"</td><td>"+myNode.getTextContent().toString()+"</td></tr>");
			}
			else
			{
				String  insertHtml = "<tr><td rowspan="+myNode.getChildNodes().getLength()+">"+myNode.getAttributes().item(0).getNodeValue() +"</td>";
				for(int j=0;j<myNode.getChildNodes().getLength();j++)
				{
					String myInnerNode = myNode.getChildNodes().item(j).getTextContent();
					insertHtml +="<td>"+myInnerNode+"</td></tr>";
				}
				out.print(insertHtml);
			}
		}
	}
}
	
	*/

	/*
	Element myElement = (Element) responseBody.getCurrentNode();
	out.print(myElement.+"<br>");
	*/
	
	
// 	XNodes strNodes = responseBody.getNodes("str");
// 	for(strNodes.first();strNodes.next();)
// 	{
// 		Element str = (Element)strNodes.getCurrentNode();
// 		if(str.getAttribute("name").equals("id")) out.print( "<tr><td>ID</td><td>"+str.getTextContent()+ "</td></tr>"); 
// 		if(str.getAttribute("name").equals("name")) out.print( "<tr><td>Name</td><td>"+str.getTextContent()+ "</td></tr>"); 
// 		if(str.getAttribute("name").equals("manu")) out.print( "<tr><td>Manu</td><td>"+str.getTextContent()+ "</td></tr>"); 
// 		if(str.getAttribute("name").equals("manu_id_s")) out.print( "<tr><td>manu_id_s</td><td>"+str.getTextContent()+ "</td></tr>"); 
// 		if(str.getAttribute("name").equals("price_c")) out.print( "<tr><td>price_c</td><td>"+str.getTextContent()+ "</td></tr>"); 
		
	
		

%>
</table>
<!--END-->
</body>
</html>

