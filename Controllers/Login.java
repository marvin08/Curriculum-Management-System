package controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dao.DbConnection;
import dao.UserDao;
import models.Users;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 197, 70, 15);
		frame.getContentPane().add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 15));
		lblUsername.setBounds(62, 81, 144, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPassword.setBounds(62, 143, 138, 27);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(210, 72, 171, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(210, 147, 171, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DbConnection dbc = new DbConnection();
				String uid = textField.getText();
				String pass = textField_1.getText();
				
				UserDao ud = new UserDao();
				
				try {
					if(ud.auth(uid,pass))
					{
						Users u1 = ud.getUserDetail(uid);
						String type="ADMIN";
						if(u1.getType().equals(type)) {
							//System.out.println( u1.getType());
							
							AdminHome ah = new AdminHome(uid);
							ah.setVisible(true);
							frame.dispose();
						}
							
						else {
							HomePage hp = new HomePage(uid);
							hp.setVisible(true);
							frame.dispose();
						}
						}
						
					else {
						JOptionPane.showMessageDialog(frame, "Invalid User or Password");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(152, 197, 117, 25);
		frame.getContentPane().add(btnLogin);
		
		
		
	}
}
