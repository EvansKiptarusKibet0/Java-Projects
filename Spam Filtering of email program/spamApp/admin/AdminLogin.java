package spamApp.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

//import UserAccount.AdminManagementFrame;

public class AdminLogin {

	private JFrame frame;
	private JTextField passwordField;
	private JPasswordField passwordField_1;
	private JButton btnBack;
	private JLabel labelBack;
	Connection connect=null;
	ResultSet rst=null;
	PreparedStatement pst=null;
	
	private JLabel labelDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AdminLogin() {
		initialize();
		//connect=UserAccount.connectDB.connDB();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tekton Pro Ext", Font.BOLD, 16));
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(100, 100, 930, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnBack=new JButton();
		labelBack=new JLabel("BACK");
		btnBack.setIcon(new ImageIcon("C:\\Users\\MyAccount\\Pictures\\back.jpg"));
		btnBack.setBounds(10,10,28,19);
		btnBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				MainClassPackage.MainClass.main(null);
			}
			
		});
		
		labelBack.setBounds(40,10,90,19);
		btnBack.setBackground(Color.CYAN);
		frame.getContentPane().add(btnBack);
		frame.getContentPane().add(labelBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Admin Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 255)));
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(180, 80, 578, 376);
		
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MyAccount\\Pictures\\login3.jpg"));
		lblNewLabel.setBounds(40, 56, 234, 201);
		panel.add(lblNewLabel);
		
		JLabel lblAdminId = new JLabel("Admin ID:");
		lblAdminId.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 14));
		lblAdminId.setBounds(303, 56, 73, 14);
		panel.add(lblAdminId);
		
		passwordField = new JTextField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passwordField_1.requestFocusInWindow();
			}
		});
		passwordField.setBounds(397, 56, 149, 20);
		panel.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		lblPassword.setBounds(303, 110, 73, 14);
		panel.add(lblPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminLogin();
			}
		});
		passwordField_1.setBounds(397, 109, 149, 20);
		panel.add(passwordField_1);
		
		labelDisplay = new JLabel("");
		labelDisplay.setForeground(new Color(255, 20, 147));
		labelDisplay.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		labelDisplay.setBounds(303, 166, 243, 18);
		panel.add(labelDisplay);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(102, 205, 170));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminLogin();
			}
		});
		btnSubmit.setBounds(358, 213, 89, 23);
		panel.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String admin=passwordField.getText();
				String password1=passwordField_1.getText();
				if(!admin.equals("")||!password1.equals("")){
				passwordField.setText("");
				passwordField_1.setText("");
				labelDisplay.setText("");
				}else{
					labelDisplay.setText("Fields already empty");
				}
			}
			
		});
		btnReset.setBackground(new Color(102, 205, 170));
		btnReset.setBounds(457, 213, 89, 23);
		panel.add(btnReset);
	}
	
	
public void adminLogin(){
		
		String y=passwordField.getText();
		@SuppressWarnings("deprecation")
		String x=passwordField_1.getText();

		if(!y.equals("")&&!x.equals("")){
		try{
			String sql="select username,password from admin where username=? and password=?";
			pst=connect.prepareStatement(sql);
			pst.setString(1,y);
			pst.setString(2,x );
			rst=pst.executeQuery();
			if(rst.next()){
			frame.dispose();
			   new AdminWeb();
			
			}else{
			    
					labelDisplay.setText("Warning, Wrong details Attempts remain");

				}
			}
		
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		}
		else
		{
			labelDisplay.setText("Fields cannot be null!!!");
		}
		
	}
	
	
		
		
		
	
	
	
	
}
