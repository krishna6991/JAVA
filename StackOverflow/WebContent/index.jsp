<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
	
	<form>
	Search Ques:<input type="text" name="ques">&nbsp; <input type="submit" value="Search" onclick="form.action='DisplaySearchQues.jsp';">
	</form>
	<br>
	<br>
	<p>This is index page</p>
	<form>
		
			Email Id:<input type="email" name="email">
		
		
			Password:<input type="password" name="pass">
		<br>
		<input type="submit" value="Login" onclick="form.action='LoginController.jsp';">  
		<a href="Register.jsp">New user Register</a><br><br>
		
	</form>
	
</body>
</html>


