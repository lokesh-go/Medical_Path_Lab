import javax.swing.*;
import java.sql.*;

class DataBase1 extends JFrame 
{
	Connection con=null;
	Statement st=null;
	
	DataBase1()
	{
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded.....................................");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","lokesh");
			System.out.println("Driver Loaded.....................................");
			st=con.createStatement();
		//	System.out.println(pid1+nm+moth+fath+scon1+scon2+ref+ag+add+tes1);
//			int i=st.executeUpdate("insert into patiententry values("+"'"+pid1+"'"+","+"'"+nm+"'"+","+"'"+ref+"'"+","+"'"+ag+"'"+","+"'"+moth+"'"+","+"'"+fath+"'"+",'Male',"+"'"+scon1+"'"+","+"'"+add+"'"+","+"'"+tes1+"'"+","+"'"+scon2+"')");
			System.out.println("value inserted.....................................");		
		}
		catch (Exception e)
		{
			e.printStackTrace();			
		}
	}
//	public static void main(String[] args) 
//	{
//		new DataBase1();
//	}
}
