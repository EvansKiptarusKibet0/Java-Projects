package UserAccount;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.swing.text.AbstractDocument;
public class Register {
	private JFrame frmSpamFilteringSoftware;
	private JTextField textField;
	private JTextField lastnameText;
	private JTextField usernameText;
	private JTextField emailText;
	private JPasswordField passwordText;
	private JPasswordField repassText;
	private JLabel lblNewLabel;
	private Dimension dim;
	Connection connect=null;
	ResultSet rst=null;
	PreparedStatement pst=null;
	public Register() {
		initialize();
		connect=connectDB.connDB();
	}

	
	private void initialize() {
		frmSpamFilteringSoftware = new JFrame();
		frmSpamFilteringSoftware.getContentPane().setBackground(new Color(175, 238, 238));
		frmSpamFilteringSoftware.setVisible(true);
		frmSpamFilteringSoftware.setResizable(false);
		frmSpamFilteringSoftware.setSize(888, 541);
		int x=2;
		frmSpamFilteringSoftware.getRootPane().setWindowDecorationStyle(x);
		frmSpamFilteringSoftware.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				System.exit(0);
			}
		});
		
		
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		frmSpamFilteringSoftware.setLocation(dim.width/2-frmSpamFilteringSoftware.getSize().width/2, dim.height/2-frmSpamFilteringSoftware.getSize().height/2);
		
		//frmSpamFilteringSoftware.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpamFilteringSoftware.getContentPane().setLayout(null);
		
		JLabel lblCreateYourAccount = new JLabel("Create Your Account ");
		lblCreateYourAccount.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblCreateYourAccount.setBounds(208, 59, 190, 23);
		frmSpamFilteringSoftware.getContentPane().add(lblCreateYourAccount);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(100, 111, 69, 14);
		frmSpamFilteringSoftware.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(100, 150, 69, 14);
		frmSpamFilteringSoftware.getContentPane().add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(100, 189, 69, 14);
		frmSpamFilteringSoftware.getContentPane().add(lblUsername);
		
		JLabel lblUserEmail = new JLabel("User Email");
		lblUserEmail.setBounds(100, 226, 69, 14);
		frmSpamFilteringSoftware.getContentPane().add(lblUserEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(100, 264, 69, 14);
		frmSpamFilteringSoftware.getContentPane().add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password");
		lblReenterPassword.setBounds(100, 303, 114, 14);
		frmSpamFilteringSoftware.getContentPane().add(lblReenterPassword);
		
		textField = new JTextField();
		((AbstractDocument)textField.getDocument()).setDocumentFilter(new HelperClasses.CharFilter());
		textField.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						lastnameText.requestFocusInWindow();
					}
				});
		textField.setBounds(312, 108, 170, 20);
		frmSpamFilteringSoftware.getContentPane().add(textField);
		textField.setColumns(10);
		
		lastnameText = new JTextField();
		((AbstractDocument)lastnameText.getDocument()).setDocumentFilter(new HelperClasses.CharFilter());
		lastnameText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usernameText.requestFocusInWindow();
			}
		});
		lastnameText.setBounds(312, 147, 170, 20);
		frmSpamFilteringSoftware.getContentPane().add(lastnameText);
		lastnameText.setColumns(10);
		
		usernameText = new JTextField();
		((AbstractDocument)usernameText.getDocument()).setDocumentFilter(new HelperClasses.CharFilter());
		usernameText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emailText.requestFocusInWindow();
			}
		});
		usernameText.setBounds(312, 186, 170, 20);
		frmSpamFilteringSoftware.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		emailText = new JTextField();
		emailText.setBounds(312, 223, 170, 20);
		emailText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				passwordText.requestFocusInWindow();
				
			}
		});
		frmSpamFilteringSoftware.getContentPane().add(emailText);
		emailText.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(312, 336, 274, 14);
		frmSpamFilteringSoftware.getContentPane().add(lblNewLabel);
		
		passwordText = new JPasswordField();
		passwordText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				repassText.requestFocusInWindow();
			}
		});
		passwordText.setBounds(312, 261, 170, 20);
		frmSpamFilteringSoftware.getContentPane().add(passwordText);
		
		repassText = new JPasswordField();
		repassText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regAction();
			}
		});
		repassText.setBounds(312, 297, 170, 20);
		frmSpamFilteringSoftware.getContentPane().add(repassText);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.CYAN);
		btnSubmit.setFocusPainted(false);
		btnSubmit.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				regAction();    
				}	
		});
		btnSubmit.setBounds(100, 360, 89, 23);
		frmSpamFilteringSoftware.getContentPane().add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.CYAN);
		btnClear.setFocusPainted(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				textField.setText("");
				lastnameText.setText("");
				usernameText.setText("");
				emailText.setText("");
				passwordText.setText("");
				repassText.setText("");
				lblNewLabel.setText("");
				
				
			}
		});
		btnClear.setBounds(208, 360, 89, 23);
		frmSpamFilteringSoftware.getContentPane().add(btnClear);
		
		
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an Account?");
		lblAlreadyHaveAn.setBounds(100, 415, 156, 14);
		frmSpamFilteringSoftware.getContentPane().add(lblAlreadyHaveAn);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSpamFilteringSoftware.dispose();
				
				new MainClassPackage.MainClass();
				
			}
		});
		btnLogin.setBackground(new Color(64, 224, 208));
		btnLogin.setBounds(252, 411, 89, 23);
		frmSpamFilteringSoftware.getContentPane().add(btnLogin);
		
		
	}
	@SuppressWarnings("deprecation")
	public void regAction(){
		String fname=new String(textField.getText());
	    String lname=new String (lastnameText.getText());
		String uname=new String (usernameText.getText());
		String email=new String(emailText.getText());
		String pass=new String(passwordText.getPassword());
		String pass1=new String(repassText.getPassword());
		
		if(!fname.equals("")&&!lname.equals("")&&!uname.equals("")&&!email.equals("")&&!pass.equals("")&&!pass1.equals(""))
				{
			if(pass.equals(pass1)&&Pattern.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", emailText.getText()))
			{
	if(pass.length()>=4){
			
		try{
			String sql="insert into new_user(firstname,lastname,username,email,password) values(?,?,?,?,?)";
			pst=connect.prepareStatement(sql);
			pst.setString(1,textField.getText());
			pst.setString(2, lastnameText.getText());
			pst.setString(3, usernameText.getText());
			pst.setString(4, emailText.getText());
			pst.setString(5, passwordText.getText());
			
			pst.execute();
			frmSpamFilteringSoftware.dispose();
			MainClassPackage.MainClass.main(null);
			
		}
		catch(Exception e)
		{
			lblNewLabel.setText("Duplicate fields,Try again!!!");
		}
	}
	else{
		lblNewLabel.setText("Password should be more than 4 characters");
	}
		}

			else
			{
				lblNewLabel.setText("Passwords cannot match or Invalid email");
			
			}
				}
		else
		{
		lblNewLabel.setText("Fields cannot be empty");
			}
	
	}
}

	
	
