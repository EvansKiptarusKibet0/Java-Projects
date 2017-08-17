package iHub.app.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class connectDB {

	Connection conn=null;
	public static Connection connDB(){
		try{
			Class.forName("org.postgresql.Driver");
			Connection conn=DriverManager.getConnection("jdbc:postgresql://51.140.33.76:6773/testdb","dev001","EV5gy2pQPDhC4H&fg3$5qzWL*9P4=D2K8ta9x&Qr2");
			return conn;
		}catch(ClassNotFoundException|SQLException e){
			JOptionPane.showMessageDialog(null, "No internet Connection, Start your server", null, JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}

}