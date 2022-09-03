package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatInsertDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/db1","root","root");
		
//		PreparedStatement ps = conn.prepareStatement("insert into emp values(?,?,?,?)");
//		ps.setInt(1, 20);
//		ps.setString(2, "Komal");
//		ps.setString(3, "Pune");
//		ps.setInt(4, 20000);
//		
//		ps.setInt(1, 40);
//		ps.setString(2, "Shubha");
//		ps.setString(3, "Nashik");
//		ps.setInt(4, 40000);
//		
//		int i = ps.executeUpdate();
//		System.out.println("Record inserted:" +i);
		
		PreparedStatement ps1 = conn.prepareStatement("update emp set firstname=?,lastname=?,age=? where eid=?");
		ps1.setString(1,"Ankita");
		ps1.setString(2,"Khandekar");
//		ps1.setInt(0, 0)
		conn.close();
		
	}

}
