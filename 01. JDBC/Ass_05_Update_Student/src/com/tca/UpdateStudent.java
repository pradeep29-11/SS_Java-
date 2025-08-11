package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateStudent {

	public static void main(String[] args) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			
			con = DriverManager.getConnection("jdbc:postgresql://localhost:8080/ajdb20","root","Root@123");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter the Roll No : ");
			int rno = Integer.parseInt(br.readLine());
			
			System.out.print("Enter the Per     : ");
			Double per = Double.parseDouble(br.readLine());
			
			ps = con.prepareStatement("Update student set per=? where rno=?");
			
			ps.setInt(2,rno);
			ps.setDouble(1,per);
			
			int sval = ps.executeUpdate();
			
			if(sval == 0)
			{
				System.out.println("Unable to update Roll no "+rno);
			}
			else
			{
				System.out.println("Record is Updated Succesfull !!");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
