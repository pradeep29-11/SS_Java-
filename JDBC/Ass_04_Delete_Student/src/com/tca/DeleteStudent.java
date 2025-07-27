package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteStudent 
{
	public static void main(String args[])
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			Class.forName("org.postgresql.Driver"); 

			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:8080/ajdb20","root","Root@123");
			
			System.out.print("Enter the Roll Number to Delete the Record : ");
			int rno = Integer.parseInt(br.readLine());
			
			ps = con.prepareStatement("Delete from student Where rno=?");
			
			ps.setInt(1,rno);
			
			int sval = ps.executeUpdate();
			
			if(sval == 0)
			{
				System.out.println("Unable to Delete Record of Roll No : "+rno);
			}
			else
			{
				System.out.println("Record is Deleted Succesfully !!");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
