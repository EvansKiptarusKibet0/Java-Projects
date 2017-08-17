package iHub.app.user1;

import javax.swing.SwingUtilities;

public class Index {

	public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable(){

		@Override
		public void run() {
			new UserLogin();
			
		}
		
	});
        
	}

}
