var showClientWidget = function() {
	return {
		init: function() {
			jQuery("#btnLogin").live("click", function() {
				jQuery.ajax({
					url: "",
					data: {
						op: "widgets_bada.loginWidget.loginHandler",
						username:$("#username").val(),
						password:$("#password").val()
					},
					success: function(data) {	
						console.log(data);
							if(data=="false"){
								$("div#warningMessage").html("<p style=\"color: red;\" id=\"warning\">Username/Password Invalid</p>");
							}
							else
								 location.reload();
						
					}
				});
			});
			
		}
	};
}();

jQuery(showClientWidget.init());
