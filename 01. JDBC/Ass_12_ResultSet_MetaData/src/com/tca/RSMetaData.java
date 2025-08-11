package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RSMetaData 
{
	public static void main(String args[])
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmt = null;
		
		String DB_DRIVER = "org.postgresql.Driver";
		String DB_URL = "jdbc:postgresql://localhost:8080/ajdb20";
		String DB_USER = "root";
		String DB_PWD = "Root@123";
		
		try 
		{
			Class.forName(DB_DRIVER);
			
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
				
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from student");
			
			rsmt = rs.getMetaData();
			int n = rsmt.getColumnCount();
			
			System.out.println("No of Columns : "+n);
			
			for(int i=1;i<=n;i++)
			{
				System.out.println("Column Name : "+rsmt.getColumnName(i));
				System.out.println("Column Type : "+rsmt.getColumnTypeName(i));
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
