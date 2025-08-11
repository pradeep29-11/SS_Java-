package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchStudent 
{

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:8080/ajdb20","root","Root@123");
			
			ps = con.prepareStatement("Select * from student where rno=?");
			
			System.out.print("Enter the Roll No to Search : ");
			int rno = Integer.parseInt(br.readLine());
			
			ps.setInt(1, rno);
			
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println("Record is Found !!");
			}
			else 
			{
				System.out.println("Record is Not Found !!");
			}
			 
			rs.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
