import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Reportentry extends JFrame implements ActionListener
{
	Label Re,pid,test,rt,nl;
	Font f1,f2,f3;
	TextField tf6;
	TextArea ta1,ta2,ta3;
	JButton b1;
	String test1,test2,pi,nor,res;
	int pid1;
	Reportentry()
	{
		f1=new Font("Serif", Font.BOLD, 24);
		f2=new Font("Serif", Font.BOLD, 20);
		f3=new Font("Serif", Font.BOLD, 18);
		
		Re=new Label("Report Entry");
		Re.setBounds(330,49,203,26);
		Re.setFont(f1);
		Re.setBackground(Color.red);
		Re.setForeground(Color.white);
		add(Re);
		pid=new Label("Patient Id");
		pid.setBounds(67,160,90,30);
		pid.setFont(f2);
		pid.setForeground(Color.red);
		add(pid);
		test=new Label("Test Name");
		test.setBounds(67,260,150,30);
		test.setFont(f2);
		add(test);
		rt=new Label("Result");
		rt.setBounds(330,260,150,30);
		rt.setFont(f2);
		add(rt);
		nl=new Label("Normal");
		nl.setBounds(520,260,150,30);
		nl.setFont(f2);
		add(nl);

		ta1=new TextArea();
		ta1.setBounds(67,295,250,290);
		ta1.setFont(f3);
		add(ta1);
		ta2=new TextArea();
		ta2.setBounds(317,295,200,290);
		ta2.setFont(f3);
		add(ta2);
		ta3=new TextArea();
		ta3.setBounds(517,295,180,290);
		ta3.setFont(f3);
		add(ta3);

		tf6=new TextField();
		tf6.setBounds(160,160,72,28);
		tf6.setFont(f2);
		tf6.setForeground(Color.red);
		add(tf6);

		b1=new JButton("Submit");
		b1.setBounds(585,635,100,25);
		b1.setFont(f3);
		b1.setBackground(Color.white);
		b1.setForeground(Color.red);
		add(b1);
		b1.addActionListener(this);
		tf6.addActionListener(this);

		setSize(800,720);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e1)
	{
		if(e1.getSource()==tf6)
		{
			try{
				String dis=tf6.getText();
				pid1=Integer.parseInt(dis);
				ResultSet rs;
				DataBase1 db=new DataBase1();
				rs=db.st.executeQuery("select *from patiententry where PATIENT_ID="+pid1+"");
				while(rs.next())
				{
					test1=rs.getString(10);
				}
				ta1.setText(test1);
				}catch(Exception e)
					{
						e.printStackTrace();
					}

		}
	
		if(e1.getSource()==b1)
		{
			pi=tf6.getText();
			test2=ta1.getText();
			res=ta2.getText();
			nor=ta3.getText();
			
			DataBase1 db=new DataBase1();
				try
				{
					int i=db.st.executeUpdate("insert into reportentry values("+"'"+pi+"'"+","+"'"+test2+"'"+","+"'"+res+"'"+","+"'"+nor+"')");
				}
				catch (Exception e8)
				{
					e8.printStackTrace();
				}

		}
	
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.red);
		g2.fillRect(40,78,710,30);
		g2.fillRect(70,50,30,90);
	}
//	public static void main(String[] args) 
//	{
//		new Reportentry();
//	}
}
