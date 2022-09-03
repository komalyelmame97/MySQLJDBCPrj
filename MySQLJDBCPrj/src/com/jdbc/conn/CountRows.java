package com.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CountRows {

	public static void main(String[] args) 
	{

        Connection conn = null;
        ResultSet res = null;
 
      
        try {
 
            Class.forName("com.mysql.cj.jdbc.Driver");
 
          
            conn=DriverManager.getConnection("jdbc:mysql://localhost/db1","root","root");
             
 
         
            try {
                Statement st = conn.createStatement();
                
                res = st.executeQuery(
                    "SELECT COUNT(1) as NumberOfRows FROM "
                    + "EMP1");
 
                
                res.next();
 
             
                System.out.println(
                    "MySQL Table -  studentsdetails contains "
                    + res.getInt("NumberOfRows") + " rows");
            }
 
        
            catch (SQLException s) {
               
                System.out.println(
                    "SQL statement is not executed!");
            }
        }
        catch (Exception e) {
 
         
            e.printStackTrace();
        }
 
        finally {
 
          
            res = null;
            conn = null;
        }
    


	}

}
