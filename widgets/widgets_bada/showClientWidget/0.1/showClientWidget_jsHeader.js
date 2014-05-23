var showClientWidget = function() {
	return {
		init: function() {
			jQuery("#btn-addClient").live("click", function() {
				jClientAll = $("#clientAll").val();
				jContactClient = $("#contactClient").val();
				jQuery.ajax({
					url: "",
					data: {
						op: "widgets_bada.showClientWidget.contactClientHandler",
						clientAll:jClientAll,
						contactClient:jContactClient
					},
					success: function(data) {
						console.log(data);
						if (data == 'false') {
							alert("client was connected to contact successfully.!")
							window.location.reload(true);
						} else {
							alert("Client already selected!");
						}
					}
				});
			});
			
		}
	};
}();

jQuery(showClientWidget.init());
