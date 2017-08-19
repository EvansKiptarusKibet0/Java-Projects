package UserAccount;
import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class About {

	private JDialog frmSpamFilteringSoftware;

	public About() {
		initialize();
	}
	private void initialize() {
		frmSpamFilteringSoftware = new JDialog();
		frmSpamFilteringSoftware.getContentPane().setBackground(new Color(175, 238, 238));
		frmSpamFilteringSoftware.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "About", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(48, 35, 678, 433);
		frmSpamFilteringSoftware.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "About developer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panel_1.setBackground(new Color(175, 238, 238));
		panel_1.setBounds(10, 37, 508, 112);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("This software was developed by a java  programmer namely; Evans kiptarus kibet.");
		lblNewLabel.setBounds(10, 21, 472, 19);
		panel_1.add(lblNewLabel);
		
		JLabel lblHeIsCurrently = new JLabel("He is currently a bachelor of computer science student in Masinde muliro university");
		lblHeIsCurrently.setBounds(10, 41, 488, 14);
		panel_1.add(lblHeIsCurrently);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "About the software", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
		panel_2.setBackground(new Color(175, 238, 238));
		panel_2.setBounds(10, 171, 508, 206);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Since nowdays most people use email for vairious ways and purposes. Hence, ");
		lblNewLabel_1.setBounds(10, 27, 488, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("there is the need of safeguarding the confidentiality of the informstion being sent.");
		lblNewLabel_2.setBounds(10, 44, 488, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("This software was design and developed to demonistrate how to eliminate the spams");
		lblNewLabel_3.setBounds(10, 63, 488, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("in the user's mailboxes hence reducing the likehoodness of email attacks.");
		lblNewLabel_4.setBounds(10, 81, 488, 14);
		panel_2.add(lblNewLabel_4);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFocusPainted(false);
		btnBack.setBackground(new Color(135, 206, 250));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSpamFilteringSoftware.dispose();
				new MainClassPackage.MainClass();
				
			}
		});
		btnBack.setBounds(52, 399, 89, 23);
		panel.add(btnBack);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSpamFilteringSoftware.dispose();
				new Register();
			}
		});
		btnNext.setFocusPainted(false);
		btnNext.setBackground(new Color(135, 206, 250));
		btnNext.setBounds(151, 399, 89, 23);
		panel.add(btnNext);
		frmSpamFilteringSoftware.setTitle("Spam Filtering software");
		frmSpamFilteringSoftware.setVisible(true);
		frmSpamFilteringSoftware.setBounds(100, 100, 788, 541);
	    frmSpamFilteringSoftware.setLocationRelativeTo(null);
	    
		//frmSpamFilteringSoftware.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
