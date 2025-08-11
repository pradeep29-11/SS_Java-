package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie c[] = request.getCookies();
		
		if(c==null)
		{
			out.println("No Cookies Saved !!!");
		}
		else
		{
			out.println("<h3> Client Side Cookies : </h3>");
			
			for(int i=0;i<c.length;i++)
			{
				String key = c[i].getName();
				String val = c[i].getValue();
				
				out.println(key+"-->"+val+"<br>");
			}
			
		}
		out.close();
	}

}
