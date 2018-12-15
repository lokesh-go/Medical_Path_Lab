import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Newaccount extends JFrame 
{
	JLabel cr,usr,pass;
	JTextField tf1;
	JPasswordField tf2;
	Newaccount()
	{
		cr=new JLabel("Create New account");
		add(cr);
		setSize(600,600);
		Container c=this.getContentPane();
		c.setBackground(Color.white);
		setLayout(null);
		setVisible(true);
	
	}
	public static void main(String[] args) 
	{
		new Newaccount();
	}
}
