package spamApp.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class AdminWeb{
	private JPanel panelEmail;
	
	
	private JButton btnView;
	private JButton btnDelete;
	private JButton btnLogout;
	private JButton btnCMD;
	private JButton btnSettings;
	
	
	private JPanel topPanelmain;
	private JPanel panelToolbar;
	
	private JPanel panelBody;
	private JPanel panelMessage;
	private JPanel panelEmailDisplay;
	private JTable table;
	
	private JPanel panelBlockKeywords;
	private JTabbedPane pane;
	
	private JPanel panelTable;
	
	private JList colorList;
	private  String[]colorNames={};
	
	public DefaultListModel model;
	
	private JTextArea cmdtext;
	
	private JTextField textAdmin;
	private JTextField textPassOne;
	
	private JLabel labelWarning;
	
	private JPanel panelWel;
	
	Connection connect=null;
	ResultSet rst=null;
	PreparedStatement pst=null;
	
	
	public AdminWeb()
	{
		initComp();
		//connect=UserAccount.connectDB.connDB();
	}
	
	
	
	public void initComp(){
	JFrame frm=new JFrame();
	frm.setTitle("Admin Email Monitoring");
	frm.setSize(1000,650);
	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frm.setLocationRelativeTo(null);
	frm.setVisible(true);
	frm.setLayout(new BorderLayout());
	
	//panelTop added here................
	topPanelmain=new JPanel();
	topPanelmain.setLayout(new FlowLayout(FlowLayout.RIGHT));
	btnLogout=new JButton("Logout");
	btnLogout.setBackground(Color.RED);
	btnLogout.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			frm.dispose();
			
			new AdminLogin().main(null);
			
		    
			
		}
		
	});
	topPanelmain.add(btnLogout);
	topPanelmain.setBackground(new Color(175, 238, 238));
	frm.add(topPanelmain, BorderLayout.NORTH);
	
	
	
	
     panelBody=new JPanel();
	panelBody.setLayout(new BorderLayout());
	frm.add(panelBody, BorderLayout.CENTER);
	
	
	
	
	
	
	
//paneltoobar added to frm
	panelToolbar=new JPanel();
	panelToolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
	panelToolbar.setPreferredSize(new Dimension(260,600));
	panelToolbar.setBackground(new Color(175, 238, 238));
	btnView=new JButton("Spam Emails");
	btnView.setPreferredSize(new Dimension(260,27));
	
	btnView.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent evt){
			btnView.setBackground(Color.WHITE);
		}
		public void mouseExited(MouseEvent e){
			//btnView.setBackground(Color.WHITE);
			btnView.setBackground(UIManager.getColor(new Color(175, 238, 238)));
		}
	});
	
	
	btnView.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			pane.removeTabAt(0);
			
			getBlockEmails();
			
			btnView.setEnabled(false);
			btnDelete.setEnabled(true);
			btnSettings.setEnabled(true);
			btnCMD.setEnabled(true);
		}
		
	});
	btnView.setBackground(new Color(175, 238, 238));
	
	
	
	btnDelete=new JButton("Keywords Block"); 
	colorList=new JList(colorNames);
	colorList.setVisibleRowCount(5);
	colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	btnDelete.setPreferredSize(new Dimension(260,27));
	btnDelete.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent evt){
			btnDelete.setBackground(Color.WHITE);
		}
		public void mouseExited(MouseEvent e){
			//btnView.setBackground(Color.WHITE);
			btnDelete.setBackground(UIManager.getColor(new Color(175, 238, 238)));
		}
	});
	
	btnDelete.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			btnView.setEnabled(true);
			btnSettings.setEnabled(true);
			btnCMD.setEnabled(true);
			btnDelete.setEnabled(false);
			
			pane.removeTabAt(0);
			panelBlockKeywords=new JPanel();
			panelBlockKeywords.setLayout(new BorderLayout());
			
			JPanel panelKey=new JPanel();
			panelKey.setLayout(new FlowLayout(FlowLayout.LEFT));
			JLabel labelOne=new JLabel("Add keywords to block:");
			labelOne.setPreferredSize(new Dimension(160,27));
			labelOne.setFont(new Font("Times New Roman",Font.BOLD,14));
			
			
			JButton btnAdd=new JButton("Add");
			btnAdd.setBackground(Color.CYAN);
			btnAdd.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					String data=JOptionPane.showInputDialog(AdminWeb.this,"Enter the keyword:");
					model.addElement(data);
					
					
					try{
				
					    String sqlInsert="insert into admin_block(keyword) values(?)";
						pst=connect.prepareStatement(sqlInsert);
						pst.setString(1, data);
						pst.execute();
						JOptionPane.showMessageDialog(null, "Record added");
						
					}catch(Exception ev){
						ev.printStackTrace();
					}
				}
				
			});
			panelKey.add(labelOne);
			panelKey.add(btnAdd);
			
			panelBlockKeywords.add(panelKey,BorderLayout.NORTH);
			
			JPanel panelListAdd=new JPanel();
			panelListAdd.setLayout(new BorderLayout());
			populateJList();
			panelListAdd.add(colorList,BorderLayout.CENTER);
			panelBlockKeywords.add(panelListAdd,BorderLayout.CENTER);
			
			
			JPanel panelDelBtn=new JPanel();
			panelDelBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
			JButton btnDeleteKey=new JButton("Delete");
			btnDeleteKey.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String removedata=(String) colorList.getSelectedValue();
					
					
					try{
					String sqlDeleteval="delete from admin_block where keyword=?";
					pst=connect.prepareStatement(sqlDeleteval);
					pst.setString(1, removedata);
					pst.execute();
					model.removeElement(colorList.getSelectedValue());
					JOptionPane.showMessageDialog(null, "Record deleted!!!!");
				
					
						
					}catch(Exception ep){
						ep.printStackTrace();
					}
					
					
				}
				
				
			});
			panelDelBtn.add(btnDeleteKey);
			panelBlockKeywords.add(panelDelBtn, BorderLayout.SOUTH);
			
          
		  
		   
		   
			pane.addTab("Blocked Keywords",null, panelBlockKeywords);
			
			
			
			
			
			
		}

		
	});
	btnDelete.setBackground(new Color(175, 238, 238));
	panelToolbar.add(btnView);
	panelToolbar.add(btnDelete);
	
	
	
	btnCMD=new JButton("Traffic View");
	btnCMD.setPreferredSize(new Dimension(260,27));
	btnCMD.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent evt){
			btnCMD.setBackground(Color.WHITE);
		}
		public void mouseExited(MouseEvent e){
			//btnView.setBackground(Color.WHITE);
			btnCMD.setBackground(UIManager.getColor(new Color(175, 238, 238)));
		}
		
		
		
		
	});
	btnCMD.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			btnView.setEnabled(true);
			btnDelete.setEnabled(true);
			btnSettings.setEnabled(true);
			btnCMD.setEnabled(false);
			pane.removeTabAt(0);
			
			
			JPanel panelCmd=new JPanel();
			panelCmd.setLayout(new BorderLayout());
			
			JPanel panelViewData=new JPanel();
			panelViewData.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			JButton btnDatMine=new JButton("View Traffic");
			//btnDatMine.setBackground(Color.CYAN);
			btnDatMine.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
			try{
				
				String sqlViewData="Select datasent from admin_traffic";
				pst=connect.prepareStatement(sqlViewData);
				rst=pst.executeQuery();
				while(rst.next()){
					
					cmdtext.append(rst.getString("datasent")+"\n");
					btnDatMine.setEnabled(false);
				}
				
				
				
			}catch(Exception p){
				p.printStackTrace();
			}
					
				}
				
			});
			
			panelViewData.add(btnDatMine);
			
			
			JButton btnCleared=new JButton("Clear");
			btnCleared.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					cmdtext.setText("");
					btnDatMine.setEnabled(true);
				}
				
			});
			panelViewData.add(btnCleared);
			panelCmd.add(panelViewData, BorderLayout.NORTH);
			
			
			JPanel panelMainArea=new JPanel();
			cmdtext=new JTextArea();
			cmdtext.setFont(new Font("Times New Roman",Font.BOLD,16));
			cmdtext.setBackground(Color.BLACK);
			cmdtext.setForeground(Color.WHITE);
			JScrollPane roll=new JScrollPane(cmdtext);
			
			panelMainArea.setLayout(new BorderLayout());
			panelMainArea.add(roll,BorderLayout.CENTER);
			panelCmd.add(panelMainArea,BorderLayout.CENTER);
			
			pane.addTab("Admin Monitor Traffic", null,panelCmd);
			
		}
		
	});
	btnCMD.setBackground(new Color(175, 238, 238));
	panelToolbar.add(btnCMD);
	
	
	
	btnSettings=new JButton("Settings");
	btnSettings.setPreferredSize(new Dimension(260,27));
	btnSettings.addMouseListener(new MouseAdapter(){
		
		public void mouseEntered(MouseEvent evt){
			btnSettings.setBackground(Color.WHITE);
		}
		public void mouseExited(MouseEvent e){
			//btnView.setBackground(Color.WHITE);
			btnSettings.setBackground(UIManager.getColor(new Color(175, 238, 238)));
		}
		
		
	});
	btnSettings.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			getSettings();
			btnView.setEnabled(true);
			btnDelete.setEnabled(true);
			btnCMD.setEnabled(true);
			btnSettings.setEnabled(false);
			
			pane.removeTabAt(0);
		}
		
	});
	btnSettings.setBackground(new Color(175, 238, 238));
	panelToolbar.add(btnSettings);
	
	
    panelBody.add(panelToolbar,BorderLayout.WEST);
    
   
    
    pane=new JTabbedPane();
	pane.setBackground(Color.WHITE);
	
	
	panelBody.add(pane, BorderLayout.CENTER);
	
    
	
	//panelMessage added
	panelMessage=new JPanel();
	panelMessage.setLayout(new FlowLayout(FlowLayout.CENTER)); 
	
	
//First panel panelWelcome
	panelWel=new JPanel();
	panelWel.setBackground(Color.WHITE);
	panelWel.setBackground(new Color(175, 238, 238));
	panelWel.setForeground(Color.RED);
	panelWel.setLayout(new BorderLayout());
	
	JLabel lbl=new JLabel("WELCOME TO MAILADMIN PLATFORM");
	lbl.setPreferredSize(new Dimension(200,50));
	panelWel.add(lbl,BorderLayout.NORTH);
	
	
	JPanel panelField=new JPanel();
	panelField.setPreferredSize(new Dimension(200,40));
	JTextArea field=new JTextArea();
	panelField.setLayout(new BorderLayout());
	//panelField.setBackground(Color.PINK);
	panelField.add(field, BorderLayout.NORTH);
	
	
	field.setEditable(false);
	
	field.setText("This is the platform for the administration purposes. The administrator uses this platform for minitoring "
			+ "the spam and filter it bases on the mailheader and the mail body contents\n\n");
	field.append("The following are the basic instructions for using this platform:-\n\n");
	field.append(">> Click the Blocked mail button to naviate to the blocked mails\n");
	field.append(">> Click the Blocked keyworks to view, add or delete the prohibited words to be sent via a mailt\n");
	field.append(">> Click the traffic view button to view the detected junk of emails\n");
	field.append(">> Click the settings button to change the administrator password\n");
	field.setLineWrap(true);
	panelWel.add(panelField, BorderLayout.CENTER);
	pane.addTab("AdminWeb Tool",null,panelWel,"Third panel");
	
	
	
	
	
	}
	/*public static void main(String []args){
	new AdminWeb();
	}
	*/
	
	public void tableShow(){
		
	panelTable=new JPanel();
	panelEmail.add(panelTable, BorderLayout.CENTER);
	 
	

	}
	
	
	
	
public void getBlockEmails(){
panelEmailDisplay=new JPanel();
panelEmailDisplay.setLayout(new BorderLayout());

JPanel panelDel=new JPanel();
panelDel.setLayout(new FlowLayout(FlowLayout.RIGHT));
JButton btnDel=new JButton("Delete spam");

btnDel.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int isSelected=table.getSelectedRow();
		
		String km=(String) table.getModel().getValueAt(isSelected, 0);
		
		
	
			
			try{
				String sqlDeleted="delete from dbreport";
				pst=connect.prepareStatement(sqlDeleted);
				
				rst=pst.executeQuery();
				if(rst.next()){
					
					JOptionPane.showMessageDialog(null,"Deleting-----");
					
				}
				
			
			}catch(Exception ex){
				ex.printStackTrace();
			}

	}
	
});

panelDel.add(btnDel);

DefaultTableModel model=new DefaultTableModel(new Object[]{"E-mail Blocked","Date_email_reported"},0);
table=new JTable();
JScrollPane pn=new JScrollPane(table);
pn.getViewport().setBackground(Color.WHITE);
panelEmailDisplay.add(pn, BorderLayout.CENTER);
panelEmailDisplay.add(panelDel,BorderLayout.SOUTH);

try{
	String sqlQuery="select tomail,date from dbreport";
	pst=connect.prepareStatement(sqlQuery);
	rst=pst.executeQuery();
	int i=0;
	while(rst.next()){
	   
		String d=rst.getString("tomail");
		String r=rst.getString("date");
		model.addRow(new Object[]{d,r});
		i++;
		table.setModel(model);
	}
	
}catch(Exception e){
	e.printStackTrace();
}
pane.addTab("Blocked emails",null, panelEmailDisplay);



	
}	

public void populateJList(){
	try{
		model=new DefaultListModel();
		String sqlFetch="Select keyword from admin_block";
		pst=connect.prepareStatement(sqlFetch);
		rst=pst.executeQuery();
		
		while(rst.next()){
			String itemSelected=rst.getString("keyword");
			model.addElement(itemSelected);
		}
		colorList.setModel(model);
		rst.close();
		pst.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
}

public void getSettings(){
	JPanel panelSettings=new JPanel();
	panelSettings.setLayout(new BorderLayout());
	panelSettings.setPreferredSize(new Dimension(100,50));
	
	JPanel panelSetTop=new JPanel();
	panelSetTop.setBackground(new Color(175, 238, 238));
	panelSettings.add(panelSetTop, BorderLayout.NORTH);
	JLabel labelset=new JLabel("Change Your password:");
	panelSetTop.add(labelset);
	
	JPanel panelSetBody=new JPanel();
	panelSetBody.setPreferredSize(new Dimension(60,50));
	panelSetBody.setBackground(Color.LIGHT_GRAY);
	//panelSetBody.setLayout(new FlowLayout(FlowLayout.RIGHT));
	panelSetBody.setLayout(new GridLayout(3,2,5,5));
	panelSetBody.setBorder(new TitledBorder(null, "Admin change password", TitledBorder.LEADING, TitledBorder.TOP,null,null));
	
	JLabel labelAdmin=new JLabel("Admin ID");
	textAdmin=new JTextField(15);
	
	JLabel labelPassOne=new JLabel("Password");
	textPassOne=new JTextField(15);
	

	
	textAdmin.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			textPassOne.requestFocusInWindow();
		}
		
	});
	
	textPassOne.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			passChangeAdmin();
		}
		
	});
	textPassOne.setPreferredSize(new Dimension(100,27));
	
	
	JPanel panelBtnPosition=new JPanel();
	panelBtnPosition.setLayout(new FlowLayout(FlowLayout.RIGHT));
	panelBtnPosition.setPreferredSize(new Dimension(100,27));
	panelBtnPosition.setBackground(Color.LIGHT_GRAY);
	
	JButton btnSubmit=new JButton("Submit");
	btnSubmit.setBackground(new Color(175, 238, 238));
	
	labelWarning=new JLabel(" ");
	labelWarning.setPreferredSize(new Dimension(100,27));
	labelWarning.setForeground(Color.RED);
	labelWarning.setFont(new Font("Times New Roman",Font.BOLD,14));
	
	
	btnSubmit.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			passChangeAdmin();
		}
		
	});
	JButton btnCancel=new JButton("Clear");
	btnCancel.setBackground(new Color(175, 238, 238));
	btnCancel.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			labelWarning.setText("");
			textAdmin.setText("");
			textPassOne.setText("");
			
		}
		
	});
	panelBtnPosition.add(btnSubmit);
	panelBtnPosition.add(btnCancel);
	
	
	panelSetBody.add(labelAdmin);
	panelSetBody.add(textAdmin);
	panelSetBody.add(labelPassOne);
	panelSetBody.add(textPassOne);
	panelSetBody.add(panelBtnPosition);
	panelSetBody.add(labelWarning);
	
	
	JPanel panelBottom=new JPanel();
	panelBottom.setPreferredSize(new Dimension(200,400));
	panelBottom.setBackground(new Color(175, 238, 238));
	panelSettings.add(panelBottom,BorderLayout.SOUTH);
	
	panelSettings.add(panelSetBody, BorderLayout.CENTER);
	
	pane.addTab("Admin Settings",null, panelSettings);
}



public void passChangeAdmin(){
String m=textAdmin.getText();
String n=textPassOne.getText();

if(!m.equals("")&&!n.equals("")){
	try{
String sqlAdminPassChange="update admin set password=? where username=?";
pst=connect.prepareStatement(sqlAdminPassChange);
pst.setString(1, n);
pst.setString(2, m);

pst.executeUpdate();

JOptionPane.showMessageDialog(null, "Password Changed to"+n);


}catch(Exception el)
	{
		el.printStackTrace();
	}
	}else{
		labelWarning.setText("Fields cannot be null");
	}
}
}


