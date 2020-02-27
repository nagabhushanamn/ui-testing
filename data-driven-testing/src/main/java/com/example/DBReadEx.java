package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

/*
 * 
 * 
 *  How java program can work with any SQL database ?
 *  
 *  
 *   ==> using JDBC API  ( java.sql.* )
 *  
 *  steps:
 *  --------
 *  
 *  
 *   step-1 : register db-driver
 *   step-2 : create  db-connection with url,username and password
 *   step-3 : create SQL statements
 *   step-4 : execute and process resultsets
 *   step-5 : close connection
 * 
 * 
 */

public class DBReadEx {

	public static void main(String[] args) throws SQLException {

//		step-1
		DriverManager.registerDriver(new Driver());

//		step-2
		String url = "jdbc:mysql://localhost:3306/shop_db";
		String user = "root";
		String password = "root1234";
		Connection connection = DriverManager.getConnection(url, user, password);
//		step-3

		String sql = "select * from shop_db.SHOP_USERS";
		Statement sqlStatement = connection.createStatement();
		ResultSet rs = sqlStatement.executeQuery(sql);

		List<String[]> lines = new ArrayList<String[]>();

		while (rs.next()) {
			String[] line = new String[3];
			line[0] = rs.getString(1);
			line[1] = rs.getString(2);
			line[2] = rs.getString(3);
			lines.add(line);
		}

		String[][] data = new String[lines.size()][0];
		lines.toArray(data);

		connection.close();

	}

}
