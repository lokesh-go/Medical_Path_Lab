import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener
{
	JLabel usr,pass,login;
	JLabel l;
	JButton sign,close,signup;
	JTextField tf1;
	JPasswordField tf2;
	Font f1,f2;
	Icon i;
	String us,ps;
	Login()
	{
		i=new ImageIcon("image\\jv1.jpg");
		l=new JLabel(i);
		l.setBounds(92,127,100,100);
		add(l);

		f1=new Font("", Font.BOLD, 15);
		f2=new Font("Serif", Font.BOLD, 22);
		login=new JLabel("Log in");
		add(login);
		login.setBounds(65,20,100,40);
		login.setForeground(Color.blue);
		login.setFont(f2);
		
		usr=new JLabel("USERNAME");
		add(usr);
		usr.setBounds(230,130,100,30);
		usr.setForeground(Color.red);
		usr.setFont(f1);
		pass=new JLabel("PASSWORD");
		add(pass);
		pass.setBounds(230,190,100,30);
		pass.setForeground(Color.red);
		pass.setFont(f1);
		
		tf1=new JTextField();
		add(tf1);
		tf1.setBounds(350,130,150,30);
		tf1.setForeground(Color.blue);
		tf1.setFont(f1);
		tf2=new JPasswordField();
		add(tf2);
		tf2.setBounds(350,190,150,30);
		tf2.setForeground(Color.blue);
		tf2.setFont(f1);
	//	tf2.setEchoChar('*');
		
		sign=new JButton("Sign in");
		add(sign);
		sign.setBounds(350,250,150,30);
		sign.setForeground(Color.blue);
		sign.setBackground(Color.white);
		sign.setFont(f1);
		close=new JButton("Close");
		add(close);
		close.setBounds(93,250,100,30);
		close.setForeground(Color.red);
		close.setBackground(Color.white);
		close.setFont(f1);
		sign.addActionListener(this);
		close.addActionListener(this);
		signup=new JButton("Sign up");
		add(signup);
		signup.setBounds(350,30,150,30);
		signup.setForeground(Color.black);
		signup.setBackground(Color.white);
		signup.setFont(f1);
		signup.addActionListener(this);
		
		setSize(600,400);
		Container c=this.getContentPane();
		c.setBackground(Color.white);
		setLayout(null);
		setVisible(true);


	
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==sign)
		{
			us=tf1.getText();
			ps=tf2.getText();
			if(us.equals("lokesh")&& ps.equals("password"))
			{
				Entryform en=new Entryform();
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid user or password","Error Message",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==close)
		{
			dispose();		
		}
		if(e.getSource()==signup)
		{
			Signup sp=new Signup();
			dispose();
		}
	
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		float dashes[]={10,6};
		Graphics2D g2=(Graphics2D)g;
		g2.setColor(Color.blue);
		g2.setStroke(new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,dashes,2));
		g2.drawRect(100,157,100,100);
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10,dashes,2));
		g2.drawRect(70,120,450,210);
	
	}
//	public static void main(String[] args) 
//	{
//		new Login();
//	}
}
