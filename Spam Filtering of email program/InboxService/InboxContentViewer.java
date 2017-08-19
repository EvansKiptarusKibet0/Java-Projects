package InboxService;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class InboxContentViewer {
	private JFrame frmViewmailbox;
	public JTextArea textArea;
	public InboxContentViewer() {
		initialize();
	}
	private void initialize() {
		frmViewmailbox = new JFrame();
		frmViewmailbox.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmViewmailbox.setTitle("ViewMailBox");
		frmViewmailbox.setBounds(100, 100, 650, 400);
		frmViewmailbox.setResizable(false);
		//frmViewmailbox.setUndecorated(true);
		frmViewmailbox.setVisible(true);
		frmViewmailbox.setLocationRelativeTo(null);
		frmViewmailbox.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmViewmailbox.getContentPane().setLayout(null);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBounds(21, 11, 591, 302);
		frmViewmailbox.getContentPane().add(textArea);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmViewmailbox.dispose();
			}
		});
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(31, 327, 89, 23);
		frmViewmailbox.getContentPane().add(btnExit);
	}
	
}
