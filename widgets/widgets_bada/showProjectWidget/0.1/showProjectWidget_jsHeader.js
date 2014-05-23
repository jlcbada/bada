var showClientWidget = function() {
	return {
		init: function() {
			jQuery("#btnSetSP").live("click", function() {
				jQuery.ajax({
					url: "",
					data: {
						op: "widgets_bada.showProjectWidget.projectHandler",
						projectId:$("#projectId").val(),
						scrumMaster:$("#scrumMaster").val(),
						projectOwner:$("#projectOwner").val()
					},
					success: function(data) {	
						console.log(data);
						alert(data);
						location.reload();
					},
					error:function(){
						alert("Error setting Scrum Master and Product Owner");
					}
				});
			});

			jQuery("#btnAdd").live("click", function() {
				jQuery.ajax({
					url: "",
					data: {
						op: "widgets_bada.showProjectWidget.projectHandler",
						projectId:$("#projectId2").val(),
						members:$("#members").val(),
						positions:$("#positions").val()
					},
					success: function(data) {	
						console.log(data);
						alert(data);
						location.reload();
					},
					error:function(){
						console.log(data);
						alert("Error Adding new Member");
					}
				});
			});
			jQuery("#btnAdd").live("click", function() {
				jQuery.ajax({
					url: "",
					data: {
						op: "widgets_bada.showProjectWidget.projectHandler",
						projectId:$("#projectId2").val(),
						members:$("#members").val(),
						positions:$("#positions").val()
					},
					done: function(data) {	
						console.log(data);
						alert(data);
						location.reload();
					},
					error:function(){
						alert("Error Adding new Member");
					}
				});
			});
		
		}
	};
}();

function removeMember(myElement){
//	alert($(myElement).attr('rel'));
	jQuery.ajax({
		url: "",
		data: {
			op: "widgets_bada.showProjectWidget.projectHandler",
			rem:$(myElement).attr('rel')
		},
		success: function(data) {	
			console.log(data);
			alert(data);
			location.reload();
		},
		error:function(){
//			console.log(data);
			alert("Error removing Member to Project");
		}
	});
}

jQuery(showClientWidget.init());
