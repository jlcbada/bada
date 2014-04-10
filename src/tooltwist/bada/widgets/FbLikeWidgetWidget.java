package tooltwist.bada.widgets;

import tooltwist.wbd.CodeInserter;
import tooltwist.wbd.CodeInserterList;
import tooltwist.wbd.JavascriptCodeInserter;
import tooltwist.wbd.PageImportCodeInserter;
import tooltwist.wbd.SnippetParam;
import tooltwist.wbd.StylesheetCodeInserter;
import tooltwist.wbd.WbdException;
import tooltwist.wbd.WbdGenerator;
import tooltwist.wbd.WbdRadioTextProperty;
import tooltwist.wbd.WbdGenerator.GenerationMode;
import tooltwist.wbd.WbdNavPointProperty;
import tooltwist.wbd.WbdRenderHelper;
import tooltwist.wbd.WbdSizeInfo;
import tooltwist.wbd.WbdStringProperty;
import tooltwist.wbd.WbdWidget;
import tooltwist.wbd.WbdWidgetController;
import tooltwist.wbd.WbdProductionHelper;
//import tooltwist.bada.productionHelpers.FbLikeWidgetProductionHelper;
import com.dinaa.ui.UimData;
import com.dinaa.ui.UimHelper;

/**
 * Facebook Like Widget
 */
public class FbLikeWidgetWidget extends WbdWidgetController
{
	private static final String SNIPPET_PREVIEW = "fbLikeWidget_preview.html";
	private static final String SNIPPET_DESIGN = "fbLikeWidget_design.html";
	private static final String SNIPPET_PRODUCTION = "fbLikeWidget_production.jsp";
	private static final boolean USE_PRODUCTION_HELPER = false;

	@Override
	protected void init(WbdWidget instance) throws WbdException
	{
		instance.defineProperty(new WbdStringProperty("elementId", null, "Id", ""));
		instance.defineProperty(new WbdRadioTextProperty("colorScheme", null, "Set Color Scheme", "light, dark", "light"));
		instance.defineProperty(new WbdRadioTextProperty("showFaces", null, "Show Friends that like the page", "true, false", "true"));
		instance.defineProperty(new WbdRadioTextProperty("showHeader", null, "Show Header", "true, false", "true"));
		instance.defineProperty(new WbdRadioTextProperty("showStream", null, "Show Stream", "true, false", "true"));
		instance.defineProperty(new WbdRadioTextProperty("showBorder", null, "Show Border", "true, false", "true"));
		instance.defineProperty(new WbdStringProperty("appId", null, "Set App ID", "372811379530508"));
		instance.defineProperty(new WbdStringProperty("width", null, "Set Width", "40%"));
		instance.defineProperty(new WbdStringProperty("height", null, "Set Height", "505"));
		instance.defineProperty(new WbdStringProperty("page", null, "Set Page", "losangeleslakers"));
	//	instance.defineProperty(new WbdRadioTextProperty("shareStyle", null, "Set Share Style", "true, false", "true"));
//		instance.defineProperty(new WbdStringProperty("myProperty", null, "My Property", ""));
//		instance.defineProperty(new WbdNavPointProperty("navpoint", null, "Navpoint", ""));
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
//				new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "fbLikeWidget_cssHeader.css")),
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
//				new JavascriptCodeInserter(instance.miscellaneousFilePath(generator, "fbLikeWidget_jsHeader.js")),

//				// Include a CSS snippet
//				new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "fbLikeWidget_cssHeader.css")),
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
//				new JavascriptCodeInserter(instance.miscellaneousFilePath(generator, "fbLikeWidget_jsHeader.js")),
					
//				// Include a CSS snippet
//				new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "fbLikeWidget_cssHeader.css")),

//				// Add import statements to the JSP
//				new PageImportCodeInserter(XData.class.getName()),
			};
			codeInserterList.add(arr);

			if (USE_PRODUCTION_HELPER)
			{
				SnippetParam[] productionHelperParams = null;
//				codeInserterList.add(WbdProductionHelper.codeInserter(instance, FbLikeWidgetProductionHelper.class.getName(), productionHelperParams));
//				codeInserterList.add(new PageImportCodeInserter(FbLikeWidgetProductionHelper.class.getName()));
			}
		}

	}
	
	@Override
	public String getLabel(WbdWidget instance) throws WbdException
	{
		return "Facebook Like Widget";
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

		String myColorScheme= instance.getProperty("colorScheme", null);
		String myShowFaces= instance.getProperty("showFaces", null);
		String myShowHeader= instance.getProperty("showHeader", null);
		String myShowStream= instance.getProperty("showStream", null);
		String myShowBorder= instance.getProperty("showBorder", null);
		String myAppId= instance.getProperty("appId", null);
		String myWidth= instance.getProperty("width", null);
		String myHeight= instance.getProperty("height", null);
		String myPage= instance.getProperty("page", null);
		//String myShare= instance.getProperty("shareStyle", null);
		SnippetParam[] params = {
//			new SnippetParam("myProperty", myProperty),
//			new SnippetParam("myNavpoint", myNavpoint)
			new SnippetParam("myColorScheme", myColorScheme),
			new SnippetParam("myShowFaces", myShowFaces),
			new SnippetParam("myShowHeader", myShowHeader),
			new SnippetParam("myShowStream", myShowStream),
			new SnippetParam("myShowBorder", myShowBorder),
			//new SnippetParam("myShareStyles", myShare),
			new SnippetParam("myAppId", myAppId),
			new SnippetParam("myWidth", myWidth),
			new SnippetParam("myHeight", myHeight),
			new SnippetParam("myPage", myPage)
			
		};
		return params;
	}
}
