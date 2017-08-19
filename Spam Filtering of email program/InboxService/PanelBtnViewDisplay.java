package InboxService;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
public class PanelBtnViewDisplay extends JPanel{
public JButton btnView;
public JButton btnDelete;
public JButton btnReport;

public PanelBtnViewDisplay(){
	setLayout(new FlowLayout(FlowLayout.LEFT));
	btnView=new JButton("View mail");
	btnReport=new JButton("Report");
	btnDelete=new JButton("Delete");
	add(btnView);
	add(btnReport);
	add(btnDelete);
}

public void getBtnReport(){
	btnReport.setVisible(true);
	btnReport.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainFrame mf=new MainFrame();
			mf.sendReportContentDb();
			
		}
		
	});
	
	
}	
}

