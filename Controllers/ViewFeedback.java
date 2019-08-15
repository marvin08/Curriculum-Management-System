package controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ViewFeedbackDao;
import models.CourseFeedback;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewFeedback extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFeedback frame = new ViewFeedback();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ViewFeedback(String uid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 35, 750, 524);
		contentPane.add(scrollPane);
		
		String[] column = {"CourseID",
                "UserId",
                "Rating1",
                "Rating2","Rating3","FeedbackId"};
		
		ViewFeedbackDao vfd = new ViewFeedbackDao();
		CourseFeedback[] cf= vfd.ViewFeedback();
		int len=cf.length;
		System.out.println(len);
		Object data[][] = new Object[len][6];
		
		for(int i=0;i<len;i++)
		{
			data[i][0] = cf[i].getCourseId();
			data[i][1] = cf[i].getUserId();
			data[i][2] = cf[i].getRating1();
			data[i][3] = cf[i].getRating2();
			data[i][4] = cf[i].getRating3();
			data[i][5] = cf[i].getFeedbackId();
		}
		JTable table = new JTable(data, column);
		
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AdminHome ah = new AdminHome(uid);
				ah.setVisible(true);
				contentPane.setVisible(false);
				
			}
		});
		btnBack.setBounds(278, 591, 117, 25);
		contentPane.add(btnBack);
		
 		
	}
}
