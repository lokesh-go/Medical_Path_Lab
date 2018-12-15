import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SReport extends JFrame implements ActionListener
{
	Label yp,pid,l2,l3,l4,l7,date,test,rt,nl;
	Font f1,f2,f3;
	TextField tf1,tf2,tf3,tf4,tf5,tf6;
	TextArea ta1,ta2,ta3;
	JButton b1,b2;
	String nm,ref,ag,se,scon2,test2,nor,res;
	int pid1;
	
	SReport()
	{
		f1=new Font("Serif", Font.BOLD, 24);
		f2=new Font("Serif", Font.BOLD, 20);
		f3=new Font("Serif", Font.BOLD, 18);
		
		yp=new Label("Your Report");
		yp.setBounds(330,49,203,26);
		yp.setFont(f1);
		yp.setBackground(Color.red);
		yp.setForeground(Color.white);
		add(yp);
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
		l7=new Label("Sex :");
		l7.setBounds(530,205,50,20);
		l7.setFont(f2);
//		l7.setBackground(Color.white);
		add(l7);
		date=new Label("Date");
		date.setBounds(440,250,60,20);
		date.setFont(f2);
		add(date);

		test=new Label("Test Name");
		test.setBounds(67,330,150,30);
		test.setFont(f2);
		add(test);
		rt=new Label("Result");
		rt.setBounds(330,330,150,30);
		rt.setFont(f2);
		add(rt);
		nl=new Label("Normal");
		nl.setBounds(520,330,150,30);
		nl.setFont(f2);
		add(nl);

		tf6=new TextField();
		tf6.setBounds(160,160,72,28);
		tf6.setFont(f2);
		tf6.setForeground(Color.red);
		add(tf6);

		tf1=new TextField();
		tf1.setBounds(150,205,200,25);
		tf1.setFont(f3);
		add(tf1);
		tf2=new TextField();
		tf2.setBounds(450,205,50,25);
		tf2.setFont(f3);
		add(tf2);
		tf3=new TextField();
		tf3.setBounds(580,205,60,25);
		tf3.setFont(f3);
		add(tf3);
		tf4=new TextField();
		tf4.setBounds(200,250,200,25);
		tf4.setFont(f3);
		add(tf4);
		tf5=new TextField();
		tf5.setBounds(500,250,170,25);
		tf5.setFont(f3);
		add(tf5);

		ta1=new TextArea();
		ta1.setBounds(67,365,250,200);
		ta1.setFont(f3);
		add(ta1);
		ta2=new TextArea();
		ta2.setBounds(317,365,200,200);
		ta2.setFont(f3);
		add(ta2);
		ta3=new TextArea();
		ta3.setBounds(517,365,180,200);
		ta3.setFont(f3);
		ta3.setForeground(Color.blue);
		add(ta3);

		b1=new JButton("Close");
		b1.setBounds(585,625,100,25);
		b1.setFont(f3);
		b1.setBackground(Color.white);
		b1.setForeground(Color.red);
		add(b1);
		b2=new JButton("Print");
		b2.setBounds(450,625,100,25);
		b2.setFont(f3);
		b2.setBackground(Color.white);
		b2.setForeground(Color.red);
		add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);
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
					res=rs.getString(3);
					nor=rs.getString(4);
				
				}
				tf1.setText(nm);
				tf2.setText(ag);
				tf3.setText(se);
				tf4.setText(ref);
				tf5.setText(scon2);
				ta1.setText(test2);
				ta2.setText(res);
				ta3.setText(nor);
				}catch(Exception e3)
					{
						e3.printStackTrace();
					}

		
		}
		
		if(e.getSource()==b2)
		{
		
		}
		if(e.getSource()==b1)
		{
			dispose();
		}
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawRect(67,205,687,120);
		g2.setColor(Color.red);
		g2.fillRect(40,78,710,30);
		g2.fillRect(70,50,30,90);
	}
//	public static void main(String[] args) 
//	{
//		new SReport();
//	}
}
