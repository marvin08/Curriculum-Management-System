package dao;

import java.sql.*;

public class DbConnection {
	
	
	
	static final String	JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String	DB_URL = "jdbc:mysql://localhost:3306/currManagement";
	static final String USER = "root";
	static final String PASSWORD = "rahul123";
		
	
	public static Connection getConn() {
		Connection conn = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	
}
