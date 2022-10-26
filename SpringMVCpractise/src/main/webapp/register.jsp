<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="jquery/jquery-3.6.1.js"></script>
<script src="/index.js"></script>

</head>
<body>
	Register Page


	<form action="login" method="post" id="reg-form">
		<h4>
			Email: <input type="email" name="email" id="useremail" placeholder="Enter Email">
		</h4>
		<br>
		<h4>
			Username: <input type="text" name="name" id="username" placeholder="Enter username">
		</h4>
		<br>
		<h4>
			password: <input type="password" name="password" id="userpassword"
				placeholder="Enter password">
		</h4>
		<br>
		<h4>
			<input type="submit" id="submit">
		</h4>

	</form>



	<!--  <script>
	
	$(document).ready(function(){
		console.log("DOM LOADED")
	})
	</script>  -->
</body>
</html>