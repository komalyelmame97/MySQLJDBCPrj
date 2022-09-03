package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuDrivenJdbc {

	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
		int choice;
//		PreparedStatement ps = conn.prepareStatement(
//				"create table college(cid int(20) primary key ,cname varchar(255) unique,ccity varchar(255)  , ccourse varchar(255) )");
//		ps.executeUpdate();
//		System.out.println("Table is created successfully");
		System.out.println("********** College Database System **********");

		do {
			System.out.println("Press 1 to insert data into database");
			System.out.println("Press 2 to display data from database");
			System.out.println("Press 3 to update data into database");
			System.out.println("Press 4 to search data from database");
			System.out.println("Press 5 to delete data from database");
			System.out.println("Press 6 to exit from database ");

			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				PreparedStatement ps1 = conn.prepareStatement("insert into college values(?,?,?,?)");
				System.out.println("Enter college id");
				int cid = sc.nextInt();
				System.out.println("Enter college name");
				String cname = sc.next();
				System.out.println("Enter college city");
				String ccity = sc.next();
				System.out.println("Enter course");
				String ccourse = sc.next();

				ps1.setLong(1, cid);
				ps1.setString(2, cname);
				ps1.setString(3, ccity);
				ps1.setString(4, ccourse);
				ps1.executeUpdate();
				System.out.println("Record inserted successfully");
				break;

			case 2:
				PreparedStatement ps2 = conn.prepareStatement("select * from college ");
				ResultSet rs = ps2.executeQuery();
//				Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//				ResultSet rs = st.executeQuery("select * from college"); // execute the query

				System.out.println("Get college records:");
				while (rs.next()) {
					int cid1 = rs.getInt(1);
					String cname1 = rs.getString(2);
					String ccity1 = rs.getString(3);
					String ccourse1 = rs.getString(4);
					System.out.println("College Data: " + " cid = " + cid1 + ", cname = " + cname1 + ", ccity = "
							+ ccity1 + ", ccourse = " + ccourse1);
				}
				rs.close();
				break;
			case 3:
				PreparedStatement ps3 = conn.prepareStatement("update college set cname=?, ccity=? where cid=?");
				System.out.println("Enter new college name");
				String cname2 = sc.next();
//				ps3.setString(1, cname2);
				System.out.println("Enter new college city");
				String ccity2 = sc.next();
//				ps3.setString(2, ccity2);
				System.out.println("Enter college id where you want to update data");
				int cid2 = sc.nextInt();
				ps3.setString(1, cname2);
				ps3.setString(2, ccity2);
				ps3.setInt(3, cid2);
				ps3.executeUpdate();
				System.out.println("Record updated successfully");
				break;
			case 4:
				PreparedStatement ps4 = conn.prepareStatement("select * from college where cid=? ");
				System.out.println("Enter college id that want to search");
				int cid3 = sc.nextInt();
				ps4.setInt(1, cid3);
				ResultSet rs1 = ps4.executeQuery();

				while (rs1.next()) {
					int cid1 = rs1.getInt(1);
					String cname1 = rs1.getString(2);
					String ccity1 = rs1.getString(3);
					String ccourse1 = rs1.getString(4);
					System.out.println("College Data: " + " cid = " + cid1 + ", cname = " + cname1 + ", ccity = "
							+ ccity1 + ", ccourse = " + ccourse1);
				}
				rs1.close();
				break;
			case 5:
				PreparedStatement ps5 = conn.prepareStatement("delete from college where cid=?");
				System.out.println("Enter college id that want to delete");
				int cid4 = sc.nextInt();
				ps5.setInt(1, cid4);
				ps5.executeUpdate();
				System.out.println("Record with specific cid is deleted sucessfully");

				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				choice++;
			}

		} while (choice != 6);
	}

}
