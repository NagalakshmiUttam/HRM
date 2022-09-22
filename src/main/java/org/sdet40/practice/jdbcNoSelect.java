package org.sdet40.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class jdbcNoSelect {

	public static void main(String[] args) throws SQLException {
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_ruler", "root","root");
		Statement stat = con.createStatement();	
		String query = "inser into emp_info(emp_id, emp_name, designation, place, branch, salary) values('1005','Mona','asst_manager','gujarat,'pune','50000')";
		int result = stat.executeUpdate(query);
		if(result==1) {
			System.out.println("emp added");
			}
		else {
			System.out.println("emp not added");
		}
		con.close();
	}
}

