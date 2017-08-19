package InboxService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import InboxService.InboxContentViewer;
import InboxService.PanelBtnViewDisplay;
import InboxService.connectDB;

public class MainFrame {

	private JFrame frmMailboxDemo;
	private JButton btnCompose, btnInbox, btnOutbox, btnSettings, btnSpam;
	private JTextField reciever_textField;
	private JTextField subject_textField;
	private JTextField date_textField;
	public JTextField sender;
	public JTextField textField;
	public JTextField textField_1;
	
	public JPanel panel_1;
	private JPanel panel_2;
	public JPanel panel3;
	private JPanel panel4;
	
	private JPanel panelSettingsUser;
	public JTextField textFieldName;
	public JPasswordField textFieldPass;
	public JTextField textFieldNew;
	public JLabel labelFieldDialog;
	
	
	private JTextArea message_textArea;
	Connection connect = null;
	ResultSet rst = null;
	PreparedStatement pst = null;
	private DefaultTableModel model, model1, model2;
	private int day, month, year;
	public JTable table, table1, table2;
	private PanelBtnViewDisplay panelBtn;
	private JPanel panelWelcome;
	
	private JLabel labelMeg;
	private JPanel panelSendConfirm;
	
	private JLabel lblSender;
	
	private JLabel labelWel;
	
	private JPanel panelHeader;
	
	private MessageSendConfirm mConfirm;

	public MainFrame() {
		initialize();
		connect = connectDB.connDB();
	}

	private void initialize() {
		frmMailboxDemo = new JFrame();
		frmMailboxDemo.setTitle("Mailbox Demo");
		frmMailboxDemo.setVisible(true);
		frmMailboxDemo.setResizable(false);
		frmMailboxDemo.setBounds(100, 150, 1150, 600);
		frmMailboxDemo.setLocationRelativeTo(null);
		frmMailboxDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMailboxDemo.getContentPane().setLayout(null);
		frmMailboxDemo.getContentPane().setBackground(new Color(175, 238, 238));
		
		frmMailboxDemo.setLayout(null);//new BorderLayout());
		
	

		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		
		panel.setBounds(10, 11, 147, 435);
		//panel.setPreferredSize(new Dimension(147,435));
		panel.setVisible(true);
		frmMailboxDemo.getContentPane().add(panel, 	BorderLayout.WEST);
		panel.setLayout(null);
		//panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		btnCompose = new JButton("Compose");
		btnCompose.setBackground(Color.GRAY);
		btnCompose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				panelWelcome.setVisible(false);
				panel_2.setVisible(false);
				panel3.setVisible(false);
				panelSettingsUser.setVisible(false);
				panel4.setVisible(false);
				panelSendConfirm.setVisible(false);
				btnCompose.setBackground(Color.WHITE);
				btnInbox.setBackground(Color.GRAY);
				btnOutbox.setBackground(Color.GRAY);
				btnSettings.setBackground(Color.GRAY);
				panel.revalidate();
				panel.repaint();

			}
		});
		btnCompose.setBounds(10, 28, 89, 23);
		//btnCompose.setPreferredSize(new Dimension(100,27));
		panel.add(btnCompose);

		btnInbox = new JButton("Inbox");
		btnInbox.setBackground(Color.GRAY);
		btnInbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panelWelcome.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panelSettingsUser.setVisible(false);
				panelSendConfirm.setVisible(false);
				btnCompose.setBackground(Color.GRAY);
				btnInbox.setBackground(Color.WHITE);
				btnOutbox.setBackground(Color.GRAY);
				btnSpam.setBackground(Color.GRAY);
				btnSettings.setBackground(Color.GRAY);

				getDataFromDB();
			}
		});
		btnInbox.setBounds(10, 62, 89, 23);
		panel.add(btnInbox);

		btnOutbox = new JButton("Outbox");
		btnOutbox.setBackground(Color.GRAY);
		btnOutbox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel_1.setVisible(false);
                panel4.setVisible(false);
                panel_2.setVisible(false);
				panel3.setVisible(true);
				panelSettingsUser.setVisible(false);
				panelWelcome.setVisible(false);
				panelSendConfirm.setVisible(false);
				btnOutbox.setBackground(Color.WHITE);
				btnCompose.setBackground(Color.GRAY);
				btnInbox.setBackground(Color.GRAY);
				
				btnSettings.setBackground(Color.GRAY);
				btnSpam.setBackground(Color.GRAY);
				
				getOutboxData();
			}

		});
		btnOutbox.setBounds(10, 103, 89, 23);
		panel.add(btnOutbox);

		btnSpam = new JButton("Spam");
		btnSpam.setBackground(Color.GRAY);
		btnSpam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(true);
				panelSettingsUser.setVisible(false);
				panelSendConfirm.setVisible(false);
				panelWelcome.setVisible(false);
				btnCompose.setBackground(Color.GRAY);
				btnInbox.setBackground(Color.GRAY);
				btnOutbox.setBackground(Color.GRAY);
				btnSettings.setBackground(Color.CYAN);
				btnSpam.setBackground(Color.WHITE);
				getSpam();

			}

		});
		btnSpam.setBounds(10, 142, 89, 23);
		panel.add(btnSpam);

		btnSettings = new JButton("Settings");
		btnSettings.setBackground(Color.GRAY);
		btnSettings.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelSettingsUser.setVisible(true);
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel3.setVisible(false);
				panel4.setVisible(false);
				panelSendConfirm.setVisible(false);
				panelWelcome.setVisible(false);
				
			}
			
		});
		btnSettings.setBounds(10, 176, 89, 23);
		panel.add(btnSettings);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(10, 210, 89, 23);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frmMailboxDemo.dispose();
				new MainClassPackage.MainClass();
			}

		});
		panel.add(btnLogout);
		
		
		
		panelSettingsUser=new JPanel();
		panelSettingsUser.setVisible(false);
		panelSettingsUser.setBackground(Color.WHITE);
		panelSettingsUser.setBorder(new TitledBorder(null,"Change user password.", TitledBorder.LEADING, TitledBorder.TOP,null,null));
		panelSettingsUser.setBounds(158,57,900,400);
		panelSettingsUser.setLayout(null);
		
		JLabel labelName=new JLabel("Email ID:");
		labelName.setBounds(45,45,100,27);
		panelSettingsUser.add(labelName);
		
		textFieldName=new JTextField();
		
		textFieldName.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			textFieldName.setText(sender.getText());
			textFieldPass.requestFocusInWindow();
				
			}
			
		});
		textFieldName.setBounds(185,45,160,22);
		panelSettingsUser.add(textFieldName);
		
		JLabel labelPassName=new JLabel("Previous password:");
		labelPassName.setBounds(45,80,140,27);
		panelSettingsUser.add(labelPassName);
		
		textFieldPass=new JPasswordField();
		textFieldPass.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textFieldNew.requestFocusInWindow();
				
			}
			
		});
		textFieldPass.setBounds(185,80,160,22);
		panelSettingsUser.add(textFieldPass);
		
		JLabel labelFieldNew=new JLabel("New Password:");
		labelFieldNew.setBounds(45,115,140,27);
		panelSettingsUser.add(labelFieldNew);
		
		textFieldNew=new JPasswordField();
		textFieldNew.setBounds(185,115,160,22);
		panelSettingsUser.add(textFieldNew);
		
		labelFieldDialog=new JLabel(" ");
		labelFieldDialog.setBounds(65,155,130,27);
		labelFieldDialog.setForeground(Color.RED);
		panelSettingsUser.add(labelFieldDialog);
		
		
		JButton btnAcceptPass=new JButton("OK");
		btnAcceptPass.setBounds(130,200,100,27);
		btnAcceptPass.setBackground(Color.WHITE);
		btnAcceptPass.setFocusPainted(false);
		btnAcceptPass.setForeground(Color.CYAN);
		btnAcceptPass.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				String r_Email=textFieldName.getText();
				String r_prev=textFieldPass.getText();
				String r_new=textFieldNew.getText();
				
				if(!r_Email.equals("")&&!r_prev.equals("")&&!r_new.equals("")){
					if(!r_prev.equals(r_new)){
						
					try{
					String sqlUpdatePass="update new_user set password=? WHERE email=? AND password=?";
					pst=connect.prepareStatement(sqlUpdatePass);
					pst.setString(1, r_new);
					pst.setString(2, r_Email);
					pst.setString(3, r_prev);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "passwords changed successfully!!");
					textFieldPass.setText("");
					textFieldName.setText("");
					textFieldNew.setText("");
						
					}catch(Exception e){
						e.printStackTrace();
					}
						
					}else{
						labelFieldDialog.setText("New and old password cannot be same");
					}
					
				}else{
				labelFieldDialog.setText("Fields cannot be null!!!");
				}
				
				
		
				
			}
			
		});
		panelSettingsUser.add(btnAcceptPass);
		
		JButton btnCancelPass=new JButton("Clear");
		btnCancelPass.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textFieldName.setText("");
				textFieldPass.setText("");
				textFieldNew.setText("");
				
			}
			
		});
		btnCancelPass.setBounds(240,200,100,27);
		btnCancelPass.setBackground(Color.WHITE);
		btnCancelPass.setFocusPainted(false);
		btnCancelPass.setForeground(Color.CYAN);
		panelSettingsUser.add(btnCancelPass);
		
		
		
		
		
		
		frmMailboxDemo.getContentPane().add(panelSettingsUser);
		
		
		
		

		panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Inbox", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
	
		panel_2.setBounds(158, 57, 900, 400);
		frmMailboxDemo.getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout());

		JPanel panelTable = new JPanel();
		panelTable.setBounds(18, 7, 900, 400);
		model = new DefaultTableModel();
		model.addColumn("Sender");
		model.addColumn("Subject");
		model.addColumn("Date");
		model.addColumn("Message");

		table = new JTable(model);
		table.setShowVerticalLines(false);
		panelBtn = new PanelBtnViewDisplay();
		panelBtn.setBackground(Color.WHITE);
		JScrollPane Jpane=new JScrollPane(table);
		Jpane.getViewport().setBackground(Color.WHITE);
		panel_2.add(Jpane, BorderLayout.CENTER);
		
		//panel_2.add(new JScrollPane(table), BorderLayout.CENTER);
		panel_2.add(panelBtn, BorderLayout.SOUTH);

		
		panelBtn.btnView.setBackground(new Color(175, 238, 238));
		panelBtn.btnView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				displayViewTextArea();
			}

		});
		panelBtn.btnReport.setVisible(true);
		panelBtn.btnReport.setBackground(new Color(175, 238, 238));
		panelBtn.btnReport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				sendReportContentDb();
			}

		});
        panelBtn.btnDelete.setBackground(new Color(175, 238, 238));
		panelBtn.btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();
				String y=(String) table.getModel().getValueAt(i, 0);
				
				String z=sender.getText();
				
				try{
				String sqlDeleteItem="delete from mail_box where frommail=? and tomail=?";
				pst=connect.prepareStatement(sqlDeleteItem);
				pst.setString(1, y);
				pst.setString(2, z);
				pst.executeUpdate();
				model.removeRow(table.getSelectedRow());
				JOptionPane.showMessageDialog(null, "Message in Inbox deleted successfully");
				
				}catch(Exception n){
					n.printStackTrace();
				}
			}
		});
		
		panelSendConfirm=new JPanel();
		panelSendConfirm.setVisible(false);
		panelSendConfirm.setLayout(new BorderLayout());
		mConfirm=new MessageSendConfirm();
		panelSendConfirm.add(mConfirm, BorderLayout.NORTH);
		panelSendConfirm.setBorder(new TitledBorder(null,"Message Confirmation",TitledBorder.LEADING,TitledBorder.TOP,null,null));
		panelSendConfirm.setBounds(158,57,900,400);
		frmMailboxDemo.getContentPane().add(panelSendConfirm);
		
		
		
		panelWelcome=new JPanel();
		panelWelcome.setVisible(true);
		panelWelcome.setBounds(158,57,900,400);
		panelWelcome.setLayout(null);
		
		JPanel panelInner=new JPanel();
		panelInner.setBounds(60,60,400,100);
		JLabel labelX=new JLabel("You are now Logged in");
		labelX.setFont(new Font("Times New Roman",Font.BOLD,24));
		labelX.setBounds(70,80,200,40);
		panelInner.add(labelX);
		
		panelInner.setBackground(new Color(175, 238, 238));
		panelWelcome.add(panelInner);
		
		panelWelcome.setBackground(new Color(175, 238, 238));
		frmMailboxDemo.getContentPane().add(panelWelcome);
		frmMailboxDemo.revalidate();
		frmMailboxDemo.repaint();
		
		panel_1 = new JPanel();
		panel_1.setVisible(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Compose your mail",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(158, 57, 900, 400);
		frmMailboxDemo.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(21, 38, 46, 14);
		panel_1.add(lblTo);

		reciever_textField = new JTextField();
		reciever_textField.setBounds(77, 35, 194, 20);
		reciever_textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				subject_textField.requestFocusInWindow();
			}

		});

		panel_1.add(reciever_textField);
		reciever_textField.setColumns(10);

		JLabel lblSu = new JLabel("Subject:");
		lblSu.setBounds(21, 78, 46, 14);
		panel_1.add(lblSu);

		subject_textField = new JTextField();
		subject_textField.setBounds(77, 75, 194, 20);
		subject_textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				date_textField.requestFocusInWindow();
			}

		});

		panel_1.add(subject_textField);
		subject_textField.setColumns(10);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(21, 116, 46, 14);
		panel_1.add(lblDate);

		date_textField = new JTextField();
		date_textField.setBounds(77, 113, 194, 20);
		date_textField.setEditable(false);
		date_textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				date_textField.setText(getCurDate());
				message_textArea.requestFocusInWindow();
			}

		});

		
		panel_1.add(date_textField);
		date_textField.setColumns(10);

		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(21, 151, 56, 14);
		panel_1.add(lblMessage);

		message_textArea = new JTextArea();
		JScrollPane sp=new JScrollPane(message_textArea);
		sp.setFont(new Font("Times New Roman",Font.BOLD,15));
	    sp.setBounds(77, 146, 475, 140);
	    panel_1.add(sp);
	    
	    labelMeg=new JLabel("");
	    labelMeg.setFont(new Font("Times New Roman",Font.BOLD,15));
	    labelMeg.setForeground(Color.RED);
	    labelMeg.setBounds(600,260,200,27);
	    panel_1.add(labelMeg);
	    

		JButton btnSubmit = new JButton("Send");
		btnSubmit.setBounds(77, 312, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				//matchContent();
				getRecipientConfirm();
				
				
				reciever_textField.setText("");
				subject_textField.setText("");
			    date_textField.setText("");
				message_textArea.setText("");
				
			}

		});
		panel_1.add(btnSubmit);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(189, 312, 89, 23);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		panel_1.add(btnCancel);
		
		//top panel
        panelHeader=new JPanel();
        panelHeader.setVisible(true);
        panelHeader.setBounds(150,15,400,40);
        panelHeader.setBackground(new Color(175, 238, 238));
        panelHeader.setLayout(new FlowLayout(FlowLayout.LEFT));
        
		lblSender = new JLabel("Sender:");
		panelHeader.add(lblSender);
		lblSender.setBounds(203, 21, 120, 14);
		

		sender = new JTextField();
		sender.setEditable(false);
		sender.setBounds(359, 100, 128, 20);
		//frmMailboxDemo.getContentPane().add(sender);
		sender.setColumns(10);
		panelHeader.add(sender);
		
		
		frmMailboxDemo.getContentPane().add(panelHeader);

		panel3 = new JPanel();
		panel3.setVisible(false);
		panel3.setBorder(new TitledBorder(null, "Outbox", TitledBorder.LEADING,TitledBorder.TOP, null, null));
		panel3.setBounds(158, 57, 900, 400);
		frmMailboxDemo.getContentPane().add(panel3);
		panel3.setLayout(new BorderLayout());
		panel3.setBackground(Color.WHITE);

		
		model1 = new DefaultTableModel();
		model1.addColumn("Recipient");
		model1.addColumn("Subject");
		model1.addColumn("Date");
		model1.addColumn("Message");

		table1 = new JTable(model1);
		table1.setShowVerticalLines(false);
		panelBtn = new PanelBtnViewDisplay();
        JScrollPane jsp=new JScrollPane(table1);
        jsp.getViewport().setBackground(Color.WHITE);
        panel3.add(jsp, BorderLayout.CENTER);
		//panel3.add(new JScrollPane(table1), BorderLayout.CENTER);
		panel3.add(panelBtn, BorderLayout.SOUTH);

		panelBtn.btnReport.setVisible(false);
		panelBtn.btnDelete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int j=table1.getSelectedRow();
				String k=(String) table1.getModel().getValueAt(j, 0);
				
				String p=sender.getText();
				
				try{
				String sqlDeleteOutbox="delete from mail_box where tomail=? and frommail=?";
				pst=connect.prepareStatement(sqlDeleteOutbox);
				pst.setString(1, k);
				pst.setString(2, p);
				pst.executeUpdate();
				model1.removeRow(table1.getSelectedRow());
				JOptionPane.showMessageDialog(null, "Email sent to" +k+ "deleted successfully");
				
				}catch(Exception n){
					n.printStackTrace();
				}
			}
				
			
			
		});
		panelBtn.btnView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int index = table1.getSelectedRow();
				if (index > -1) {
					TableModel m = table1.getModel();

					String lec_mode = m.getValueAt(index, 0).toString();
					String lec_mode1 = m.getValueAt(index, 1).toString();
					String lec_mode2 = m.getValueAt(index, 2).toString();
					String lec_mode3 = m.getValueAt(index, 3).toString();

					InboxContentViewer v = new InboxContentViewer();
					v.textArea.append("TO:\t" + lec_mode + "\n");
					v.textArea.append("SUBJECT:\t" + lec_mode1 + "\n");
					v.textArea.append("DATE:\t" + lec_mode2 + "\n");
					v.textArea.append("MESSAGE:\t" + lec_mode3);

				}
			}

		});
		
		
		

		panel4 = new JPanel();
		panel4.setVisible(false);
		panel4.setBorder(new TitledBorder(null, "Spam messages...",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel4.setBounds(158, 57, 900, 400);
		panel4.setBackground(Color.WHITE);
		frmMailboxDemo.getContentPane().add(panel4);
		panel4.setLayout(new BorderLayout());

	
		model2 = new DefaultTableModel();
		model2.addColumn("Sender");
		model2.addColumn("Subject");
		model2.addColumn("Date");
		model2.addColumn("Message");

		table2 = new JTable(model2);
		table2.setShowVerticalLines(false);
		panelBtn = new PanelBtnViewDisplay();
		panelBtn.btnReport.setVisible(false);
		
		panelBtn.btnDelete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int p=table2.getSelectedRow();
				String km=(String) table2.getModel().getValueAt(p, 0);
				
				String c=sender.getText();
				
				try{
				String sqlDeleteOutbox="delete from spam_box where tomail=? and frommail=?";
				pst=connect.prepareStatement(sqlDeleteOutbox);
				pst.setString(1, c);
				pst.setString(2, km);
				pst.executeUpdate();
				model2.removeRow(table2.getSelectedRow());
				JOptionPane.showMessageDialog(null, "Spam sent to" +c+ "deleted successfully");
				
				}catch(Exception n){
					n.printStackTrace();
				}
				
				
				
				
				
			}
			
		});
		
		
		
		panelBtn.btnView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int index = table2.getSelectedRow();
				if (index > -1) {
					TableModel model2 = table2.getModel();

					String xmode = model2.getValueAt(index, 0).toString();
					String ymode1 = model2.getValueAt(index, 1).toString();
					String zmode2 = model2.getValueAt(index, 2).toString();
					String amode3 = model2.getValueAt(index, 3).toString();

					InboxContentViewer cv = new InboxContentViewer();
					cv.textArea.append("From:\t" + xmode + "\n");
					cv.textArea.append("Subject:\t" + ymode1 + "\n");
					cv.textArea.append("Date:\t" + zmode2+"\n");
					cv.textArea.append("Message:\t" + amode3);

				}

			}

		});

		//panel4.add(new JScrollPane(table2), BorderLayout.CENTER);
        JScrollPane scroll=new JScrollPane(table2);
        scroll.getViewport().setBackground(Color.WHITE);
        panel4.add(scroll, BorderLayout.CENTER);
		panel4.add(panelBtn, BorderLayout.SOUTH);

	}

	public void eSender() {
		String reciever = new String(reciever_textField.getText());
		String sendiii = sender.getText();
		String subject = new String(subject_textField.getText());
		String date = new String(date_textField.getText());
		String message = new String(message_textArea.getText());

		if (!sender.equals("") && !reciever.equals("") && !subject.equals("")
				&& !message.equals("") && !date.equals("")) {
			if (!sendiii.equals(reciever)) {

				try {
					String sql = "insert into mail_box(frommail,tomail,subject,date,message) values(?,?,?,?,?)";

					pst = connect.prepareStatement(sql);

					pst.setString(1, sender.getText());
					pst.setString(2, reciever_textField.getText());
					pst.setString(3, subject_textField.getText());
					pst.setString(4, date_textField.getText());
					pst.setString(5, message_textArea.getText());

					pst.execute();

					//JOptionPane.showMessageDialog(null,"Email send successfully!!!");
					panel_1.setVisible(false);
					panel_2.setVisible(false);
					panel3.setVisible(false);
					panel4.setVisible(false);
					panelWelcome.setVisible(false);
					panelSendConfirm.setVisible(true);
					
					
				   
                   String append1=">>"+sender.getText()+"  sent message to  "+reciever_textField.getText()+" On "+getCurDate()
                		   ;
					
					try{
					String sqlTraffic="insert into admin_traffic(datasent) values(?)";
					pst=connect.prepareStatement(sqlTraffic);
					pst.setString(1, append1);
					pst.execute();
					
					}catch(Exception e){
						e.printStackTrace();
					}
				}

				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, e);

				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Email cannnot be sent to itself");
			}
		}

		else {
			JOptionPane.showMessageDialog(null, "Fields cannot be empty");
		}
	}

	public void getDataFromDB() {
		String sender = "";
		String Subject = "";
		String Date = "";
		String Message = "";
		String send = this.sender.getText();
		if (!send.equals("")) {
			try {
				String q = "select frommail,subject,date,message from mail_box where tomail=?";
				pst = connect.prepareStatement(q);
				pst.setString(1, send);
				rst = pst.executeQuery();
				// for(int i=0;i<=table.getRowCount();i++){

				while (rst.next()) {
					sender = rst.getString("frommail");
					Subject = rst.getString("subject");
					Date = rst.getString("date");
					Message = rst.getString("message");

					model.addRow(new Object[] { sender, Subject, Date, Message });
					model.removeTableModelListener(table);
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Invalid sender");
		}
	}

	public String getCurDate() {
		GregorianCalendar date = new GregorianCalendar();
		day = date.get(Calendar.DAY_OF_MONTH);
		month = date.get(Calendar.MONTH);
		year = date.get(Calendar.YEAR);
		String curDate = day + "/" + month + "/" + year;
		return curDate;
	}

	public void getOutboxData() {
		String Recipient = "";
		String Subject = "";
		String Date = "";
		String Message = "";
		String send = this.sender.getText();
		if (!send.equals("")) {
			try {
				String q = "select tomail,subject,date,message from mail_box where frommail=?";
				String numberOfCol = "select count(*) from mail_box";
				pst = connect.prepareStatement(q);
				pst.setString(1, send);
				rst = pst.executeQuery();
				for (int i = 0; i <= numberOfCol.length(); i++) {

					if (rst.next()) {
						Recipient = rst.getString("tomail");
						Subject = rst.getString("subject");
						Date = rst.getString("date");
						Message = rst.getString("message");
						model1.addRow(new Object[] { Recipient, Subject, Date,
								Message });
						model1.removeTableModelListener(table1);
					}
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Invalid sender");
		}
	}

	public void displayViewTextArea() {
		int index = table.getSelectedRow();
		if (index > -1) {
			TableModel m = table.getModel();

			String lec_mode = m.getValueAt(index, 0).toString();
			String lec_mode1 = m.getValueAt(index, 1).toString();
			String lec_mode2 = m.getValueAt(index, 2).toString();
			String lec_mode3 = m.getValueAt(index, 3).toString();

			InboxContentViewer v = new InboxContentViewer();
			v.textArea.append("Read your Message:\n\n");
			v.textArea.append("From: " + lec_mode + "\n");
			v.textArea.append("Subject: " + lec_mode1 + "\n");
			v.textArea.append("Date: " + lec_mode2+"\n");
			v.textArea.append("Message: " + lec_mode3);

		}
	}

	public void sendReportContentDb() {
		try {
			int col = table.getSelectedRow();
			String recipent1 = (String) table.getValueAt(col, 0);
			String subject1 = (String) table.getValueAt(col, 1);
			String date1 = (String) table.getValueAt(col, 2);
			String message1 = (String) table.getValueAt(col, 3);
			try {
				connect.setAutoCommit(false);
				String sq = "insert into dbreport(tomail,subject,date,message) values(?,?,?,?)";
				pst = connect.prepareStatement(sq);
				pst.setString(1, recipent1);
				pst.setString(2, subject1);
				pst.setString(3, date1);
				pst.setString(4, message1);
				pst.addBatch();

				JOptionPane.showMessageDialog(null, "reported succeessfully");

			} catch (Exception ep) {
				JOptionPane.showMessageDialog(null, ep.getMessage());
			}

			pst.executeBatch();
			connect.commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}
	
	
	
public void matchContent() 
{
String Message = message_textArea.getText();
String[] messageSnippet=Message.split("\\s+");

ArrayList<String> result=new ArrayList<String>();

        try{
        	Statement st=connect.createStatement();
        	String s="select keyword from admin_block";
        	rst=st.executeQuery(s);
        	while(rst.next())
        	{
        		String stn=new String();
        		stn=rst.getString("keyword");
        	    result.add(stn);
        	    
        	boolean isEqual=false;    
    for(int i=0;i<result.size();i++){
	for(int j=0;j<messageSnippet.length;j++){
		
		 if(result.get(i).equals(messageSnippet[j])){
			 isEqual=true;
				spamSend();
				break;

			 } 
		 
		 else{
			 isEqual=false;	
			 }
	 }
	if((result.size()-1)==i&&isEqual){
		 matchDomain();
	}
      
 }
        	}
 
 
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        }
		
		
		
		
		/*
		if (!getMessage.equals("")) {
			try {
				String sqlContent = "SELECT keyword from admin_block where keyword=?";
				pst = connect.prepareStatement(sqlContent);
				pst.setString(1, getMessage);
				rst = pst.executeQuery();
				if (rst.next()) {

					spamSend();

				} else {

					matchDomain();
				}

			} catch (Exception ey) {
				JOptionPane.showMessageDialog(null, ey);
			}
		}
		
	}
	*/


	public void matchDomain() {
		String getDom = sender.getText();
		if (!reciever_textField.equals("")) {
			try {
				String sqlDomain = "select tomail from dbreport where tomail=?";
				pst = connect.prepareStatement(sqlDomain);
				pst.setString(1, getDom);
				rst = pst.executeQuery();
				if (rst.next()) {

					spamSend();

				} else {
					eSender();
				}

			} catch (Exception ew) {
				JOptionPane.showMessageDialog(null, ew);
			}
		}
	}

	public void spamSend() {
		String reciev = new String(reciever_textField.getText());
		String sen = sender.getText();
		String sub = new String(subject_textField.getText());
		String d = new String(date_textField.getText());
		String mes = new String(message_textArea.getText());

		if (!sender.equals("") && !reciev.equals("") && !sub.equals("")
				&& !mes.equals("") && !d.equals("")) {
			if (!sen.equals(reciev)) {

				try {
					String sqlSpam = "insert into spam_box(frommail,tomail,subject,date,message) values(?,?,?,?,?)";

					pst = connect.prepareStatement(sqlSpam);

					pst.setString(1, sender.getText());
					pst.setString(2, reciever_textField.getText());
					pst.setString(3, subject_textField.getText());
					pst.setString(4, date_textField.getText());
					pst.setString(5, message_textArea.getText());

					pst.execute();

					//JOptionPane.showMessageDialog(null,"Email send successfully!!!");
					panel_1.setVisible(false);
					panel_2.setVisible(false);
					panel3.setVisible(false);
					panel4.setVisible(false);
					panelWelcome.setVisible(false);
					panelSendConfirm.setVisible(true);
					
				
					
					String append1=">>"+sender.getText()+"  sent spam to  "+reciever_textField.getText()+" On "+getCurDate();
					
					try{
					String sqlTraffic="insert into admin_traffic(datasent) values(?)";
					pst=connect.prepareStatement(sqlTraffic);
					pst.setString(1, append1);
					pst.execute();
					
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);

				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Email cannnot be sent to itself");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Fields cannot be empty");
		}
	}

	public void getSpam() {
		String sender1 = "";
		String Subject1 = "";
		String Date1 = "";
		String Message1 = "";
		
		String send1 = this.sender.getText();
		if (!send1.equals("")) {
			try {
				String sqlOutput = "select frommail,subject,date,message from spam_box where tomail=?";
				pst = connect.prepareStatement(sqlOutput);
				pst.setString(1, send1);
				rst = pst.executeQuery();

					if (rst.next()) {
						sender1 = rst.getString("frommail");
						Subject1 = rst.getString("subject");
						Date1 = rst.getString("date");
						Message1 = rst.getString("message");
						model2.addRow(new Object[] { sender1, Subject1, Date1,
								Message1 });
						model2.removeTableModelListener(table2);

					}
				

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Invalid sender");
		}
	}
	
	
	
	public void getUsername(){
		String userName=sender.getText();
		try{
		String sqlUsername="Select username from new_user where email=?";
		pst=connect.prepareStatement(sqlUsername);
		pst.setString(1, sender.getText());
		pst.executeQuery();
		
		labelWel.setText("Welcome\t"+sqlUsername);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
public void getRecipientConfirm(){
String confirmEmail=reciever_textField.getText();
String s = sender.getText();
String t = subject_textField.getText();
String d = date_textField.getText();
String m = message_textArea.getText();


if(!confirmEmail.equals("")&&!s.equals("")&&!t.equals("")&&!d.equals("")&&!m.equals("")){

	if(Pattern.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", reciever_textField.getText()))
	try{
		String sqlConf="select email from new_user where email=?";
		pst=connect.prepareStatement(sqlConf);
		pst.setString(1,confirmEmail);
		rst=pst.executeQuery();
		if(rst.next()){
			//matchContent();
			matchDomain();
		}
		else{
			//JOptionPane.showMessageDialog(null, "Invalid email addresss,Try again");
			labelMeg.setText("Invalid email Address");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}else{
		//JOptionPane.showMessageDialog(null, "Wrong email format,Check and try again");
		labelMeg.setText("Wrong email format,Try again");
	}
}else{
	labelMeg.setText("Fields are null,fill and try again");
}
}

}

