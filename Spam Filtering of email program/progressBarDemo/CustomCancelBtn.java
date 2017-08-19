package progressBarDemo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
public class CustomCancelBtn extends JPanel {
public JButton btnCancelProg;
	public CustomCancelBtn(){
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnCancelProg=new JButton("Cancel");
		btnCancelProg.setBackground(Color.WHITE);
		btnCancelProg.setFont(new Font("Times New Roman",Font.BOLD,14));
		btnCancelProg.setPreferredSize(new Dimension(100,25));
		btnCancelProg.setFocusPainted(false);
		add(btnCancelProg);
		
	}
}
