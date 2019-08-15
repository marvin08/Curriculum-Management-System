package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Course;

public class CurriculumDao {
	Connection conn = DbConnection.getConn();
	public Course[] getCurriculumDetails(String batch,int k) throws SQLException {
		int count[] = new int[8];
		int i=0;
		String sql1 = "select count(CourseID) from Curriculum where Batch='Y16' group by Semester;";
		PreparedStatement stmt1 = conn.prepareStatement(sql1);
		ResultSet rs1 = stmt1.executeQuery(sql1);
		String sem = Integer.toString(k);
		while(rs1.next()) {
			count[i++]=rs1.getInt(1);
		}
		//System.out.println("Stage1");
		String sql= "select Course.CourseID, Course.Name, Course.Type, Course.Credits, Curriculum.Semester from Course, Curriculum where Curriculum.CourseID=Course.CourseID and Curriculum.Semester="+sem+" and Curriculum.Batch = 'Y16';";
		PreparedStatement stmt = conn.prepareStatement(sql);
		//stmt.setInt(1, 1);
		ResultSet rs = stmt.executeQuery(sql);
		Course[] c = new Course[count[k-1]];
		int j=0;
			while(rs.next()) {
				c[j]=new Course();
				c[j].setCourseID(rs.getString(1));
				c[j].setName(rs.getString(2));
				c[j].setType(rs.getString(3));
				c[j].setCredits(rs.getInt(4));
				//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
				j++;
			}
		return c;
	}
}
