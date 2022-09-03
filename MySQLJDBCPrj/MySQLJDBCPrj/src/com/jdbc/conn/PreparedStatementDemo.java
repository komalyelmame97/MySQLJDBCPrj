package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
//		PreparedStatement ps = conn.prepareStatement("insert into emp values(?,?,?,?)");
//		ps.setLong(1, 11);
//		ps.setString(2, "Suyasha");
//		ps.setString(3, "Pande");
//		ps.setLong(4, 29);
//		int i = ps.executeUpdate();
//		System.out.println(i + " record inserted");

//		PreparedStatement ps1 = conn.prepareStatement("update emp set firstname=?, lastname=? ,age=? where eid=?");
//		ps1.setString(1, "Ashvini");
//		ps1.setString(2, "Lahoti");
//		ps1.setInt(3, 29);
//		ps1.setInt(4, 9);

//		PreparedStatement ps2 = conn.prepareStatement("delete from emp  where eid=?");
//		ps2.setInt(1, 10);
//		int i1 = ps2.executeUpdate();
//		System.out.println(i1 + " record deleted");

		PreparedStatement ps3 = conn.prepareStatement("select * from emp ");
		ResultSet rs = ps3.executeQuery();
		System.out.println("Get employee records");
		while (rs.next()) {
			int empId = rs.getInt(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			int empAge = rs.getInt(4);
			System.out.println("Employee Data:" + " id = " + empId + ", firstName = " + firstName + ", lastName = "
					+ lastName + ", empAge = " + empAge);
		}
		rs.close();
		conn.close();

	}
}
