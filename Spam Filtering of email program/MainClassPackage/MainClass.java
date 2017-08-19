package MainClassPackage;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class MainClass {

	private JDialog frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	Connection connect=null;
	ResultSet rst=null;
	PreparedStatement pst=null;
	public static void main(String []args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new MainClass();
			}
			
		});
	}
	
	public MainClass() {
		initialize();
		//connect=UserAccount.connectDB.connDB();
	}
	private void initialize() {
		frame = new JDialog();
	
		frame.setBounds(100, 100, 915, 570);
		//frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		int x=5;
		frame.getRootPane().setWindowDecorationStyle(x);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				promptWindowClose();
			}
		});
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(32, 178, 170));
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
			
		});
		mnFile.add(mntmExit);
		JMenu mnAbout = new JMenu("About");
		mnAbout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnAbout);
		
		JMenuItem mntmAboutSoftware = new JMenuItem("About software");
		mntmAboutSoftware.setBackground(new Color(175, 238, 238));
		
		mntmAboutSoftware.addActionListener(new ActionListener(){
       
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				new UserAccount.About();
			}
			
		});
		mnAbout.add(mntmAboutSoftware);
		
		JMenuItem mntmAboutDeveloper = new JMenuItem("About developer");
		mntmAboutDeveloper.setBackground(new Color(175, 238, 238));
		mntmAboutDeveloper.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				new UserAccount.About();
			}
			
		});
		mnAbout.add(mntmAboutDeveloper);
		
		JMenu mnAccount = new JMenu("Account");
		mnAccount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnAccount);
		
		JMenuItem mntmRegister = new JMenuItem("Register");
		mntmRegister.setBackground(new Color(175, 238, 238));
		mntmRegister.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				new UserAccount.Register();
			}
			
		});
		mnAccount.add(mntmRegister);
		
		JMenuItem mntmAdminLogin = new JMenuItem("Admin Login");
		mntmAdminLogin.setBackground(new Color(175, 238, 238));
		mntmAdminLogin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				new spamApp.admin.AdminLogin().main(null);
			}
			
		});
		mnAccount.add(mntmAdminLogin);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnHelp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				new UserAccount.Help_User();
			}
			
		});
		menuBar.add(mnHelp);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 238, 433);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(175, 238, 238));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MyAccount\\Pictures\\download.jpg"));
		lblNewLabel.setBounds(0, 0, 238, 155);
		panel.add(lblNewLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBackground(Color.WHITE);
		btnHome.setFocusPainted(false);
		btnHome.setBounds(52, 178, 110, 23);
		panel.add(btnHome);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				//new firstproject.About();
			}
		});
		btnAbout.setBackground(new Color(175, 238, 238));
		btnAbout.setFocusPainted(false);
		btnAbout.setBounds(52, 213, 110, 23);
		panel.add(btnAbout);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UserAccount.Register();
			}
		});
		btnRegister.setBackground(new Color(175, 238, 238));
		btnRegister.setFocusPainted(false);
		btnRegister.setBounds(52, 247, 110, 23);
		panel.add(btnRegister);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				spamApp.admin.AdminLogin admin=new spamApp.admin.AdminLogin();
				admin.main(null);
				
			}
		});
		btnAdminLogin.setBackground(new Color(175, 238, 238));
		btnAdminLogin.setBounds(52, 281, 110, 23);
		btnAdminLogin.setFocusPainted(false);
		panel.add(btnAdminLogin);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				//new firstproject.Help_User();
			}
		});
		btnHelp.setBackground(new Color(175, 238, 238));
		btnHelp.setFocusPainted(false);
		btnHelp.setBounds(52, 315, 110, 23);
		panel.add(btnHelp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBounds(240, 0, 665, 143);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SPAM FILTER OF EMAIL PROGRAM");
		lblNewLabel_1.setFont(new Font("Script MT Bold", Font.BOLD, 18));
		lblNewLabel_1.setBounds(40, 29, 441, 79);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "User Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(175, 238, 238));
		panel_2.setBounds(240, 143, 665, 290);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEmailId = new JLabel("Email ID:");
		lblEmailId.setFont(new Font("Times New Roman",Font.BOLD,15));
		lblEmailId.setBounds(84, 67, 65, 14);
		panel_2.add(lblEmailId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman",Font.BOLD,15));
		lblPassword.setBounds(84, 120, 68, 14);
		panel_2.add(lblPassword);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passwordField.requestFocusInWindow();
			}
		});
		textField.setBounds(177, 64, 172, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginUser();
			}
		});
		passwordField.setBounds(177, 117, 172, 20);
		panel_2.add(passwordField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				loginUser();
				
			}
		});
		btnSubmit.setBackground(new Color(176, 196, 222));
		btnSubmit.setBounds(177, 209, 89, 23);
		panel_2.add(btnSubmit);
		
		JButton btnCancel = new JButton("Clear");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String x=textField.getText();
				String y=passwordField.getText();
				if(!x.equals("")&&!y.equals("")){
					textField.setText("");
					passwordField.setText("");
					
				}else if(x.equals("")&&y.equals("")){
					lblNewLabel_2.setText("Fields already cleared");
				}
			}
		});
		btnCancel.setBackground(new Color(176, 196, 222));
		btnCancel.setBounds(276, 209, 89, 23);
		panel_2.add(btnCancel);
		
		lblNewLabel_2= new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(177, 163, 206, 14);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(32, 178, 170));
	
		panel_3.setBounds(0, 430, 905, 67);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblDevelopedByEvans = new JLabel("Developed by: EVANS KIPTARUS KIBET");
		lblDevelopedByEvans.setForeground(Color.RED);
		lblDevelopedByEvans .setVisible(true);
		lblDevelopedByEvans.setBounds(573, 56, 231, 14);
		panel_3.add(lblDevelopedByEvans);
	}
	
	public void loginUser(){
		String emailUser=textField.getText();
		@SuppressWarnings("deprecation")
		String passUser=passwordField.getText();

		if(!emailUser.equals("")&&!passUser.equals("")){
		try{
			String sql="select email,password from new_user where email=? and password=?";
			pst=connect.prepareStatement(sql);
			pst.setString(1,emailUser);
			pst.setString(2,passUser );
			rst=pst.executeQuery();
			if(rst.next()){
				frame.dispose();
				progressBarDemo.MainFrame pbd=new progressBarDemo.MainFrame();
				pbd.labelPanel.mailTextField.setText(getMail());
				
				
			}else{
		lblNewLabel_2.setText("Invalid email or Wrong password, Try again!!");
				
		}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		}
		else
		{
		lblNewLabel_2.setText("Fields cannot be null!!!");
		}
	}

	public String getMail(){
		return textField.getText();
	}
	
	public void promptWindowClose(){
		String btnClick[]={"Yes","No"};
		int PromptResult=JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Warning!!!",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, btnClick, btnClick[1]);
		
		if(PromptResult==0){
			frame.dispose();
		}
	}
}
