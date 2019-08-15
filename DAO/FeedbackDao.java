package dao;

import java.sql.*;

import models.CourseFeedback;

public class FeedbackDao {
	
	Connection conn = DbConnection.getConn();
	
	public void FeedbackDetails(CourseFeedback cf) {
		
		
		String cid = cf.getCourseId();
		String uid = cf.getUserId();
		String fid = cid + uid;
		int r3 = cf.getRating3();
		String r1 = cf.getRating1();
		String r2 = cf.getRating2();
		
		
		String sql= "Insert into CourseFeedback values(?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cid);
			stmt.setString(2, uid);
			stmt.setString(3, r1);
			stmt.setString(4, r2);
			stmt.setInt(5, r3);
			stmt.setString(6, fid);
			  stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
