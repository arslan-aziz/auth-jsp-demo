<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>	

	<%
		session.setAttribute("form","yes");
	%>
	<form action="login" method="get">
		Enter username : <input type="text" name="uname"><br>
	</form>
	<input type="submit">
</body>
</html>