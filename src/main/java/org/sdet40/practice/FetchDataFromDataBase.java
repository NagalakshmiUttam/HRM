package org.sdet40.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDataBase {
	// for DQL statement

	public static void main(String[] args) throws SQLException 
	{
		//create object for the driver
 Driver dbdriver=new Driver();
 
 //register the driver instance to the jdbc
 DriverManager.registerDriver(dbdriver);
 
 //establish the database connection
 Connection connection=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_ruler", "root", "root");
 
 try {
	 // create the statement
	 Statement statement=connection.createStatement();
	 
	 //execute the query
	 ResultSet result=	statement.executeQuery("select * from emp_info;");
	 
	 //verify or fetch data 
	 while(result.next()) {
		 System.out.println(result.getString("emp_id"));
		 
	 }
		
 
	}
 
 finally {
	 //close the database connection
	 connection.close(); //mandatory
	 System.out.println("connection closed successfully");
 }
	}
}


