package com.wipro.hms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {

		String driver="oracle.jdbc.driver.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@Localhost:1521:xe";
		String username="system";
    	String password="royal";
        

    	//Register the Driver 
		Class.forName(driver);
		
	   //Establish the Connection
		Connection con = DriverManager.getConnection(jdbc_url,username,password);
		
		return con;
		
		
	}

}
