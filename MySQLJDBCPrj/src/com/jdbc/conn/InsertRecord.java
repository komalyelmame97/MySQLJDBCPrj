package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertRecord {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/db1","root","root");
			System.out.println("Database is connected!");
			
			 Statement stmt = conn.createStatement();
			 conn.close();
			 
	} catch(Exception e)
	{
		
	}
	}
}
