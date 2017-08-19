package UserAccount;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.TitledBorder;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AdminLogin {

	private JFrame frmSpamFilteringOf;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	Connection connect=null;
	ResultSet rst=null;
	PreparedStatement pst=null;
	public AdminLogin() {
		initialize();
		connect=connectDB.connDB();
	}
	private void initialize() {
		frmSpamFilteringOf = new JFrame();
		frmSpamFilteringOf.setBackground(new Color(0, 139, 139));
		frmSpamFilteringOf.getContentPane().setBackground(new Color(216, 191, 216));
		frmSpamFilteringOf.setTitle("Spam Filtering of email");
		frmSpamFilteringOf.setVisible(true);
	
		frmSpamFilteringOf.setBounds(100, 100, 715, 464);
		frmSpamFilteringOf.setResizable(false);
		frmSpamFilteringOf.setLocationRelativeTo(null);
		frmSpamFilteringOf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmSpamFilteringOf.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent we){
				String btns[]={"Yes","No"};
				int PromptResult=JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Warning!!!",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, btns, btns[1]);
				
				if(PromptResult==0){
					System.exit(0);
				}
			}
				
		});
		frmSpamFilteringOf.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBorder(new TitledBorder(null, "Admin Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(135, 46, 379, 219);
		frmSpamFilteringOf.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 37, 77, 14);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 101, 77, 14);
		panel_1.add(lblPassword);
		
		//textField = new JTextField(20);
	
		textField_1=new JTextField("Enter your admin");
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent fe) {
				if(textField_1.getText().equals("Enter your admin")){
				textField_1.setText("");
				textField_1.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(textField_1.getText().isEmpty()){
					textField_1.setForeground(Color.GRAY);
					textField_1.setText("Enter your admin");
				}
			}
		});
		
		textField_1.setForeground(Color.GRAY);
		
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				passwordField.requestFocusInWindow();
			}
		});
		textField_1.setBounds(97, 34, 182, 20);
		
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminLogin();
			}
		});
		passwordField.setBounds(97, 98, 182, 20);
		panel_1.add(passwordField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				adminLogin();
				
				
			}
		});
		btnSubmit.setBackground(new Color(240, 248, 255));
		btnSubmit.setBounds(97, 166, 89, 23);
		panel_1.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setBackground(new Color(240, 248, 255));
		btnCancel.setBounds(213, 166, 89, 23);
		panel_1.add(btnCancel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		//lblNewLabel.setVisible(false);
		lblNewLabel.setBounds(97, 129, 205, 14);
		panel_1.add(lblNewLabel);
	}
	public void adminLogin(){
		
		String y=textField_1.getText();
		@SuppressWarnings("deprecation")
		String x=passwordField.getText();

		if(!y.equals("")&&!x.equals("")){
		try{
			String sql="select username,password from admin where username=? and password=?";
			pst=connect.prepareStatement(sql);
			pst.setString(1,y);
			pst.setString(2,x );
			rst=pst.executeQuery();
			if(rst.next()){
				frmSpamFilteringOf.dispose();
			    new AdminManagementFrame();
				
				
			}else{
				lblNewLabel.setText("Wrong increditials");
				
			}
		
		
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		}
		else
		{
			lblNewLabel.setText("Fields cannot be null!!!");
		}
		
	}
	
	public String getMail()
	{
		return textField_1.getText();
	}
		
		
		
		
	}

