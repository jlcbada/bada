var showClientWidget = function() {
	return {
		init: function() {
			jQuery("#btn-addClient").live("click", function() {
				if($("form")[0].checkValidity()) {
					var jMyId=$("#txtMyId").val();
					var jNextNav= $("#nextNav").val();
					var jTxtClientName = $("#txtClientName").val();
					var jTxtClientEmail = $("#txtClientEmail").val();
					var jTxtClientWebsite = $("#txtClientWebsite").val();
					var jTxtClientAddress = $("#txtClientAddress").val();
					var jClientDesc = $("#clientDesc").val();
					jQuery.ajax({
						url: "",
						data: {
							op: "widgets_bada.addClientWidget.addClientHandler",
							txtMyId:jMyId,
							txtClientName:jTxtClientName,
							txtClientEmail:jTxtClientEmail,
							txtClientWebsite:jTxtClientWebsite,
							txtClientAddress:jTxtClientAddress,
							clientDesc:jClientDesc
						},
						
						success: function(data) {
							console.log(data);
						
								alert(data);
								window.location.href=jNextNav;
							
							
						}
					});
				}
				else
					{
					alert("Please fill up the form properly.");
					}
			});
			
		}
	};
}();

jQuery(showClientWidget.init());
