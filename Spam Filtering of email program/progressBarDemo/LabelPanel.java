package progressBarDemo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LabelPanel extends JPanel{
	private JLabel emailSender;
	public JTextField mailTextField;
	Connection connect=null;
	ResultSet rst=null;
	PreparedStatement pst=null;
	
	public LabelPanel(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		emailSender=new JLabel("Welcome");
		emailSender.setPreferredSize(new Dimension(90,30));
		emailSender.setFont(new Font("Times New Roman",Font.BOLD,15));
		//setBackground(new Color(135, 206, 250));
		mailTextField=new JTextField(18);
		mailTextField.setPreferredSize(new Dimension(100,20));
		mailTextField.setFont(new Font("Times new Roman",Font.BOLD,15));
		
		//mailTextField.setBackground(new Color(175, 238, 238));
		mailTextField.setEditable(false);
		add(emailSender);
		add(mailTextField);
		
	}
	
	public void getSecondMailAdd(){
		mailTextField.getText();
	}

}
