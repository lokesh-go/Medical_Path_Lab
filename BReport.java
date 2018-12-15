import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BReport extends JFrame implements ActionListener 
{
	Label cr,pid,l2,l3,l4,l5,l6,l7,l8,date,test,rt,at;
	Font f1,f2,f3,f4;
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	TextArea ta1,ta2,ta3;
	JButton b1,b2,b3;
	String nm,ref,ag,se,scon2,test2,nor,res;
	int pid1;
	String pi,nm1,ef,tot,amt,tes;
	
	
	BReport()
	{
		f1=new Font("Serif", Font.BOLD, 24);
		f2=new Font("Serif", Font.BOLD, 20);
		f3=new Font("Serif", Font.BOLD, 18);
		f4=new Font("", Font.BOLD, 16);
		
		cr=new Label("Case Receipt");
		cr.setBounds(330,49,203,26);
		cr.setFont(f1);
		cr.setBackground(Color.blue);
		cr.setForeground(Color.white);
		add(cr);
		pid=new Label("Patient Id");
		pid.setBounds(67,160,90,30);
		pid.setFont(f2);
		pid.setForeground(Color.red);
		add(pid);
		l2=new Label("Name :");
		l2.setBounds(68,205,70,20);
		l2.setFont(f2);
//		l2.setBackground(Color.white);
		add(l2);
		l3=new Label("Reffered by :");
		l3.setBounds(68,250,130,20);
		l3.setFont(f2);
//		l3.setBackground(Color.white);
		add(l3);
		l4=new Label("Age :");
		l4.setBounds(380,205,50,25);
		l4.setFont(f2);
//		l4.setBackground(Color.white);
		add(l4);
		l5=new Label("Entry Fee");
		l5.setBounds(400,480,100,20);
		l5.setFont(f2);
		add(l5);
		l6=new Label("Total");
		l6.setBounds(400,530,100,20);
		l6.setFont(f2);
		add(l6);
		l7=new Label("Sex :");
		l7.setBounds(530,205,50,20);
		l7.setFont(f2);
//		l7.setBackground(Color.white);
		add(l7);
		l8=new Label("( PLEASE BRING THIS RECEIPT FOR REPORT COLLECTION )");
		l8.setBounds(156,100,490,25);
		l8.setForeground(Color.blue);
		l8.setFont(f4);
		add(l8);
		date=new Label("Date");
		date.setBounds(440,250,60,20);
		date.setFont(f2);
		add(date);
		test=new Label("Test Name");
		test.setBounds(67,330,150,30);
		test.setFont(f2);
		add(test);
		at=new Label("Amount");
		at.setBounds(520,330,150,30);
		at.setFont(f2);
		add(at);

		tf6=new TextField();
		tf6.setBounds(160,160,72,28);
		tf6.setFont(f2);
		tf6.setForeground(Color.red);
		add(tf6);

		tf1=new TextField();
		tf1.setBounds(150,205,200,25);
		tf1.setFont(f4);
		add(tf1);
		tf2=new TextField();
		tf2.setBounds(450,205,50,25);
		tf2.setFont(f4);
		add(tf2);
		tf3=new TextField();
		tf3.setBounds(580,205,60,25);
		tf3.setFont(f4);
		add(tf3);
		tf4=new TextField();
		tf4.setBounds(200,250,200,25);
		tf4.setFont(f4);
		add(tf4);
		tf5=new TextField();
		tf5.setBounds(500,250,170,25);
		tf5.setFont(f4);
		add(tf5);

		tf7=new TextField("500.00");
		tf7.setBounds(520,480,170,25);
		tf7.setFont(f4);
		add(tf7);
		tf8=new TextField();
		tf8.setBounds(520,530,170,25);
		tf8.setFont(f4);
		add(tf8);

		ta1=new TextArea();
		ta1.setBounds(67,365,450,100);
		ta1.setFont(f4);
		add(ta1);
		ta3=new TextArea();
		ta3.setBounds(517,365,180,100);
		ta3.setFont(f4);
		add(ta3);

		b1=new JButton("Close");
		b1.setBounds(585,625,100,25);
		b1.setFont(f3);
		b1.setBackground(Color.white);
		b1.setForeground(Color.red);
		add(b1);
		b2=new JButton("Submit");
		b2.setBounds(450,625,100,25);
		b2.setFont(f3);
		b2.setBackground(Color.white);
		b2.setForeground(Color.red);
		add(b2);
		b3=new JButton("Print");
		b3.setBounds(315,625,100,25);
		b3.setFont(f3);
		b3.setBackground(Color.white);
		b3.setForeground(Color.red);
		add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		tf6.addActionListener(this);

		Container c=this.getContentPane();
		c.setBackground(Color.white);
		setSize(800,720);
		setLayout(null);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==tf6)
		{
			try{
				String dis=tf6.getText();
				pid1=Integer.parseInt(dis);
				ResultSet rs;
				DataBase1 db=new DataBase1();
				rs=db.st.executeQuery("select *from patiententry where PATIENT_ID="+pid1+"");
				while(rs.next())
				{
					nm=rs.getString(2);
					ref=rs.getString(3);
					ag=rs.getString(4);
					se=rs.getString(7);
					scon2=rs.getString(11);
				}
				rs=db.st.executeQuery("select *from reportentry where PATIENT_ID="+pid1+"");
				while(rs.next())
				{
					test2=rs.getString(2);
				}
				tf1.setText(nm);
				tf2.setText(ag);
				tf3.setText(se);
				tf4.setText(ref);
				tf5.setText(scon2);
				ta1.setText(test2);
				}catch(Exception e3)
					{
						e3.printStackTrace();
					}

		}
		if(e.getSource()==b1)
		{
			dispose();
		}
		if(e.getSource()==b2)
		{
			pi=tf6.getText();
			nm1=tf1.getText();
			tes=ta1.getText();
			amt=ta3.getText();
			ef=tf7.getText();
			tot=tf8.getText();
			System.out.println(pi+nm1+tes+amt+ef+tot);

			DataBase1 db=new DataBase1();
				try
				{
			
					int i=db.st.executeUpdate("insert into billentry values("+"'"+pi+"'"+","+"'"+nm1+"'"+","+"'"+tes+"'"+","+"'"+amt+"'"+","+"'"+ef+"'"+","+"'"+tot+"')");
	
				}
				catch (Exception e8)
				{
					e8.printStackTrace();
				}

			
		}
		if(e.getSource()==b3)
		{
			
		}
	
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawRect(67,205,687,120);
		g2.setColor(Color.blue);
		g2.fillRect(40,78,710,30);
		g2.fillRect(70,50,30,90);
	}
//	public static void main(String[] args) 
//	{
//		new BReport();
//	}
}
