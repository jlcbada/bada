
var DynamicTab = function() {
	return {
		myVariable: null,

		init: function() {
			$('#cssmenu').prepend('<div id="bg-one"></div><div id="bg-two"></div><div id="bg-three"></div><div id="bg-four"></div>');
		},
		
		myMethod: function() {
			alert("DynamicTab.myMethod()");
		}
		// no comma after last method
	};
}();

jQuery(DynamicTab.init()); // Run after page loads