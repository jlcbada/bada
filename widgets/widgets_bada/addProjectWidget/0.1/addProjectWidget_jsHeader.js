var showClientWidget = function() {
	return {
		init: function() {
			jQuery("#btn-addProject").live("click", function() {
				/*jClientAll = $("#clientAll").val();
				jContactClient = $("#contactClient").val();
				$('td[name=tcol1]')*/
				//--------------Validate dates
				var today = new Date();
				var dd = today.getDate();
				var mm = today.getMonth()+1; //January is 0!
				var yyyy = today.getFullYear();

				if(dd<10) {
				    dd='0'+dd
				} 

				if(mm<10) {
				    mm='0'+mm
				} 

				today = yyyy+'-'+mm+'-'+dd;
				
				//---------------END 
				
				var jProjectId = $('#projectId').val();
				var jNextNav = $('#nextNav').val();
				var jTxtProjectName =  $('#txtProjectName').val();
				var jCmbClient =  $('#cmbClient').val();
				var jTxtProjectDesc = $('#txtProjectDesc').val();
				var jDtpStart =  $('#dtpStart').val();
				var jDtpEnd =   $('#dtpEnd').val();
				if (jDtpStart<today.toString())
				{
					alert("Invalid Start Date");
				}
				else if (jDtpStart>jDtpEnd)
				{
					alert("Invalid End Date");
				}
				else if(jTxtProjectName==""||jTxtProjectDesc==""||jDtpEnd=="")
				{
					alert("Please fill up the form properly");	
				}
				else
				{
					jQuery.ajax({
						url: "",
						data: {
							op: "widgets_bada.addProjectWidget.addProjectHandler",
							projectId:jProjectId,
							txtProjectName:jTxtProjectName,
							cmbClient:jCmbClient,
							txtProjectDesc:jTxtProjectDesc,
							dtpStart:jDtpStart,
							dtpEnd:jDtpEnd
							
							
						},
						success: function(data) {
							console.log(data);
						
								alert(data);
								window.location.href=jNextNav;
							
							
						}
					});
				}
			});
			
			
		}
	};
}();

jQuery(showClientWidget.init());
