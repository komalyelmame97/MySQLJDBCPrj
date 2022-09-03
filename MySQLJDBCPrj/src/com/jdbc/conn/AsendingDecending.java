package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AsendingDecending {

	public static void main(String[] args) throws SQLException,ClassNotFoundException
	{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn=null;
			    
		     conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","root");
		 
		      System.out.println(" database connected!");
		     
		    Statement stmt=conn.createStatement();
		    String sql = "SELECT * FROM EMP1 ORDER BY firstname ";
		    
		 ResultSet rs=stmt.executeQuery(sql);
		 
		      //System.out.println("create table in given database...");
		     while(rs.next()) {
		    	 int eid=rs.getInt("eid");
		    	 String firstname=rs.getString("firstname");
		    	 String lastname=rs.getString("lastname");
		    	 int age=rs.getInt("age");
		    	 System.out.println(eid+ " "+firstname+ " "+lastname+" "+age);
		     }

	}

}
