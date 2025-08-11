<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String name = request.getParameter("un");
		String pwd = request.getParameter("pwd");
		
		if(pwd.equals("TCA"))
		{
			response.sendRedirect("https://development.technocompacademy.com/");
		}
		else
		{
			out.println("<h3> Error </h3>");
			response.sendRedirect("http://localhost:8081/Ass03_LoginForm/Login.html");
		}
	%>
</body>
</html>