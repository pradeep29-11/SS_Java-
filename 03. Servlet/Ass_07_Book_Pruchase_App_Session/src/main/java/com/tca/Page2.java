package com.tca;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Page2")
public class Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String val[] = request.getParameterValues("Lbook");
		
		int ltotal = 0;
		
		if(val != null)
		{
			for(int i=0;i<val.length;i++)
			{
				ltotal += Integer.parseInt(val[i]);
			}
		}
		
		HttpSession st = request.getSession(true);
		st.setAttribute("P1Total",ltotal);
		
		out.println("<h1> Servlet And JSP Books </h1>");
		out.println("<form methos='GET' action='./Page3' >");
		out.println("<b>Select Books </b> <br>");
		out.println("<input type='checkbox' name='sjBook' value='450'> Book1 Rs.450 <br>");
		out.println("<input type='checkbox' name='sjBook' value='300'> Book2 Rs.300 <br>");
		out.println("<input type='checkbox' name='sjBook' value='250'> Book3 Rs.250 <br>");
		out.println("<input type='submit' value='payment' />");
		out.println("</form>");
		
		out.close();
		
	}

}
