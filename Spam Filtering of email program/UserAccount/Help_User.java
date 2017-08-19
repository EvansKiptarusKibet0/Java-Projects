package UserAccount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Help_User {

	private JDialog frame;

	
	
	public Help_User() {
		initialize();
	}

	
	private void initialize() {
		frame = new JDialog();
		frame.setVisible(true);

		frame.setBounds(150, 100, 715, 471);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	   frame.setLayout(new BorderLayout());
	   
	   String help="For the user to use this facility,He or she should;\n\n"
	   		+ "1.Create the account through registration and login\n"
	   		+ "2.Login to access your inbox\n"
	   		+ "3.User can view inbox, Outbox and Spam messages or changed password\n"
	   		+ "4.If user found a suspecious message he/she should report it to admin"
	   		+ ""
	   		+ "For the admin,he/she should;\n\n"
	   		+ "a.Login to the admin area using admin and password provided by the developer\n"
	   		+ "b.Admin should view the traffic send,block keywords and the reported emails\n"
	   		+ "c.Admin can delete block keywords and reported mails";
	   
	   JPanel panelTop=new JPanel();
	   panelTop.setLayout(new FlowLayout(FlowLayout.CENTER));
	   panelTop.setBackground(new Color(175, 238, 238));
	   JLabel labelNav=new JLabel("UserHelp");
	   labelNav.setPreferredSize(new Dimension(130,27));
	   labelNav.setFont(new Font("Times New Roman",Font.BOLD,18));
	   panelTop.add(labelNav);
	   
	   JPanel panelCenter=new JPanel();
	   panelCenter.setLayout(new BorderLayout());
	   
	   JTextArea textA=new JTextArea(help);
	   textA.setEditable(false);
	   JScrollPane pane=new JScrollPane(textA);
	   textA.setPreferredSize(new Dimension(100,27));
	   panelCenter.add(pane);
	   
	   frame.add(panelTop, BorderLayout.NORTH);
	   frame.add(panelCenter, BorderLayout.CENTER);
	   
			
			
			
	}
	
	public static void main(String []args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new Help_User();
				
			}
			
		});
	}


}
