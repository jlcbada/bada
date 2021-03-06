package tooltwist.bada.widgets;

import tooltwist.wbd.CodeInserter;
import tooltwist.wbd.CodeInserterList;
import tooltwist.wbd.JavascriptCodeInserter;
import tooltwist.wbd.PageImportCodeInserter;
import tooltwist.wbd.SnippetParam;
import tooltwist.wbd.StylesheetCodeInserter;
import tooltwist.wbd.WbdException;
import tooltwist.wbd.WbdGenerator;
import tooltwist.wbd.WbdGenerator.GenerationMode;
import tooltwist.wbd.WbdNavPointProperty;
import tooltwist.wbd.WbdRadioTextProperty;
import tooltwist.wbd.WbdRenderHelper;
import tooltwist.wbd.WbdSizeInfo;
import tooltwist.wbd.WbdStringProperty;
import tooltwist.wbd.WbdWidget;
import tooltwist.wbd.WbdWidgetController;
import tooltwist.wbd.WbdProductionHelper;
//import tooltwist.bada.productionHelpers.GoogleMapsProductionHelper;
import com.dinaa.ui.UimData;
import com.dinaa.ui.UimHelper;

/**
 * Google Maps Widget
 */
public class GoogleMapsWidget extends WbdWidgetController
{
	private static final String SNIPPET_PREVIEW = "googleMaps_preview.html";
	private static final String SNIPPET_DESIGN = "googleMaps_design.html";
	private static final String SNIPPET_PRODUCTION = "googleMaps_production.jsp";
	private static final boolean USE_PRODUCTION_HELPER = false;

	@Override
	protected void init(WbdWidget instance) throws WbdException
	{
		instance.defineProperty(new WbdStringProperty("elementId", null, "Id", ""));
		//instance.defineProperty(new WbdStringProperty("longitude", null, "Set Longitude", "-0.120850"));
		//instance.defineProperty(new Wbd("navpoint", null, "Navpoint", "")); 
		instance.defineProperty(new WbdRadioTextProperty("mapType", null, "Map Type", "HYBRID, ROADMAP, SATELLITE, TERRAIN", "ROADMAP"));
		instance.defineProperty(new WbdStringProperty("latlong", null, "Lat&&Long (separate by pipe if Multiple)", "51.508742&&-0.120850"));
		instance.defineProperty(new WbdStringProperty("mapWidth", null, "Widths", "500"));
		instance.defineProperty(new WbdStringProperty("mapHeight", null, "Height", "380"));
		instance.defineProperty(new WbdStringProperty("mapZoom", null, "Zoom Range (0-19)", "5"));
	}
	
	@Override
	public void getCodeInserters(WbdGenerator generator, WbdWidget instance, UimData ud, CodeInserterList codeInserterList) throws WbdException
	{
//TODO: Uncomment this as required
		GenerationMode mode = generator.getMode();
		if (mode == GenerationMode.DESIGN)
		{
			// Add code inserters for design mode
			CodeInserter[] arr = {

//				// Include a CSS snippet
//				new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "googleMaps_cssHeader.css")),
			};
			codeInserterList.add(arr);
		}
		else if (mode == GenerationMode.PREVIEW)
		{
			// Add code inserters for preview mode
			CodeInserter[] arr = {
//				// Link to an external Javascript file
//				new JavascriptLinkInserter(jsUrl),

//				// Link to an external stylesheet
//				new StylesheetLinkInserter(cssUrl),

//				// Include a javascript snippet 
//				new JavascriptCodeInserter(instance.miscellaneousFilePath(generator, "googleMaps_jsHeader.js")),

//				// Include a CSS snippet
//				new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "googleMaps_cssHeader.css")),
			};
			codeInserterList.add(arr);
		}
		else if (mode == GenerationMode.PRODUCTION || generator.getMode() == GenerationMode.CONTROLLER)
		{
			// Add code inserters for production mode
			CodeInserter[] arr = {
//				// Link to an external Javascript file
//				new JavascriptLinkInserter(jsUrl),
					
//				// Link to an external stylesheet
//				new StylesheetLinkInserter(cssUrl),
					
//				// Include a javascript snippet 
//				new JavascriptCodeInserter(instance.miscellaneousFilePath(generator, "googleMaps_jsHeader.js")),
					
//				// Include a CSS snippet
//				new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "googleMaps_cssHeader.css")),

//				// Add import statements to the JSP
//				new PageImportCodeInserter(XData.class.getName()),
			};
			codeInserterList.add(arr);

			if (USE_PRODUCTION_HELPER)
			{
				SnippetParam[] productionHelperParams = null;
//				codeInserterList.add(WbdProductionHelper.codeInserter(instance, GoogleMapsProductionHelper.class.getName(), productionHelperParams));
//				codeInserterList.add(new PageImportCodeInserter(GoogleMapsProductionHelper.class.getName()));
			}
		}

	}
	
	@Override
	public String getLabel(WbdWidget instance) throws WbdException
	{
		return "Google Maps Widget";
	}
	
	@Override
	public WbdSizeInfo getSizeInfo(WbdGenerator generator, WbdWidget instance) throws WbdException
	{
		return WbdSizeInfo.unknownSizeInfo();
	}
	
	@Override
	public void renderForPreview(WbdGenerator generator, WbdWidget instance, UimData ud, WbdRenderHelper rh) throws WbdException
	{
		rh.renderSnippetForStaticPage(generator, instance, SNIPPET_PREVIEW, getSnippetParams(generator, instance, ud));
	}
	
	@Override
	public void renderForDesigner(WbdGenerator generator, WbdWidget instance, UimData ud, WbdRenderHelper rh) throws WbdException
	{
		rh.renderSnippetForStaticPage(generator, instance, SNIPPET_DESIGN, getSnippetParams(generator, instance, ud));
	}
	
	@Override
	public void renderForJSP(WbdGenerator generator, WbdWidget instance, UimHelper ud, WbdRenderHelper rh) throws Exception
	{
		rh.beforeProductionCode(generator, instance, getSnippetParams(generator, instance, ud), USE_PRODUCTION_HELPER);
		rh.renderSnippetForProduction(generator, instance, SNIPPET_PRODUCTION);
		rh.afterProductionCode(generator, instance);
	}
	
	private SnippetParam[] getSnippetParams(WbdGenerator generator, WbdWidget instance, UimData ud) throws WbdException {
//		String myProperty = instance.getProperty("myProperty", null);
//		String myNavpoint = instance.getProperty("myNavpoint", null);
		String myWidth = instance.getProperty("mapWidth", null);
		String myHeight = instance.getProperty("mapHeight", null);
		//String myLongitude = instance.getProperty("longitude",null);
		String myLatLong = instance.getProperty("latlong", null);
		String myMapType = instance.getProperty("mapType",null);
		String myMapZoom = instance.getProperty("mapZoom", null);
		SnippetParam[] params = {
//			new SnippetParam("myProperty", myProperty),
//			new SnippetParam("myNavpoint", myNavpoint)
				new SnippetParam("myWidth",myWidth),
				new SnippetParam("myHeight",myHeight),
				new SnippetParam("myLatLong",myLatLong),
				//new SnippetParam("myLat",myLatitude),
				new SnippetParam("myMapType",myMapType),
				new SnippetParam("myMapZoom",myMapZoom) 
				
		};
		return params;
	}
}
