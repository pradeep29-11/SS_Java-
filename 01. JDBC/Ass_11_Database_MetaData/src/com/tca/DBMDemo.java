package com.tca;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBMDemo 
{

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		DatabaseMetaData dbmd = null;
		ResultSet rs = null;
		
		String DB_DRIVER = "org.postgresql.Driver";
		String DB_URL = "jdbc:postgresql://localhost:8080/ajdb20";
		String DB_USER = "root";
		String DB_PWD = "Root@123";
		
		try 
		{
			Class.forName(DB_DRIVER);
			
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			
			dbmd = con.getMetaData();
			
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDatabaseProductVersion());
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getUserName());
			
			rs = dbmd.getTables(null, null, null,new String[] {"TABLE"});
			
			while(rs.next()) 
			{
				System.out.println(rs.getString("TABLE_NAME"));
			}
			con.close();
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
