
var PersonMaintenance = function() {
	return {
		myVariable: null,

		init: function() {
			alert("PersonMaintenance.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".PersonMaintenance .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("PersonMaintenance.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(PersonMaintenance.init()); // Run after page loads