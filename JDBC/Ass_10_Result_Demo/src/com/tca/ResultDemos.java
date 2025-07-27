package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultDemos 
{

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
			
			//ps = con.prepareStatement("Select * from student order by rno",ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			
			//ps = con.prepareStatement("Select * from student order by rno",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ps = con.prepareStatement("Select * from student order by rno",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("Roll No   : "+rs.getInt("rno"));
				System.out.println("Name      : "+rs.getString("name"));
				System.out.println("Percenage : "+rs.getDouble("per"));
				
				System.out.println("---------------------------------------------");
			}
			System.out.println("*********************Backward Direction********************");
			while(rs.previous())
			{
				System.out.println("Roll No   : "+rs.getInt("rno"));
				System.out.println("Name      : "+rs.getString("name"));
				System.out.println("Percenage : "+rs.getDouble("per"));
				
				System.out.println("---------------------------------------------");
			}
			
			rs.absolute(2);
			System.out.println("Roll No   : "+rs.getInt("rno"));
			 
			rs.first();
			System.out.println("Roll No   : "+rs.getInt("rno"));
			
			rs.last();
			System.out.println("Roll No   : "+rs.getInt("rno"));
			
			System.out.print("Pres Any key To Continue....");
			System.in.read();
			
			rs.refreshRow();
			
			System.out.println("Roll No   : "+rs.getInt("rno"));
			
			rs.absolute(4);
			System.out.println("Fourth Row : RNO "+ rs.getInt(1) + " Name :" + rs.getString(2));
			rs.updateString(2, "ANUJ");
			rs.updateDouble(3, 64);
			rs.updateRow();
			System.out.println("Record is updated for Roll Number : " + rs.getInt(1));
			
			rs.absolute(4);
			rs.deleteRow();
			System.out.println("Record is delete !!");
			
			rs.close();
			con.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
