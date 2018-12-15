import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.sql.*;

public class Medical extends JFrame implements ActionListener 
{
	Label path;
	JButton Enter;
	Font f1,f2,f3;
	Image img,img1,img2,img3,img4,img5,img6,img7,img8;
	MediaTracker med;
	Toolkit tk;
		

	Medical()
	{
		Enter=new JButton("Click to Log in");
		add(Enter);
		Enter.setBounds(1050,580,140,29);
		Enter.setBackground(Color.white);
		Enter.setForeground(Color.blue);
		f2=new Font("", Font.BOLD, 14);
		f3=new Font("", Font.BOLD, 18);
		Enter.setFont(f2);
		Enter.addActionListener(this);
		

		med=new MediaTracker(this);
		tk=tk.getDefaultToolkit();
		img=tk.getImage("image\\p.jpg");
		img1=tk.getImage("image\\q.jpg");

		img2=tk.getImage("image\\lab.jpg");
		img3=tk.getImage("image\\o.jpg");
		img4=tk.getImage("image\\labw.jpg"); 
		img5=tk.getImage("image\\ana.jpg");
		img6=tk.getImage("image\\s1.jpg");
		
		setLayout(null);
		
		Container c=this.getContentPane();
		c.setBackground(Color.white);
		setSize(1368,720);
		setVisible(true);
		
		f1=new Font("Serif", Font.PLAIN, 70);
		
		path=new Label("Medical Path Lab");
		add(path);
		path.setBounds(250,60,500,60);
		path.setFont(f1);
		path.setBackground(Color.white);
		path.setForeground(Color.red);
		
	}

 
	public void actionPerformed(ActionEvent e)
	{
		Login lg=new Login();
		dispose();
	}
	

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(img,30,50,this);
		g2.drawImage(img1,30,190,this);
		g2.drawImage(img2,210,530,this);
		g2.drawImage(img3,30,530,this);
		g2.drawImage(img4,400,530,this);
		g2.drawImage(img5,600,530,this);
		g2.drawImage(img6,900,190,this);

	}


	public static void main(String[] args) 
	{
		new Medical();
	}
}