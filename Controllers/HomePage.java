package controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DbConnection;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	


	public HomePage(String uid) {
		frame = new JFrame();
		
		
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(56, 179, 70, 15);
		contentPane.add(label);
		
		JButton btnViewExistingCurriculum = new JButton("View Existing Curriculum");
		btnViewExistingCurriculum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewCurriculum vc =new ViewCurriculum(uid);
				vc.setVisible(true);
				
				frame.dispose();
				DbConnection dbc = new DbConnection();
				
			}
		});
		btnViewExistingCurriculum.setBounds(98, 73, 248, 25);
		contentPane.add(btnViewExistingCurriculum);
		
		JButton btnGiveFeedback = new JButton("Give Feedback");
		btnGiveFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GiveFeedback gf = new GiveFeedback(uid);
				gf.setVisible(true);
				frame.dispose();
			}
		});
		btnGiveFeedback.setBounds(98, 160, 248, 25);
		contentPane.add(btnGiveFeedback);
		
		JButton btnL = new JButton("Logout");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lp = new Login();
				frame.dispose();
				
				
			}
		});
		btnL.setBounds(153, 223, 117, 25);
		contentPane.add(btnL);
	}

}
