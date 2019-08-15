package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.CourseFeedback;

public class ViewFeedbackDao {
	
	Connection conn = DbConnection.getConn();
	
	public CourseFeedback[] ViewFeedback() {
		int rows=0;
		String sql1 = "select count(*) from CourseFeedback;";
		PreparedStatement stmt1;
		try {
			stmt1 = conn.prepareStatement(sql1);
			ResultSet rs1 = stmt1.executeQuery(sql1);
			while(rs1.next()) {
				rows=rs1.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(rows);
		CourseFeedback cf[] = new CourseFeedback[rows];
		String sql = "Select * from CourseFeedback;";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int j=0;
			//System.out.println("S1");
			while(rs.next()) {
				cf[j]=new CourseFeedback();
				cf[j].setCourseId(rs.getString(1));
				cf[j].setUserId(rs.getString(2));
				cf[j].setRating1(rs.getString(3));
				cf[j].setRating2(rs.getString(4));
				cf[j].setRating3(rs.getInt(5));
				cf[j].setFeedbackId(rs.getString(6));
				j++;
				//System.out.println(rs.getString(1)+" "+rs.getString(2));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cf;
		
	}

}
