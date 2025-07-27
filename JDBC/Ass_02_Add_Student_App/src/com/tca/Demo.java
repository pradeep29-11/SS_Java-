package com.tca;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo 
{

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			// Step 1 : Load Driver 
			
			Class.forName("org.postgresql.Driver");
			
			// Step 2 : Forming a connection using URL,Username,Password
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:8080/ajdb20","root","Root@123");
			
			// Step 3 : Prepare SQL Statement
			
			System.out.print("Enter the Roll No      : ");
			int rno = Integer.parseInt(br.readLine());
			
			System.out.print("Enter the Name         : ");
			String name = br.readLine();
			
			System.out.println("Enter the Percentage : ");
			Double per = Double.parseDouble(br.readLine());
			
			ps = con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, rno);
			ps.setString(2,name);
			ps.setDouble(3,per);
			
			// Step 4 : Execute SQL Statement
			
			int sval = ps.executeUpdate();
			
			if(sval == 0)
			{
				System.out.println("Unable to Insert Record !!");
			}
			else
			{
				System.out.println("Recordis Saved Succesfully !!!");
			}
			
			// Step 5 : Close Connection
			
			con.close();
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}

	}

}
