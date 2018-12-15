import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.util.*;
import java.sql.*;

public class Transaction extends JFrame implements ActionListener, ItemListener
{
	Label dt,pname,test,apaid,date;
	TextArea ta1,ta2,ta3;
	JButton b1,b2;
	Font f1,f2,f3;
	JComboBox cb1,cb2,cb3;
	String day[]={"day","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String month[]={"month","01","02","03","04","05","06","07","08","09","10","11","12"};
	String year[]={"year","2016","2017","2018","2019","2020"};
	String s1,s2,s3,scon1,nm,tes,amt;
		

	Transaction()
	{
		f1=new Font("Serif", Font.BOLD, 24);
		f2=new Font("Serif", Font.BOLD, 20);
		f3=new Font("Serif", Font.BOLD, 18);
		dt=new Label("Daily Transaction");
		dt.setBounds(300,49,203,26);
		dt.setFont(f1);
		dt.setBackground(Color.red);
		dt.setForeground(Color.white);
		add(dt);
		date=new Label("Date");
		date.setBounds(270,100,50,30);
		date.setFont(f2);
		add(date);
		cb1=new JComboBox(day);
		cb1.setBounds(325,103,50,23);
		add(cb1);
		cb2=new JComboBox(month);
		cb2.setBounds(376,103,64,23);
		add(cb2);
		cb3=new JComboBox(year);
		cb3.setBounds(441,103,55,23);
		add(cb3);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb3.addActionListener(this);

		pname=new Label("Patient Name");
		pname.setBounds(66,150,150,30);
		pname.setFont(f2);
		add(pname);
		test=new Label("Test Name");
		test.setBounds(350,150,150,30);
		test.setFont(f2);
		add(test);
		apaid=new Label("Amount Paid");
		apaid.setBounds(550,150,150,30);
		apaid.setFont(f2);
		add(apaid);
		ta1=new TextArea();
		ta1.setBounds(66,180,280,440);
		add(ta1);
		ta2=new TextArea();
		ta2.setBounds(346,180,200,440);
		add(ta2);
		ta3=new TextArea();
		ta3.setBounds(546,180,180,440);
		add(ta3);
		b1=new JButton("Close");
		b1.setBounds(585,642,100,25);
		b1.setFont(f3);
		b1.setBackground(Color.white);
		b1.setForeground(Color.red);
		add(b1);
		b1.addActionListener(this);
		setSize(800,720);
		setLayout(null);
		setVisible(true);
	}
	public void itemStateChanged(ItemEvent e1)
	{
			 s1=cb1.getSelectedItem().toString();
			 s2=cb2.getSelectedItem().toString();
			 s3=cb3.getSelectedItem().toString();
			 scon1=s1+"/"+s2+"/"+s3;
			
			
	}
	 
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cb3)
		{
			try
			{
				Vector v;
				v=new Vector();
				ResultSet rs,rs1;
				DataBase1 db=new DataBase1();
				System.out.println(scon1);
				rs=db.st.executeQuery("select  name from patiententry where Date1='"+scon1+"'");
				while(rs.next())
				{
					nm=rs.getString(1);
					
					v.addElement(new String(nm));}
					Enumeration enum1=v.elements();
					
					while(enum1.hasMoreElements())
					{
						String resu=""+enum1.nextElement();
						ta1.append(resu);
						ta1.append("\n");
					
					
					rs1=db.st.executeQuery("select test_name,total_amt from billentry where name='"+resu+"'");
					while(rs1.next())
					{
						tes=rs1.getString(1);
						amt=rs1.getString(2);
						ta2.append(tes);
						ta3.append(amt);
						
						ta2.append("\n");
						ta3.append("\n");
					}

				//	System.out.println("Name.= "+nm);
				}
				/*	rs1=db.st.executeQuery("select test_name,total_amt from billentry where name='"+nm+"'");
					while(rs1.next())
					{
						tes=rs1.getString(1);
						amt=rs1.getString(2);
						ta2.append("\n");
						ta3.append("\n");
						ta2.append(tes);
						ta3.append(amt);
						
						System.out.println("Test Name= "+tes);
						System.out.println("Amount= "+amt);

					} */
				
								
			}
			catch (Exception e4)
			{
				e4.printStackTrace();
			}

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
		g2.setColor(Color.red);
		g2.fillRect(40,78,710,30);
		g2.fillRect(70,50,30,90);
	}
	public static void main(String[] args) 
	{
		new Transaction();
	}
}
