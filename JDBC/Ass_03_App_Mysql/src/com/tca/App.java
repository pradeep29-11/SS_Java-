package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App 
{
	public static void main(String args[])
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		try 
		{
			// Step 1 : Load Driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");      //Change 1
			
			//Step 2 : Form Connection
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajdb20","root","Root@123");
			
			//Step 3 : Prepare Statment
			
			ps = con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)");
			
			ps.setInt(1,15);
			ps.setString(2,"Pradeep");
			ps.setDouble(3,90.12);
			
			//Step 4 : Fire SQL
			
			int sval = ps.executeUpdate();
			
			if(sval == 0)
			{
				System.out.println("Unable to Save Record !!");
			}
			else 
			{
				System.out.println("Record is Saved Succesfully !!");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
