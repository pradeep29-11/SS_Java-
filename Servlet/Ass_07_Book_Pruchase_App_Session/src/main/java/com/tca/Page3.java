package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Page3")
public class Page3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String val[] = request.getParameterValues("sjBook");
		
		int ltotal = 0;
		
		if(val != null)
		{
			for(int i=0;i<val.length;i++)
			{
				ltotal += Integer.parseInt(val[i]);
			}
		}
		
		HttpSession hs = request.getSession(false);
		int total = Integer.parseInt(hs.getAttribute("P1Total").toString());
		
		//int ltotal = Integer.parseInt(hs.getAttribute("p1total").toString());
		
		int bill = ltotal+total;
		
		out.println("<h2> BILL </h2>");
		out.println("Page 1 : "+total+"<br>");
		out.println("Page 2 : "+ltotal+"<br>");
		out.println("Total Bill Amount : "+bill+"<br>");
		
		hs.invalidate();
		
		out.close();
	}

}
