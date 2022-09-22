package org.sdet40.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyTheDataFromDataBase {

	public static void main(String[] args) throws SQLException
	{
		//step1: create the object for the Driver
		Driver dbDriver=new Driver();
		 
		//step2: register the driver instance to the jdbc
		DriverManager.deregisterDriver(dbDriver);
		
		//step3: establish the database connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_ruler","root","root");
		
		try {
		//step4: create the statement
		Statement statement=connection.createStatement();
			
		//step5: execute the query
		int result = statement.executeUpdate("update emp_info set emp_name='Nagalakshmi';");
		
		//step6: verify the iteration and fetch the data
		System.out.println(result+"Database updated successfully");
		}
		 
		finally {
			//close the database connection
			connection.close();//mandatory
			System.out.println("connection closed successfully");
		
			
		}
		
	}

}
