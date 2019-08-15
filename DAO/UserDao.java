package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import models.Users;

public class UserDao {
	Connection conn = DbConnection.getConn();
	
	public Users getUserDetail(String id) throws SQLException {
		Users u1 = new Users();
		String sql= "select * from Users where UserID=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs =  stmt.executeQuery();
		while(rs.next()) {
			u1.setId(rs.getString(1));
			u1.setName(rs.getString(2));
			u1.setType(rs.getString(3));
			
		}
		return u1;
	}
	
	public boolean auth(String userId,String pass) throws SQLException {
		String sql= "select * from Users where UserID=? and Password=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, userId);
		stmt.setString(2, pass);
		ResultSet rs =  stmt.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}
}
