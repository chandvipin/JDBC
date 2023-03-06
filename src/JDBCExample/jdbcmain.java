package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcmain {

	public static void main(String[] args)  {
		      // connection est.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbc", "root", "1234");
			System.out.println("Database Connection success");

			
			        //create database 
//			Statement stm = con.createStatement();
//			String query = "CREATE DATABASE myjdbc";
//			stm.execute(query);
//			System.out.println("Database created successfully");
//			con.close();
			
			
			
			        //create table 
//			Statement stmt = con.createStatement();		
//			String query = "CREATE TABLE REGISTRATION " + "(id INTEGER not NULL, " + " first VARCHAR(255), " + " last VARCHAR(255), " + " age INTEGER, " + " PRIMARY KEY ( id ))"; 			
//			stmt.executeUpdate(query);			
//			System.out.println("table created in the database");
			
			
			
			
			       //insert data into table
			String query = "INSERT INTO REGISTRATION(id,first,last,age)VALUES(?,?,?,?)";			
			PreparedStatement ptmt = con.prepareStatement(query);			
			ptmt.setInt(1, 2);
			ptmt.setString(2, "pankaj");
			ptmt.setString(3,"singh");
			ptmt.setInt(4, 32);		
			System.out.println("Data inserted successfully...");
			ptmt.executeUpdate();
			ptmt.close();
			
			
			
			
			        //extract data from table		
//           String query = "Select * from registration where age >25;";          
//           Statement stmt = con.createStatement();           
//           ResultSet rs = stmt.executeQuery(query);          
//           ResultSetMetaData rsmd = rs.getMetaData();          
//           System.out.println("Total number of column count "+rsmd.getColumnCount());
//           System.out.println("Column name of 1st "+rsmd.getColumnName(1));
//           
//           while(rs.next()) {
//        	   System.out.println("Student sr.no : "+rs.getString(1)+" First name : "+rs.getString(2)+" Last name : "+rs.getString(3)+" Age : "+rs.getString(4));
//           }
           
//			rs.close();
//			con.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
