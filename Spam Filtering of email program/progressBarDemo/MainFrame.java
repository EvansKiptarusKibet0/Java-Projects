package progressBarDemo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class MainFrame extends JPanel{
	private JFrame f;
public LabelPanel labelPanel;
public static CustomPanel panel;
public CustomCancelBtn cancelButton;
public MainFrame(){
Myframe();
	}

	private void Myframe() {
    f=new JFrame();
	setLayout(new BorderLayout());
    f.setUndecorated(true);
    f.setSize(750, 450);
    labelPanel=new LabelPanel();
    labelPanel.setBackground(new Color(175, 238, 238));
    panel=new CustomPanel();
    cancelButton=new CustomCancelBtn();
    f.add(labelPanel, BorderLayout.NORTH);
    f.add(panel, BorderLayout.CENTER);
    f.add(cancelButton,BorderLayout.SOUTH);
    cancelButton.setBackground(new Color(175, 238, 238));
    cancelButton.btnCancelProg.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
    	
    });
    
    f.setLocationRelativeTo(null);
    f.setBackground(new Color(135, 206, 250));
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    threadRun();
	}
	public void threadRun(){
		new Thread(new Runnable(){

			@Override
			public void run() {
				for(int num=1;num<=100;num++){
		
		try {
			MainFrame.panel.updateProgress(num);
			Thread.sleep(50);
			MainFrame.panel.repaint();
			
			if(num==100){
				
		    f.dispose();
			InboxService.MainFrame pmf=new InboxService.MainFrame();	
			pmf.sender.setText(labelPanel.mailTextField.getText());
			
			
			}
			
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
			}
			}
		}).start();
		}
		
		
	}


