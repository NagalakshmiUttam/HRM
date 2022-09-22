package org.sdet40.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class jdbcPractice {

	public static void main(String[] args) throws SQLException {
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_ruler","root","root");
		Statement stat = con.createStatement();
	    String query = "select*from emp_info";
	    ResultSet result = stat.executeQuery(query);
	    while(result.next()) {
	    	System.out.println(result.getInt(1)+ "\t" +result.getString(2)+ "\t" +result.getString(3)+ "\t" +result.getString(4)+ "\t" +result.getString(5)+ "\t" +result.getString(6));
	    	
	    }
	    con.close();
		 
	}

}
