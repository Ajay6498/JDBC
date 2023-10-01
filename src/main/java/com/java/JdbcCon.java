package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCon {

	private JdbcCon() {

	}

	public static void getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbccrud", "root", "ajay123");
			java.sql.Statement statement = con.createStatement();
			//System.out.println(con);
			/*
			           //Table Creation
			 
			  statement.execute( "create table Student(RNo int primary key,Name
			  varchar(255),LastName varchar(255),City varchar(255));");
			  */
			
			// Insert values
			//statement.execute("insert into student values(4,'jdj','er','Pune')");
			
			// Read values from database
			
			ResultSet resultSet = statement.executeQuery("select * from student");

			while (resultSet.next()) {
				int rno = resultSet.getInt(1);
				String name = resultSet.getNString(2);
				String lname = resultSet.getNString(3);
				String city = resultSet.getNString(4);

				System.out.println(rno + "|" + name + "|" + lname + "|" + city);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		JdbcCon.getCon();
	}

}
