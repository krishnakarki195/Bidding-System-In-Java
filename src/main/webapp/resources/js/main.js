$(document).ready(function() {
	var baseUrl = "/" + window.location.pathname.split('/')[1];

	$("#username").blur(function(){
		var username = $("#username").val();
		$.ajax({
			url : baseUrl+"/user/validate",
			type : "POST",
			data : {
				username : $('#username').val()
			},
			dataType : "JSON",
			success : function(result) {
				
				if ($.trim(result) == "true") {
					
					$('.username').html('This username is already used!').show();
				} else {
					$('.username').html('This username Works').show();
					//$('#form-registration').submit();
				}
			},
			error : function() {
				alert("eroor")
				alert('Some error occurred!');
			}
		});
		
	});
});