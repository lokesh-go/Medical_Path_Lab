import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.sql.*;

public class Labentry extends JFrame implements ActionListener
{
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,pid,tname,date;
	Font f1,f2,f3;
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
	JRadioButton rb1,rb2;
	JButton b1,b2;
	Image img;
	MediaTracker med;
	Toolkit tk;
	TextArea ta;
	int pid1;
	Statement st=null;
	String nm,se,moth,fath,scon1,scon2,ref,ag,add,test1;
	
	Labentry()
	{
		f1=new Font("Serif",Font.BOLD, 40);
		f2=new Font("Serif",Font.BOLD, 18);
		f3=new Font("Serif",Font.BOLD, 24);
		
		l1=new Label("Lab Entry");
		l1.setBounds(570,30,250,50);
		l1.setFont(f1);
//		l1.setBackground(Color.white);
		l1.setForeground(Color.red);
		add(l1);
		pid=new Label("Patient Id");
		pid.setBounds(180,85,90,30);
		pid.setFont(f2);
		pid.setForeground(Color.red);
		add(pid);
		l2=new Label("Name :");
		l2.setBounds(180,150,70,20);
		l2.setFont(f2);
//		l2.setBackground(Color.white);
		add(l2);
		
		l3=new Label("Reffered by :");
		l3.setBounds(180,200,150,20);
		l3.setFont(f2);
//		l3.setBackground(Color.white);
		add(l3);
		l4=new Label("Age :");
		l4.setBounds(180,250,150,20);
		l4.setFont(f2);
//		l4.setBackground(Color.white);
		add(l4);
		l5=new Label("Mother's Name :");
		l5.setBounds(180,300,190,20);
		l5.setFont(f2);
//		l5.setBackground(Color.white);
		add(l5);
		l6=new Label("Father's Name :");
		l6.setBounds(180,350,190,20);
		l6.setFont(f2);
//		l6.setBackground(Color.white);
		add(l6);
		l7=new Label("Sex :");
		l7.setBounds(180,400,80,20);
		l7.setFont(f2);
//		l7.setBackground(Color.white);
		add(l7);
		l8=new Label("DOB :");
		l8.setBounds(180,450,80,20);
		l8.setFont(f2);
//		l8.setBackground(Color.white);
		add(l8);
		l9=new Label("Address :");
		l9.setBounds(180,500,100,20);
		l9.setFont(f2);
		add(l9);
		tname=new Label("Test Name");
		tname.setBounds(840,450,120,20);
		tname.setFont(f2);
		add(tname);
		date=new Label("Date");
		date.setBounds(840,500,60,20);
		date.setFont(f2);
		add(date);

		tf1=new TextField();
		tf1.setBounds(400,150,200,25);
		add(tf1);

		tf2=new TextField();
		tf2.setBounds(400,200,200,25);
		add(tf2);

		tf3=new TextField();
		tf3.setBounds(400,250,40,25);
		add(tf3);

		tf4=new TextField();
		tf4.setBounds(400,300,200,25);
		add(tf4);

		tf5=new TextField();
		tf5.setBounds(400,350,200,25);
		add(tf5);

		tf6=new TextField();
		tf6.setBounds(270,85,72,28);
		tf6.setFont(f2);
		tf6.setForeground(Color.red);
		add(tf6);
		tf6.addActionListener(this);

		tf7=new TextField();
		tf7.setBounds(960,450,180,26);
		tf7.setFont(f2);
		tf7.setForeground(Color.blue);
		add(tf7);

		tf8=new TextField();
		tf8.setBounds(400,400,80,26);
		add(tf8);
		
		tf9=new TextField();
		tf9.setBounds(400,450,180,26);
		add(tf9);
		
		tf10=new TextField();
		tf10.setBounds(960,500,180,26);
		add(tf10);
		
		ta=new TextArea();
		ta.setBounds(400,500,200,100);
		add(ta);

		b1=new JButton("Report Entry");
		b1.setBounds(880,600,150,25);
		b1.setBackground(Color.white);
		b1.setForeground(Color.blue);
		add(b1);
		b2=new JButton("Close");
		b2.setBounds(1050,600,100,25);
		b2.setBackground(Color.white);
		b2.setForeground(Color.blue);
		add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);

		med=new MediaTracker(this);
		tk=tk.getDefaultToolkit();
		img=tk.getImage("image\\lab4.jpg");
		
		
		Container c=this.getContentPane();
		c.setBackground(Color.white);	
	  setSize(1368,720);
	  setLayout(null);
	  setVisible(true);
	}

	public void actionPerformed(ActionEvent e2)
	{
		if(e2.getSource()==b1)
		{
		   Reportentry rt=new Reportentry();
		}
		if(e2.getSource()==b2)
		{
			dispose();
		}
		if(e2.getSource()==tf6)
		{
			try{
				String dis=tf6.getText();
				System.out.println(dis);
			pid1=Integer.parseInt(dis);
			ResultSet rs;
			DataBase1 db=new DataBase1();
			rs=db.st.executeQuery("select *from patiententry where PATIENT_ID="+pid1+"");
			while(rs.next())
			{
				nm=rs.getString(2);
				ref=rs.getString(3);
				ag=rs.getString(4);
				moth=rs.getString(5);
				fath=rs.getString(6);
				test1=rs.getString(10);
				scon1=rs.getString(8);
				scon2=rs.getString(11);
				add=rs.getString(9);
				se=rs.getString(7);
			}
			tf1.setText(nm);
			tf2.setText(ref);
			tf3.setText(ag);
			tf4.setText(moth);
			tf5.setText(fath);
			tf8.setText(se);
			tf9.setText(scon1);
			tf10.setText(scon2);
			tf7.setText(test1);
			ta.setText(add);

		//	System.out.println(nm+ref+ag+moth+fath+test1);
			}catch(Exception e3)
			{
				e3.printStackTrace();
			}
		}
	
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(img,800,140,this);

		float dashes[]={8,6};

		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,dashes,2));
		g2.drawLine(150,160,650,160);
		g2.drawLine(150,160,150,670);
		g2.drawLine(150,670,650,670);
		g2.drawLine(650,670,650,160);

	}
//	public static void main(String[] args) 
//	{
//		new Labentry();
//	}
}
