package org.sdet40.GenericUtility;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection connection;
	public List<String> getDataFromDatabase(String query, String columnName) throws SQLException{
		Statement statement=connection.createStatement();
		ResultSet result = statement.executeQuery(columnName);
		List<String> list=new ArrayList<>();
		while(result.next()) {
			list.add(result.getString(columnName));
		}
		return list;		
	}
	
	public void openDataBaseConnection(String dbURL,String dbUserName, String Password) throws SQLException {
		Driver dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
		connection=DriverManager.getConnection(dbURL, dbUserName, Password);
		
	}
	public void closeDB() throws SQLException {
		connection.close();
	}
	public void modifyDataintoDB(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		}
	public boolean verifyDataIntoDB(String query, String columnName, String expectedDate) throws SQLException {
		List<String> list = getDataFromDatabase(query, columnName);
		boolean flag = false;
		for(String actualdata:list) {
			if(actualdata.equalsIgnoreCase(expectedDate)) {
				flag=true;
				break;
				
			}
		}
		return flag;
	}
	
	
	
	 
	
	

}
