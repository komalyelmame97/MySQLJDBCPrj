package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultsetOperation {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		System.out.println("Databse is connected");
		ResultSet rs = null;

		try {
//			Statement st = conn.createStatement();
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from emp"); // execute the query
//			rs = st.executeQuery("select * from emp order by age"); // execute the query

//			while (rs.next()) {
//				displayData(rs);
//
//			}
			System.out.println("Now go directly to 2nd row=>");
//			rs.absolute(2); // Go directly to 2nd row
//			displayData(rs);
			if (rs.absolute(2)) {
				rs.updateString("firstname", "Apoorva");
				rs.updateRow();
				displayData(rs);
			}
//			rs.absolute(3);
//			displayData(rs);
			System.out.println("Now go before first =>");
			rs.absolute(2);
			rs.beforeFirst();
//			rs.afterLast();
//			rs.isLast();
			while (rs.next()) {
				displayData(rs);

			} // System.out.println("Now go to Previous row=>");
//			rs.previous();
//			// Go to 1st row which is previous of 2nd row
//			displayData(rs);

//			System.out.println("total rows in table " + rs.getRow() + " rows");
		} catch (SQLException s) {

			System.out.println("SQL statement is not executed!" + s.getMessage());
		} finally {

			rs = null;
			conn = null;
		}

	}

	private static void displayData(ResultSet rs) throws SQLException {
		System.out.println("empId:" + rs.getInt(1));
		System.out.println("firstName:" + rs.getString(2));
		System.out.println("lastName:" + rs.getString(3));
		System.out.println("age:" + rs.getInt(4));
		System.out.println("");


	}

}
