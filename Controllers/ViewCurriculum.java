package controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dao.CurriculumDao;
import models.Course;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class ViewCurriculum extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCurriculum frame = new ViewCurriculum();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	
	public ViewCurriculum(String uid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectBatch = new JLabel("Select Batch");
		lblSelectBatch.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSelectBatch.setBounds(413, 30, 147, 25);
		contentPane.add(lblSelectBatch);
		
		
		 String batchList[]={"Y15","Y16","Y17"};        
		JComboBox comboBox = new JComboBox(batchList);
		comboBox.setBounds(176, 90, 94, 24);
		
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 152, 600, 400);
		contentPane.add(scrollPane);
		
		JButton btnOk = new JButton("OK");
		String[] column = {"CourseID",
                "Name",
                "Type",
                "Credits","Semester"};
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String batch = (String)comboBox.getSelectedItem(); 
				int sum=0;
				CurriculumDao cd = new CurriculumDao();
				try {
						for(int i=0;i<8;i++)
						{
							Course c[] = cd.getCurriculumDetails(batch,i+1);
							sum+= c.length;
						}
						
					
					
					System.out.println(sum);
					
					Object data[][] = new Object[sum+8][5];
					int p=0;
					
					for(int i=0;i<8;i++)
					{
						Course d[] = cd.getCurriculumDetails(batch,i+1);
						int length = d.length;
						System.out.println(length);
						
						
						
						for(int j=0;j<length;j++)
						{
							data[p][0] = d[j].getCourseID();
							data[p][1] = d[j].getName();
							data[p][2] = d[j].getType();
							data[p][3] = d[j].getCredits();
							data[p][4]= i+1;
							p++;
						}
						data[p][0]="";
						data[p][1]="";
						data[p][2]="";
						data[p][3]="";
						data[p][4]="";
						p++;
					}
					
					
					JTable table = new JTable(data, column);
					
					scrollPane.setViewportView(table);
					
					
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnOk.setBounds(615, 90, 117, 25);
		contentPane.add(btnOk);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s="AD101";
				if(uid.equals(s)) {
					AdminHome ah = new AdminHome(uid);
					ah.setVisible(true);
					contentPane.setVisible(false);
				}
				else {
				HomePage hp = new HomePage(uid);
				hp.setVisible(true);
				contentPane.setVisible(false);
				}
				
			}
		});
		btnBack.setBounds(394, 582, 117, 25);
		contentPane.add(btnBack);
		
		
		
		
	}
}
