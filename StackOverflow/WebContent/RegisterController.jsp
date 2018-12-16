<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="test.UserMethods"%>

<%String email = request.getParameter("email");
String name = request.getParameter("name");
String pass = request.getParameter("pass");
boolean flag= UserMethods.register(name,email,pass);
if(flag)
{
	response.sendRedirect("Welcome.jsp");
}
else
{
	response.sendRedirect("Register.jsp");
}
%>
