
var ShowMemberWidgets_[[widgetId]] = function() {
	return {
		myVariable: null,

		init: function() {
			alert("ShowMemberWidgets_[[widgetId]].init");
			
//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".ShowMemberWidgets .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("ShowMemberWidgets.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(ShowMemberWidgets_[[widgetId]].init()); // Run after page loads