<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Page</h1>

	<form action="login" method="post" id="log-form">
		Email : <input type="email" id="useremail" name="email"
			placeholder="Enter your email"><br> Password : <input
			type="password" id="userpassword" name="password"
			placeholder="Enter your password"><br> <input
			type="submit">


	</form>
	
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
		console.log("DOM loaded")
		$('#log-form').on('submit',function(event){
			event.preventDefault();
			console.log("submit button clicked");
			var loginData={
					email:$('#useremail').val(),
					password:$('#userpassword').val()
			}
			$.ajax({
				method:'POST',
				contentType:'application/json; charset=utf-8',
				dataType:'json',
				data:JSON.stringify(loginData),
				url:'login',
				success:function(result){
					var status=result.responseStatus
					console.log(status)
					/*  if(result.responseStatus=="Success"){
						  swal("Login Sucessfull..click ok to get Redirected to index page")
							.then((value) => {
							  window.location="home";
							});
					 }else{
						 swal("Invalid Credentials")
					 } */
				},
				error:function(error){
				console.log(error);	
				}
			})
			
		})
	})
	</script>
</body>
</html>