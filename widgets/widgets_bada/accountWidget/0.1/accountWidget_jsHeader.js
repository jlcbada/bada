

var showClientWidget = function() {
	return {
		init: function() {
		jQuery("#send_data").live("click", function() {
			if($("form")[0].checkValidity()) 
			{
				var jLastName = $("#lastName").val();	
				console.log(jLastName);
				var jFirstName = $("#firstName").val();
				console.log(jFirstName);
				var jMiddleName = $("#middleName").val();	
				console.log(jMiddleName);
				var jEmail = $("#email").val();	
				console.log(jEmail);
				var jSkypeId = $("#skypeId").val();	
				console.log(jSkypeId);
				var jNextNav = $("#nextNav").val();
				if ($("#myDropdown"))
				{
					var jCmbClient=$("#myDropdown").val();	
					jQuery.ajax({
						url: "",
						data: {
							op: "widgets_bada.accountWidget.accountHandler",
							lastName:jLastName,
							firstName:jFirstName,
							middleName:jMiddleName,
							email:jEmail,
							skypeId:jSkypeId,
							cmbClient:jCmbClient
						},
						success: function(data) {
							console.log(data);
							alert(data);
							window.location.href=jNextNav;
						}
					});
				}
				else if($("#txtpassword"))
				{
					var pass1 = document.getElementById("pass1").value;
					var pass2 = document.getElementById("pass2").value;
					if (pass1!=pass2)
					{
						alert("Passwords dont Match");
					}
					else
					{
						var jTxtUsername = $("#txtusername");	
						var jTxtPassword = $("#pass1")
						jQuery.ajax({
							url: "",
							data: {
								op: "widgets_bada.accountWidget.accountHandler",
								lastName:jLastName,
								firstName:jFirstName,
								middleName:jMiddleName,
								email:jEmail,
								skypeId:jSkypeId,
								txtusername:jTxtUsername,
								txtpassword:jTxtPassword
							},
							success: function(data) {
								console.log(data);
								alert(data);
								window.location.href=jNextNav;
								}
							});
					}
				}
				else
					alert("There is a problem, please contact the Administrator");
		}
		else
		{
			alert("please fill up the form properly");
		}
		});
		}
	};
}();

jQuery(showClientWidget.init());
