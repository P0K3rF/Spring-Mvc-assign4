<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<div class="container py-5 ">
		<div class="col-md-5 offset-md-3">
			<div class="card">
				<div class="card-header text-center bg-primary">
					<h2>Registration Page</h2>
				</div>
				<div class="card-body">
					<form action="register" method="post" id="reg-form">
						<div class="form-group">
							<label for="email" style=" margin-top: 5%">Email:</label> <input type="email"
								class="form-control" id="useremail" placeholder="Enter email"
								name="email">
						</div>
						<div class="form-group">
							<label for="username" style=" margin-top: 5%">Username:</label> <input type="text"
								class="form-control" id="username" placeholder="Enter username"
								name="name">
						</div>
						<div class="form-group">
							<label for="userpassword" style=" margin-top: 5%">Password:</label> <input type="password"
								class="form-control" id="userpassword"
								placeholder="Enter password" name="password" >
						</div>
						<span></span>
						<div class="container text-center py-3">
						<button type="submit" class="btn btn-default bg-primary ">Submit</button>
					</div>
					</form>
					</div>
				</div>
			</div>
		</div>



		<script src="https://code.jquery.com/jquery-3.6.0.min.js"
			integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
			crossorigin="anonymous"></script>
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

		<script>
	$(document).ready(function(){
		console.log("loaded.....");
		$('#reg-form').on('submit',function(event){
			
			event.preventDefault();
			console.log("submit button click")
			var formData = {
					"email" : $("#useremail").val(),
					"username" : $("#username").val(),
					"password" : $("#userpassword").val()
				} 
			/* var formData=new FormData(this) */
		$.ajax(
		{
			type:"POST",
			contentType : 'application/json; charset=utf-8',
			 dataType : 'json',
			url:'register',  
			 data:JSON.stringify(formData),
			 
			/* data:formData, */
			 success:function(result) {
				 var status=result.responseStatus
				 if(result.responseStatus=="Success"){
					  swal("Registered Successfully..click ok to get Redirected to login page")
						.then((value) => {
						  window.location="login";
						});
				 }else{
					 swal("Enter the valid details")
				 }
				 
				  
				 },
		 error: function(xhr, status, error) {
		      console.log(error)
		   },
		}		
		);
		
			/* $('#submit-btn').hide();
			$('#loader').show(); */
			//send to register Servlet
			
		});
	});
	
	
	</script>
</body>
</html>



