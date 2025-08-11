package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JavaPlsqlDemo {

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String DB_DRIVER = "org.postgresql.Driver";
		String DB_URL = "jdbc:postgresql://localhost:8080/ajdb20";
		String DB_USER = "root";
		String DB_PWD = "Root@123";
		
		try 
		{
			Class.forName(DB_DRIVER);
			
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			
			//ps = con.prepareStatement("Select msg()");
			
			//ps = con.prepareStatement("Select add(55,33)");
			
			ps = con.prepareStatement("Select addinfo(22,'Aniket',90.1)");
			rs = ps.executeQuery();
			
			rs.next();
			System.out.println(rs.getString(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
