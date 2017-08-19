package HelperClasses;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AdminPasswordChangeClass extends JFrame{
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField userText;
	private JPasswordField passText;
	
	
	public AdminPasswordChangeClass(){
		setTitle("My title");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,150,700,550);
		setResizable(false);
		setLayout(null);
		
		usernameLabel=new JLabel("Username");
		usernameLabel.setBounds(20,20,50,80);
		userText=new JTextField(25);
		add(usernameLabel);
		add(userText);
		
		passwordLabel=new JLabel("Password");
		passText=new JPasswordField(25);
		add(passwordLabel);
		add(passText);
		
		
	}
	
	
	public static void main(String []args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new AdminPasswordChangeClass();
				
			}
			
		});
	}

}
