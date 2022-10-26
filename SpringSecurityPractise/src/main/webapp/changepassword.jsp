<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ChangePassword</title>
</head>
<body>
<form action="change-password" method="POST">
username : <input type="text" id="useremail" name="username"
			placeholder="Enter your name"><br> 
	Old Password : <input type="password" id="password" name="oldpassword"
			placeholder="Enter your password"><br> 
	new Password : <input type="password" id="password" name="newpassword"
			placeholder="Enter your password"><br>
			<input type="submit" value="submit">
</form>
</body>
</html>