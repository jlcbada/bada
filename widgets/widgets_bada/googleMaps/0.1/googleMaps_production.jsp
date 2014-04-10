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
<%@page import="tooltwist.bada.productionHelpers.GoogleMapsProductionHelper"%>
--%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
//	GoogleMapsProductionHelper h = (GoogleMapsProductionHelper) helper;
//	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<!DOCTYPE html>
<html>
<head>
<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM&sensor=false">
</script>

<script>

function checkZoomRange(x){
	var DEFAULT_VALUE=5;
	if(x>=0 && x<=19)	 return x;
	else return DEFAULT_VALUE;
}


function initialize(){
	//alert("here");
//alert("%%myLatLong%%");
var locs = "%%myLatLong%%";
	var arLocs = locs.split("|");
	var temp="";
	for(var i=0; i<arLocs.length; i++)
		{
		var arTemp = arLocs[i].split("&&");
		arLocs[i] = ""+i+", "+ arTemp[0]+", "+arTemp[1]+", "+i;
		}
	//alert(arLocs[0]);
	
	var locations = arLocs;
	 				var zoomRange = checkZoomRange(%%myMapZoom%%);
	                var map = new google.maps.Map(document.getElementById('googleMap'), {
	                  zoom: zoomRange,
	                  center: new google.maps.LatLng(-33.92, 151.25),
	                  mapTypeId: google.maps.MapTypeId.ROADMAP
	                });

	                var infowindow = new google.maps.InfoWindow();

	                var marker, i;

	                for (i = 0; i < locations.length; i++) { 
	                	//alert(arLocs[i]);
	                	var x = arLocs[i].split(",");
	                	//alert(x);
	                /*51.508742&&-0.120850*/
	                  marker = new google.maps.Marker({
	                    position: new google.maps.LatLng(x[1], x[2]),
	                    map: map
	                  });
	                  //alert(x[0]);
	                  google.maps.event.addListener(marker, 'click', (function(marker, i) {
	                    return function() {
	                      infowindow.setContent(x[i][0]);
	                      infowindow.open(map, marker);
	                    }
	                  })(marker, i));
	                }
	}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>

<body>
%%myLatLong%%
<div id="googleMap" style="width:%%myWidth%%;height:%%myHeight%%;"></div>

</body>
</html>

<!--END-->
</body>
</html>
