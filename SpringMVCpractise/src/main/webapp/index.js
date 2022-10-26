$(document).ready(function() {
	console.log("Docuemnt Loaded")
	$('#reg-form').on('submit', function(event) {
		event.preventDefault();
		console.log("submit button clicked")
		/*var formData = $(this).serialize();
		console.log(formData);*/
		
		var formData={
			email:$('#useremail').val(),
			name:$('#username').val(),
			password:$('#userpassword').val()
		}
		
		$.ajax({
			type:'POST',
			contentType : 'application/json; charset=utf-8',
			 dataType : 'json',
			url:'register',  
			 data:JSON.stringify(formData),
			success: function(response){
				/*if(response.trim()=='successfull'){
				console.log("seuccfully Response is " +response)
				}
				else{
					console.log("Response got but not succefull" +response)
				}*/
				console.log("Response succefull "+ JSON.stringify(response));
				window.location.href="http://localhost:8282/home"
			},
			error:function(error){
				console.log("Error is " + JSON.stringify(error))
			},
			
		})
	})
})