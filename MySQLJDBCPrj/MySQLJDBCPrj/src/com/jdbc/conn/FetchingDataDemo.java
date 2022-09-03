package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchingDataDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery("select * from emp");

			System.out.println("No of Records:");
			while (rs.next()) {
				// Display values
				System.out.print("EID: " + rs.getInt("eid"));
				System.out.print(", First Name: " + rs.getString("firstname"));
				System.out.println(", Last Name: " + rs.getString("lastname"));
				System.out.print(", Age: " + rs.getInt("age") + "\n");

			}
			rs.last();
			System.out.println("Table contains " + rs.getRow() + " rows");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
