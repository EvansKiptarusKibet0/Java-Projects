package iHub.app.user1;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DownloadDebtorsList {
	private static Connection connect=null;
	private Statement st=null;
	private ResultSet rs=null;
	
		public DownloadDebtorsList()
		{
			connect=iHub.app.helper.connectDB.connDB();
			String filename="F:/data.xls" ;
			HSSFWorkbook hwb=new HSSFWorkbook();
			HSSFSheet sheet = hwb.createSheet("Customers Information");
			HSSFRow rowH=sheet.createRow((short)1);
			rowH.createCell((short)2).setCellValue("---****REMOTE REFERENCE APP****---");
			HSSFRow rowhead=sheet.createRow((short)3);
			rowhead.createCell((short) 0).setCellValue("First Name");
			rowhead.createCell((short) 1).setCellValue("Last Name");
			rowhead.createCell((short) 2).setCellValue("Phone Number");
			rowhead.createCell((short) 3).setCellValue("ID No.");
			rowhead.createCell((short) 4).setCellValue("Due");
			rowhead.createCell((short)4).setCellValue("County");
			

			try{
			st=connect.createStatement();
			rs=st.executeQuery("Select * from tb_due_listing");
			int i=4;
			while(rs.next()){
			HSSFRow row= sheet.createRow((short)i);
			row.createCell((short) 0).setCellValue(rs.getString("firstname"));
			row.createCell((short) 1).setCellValue(rs.getString("lastname"));
			row.createCell((short) 2).setCellValue(rs.getString("phone_numbers"));
			row.createCell((short) 3).setCellValue(Integer.toString(rs.getInt("idno")));
			row.createCell((short) 4).setCellValue(Integer.toString(rs.getInt("due")));
			row.createCell((short)4).setCellValue(rs.getString("country"));
			i++;
			}
			FileOutputStream fileOut = new FileOutputStream(filename);
			hwb.write(fileOut);
			fileOut.close();
			JOptionPane.showMessageDialog(null, "Debtors List Downloaded Successfully");
            
			} catch ( Exception ex ) {
				ex.printStackTrace();
			}	
	}
}
