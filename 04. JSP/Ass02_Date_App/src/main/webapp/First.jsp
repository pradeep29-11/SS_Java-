<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String name = request.getParameter("un");
		Date d = new Date();
		int hr = d.getHours();
		String msg = "";
		
		if(hr < 12)
		{
			msg = "Good Morning";
		}
		else if(hr < 14)
		{
			msg = "Good Afternoon";
		}
		else
		{
			msg = "Good Evening ";
		}
		out.println("<h2>"+msg+" ---> "+name+"</h2>");
	%>
</body>
</html>