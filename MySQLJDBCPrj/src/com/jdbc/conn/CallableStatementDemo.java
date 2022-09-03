package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.CallableStatement;

public class CallableStatementDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		System.out.println("Connection established.....");
		
		CallableStatement cstmt = conn.prepareCall("{call get_employee()}");
	
		ResultSet rs = cstmt.executeQuery();
		System.out.println("Get employee records.....");
		while (rs.next()) {
			int eid = rs.getInt(1);
			String ename = rs.getString(2);
			String ecity = rs.getString(3);
		
			System.out.println("Employee Data : " + " id = " +eid + ", ename = " + ename + ", ecity = " +ecity);
			
		}
		
		
		CallableStatement cs = conn.prepareCall("{call get_employee(?)}");
		cs.setInt(1, 4);
		ResultSet rs1 = cs.executeQuery();
		System.out.println("Get employee records");
		
		rs.close();
		conn.close();
	}

}
