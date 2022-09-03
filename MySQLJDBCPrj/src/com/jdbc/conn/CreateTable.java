package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/db1","root","root");
			System.out.println("Database is connected!");
			
			 Statement stmt = conn.createStatement();
		
			 String sql = "CREATE TABLE EMP (eid INTEGER not NULL,firstname VARCHAR(255),lastname VARCHAR(255),age INTEGER,PRIMARY KEY(eid))";
//			 String sql = "CREATE TABLE EMP2 " +
//                     "(eid INTEGER not NULL, " +
//                     " firstname VARCHAR(255), " + 
//                     " lastname VARCHAR(255), " + 
//                     " age INTEGER, " + 
//                     " PRIMARY KEY ( eid ))";
		
			 stmt.executeUpdate(sql);
			
			 System.out.println("Create table in given database..")	;	
			 
			 conn.close();
		}catch(Exception e)
		{
			System.out.println("Do not connect to DB1 - Error:" +e);
		}
	

	}

}
