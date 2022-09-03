package com.jdbc.conn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CollableStatmentInsertRecord {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		System.out.println("Connection established.....");
		
		
		String sql = "insert into get_employee values(?,?,?)";
		CallableStatement cstmt = conn.prepareCall(sql);
		
		cstmt.setInt(1, 5);
		cstmt.setString(2, "Gauri");
		cstmt.setString(3, "Pune");
		cstmt.execute();
		System.out.println("uploaded successfully");
		}


	}


