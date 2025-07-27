package com.tca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo 
{

	public static void main(String[] args) throws SQLException 
	{
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		
		String DB_DRIVER = "org.postgresql.Driver";
		String DB_URL = "jdbc:postgresql://localhost:8080/ajdb20";
		String DB_USER = "root";
		String DB_PWD = "Root@123";
		
		try 
		{
			Class.forName(DB_DRIVER);
			
			con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			
			con.setAutoCommit(false);
			
			ps1 = con.prepareStatement("UPDATE account set balance=balance-500 where ano=101");
			ps1.executeUpdate();
			
			//Integer.parseInt("hii");
			
			ps2 = con.prepareStatement("UPDATE account set balance=balance+500 where ano=102");
			
			ps2.executeUpdate();
			
			con.commit();
			con.close();
			
			System.out.println("Amount Transfer succesfull !!");
		}
		catch(Exception e)
		{
			System.out.println("Tranaction Faild !!");
			con.rollback();
			
			e.printStackTrace();
		}
		
	}

}
