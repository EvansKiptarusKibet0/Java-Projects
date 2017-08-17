package iHub.app.user1;

import iHub.app.helper.UserBehavour;
import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;

public class UserLogin implements UserBehavour{
	private JDialog frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private Connection connect=null;
	private PreparedStatement pst=null;
	private ResultSet rst=null;
	private JLabel label;
	
	public UserLogin() {
		initialize();
		connect=iHub.app.helper.connectDB.connDB();
	}
	private void initialize() {
		frame = new JDialog();
		frame.setTitle("Remote Reference App");
		frame.setBounds(160, 80, 885, 492);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "User1 Login", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 849, 431);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(62, 103, 125, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(62, 180, 125, 14);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(214, 102, 191, 23);
		textField.setFont(new Font("Times New Roman",Font.BOLD,15));
		textField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				passwordField.requestFocusInWindow();
			}
			
		});
		textField.setForeground(Color.BLUE);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 179, 191, 23);
		passwordField.setFont(new Font("Times New Roman",Font.BOLD,15));
		passwordField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			loginUser();
			
			}
			
		});
		passwordField.setForeground(Color.BLUE);
		panel.add(passwordField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBackground(Color.LIGHT_GRAY);
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginUser();
			}
			
		});
		btnSubmit.setBounds(214, 279, 89, 23);
		panel.add(btnSubmit);
		
		JButton btnClear = new JButton("Reset");
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setForeground(Color.BLUE);
		btnClear.setFocusPainted(false);
		btnClear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				clearLogin();
			}
			
		});
		btnClear.setBounds(327, 279, 89, 23);
		panel.add(btnClear);
		
		label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(214, 235, 230, 14);
		panel.add(label);
	}
	
	
	
	
	
	@Override
	public void loginUser() 
	{
		
	String user=textField.getText();
	String pass=passwordField.getText();
	
	if(!user.equals("")&&!pass.equals("")){
		
		try{
		
			String sqlLogin="select username,password from tb_profiles where username=? and password=?";
			pst=connect.prepareStatement(sqlLogin);
			pst.setString(1,user);
			pst.setString(2,pass);
			rst=pst.executeQuery();
			if(rst.next()){
				frame.dispose();
				new UserMenuArea();
				
			}else{
				label.setText("Wrong username or password,try again");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	else{
		label.setText("Fields cannot be null");
	}
	}
	
	@Override
	public void clearLogin() {
		textField.setText("");
		passwordField.setText("");
		label.setText("");
		
	}
}
