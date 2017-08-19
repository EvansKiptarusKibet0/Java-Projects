package UserAccount;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;

import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminManagementFrame {

	private JFrame frame;
	private JTextField textField_1;
	private JComboBox<String> comboBox;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox_1;
	private JButton btnRefresh;
	private JButton btnDenyAccess;
	Connection connect=null;
	ResultSet rst=null;
	PreparedStatement pst=null;
	public AdminManagementFrame() {
		initialize();
		connect=connectDB.connDB();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 702, 479);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		mnFile.add(mntmExit);
		
		JMenu mnSettings = new JMenu("Settings");
		mnSettings.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnSettings);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnSettings.add(mntmChangePassword);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmLogout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
				new AdminLogin();
			}
			
		});
		mnSettings.add(mntmLogout);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 29, 666, 44);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminManagementPlatform = new JLabel("Admin Management platform");
		lblAdminManagementPlatform.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		lblAdminManagementPlatform.setBounds(77, 11, 521, 22);
		panel.add(lblAdminManagementPlatform);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 74, 299, 281);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblForbiddenKeywords = new JLabel("Forbidden keywords");
		lblForbiddenKeywords.setBounds(21, 27, 174, 14);
		panel_1.add(lblForbiddenKeywords);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 52, 167, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		btnDenyAccess = new JButton("Deny Access");
		btnDenyAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertDataToBlock();
			}
		});
		btnDenyAccess.setBounds(10, 203, 132, 23);
		panel_1.add(btnDenyAccess);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 174, 208, 14);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(319, 76, 357, 279);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblListOfBlocked = new JLabel("List of Blocked Keywords:");
		lblListOfBlocked.setBounds(31, 25, 161, 14);
		panel_2.add(lblListOfBlocked);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(175, 25, 141, 20);
		panel_2.add(comboBox);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String x=comboBox.getSelectedItem().toString();
				
				
					String sqlDelete="delete from admin_block where keyword=?";
					
				try{
					
					pst=connect.prepareStatement(sqlDelete);
					pst.setString(1, x);
					pst.executeUpdate();
					comboBox.removeItem(x);
					JOptionPane.showMessageDialog(null, x+"\tDeleted");
					
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				}
			
			}
			
		});
		btnRemove.setBounds(209, 221, 89, 23);
		panel_2.add(btnRemove);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				displayComboBox();
				displayComboBox_1();
				
			}
		});
		btnRefresh.setBounds(103, 221, 89, 23);
		panel_2.add(btnRefresh);
		
		JLabel lblBlockedEmails = new JLabel("Blocked emails:");
		lblBlockedEmails.setBounds(31, 84, 125, 14);
		panel_2.add(lblBlockedEmails);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(175, 81, 141, 20);
		panel_2.add(comboBox_1);
	}
	
	public void InsertDataToBlock(){
	String firstKeyword=textField_1.getText();
	
	
	if(!firstKeyword.equals("")){
		try{
		
			String sqlInsert="insert into admin_block(keyword) values(?)";
			
			pst=connect.prepareStatement(sqlInsert);
			
            pst.setString(1, textField_1.getText());
			pst.execute();
			lblNewLabel.setText("Successfully block the keywords");
			textField_1.setText("");
			
			//displayComboBox();
			
			clearComboBox();
		}catch(Exception excep){
			JOptionPane.showMessageDialog(null, excep);
		}
	}
		
		
	}
	
	public void displayComboBox(){
		try{
		Statement st=connect.createStatement();
		String fetch="select keyword from admin_block";
		rst=st.executeQuery(fetch);
		while(rst.next()){
			String pat=rst.getString("keyword");
			comboBox.addItem(pat);
			//comboBox.removeItemListener(null);
			if(comboBox.getItemCount()!=0){
				btnRefresh.setEnabled(false);
			    btnDenyAccess.setEnabled(false);
			}
		
		}
		}catch(Exception exe){
			JOptionPane.showMessageDialog(null, exe);
		}
		
	}

	
	public void displayComboBox_1(){
		try{
		Statement st=connect.createStatement();
		String sel="select tomail from dbreport";
		rst=st.executeQuery(sel);
		while(rst.next()){
			String pat1=rst.getString("tomail");
			comboBox_1.addItem(pat1);
			btnDenyAccess.setEnabled(false);
		
		}
		}catch(Exception exe){
			JOptionPane.showMessageDialog(null, exe);
		}
		
	}
	
	public void clearComboBox(){
		comboBox.removeAllItems();
		comboBox.removeAllItems();
		
		if(comboBox.equals("")&&comboBox.equals("")){
			displayComboBox();
			displayComboBox_1();
		}
	}

	
}
