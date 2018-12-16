<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="test.Questions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 

Hello<jsp:useBean id="test" class="test.Questions" />
  <%
 // Questions tc = new Questions();
  // out.print(tc.Ques());
  %> -->
  	<form>
		<input type="submit" value="Give Test" onclick="form.action='quiz_index.html';"> 
	</form>
</body>
</html>