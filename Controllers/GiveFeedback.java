package controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DbConnection;
import dao.FeedbackDao;
import dao.UserDao;
import models.CourseFeedback;
import models.Users;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GiveFeedback extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiveFeedback frame = new GiveFeedback();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public GiveFeedback(String uid) {
		
		Connection conn = DbConnection.getConn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelevanceOfCourse = new JLabel("Relevance of Course Based on Market Trends");
		lblRelevanceOfCourse.setBounds(12, 180, 426, 15);
		contentPane.add(lblRelevanceOfCourse);
		
		 String batchList[]={"Y15","Y16","Y17"};  
		JComboBox comboBox = new JComboBox(batchList);
		comboBox.setBounds(62, 118, 98, 24);
		      
			
		contentPane.add(comboBox);
		
		
		JLabel lblSelectBatch = new JLabel("Select Batch");
		lblSelectBatch.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSelectBatch.setBounds(49, 43, 170, 31);
		contentPane.add(lblSelectBatch);
		
		JLabel lblSelectCourse = new JLabel("Select Course");
		lblSelectCourse.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSelectCourse.setBounds(368, 47, 170, 23);
		contentPane.add(lblSelectCourse);
		
		 String courses[]={"COA","CP","OS","IMAD","EFE"};  
		JComboBox comboBox_1 = new JComboBox(courses);
		comboBox_1.setBounds(391, 118, 98, 24);
		contentPane.add(comboBox_1);
		
		JLabel lblIsThisCourse = new JLabel("Is this Course Suitable For CSE Branch?");
		lblIsThisCourse.setBounds(12, 316, 397, 15);
		contentPane.add(lblIsThisCourse);
		
		JLabel lblNewLabel = new JLabel("Is this Course helpful in improving Problem Solving Skills?");
		lblNewLabel.setBounds(12, 390, 526, 15);
		contentPane.add(lblNewLabel);
		
		
		
		String rating3[]={"1","2","3","4","5"};        
		JComboBox comboBox_2 = new JComboBox(rating3);
		
		String rating2[]={"YES","NO"};        
		JComboBox comboBox_3 = new JComboBox(rating2);
		
		String rating1[]={"YES","NO"};        
		JComboBox comboBox_4 = new JComboBox(rating1);
		
	
		comboBox_2.setBounds(49, 207, 86, 24);
		contentPane.add(comboBox_2);
		
	
		comboBox_3.setBounds(49, 343, 86, 24);
		contentPane.add(comboBox_3);
		
		
		comboBox_4.setBounds(49, 417, 86, 24);
		contentPane.add(comboBox_4);
		
		
		CourseFeedback cf = new CourseFeedback();
		Users u = new Users();
		
		JButton btnSubmit = new JButton("Submit ");
		btnSubmit.setBounds(49, 509, 157, 25);
		contentPane.add(btnSubmit);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HomePage hp = new HomePage(uid);
				hp.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btnNewButton.setBounds(412, 509, 117, 25);
		contentPane.add(btnNewButton);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("S1");
				String batch = (String)comboBox.getSelectedItem(); 
				String course = (String)comboBox_1.getSelectedItem();
				String rr3 = (String)comboBox_2.getSelectedItem();
				String r2 = (String)comboBox_3.getSelectedItem();
				String r1 = (String)comboBox_4.getSelectedItem();
				//System.out.println("S2");
				int r3 = Integer.parseInt(rr3);
				//System.out.println(r3);
				cf.setRating1(r1);
				cf.setRating2(r2);
				cf.setRating3(r3);
				
				String cid;
				String sql= "select CourseID from Course where Name=?";
				
				PreparedStatement stmt;
				
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, course);
					ResultSet rs = stmt.executeQuery();
					while(rs.next())
					{
						cid = rs.getString(1);
						//System.out.println(cid);
						cf.setCourseId(cid);
						break;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				cf.setUserId(uid);
				
				
				FeedbackDao fd = new FeedbackDao();
				fd.FeedbackDetails(cf);
				
				JOptionPane.showMessageDialog(contentPane, "Feedback Successfully Submitted");
				
				 
				
			}
		});
		
		 
		
	}
}
