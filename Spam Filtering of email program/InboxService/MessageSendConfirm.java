package InboxService;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class MessageSendConfirm extends JPanel{

	private JLabel labelConfirm;
	public MessageSendConfirm(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		labelConfirm=new JLabel("Message send successfully.....");
		add(labelConfirm);
	}
}
