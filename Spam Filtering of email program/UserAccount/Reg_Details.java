package UserAccount;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Reg_Details extends JFrame{
	private JPanel panelTop;
	private JPanel panelCenter;
	
	public Reg_Details(){
		super("Hello second reg");
		setSize(900,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		panelTop=new JPanel();
		panelTop.setPreferredSize(new Dimension(250,50));
		add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel label=new JLabel("***---Next Registration---***");
		label.setPreferredSize(new Dimension(200,27));
		label.setFont(new Font("Times New Roman",Font.BOLD,15));
		panelTop.add(label);
		
		
		panelCenter=new JPanel();
		panelCenter.setLayout(new BorderLayout());
		JTextField txt=new JTextField();
	    panelCenter.add(txt, BorderLayout.CENTER);
		
		add(panelCenter, BorderLayout.CENTER);
	}

	
	public static void main(String []args){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
			
				new Reg_Details();
			}
			
		});
	}
}
