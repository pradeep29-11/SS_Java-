package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddNStudent 
{

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String DB_URL = "jdbc:postgresql://localhost:8080/ajdb20";
		String DB_USER = "root";
		String DB_PWD = "Root@123";
		String JDBC_DRIVER = "org.postgresql.Driver";
		try 
		{
			Class.forName(JDBC_DRIVER);
			
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			
			ps = con.prepareStatement("Insert into student values(?,?,?)");
			while(true)
			{
				
				System.out.print("Enter the ROll no    : ");
				int rno = Integer.parseInt(br.readLine());
				
				System.out.print("Enter the Name       : ");
				String name = br.readLine();
				
				System.out.print("Enter the Percentage : ");
				Double per = Double.parseDouble(br.readLine());
				
				ps.setInt(1,rno);
				ps.setString(2, name);
				ps.setDouble(3,per);
				
				int sval = ps.executeUpdate();
				
				System.out.print("Do you Want to Continue[Yes/No] : ");
				String option = br.readLine();
				
				if(option.equalsIgnoreCase("yes"))
				{
					continue;
				}
				else 
				{
					break;
				}
			}
			System.out.println("Records Saved Successfully !!");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
