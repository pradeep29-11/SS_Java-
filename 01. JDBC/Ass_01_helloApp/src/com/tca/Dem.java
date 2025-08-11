package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Dem {

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			// Step 1 : Load Driver 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2 : Forming a connection using URL,Username,Password
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/ajdb20","root","root@123");
			
			// Step 3 : Prepare SQL Statement
			
			ps = con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, 15);
			ps.setString(2,"Pradeep");
			ps.setFloat(3,12);
			
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
