<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="authenticateuser" method="post" id="log-form">
		username : <input type="text" id="useremail" name="username"
			placeholder="Enter your name"><br> 
		Password : <input type="password" id="userpassword" name="password"
			placeholder="Enter your password"><br> 
			<input type="submit">
	</form:form>
</body>
</html>