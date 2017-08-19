package MainClassPackage;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class WelcomeMessagePanel extends JPanel {
public JLabel labelMessage;
public JButton btnCancel;

public WelcomeMessagePanel(){
	setLayout(new FlowLayout(FlowLayout.RIGHT));
	btnCancel=new JButton("Cancel");


	add(btnCancel);
}
}
