package InboxService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class connectDB {
	Connection conn=null;
	public static Connection connDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			return conn;
		}catch(ClassNotFoundException|SQLException e){
			JOptionPane.showMessageDialog(null, "No internet Connection, Start your server", null, JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}

}