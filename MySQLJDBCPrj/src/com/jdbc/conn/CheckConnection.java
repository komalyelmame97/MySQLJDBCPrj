package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CheckConnection {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/db1","root","root");
			System.out.println("Database is connected!");
			
			conn.close();
			
		}catch(Exception e)
		{
			System.out.println("Do not connect to DB1 - Error:" +e);
		}
	
	}

}
