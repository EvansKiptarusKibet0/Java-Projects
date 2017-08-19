package MainClassPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class LoadClassFrame {
	static int min=0;
	private static WelcomeMessagePanel msgPanel;
	private static Dimension dim;
	static int max=100;
	private static JProgressBar progressBar;
	public static void main(String[] args) {

JDialog f=new JDialog(new JFrame(),"LOADING EMAIL SYSTEM....");
progressBar=new JProgressBar();
progressBar.setMinimum(min);
progressBar.setMaximum(max);
progressBar.setIndeterminate(true);
f.add(progressBar);
f.setUndecorated(true);
int x=3;
f.getRootPane().setWindowDecorationStyle(x);
f.addWindowListener(new WindowAdapter(){
	public void windowClosing(WindowEvent evt){
		System.exit(0);
	}
});

//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Container content=f.getContentPane();

progressBar.setValue(20);
progressBar.setStringPainted(true);
progressBar.setForeground(Color.RED);
//progressBar.setString("---**Loading**----");

Border border=BorderFactory.createTitledBorder("--------****LOADING A MAIL SYSTEM****-----");
progressBar.setBorder(border);

progressBar.setBackground(Color.WHITE);

progressBar.setSize(500,60);

content.add(progressBar, BorderLayout.SOUTH);

msgPanel=new WelcomeMessagePanel();
msgPanel.setBackground(Color.cyan);
msgPanel.btnCancel.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
});
content.add(msgPanel,BorderLayout.SOUTH);
dim=Toolkit.getDefaultToolkit().getScreenSize();
f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
f.setBounds(400,200,500,170);
f.setVisible(true);



for(int i=min; i<=max; i++){
	final int percent=i;
	if(i==100){
		f.dispose();
		
		MainClass.main(null);
	
	
	}
	try{
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				updateBar(percent);
				
			}
			
		});
		Thread.sleep(100);
		
		
	}catch(InterruptedException e){
		
	}
}


}
	public static void updateBar(int newValue){
		progressBar.setValue(newValue);
	
		
		
		
	
	}
	

	
	}


