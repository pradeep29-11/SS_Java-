package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayStudent 
{
	public static void main(String args[])
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:8080/ajdb20","root","Root@123");
			
			ps = con.prepareStatement("select * from student ");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("Roll No : "+rs.getInt("rno"));
				System.out.println("Name    : "+rs.getString("name"));
				System.out.println("Per     : "+rs.getDouble("per"));
				System.out.println("------------------------------------------");
			}
			rs.close();
			con.close();
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
	}

}
