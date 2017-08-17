package iHub.app.user1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
public class UserMenuArea{
private JPanel panelTop;
private JPanel panelMenu;
private JTabbedPane pane;
private JTextArea areaDisplay;
private JTextField fieldSearch;
private JButton btnSearchData;
private Connection connect=null;
private PreparedStatement pst=null;
private ResultSet rst=null;
private JTextArea textDept;
private JDialog dialog;

public UserMenuArea(){
	createDialog();
	connect=iHub.app.helper.connectDB.connDB();
}


public void createDialog()
{
dialog=new JDialog();
dialog.setTitle("***REMOTE REFERENCE APP***");
dialog.setBounds(150,60,1050,600);
dialog.setVisible(true);
dialog.setLayout(new BorderLayout());
pane=new JTabbedPane();

//create top JPanel
panelTop=new JPanel();
panelTop.setPreferredSize(new Dimension(950,40));
panelTop.setBackground(Color.CYAN);

JLabel labelWelcome=new JLabel("Welcome user1");
labelWelcome.setPreferredSize(new Dimension(160,26));
labelWelcome.setFont(new Font("Times New Roman",Font.BOLD,16));
labelWelcome.setForeground(Color.MAGENTA);
panelTop.add(labelWelcome);
dialog.add(panelTop,BorderLayout.NORTH);

//panel menu area
panelMenu=new JPanel();
panelMenu.setPreferredSize(new Dimension(200,600));

JButton btnMenu=new JButton("MENU");
JLabel label=new JLabel("----------------------------------------------------");
label.setPreferredSize(new Dimension(160,5));
btnMenu.setPreferredSize(new Dimension(160,22));
btnMenu.setBackground(Color.WHITE);
btnMenu.setForeground(Color.BLUE);
btnMenu.setBorderPainted(false);
btnMenu.setFocusPainted(false);
panelMenu.add(btnMenu);
panelMenu.add(label);



JButton btnSearch=new JButton("Search Customer");
btnSearch.setPreferredSize(new Dimension(160,25));
btnSearch.setBackground(Color.LIGHT_GRAY);
btnSearch.setForeground(Color.BLUE);
btnSearch.setFocusPainted(false);
btnSearch.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent e) {
		pane.removeTabAt(0);
		getUser();
	}
	
});
panelMenu.add(btnSearch);

JButton btnPrint=new JButton("Debt Report");
btnPrint.setPreferredSize(new Dimension(160,25));
btnPrint.setBackground(Color.LIGHT_GRAY);
btnPrint.setForeground(Color.BLUE);
btnPrint.setFocusPainted(false);
btnPrint.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		pane.removeTabAt(0);
		printDept();
		fetchDeni();
		
		
	}
	
});
panelMenu.add(btnPrint);

JButton btnLogout=new JButton("Logout");
btnLogout.setPreferredSize(new Dimension(160,25));
btnLogout.setBackground(Color.LIGHT_GRAY);
btnLogout.setForeground(Color.BLUE);
btnLogout.setFocusPainted(false);
btnLogout.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		dialog.dispose();
		new UserLogin();
	}
	
});
panelMenu.add(btnLogout);

panelMenu.setBackground(Color.WHITE);
dialog.add(panelMenu,BorderLayout.WEST);



//panelCenter
getUser();
dialog.add(pane, BorderLayout.CENTER);
}


public void getUser(){
	JPanel panelWel=new JPanel();
	panelWel.setLayout(new BorderLayout());

	JPanel panelSearch=new JPanel();
	panelSearch.setPreferredSize(new Dimension(400,40));
	panelSearch.setLayout(new FlowLayout(FlowLayout.CENTER));
	JLabel labelInf=new JLabel("Enter Customer ID/Phone Number:");
	fieldSearch=new JTextField();
	((AbstractDocument)fieldSearch.getDocument()).setDocumentFilter(new iHub.app.helper.CharFilter());
	fieldSearch.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			fetchUser1();
		}
		
	});
	
	
	fieldSearch.setPreferredSize(new Dimension(200,27));
	btnSearchData=new JButton("Search");
	btnSearchData.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			fetchUser1();
		}
		
	});
	btnSearchData.setBackground(Color.LIGHT_GRAY);
	btnSearchData.setForeground(Color.BLUE);
	btnSearchData.setFocusPainted(false);
	
	btnSearchData.setPreferredSize(new Dimension(80,27));
	panelSearch.add(labelInf);
	panelSearch.add(fieldSearch);
	panelSearch.add(btnSearchData);

	panelWel.add(panelSearch,BorderLayout.NORTH);

	JPanel panelDisplay=new JPanel();
	panelDisplay.setLayout(new BorderLayout());
	areaDisplay=new JTextArea();
	panelDisplay.add(areaDisplay, BorderLayout.CENTER);
	panelWel.add(panelDisplay, BorderLayout.CENTER);

	panelWel.setBackground(Color.LIGHT_GRAY);
	pane.addTab("Search Customers Information",null, panelWel);
}


public void printDept(){
	JPanel panelDeptors=new JPanel();
	panelDeptors.setLayout(new BorderLayout());
	panelDeptors.setVisible(false);
	JPanel panelUpper=new JPanel();
	panelUpper.setLayout(new FlowLayout(FlowLayout.LEFT));
	
	JButton btnExport=new JButton("Download as Excel");
	btnExport.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new DownloadDebtorsList();
		}
	});
	btnExport.setPreferredSize(new Dimension(160,26));
	btnExport.setBackground(Color.LIGHT_GRAY);
	btnExport.setForeground(Color.BLUE);
	btnExport.setFocusPainted(false);
	panelUpper.add(btnExport);
	panelUpper.setPreferredSize(new Dimension(600,40));
	panelDeptors.add(panelUpper, BorderLayout.NORTH);
    
	textDept=new JTextArea();
    JScrollPane paneScroll=new JScrollPane(textDept);
	panelDeptors.add(paneScroll, BorderLayout.CENTER);

	pane.addTab("Search Deptors information", null,panelDeptors);
}


public void fetchUser1(){
String user=fieldSearch.getText();
String m="";
String n="";
String g="";
String f="";
String j="";
String p="";

if(!user.equals("")){
	try{
String sql="select  firstname,lastname,phone_numbers,idno,due,country from tb_due_listing where idno=? or phone_numbers=?";
pst=connect.prepareStatement(sql);
pst.setString(1, user);
pst.setString(2, user);
rst=pst.executeQuery();

if(rst.next()){
	n=rst.getString("lastname");
	m=rst.getString("firstname");
	g=rst.getString("phone_numbers");
	f=rst.getString("idno");
	j=rst.getString("due");
	p=rst.getString("country");
	
	areaDisplay.setEditable(false);
	areaDisplay.setBackground(Color.LIGHT_GRAY);
	areaDisplay.setFont(new Font("Times New Roman",Font.BOLD,14));
	areaDisplay.setText("------****REMOTE REFERENCE APP****--------\n");
	areaDisplay.append("*******Details of the "+user+" Searched was found*******\n\n");
	areaDisplay.append("\tFIRST NAME\t"+"LAST NAME\t"+"PHONE NO.\t"+"ID NO.\t"+"DUE\t"+"COUNTY\n");
	areaDisplay.append("---------------------------------------------------------------------------------------------------------"
			+ "-----------------------\n");
	areaDisplay.append("\t"+m+"\t"+n+"\t"+g+"\t"+f+"\t"+j+"\t"+p);
	
}else{
	
	areaDisplay.setEditable(false);
	areaDisplay.setBackground(Color.LIGHT_GRAY);
	areaDisplay.setFont(new Font("Times New Roman",Font.BOLD,14));
	areaDisplay.setText("------****REMOTE REFERENCE APP****--------\n");
	areaDisplay.append("*******Details of the "+user+" Searched was not found!!!*******\n\n");
	
}

}catch(Exception e){
		JOptionPane.showMessageDialog(null, e);
}
}
}

public void fetchDeni(){
	try{
String sqlUpdate="select  firstname,lastname,phone_numbers,idno,due,country from tb_due_listing";

pst=connect.prepareStatement(sqlUpdate);
rst=pst.executeQuery();

textDept.setEditable(false);
textDept.setBackground(Color.LIGHT_GRAY);
textDept.setFont(new Font("Times New Roman",Font.BOLD,14));
textDept.setText("------****REMOTE REFERENCE APP****--------\n");

textDept.append("NO."+"\tFIRST NAME\t"+"LAST NAME\t"+"PHONE NO.\t"+"ID NO.\t"+"DUE\t"+"COUNTY\n");
textDept.append("---------------------------------------------------------------------------------------------------------"
		+ "-----------------------\n");

while(rst.next()){
    int x=rst.getRow();
	textDept.append(x+"\t"+rst.getString(1));
	textDept.append("\t"+rst.getString(2));
	textDept.append("\t"+rst.getString(3));
	textDept.append("\t"+rst.getString(4));
	textDept.append("\t"+rst.getString(5));
	textDept.append("\t"+rst.getString(6)+"\n");
	}
	}
	catch(Exception exp){
		exp.printStackTrace();
	}
		
	}
}
