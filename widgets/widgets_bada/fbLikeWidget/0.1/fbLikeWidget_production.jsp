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
<%@page import="tooltwist.bada.productionHelpers.FbLikeWidgetProductionHelper"%>
--%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
//	FbLikeWidgetProductionHelper h = (FbLikeWidgetProductionHelper) helper;
//	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_GB/all.js#xfbml=1&appId=%%myAppId%%";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<div class="fb-share-button" data-href="https://facebook.com/%%myPage%%" data-type="box_count"></div><br>
<iframe frameborder=0 style="width:%%myWidth%%;height:%%myHeight%%;"  src="http://www.facebook.com/plugins/likebox.php?
href=https%3A%2F%2Fwww.facebook.com%2F%%myPage%%&
width&height=%%myHeight%%&
colorscheme=%%myColorScheme%%&
show_faces=%%myShowFaces%%&
header=%%myShowHeader%%&
stream=%%myShowStream%%&
show_border=%%myShowBorder%%&
appId=%%myAppId%%"></iframe>


<!--END-->
</body>
</html>
