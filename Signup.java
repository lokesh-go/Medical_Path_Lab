import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener  
{
	JButton ok,back;
	JLabel pass,head,head1;
	JPasswordField tf1;
	Font f1,f2;
	String ps;
	Signup()
	{
		f1=new Font("", Font.BOLD, 14);
		head=new JLabel("Before creating a new account you must have entered");
		add(head);
		head.setBounds(28,20,500,20);
		head.setForeground(Color.blue);
		head.setFont(f1);
		head1=new JLabel("administrator password....");
		add(head1);
		head1.setBounds(28,40,500,20);
		head1.setForeground(Color.blue);
		head1.setFont(f1);
		pass=new JLabel("PASSWORD");
		add(pass);
		pass.setBounds(100,100,100,20);
		pass.setForeground(Color.red);
		pass.setFont(f1);
		
		tf1=new JPasswordField();
		add(tf1);
		tf1.setBounds(200,100,170,27);
		tf1.setForeground(Color.red);
		tf1.setFont(f1);

		ok=new JButton("OK");
		add(ok);
		ok.setBounds(290,150,80,25);
		ok.setBackground(Color.white);
		ok.setForeground(Color.blue);
		back=new JButton("BACK");
		add(back);
		back.setBounds(200,150,80,25);
		back.setBackground(Color.white);
		back.setForeground(Color.blue);

		ok.addActionListener(this);
		back.addActionListener(this);

		setSize(500,250);
		Container c=this.getContentPane();
		c.setBackground(Color.white);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==ok)
		{
		ps=tf1.getText();
		if(ps.equals("sony"))
		{
		
		}
		else
			JOptionPane.showMessageDialog(null,"Invalid administrator password","Error Message",JOptionPane.ERROR_MESSAGE);
		}
		if(e.getSource()==back)
		{
			Login le=new Login();
			dispose();
		}
	}
//	public static void main(String[] args) 
//	{
//		new Signup();
//	}
}
