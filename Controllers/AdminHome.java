package controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome(String uid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewExistingCurriculum = new JButton("View Existing Curriculum");
		btnViewExistingCurriculum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCurriculum vc =new ViewCurriculum(uid);
				vc.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnViewExistingCurriculum.setBounds(99, 54, 241, 25);
		contentPane.add(btnViewExistingCurriculum);
		
		JButton btnViewFeedbacks = new JButton("View Feedbacks");
		btnViewFeedbacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ViewFeedback vf = new ViewFeedback(uid);
				vf.setVisible(true);
				frame.dispose();
			}
		});
		btnViewFeedbacks.setBounds(134, 149, 172, 25);
		contentPane.add(btnViewFeedbacks);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login lp = new Login();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(164, 217, 117, 25);
		contentPane.add(btnNewButton);
	}

}
