import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyPanel extends JPanel
{
	
	MyPanel(String s)
	{
		setBounds(0,0,1200,800);
	}
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.decode("#CC0000");
        Color color2 = Color.decode("#0100B3");
        GradientPaint gp = new GradientPaint(200, 100, color1, 100, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }

}
class MyPanel_white extends JPanel
{
	public MyPanel_white() {
		setBackground(Color.white);
	}
}
class MyButton extends JButton
{	Font f=new Font("Arial",Font.BOLD,15);
	MyButton(String s)
	{
		super(s);
		setBackground(Color.decode("#ADD8E6"));
		setBorderPainted(false);
		setFont(f);
	}
}
class MyTF1 extends JTextField
{
	MyTF1()
	{
		Font f=new Font("Arial",Font.BOLD,15);
		setFont(f);
		setBackground(Color.black);
		setForeground(Color.white);
		setBorder(null);
	}
}
class MyTF2 extends JTextField
{
	MyTF2()
	{
		Font f=new Font("Arial",Font.BOLD,20);
		setFont(f);
		setBackground(Color.black);
		setForeground(Color.white);
		setBorder(null);
	}
}
class MakePanel extends JFrame implements ActionListener,MouseListener
{
	
	Container cont;
	MyTF1 tf1;
	MyTF2 tf2;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18;
	MyPanel panel_main;
	MyPanel_white panel_in;
	int flag1=0,flag2=0,flag3=0;
	String lab,tf1data,tf2data;
	int isnum=0,isdot=0;
	MakePanel(String s)
	{
		super(s);
		//setBackground(new Color(0, 0, 0, 0));
		cont = getContentPane();
		cont.setLayout(null);
		cont.setBackground(Color.decode("#333"));
		
		panel_main = new MyPanel("Main_Panel");
		panel_main.setLayout(null);
		cont.add(panel_main);
		
		panel_in=new MyPanel_white();
		panel_in.setBounds(450, 150, 294, 458);
		panel_in.setLayout(null);
		panel_main.add(panel_in);
		
		tf1=new MyTF1();
		tf2=new MyTF2();
		tf1.setText("");
		tf2.setText("");
		
		panel_in.add(tf1);
		panel_in.add(tf2);
		
		tf1.setBounds(0,0,294,30);
		tf2.setBounds(0,30,294,60);
		
		b1=new MyButton("AC");
		b1.setBounds(1,91,144,70);
		
		b2=new MyButton("DEL");
		b2.setBounds(149,91,70,70);
		
		b3=new MyButton("/");
		b3.setBounds(223,91,70,70);
		
		
		b4=new MyButton("1");
		b4.setBounds(1,165,70,70);
		
		b5=new MyButton("2");
		b5.setBounds(75,165,70,70);
		
		b6=new MyButton("3");
		b6.setBounds(149,165,70,70);
		
		b7=new MyButton("*");
		b7.setBounds(223,165,70,70);
		
		
		b8=new MyButton("4");
		b8.setBounds(1,239,70,70);
		
		b9=new MyButton("5");
		b9.setBounds(75,239,70,70);
		
		b10=new MyButton("6");
		b10.setBounds(149,239,70,70);
		
		b11=new MyButton("+");
		b11.setBounds(223,239,70,70);
		
		
		b12=new MyButton("7");
		b12.setBounds(1,313,70,70);
		
		b13=new MyButton("8");
		b13.setBounds(75,313,70,70);
		
		b14=new MyButton("9");
		b14.setBounds(149,313,70,70);
		
		b15=new MyButton("-");
		b15.setBounds(223,313,70,70);
		
		
		b16=new MyButton(".");
		b16.setBounds(1,387,70,70);
		
		b17=new MyButton("0");
		b17.setBounds(75,387,70,70);
		
		b18=new MyButton("=");
		b18.setBounds(149,387,144,70);
		
		panel_in.add(b1);
		panel_in.add(b2);
		panel_in.add(b3);
		
		panel_in.add(b4);
		panel_in.add(b5);
		panel_in.add(b6);
		panel_in.add(b7);
		
		panel_in.add(b8);
		panel_in.add(b9);
		panel_in.add(b10);
		panel_in.add(b11);
		
		panel_in.add(b12);
		panel_in.add(b13);
		panel_in.add(b14);
		panel_in.add(b15);
		
		panel_in.add(b16);
		panel_in.add(b17);
		panel_in.add(b18);
		
		b1.addMouseListener(this);b1.addActionListener(this);
		b2.addMouseListener(this);b2.addActionListener(this);
		b3.addMouseListener(this);b3.addActionListener(this);
		b4.addMouseListener(this);b4.addActionListener(this);
		b5.addMouseListener(this);b5.addActionListener(this);
		b6.addMouseListener(this);b6.addActionListener(this);
		b7.addMouseListener(this);b7.addActionListener(this);
		b8.addMouseListener(this);b8.addActionListener(this);
		b9.addMouseListener(this);b9.addActionListener(this);
		b10.addMouseListener(this);b10.addActionListener(this);
		b11.addMouseListener(this);b11.addActionListener(this);
		b12.addMouseListener(this);b12.addActionListener(this);
		b13.addMouseListener(this);b13.addActionListener(this);
		b14.addMouseListener(this);b14.addActionListener(this);
		b15.addMouseListener(this);b15.addActionListener(this);
		b16.addMouseListener(this);b16.addActionListener(this);
		b17.addMouseListener(this);b17.addActionListener(this);
		b18.addMouseListener(this);b18.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	void validation(String s)
	{
		if(flag1==1 && flag2==0)
		{
			if(s.equals("AC")){			b1.setBackground(Color.decode("#67818A"));b1.setForeground(Color.white);	}
			else if(s.equals("DEL")) {	b2.setBackground(Color.decode("#67818A"));b2.setForeground(Color.white);	}
			else if(s.equals("/")) 	{	b3.setBackground(Color.decode("#67818A"));b3.setForeground(Color.white);	}
			else if(s.equals("1")) {	b4.setBackground(Color.decode("#67818A"));b4.setForeground(Color.white);	}
			else if(s.equals("2")) {	b5.setBackground(Color.decode("#67818A"));	b5.setForeground(Color.white);}
			else if(s.equals("3")) {	b6.setBackground(Color.decode("#67818A"));	b6.setForeground(Color.white);}
			else if(s.equals("*")) {	b7.setBackground(Color.decode("#67818A"));	b7.setForeground(Color.white);}
			else if(s.equals("4")) {	b8.setBackground(Color.decode("#67818A"));	b8.setForeground(Color.white);}
			else if(s.equals("5")) {	b9.setBackground(Color.decode("#67818A"));	b9.setForeground(Color.white);}
			else if(s.equals("6")) {	b10.setBackground(Color.decode("#67818A"));	b10.setForeground(Color.white);}
			else if(s.equals("+")) {	b11.setBackground(Color.decode("#67818A"));	b11.setForeground(Color.white);}
			else if(s.equals("7")) {	b12.setBackground(Color.decode("#67818A"));	b12.setForeground(Color.white);}
			else if(s.equals("8")) {	b13.setBackground(Color.decode("#67818A"));	b13.setForeground(Color.white);}
			else if(s.equals("9")) {	b14.setBackground(Color.decode("#67818A"));	b14.setForeground(Color.white);}
			else if(s.equals("-")) {	b15.setBackground(Color.decode("#67818A"));	b15.setForeground(Color.white);}
			else if(s.equals(".")) {	b16.setBackground(Color.decode("#67818A"));	b16.setForeground(Color.white);}
			else if(s.equals("0")) {	b17.setBackground(Color.decode("#67818A"));	b17.setForeground(Color.white);}
			else if(s.equals("=")) {	b18.setBackground(Color.decode("#67818A"));	b18.setForeground(Color.white);}
		}
		else if(flag1==0 && flag2==1)
		{
			if(s.equals("AC")){			b1.setBackground(Color.decode("#ADD8E6"));	b1.setForeground(Color.black);}
			else if(s.equals("DEL")) {	b2.setBackground(Color.decode("#ADD8E6"));	b2.setForeground(Color.black);}
			else if(s.equals("/")) 	{	b3.setBackground(Color.decode("#ADD8E6"));	b3.setForeground(Color.black);}
			else if(s.equals("1")) {	b4.setBackground(Color.decode("#ADD8E6"));	b4.setForeground(Color.black);}
			else if(s.equals("2")) {	b5.setBackground(Color.decode("#ADD8E6"));	b5.setForeground(Color.black);}
			else if(s.equals("3")) {	b6.setBackground(Color.decode("#ADD8E6"));	b6.setForeground(Color.black);}
			else if(s.equals("*")) {	b7.setBackground(Color.decode("#ADD8E6"));	b7.setForeground(Color.black);}
			else if(s.equals("4")) {	b8.setBackground(Color.decode("#ADD8E6"));	b8.setForeground(Color.black);}
			else if(s.equals("5")) {	b9.setBackground(Color.decode("#ADD8E6"));	b9.setForeground(Color.black);}
			else if(s.equals("6")) {	b10.setBackground(Color.decode("#ADD8E6"));	b10.setForeground(Color.black);}
			else if(s.equals("+")) {	b11.setBackground(Color.decode("#ADD8E6"));	b11.setForeground(Color.black);}
			else if(s.equals("7")) {	b12.setBackground(Color.decode("#ADD8E6"));	b12.setForeground(Color.black);}
			else if(s.equals("8")) {	b13.setBackground(Color.decode("#ADD8E6"));	b13.setForeground(Color.black);}
			else if(s.equals("9")) {	b14.setBackground(Color.decode("#ADD8E6"));	b14.setForeground(Color.black);}
			else if(s.equals("-")) {	b15.setBackground(Color.decode("#ADD8E6"));	b15.setForeground(Color.black);}
			else if(s.equals(".")) {	b16.setBackground(Color.decode("#ADD8E6"));	b16.setForeground(Color.black);}
			else if(s.equals("0")) {	b17.setBackground(Color.decode("#ADD8E6"));	b17.setForeground(Color.black);}
			else if(s.equals("=")) {	b18.setBackground(Color.decode("#ADD8E6"));	b18.setForeground(Color.black);}
		}
		else if(flag3==1 && flag1==0 && flag2==0)
		{
			if(s.equals("AC")){			b1.setBackground(Color.decode("#99CC00"));	b1.setForeground(Color.black);}
			else if(s.equals("DEL")) {	b2.setBackground(Color.decode("#99CC00"));	b2.setForeground(Color.black);}
			else if(s.equals("/")) 	{	b3.setBackground(Color.decode("#99CC00"));	b3.setForeground(Color.black);}
			else if(s.equals("1")) {	b4.setBackground(Color.decode("#99CC00"));	b4.setForeground(Color.black);}
			else if(s.equals("2")) {	b5.setBackground(Color.decode("#99CC00"));	b5.setForeground(Color.black);}
			else if(s.equals("3")) {	b6.setBackground(Color.decode("#99CC00"));	b6.setForeground(Color.black);}
			else if(s.equals("*")) {	b7.setBackground(Color.decode("#99CC00"));	b7.setForeground(Color.black);}
			else if(s.equals("4")) {	b8.setBackground(Color.decode("#99CC00"));	b8.setForeground(Color.black);}
			else if(s.equals("5")) {	b9.setBackground(Color.decode("#99CC00"));	b9.setForeground(Color.black);}
			else if(s.equals("6")) {	b10.setBackground(Color.decode("#99CC00"));	b10.setForeground(Color.black);}
			else if(s.equals("+")) {	b11.setBackground(Color.decode("#99CC00"));	b11.setForeground(Color.black);}
			else if(s.equals("7")) {	b12.setBackground(Color.decode("#99CC00"));	b12.setForeground(Color.black);}
			else if(s.equals("8")) {	b13.setBackground(Color.decode("#99CC00"));	b13.setForeground(Color.black);}
			else if(s.equals("9")) {	b14.setBackground(Color.decode("#99CC00"));	b14.setForeground(Color.black);}
			else if(s.equals("-")) {	b15.setBackground(Color.decode("#99CC00"));	b15.setForeground(Color.black);}
			else if(s.equals(".")) {	b16.setBackground(Color.decode("#99CC00"));	b16.setForeground(Color.black);}
			else if(s.equals("0")) {	b17.setBackground(Color.decode("#99CC00"));	b17.setForeground(Color.black);}
			else if(s.equals("=")) {	b18.setBackground(Color.decode("#99CC00"));	b18.setForeground(Color.black);}
		
		}
	}
	public void mouseClicked(MouseEvent e) {  
		flag1=0;    	flag2=0;   	flag3=1;
    	AbstractButton EventSource = (AbstractButton)e.getSource();
        validation(EventSource.getText());
    }  
    public void mouseEntered(MouseEvent e) {  
    	flag1=1;    	flag2=0;    	flag3=0;
    	AbstractButton EventSource = (AbstractButton)e.getSource();
        validation(EventSource.getText());
    }  
    public void mouseExited(MouseEvent e) {  
    	flag1=0;   	flag2=1;   	flag3=0;
    	AbstractButton EventSource = (AbstractButton)e.getSource();
        validation(EventSource.getText());
    }  
    public void mousePressed(MouseEvent e) {           }  
    public void mouseReleased(MouseEvent e) {            }  
    // Action Performed
	public void actionPerformed(ActionEvent ae)
	{
		
			lab=ae.getActionCommand();
			if(lab.equals("AC"))
			{	isdot=1;
				tf1.setText("");
				tf2.setText("");
				isnum=0;
			}
			else if(lab.equals("DEL")) {
				if((tf2.getText()).equals(""))
				{	}
				else
				{
					isdot=1;
				tf2data=tf2.getText();
				tf2.setText(tf2data.substring(0,tf2data.length() - 1));
				}
			}
			else if(lab.equals("/")) 	{	
				try
				{
					if(isnum==1)
					{	isdot=1;
						if((tf1.getText()).equals(""))
						{
							tf2data=tf2.getText();
							tf1data=tf2data.concat("/");
							tf1.setText(tf1data);
							tf2.setText("");
						}
						else
						{
							tf1data=tf1.getText();
							tf2data=tf2.getText();
							double a=Double.parseDouble(tf1data.substring(0, tf1data.length() - 1));
							double b=Double.parseDouble(tf2data);
							tf1.setText("");
							//double c=1;
							String sim=tf1data.substring(tf1data.length() - 1,tf1data.length());
							double c=1;
							if(sim.equals("/"))
							{	c=a/b;	}
							else if(sim.equals("*"))
							{	c=a*b;	}
							else if(sim.equals("-"))
							{	c=a-b;	}
							else if(sim.equals("+"))
							{	c=a+b;	}
							tf1.setText((Double.toString(c)).concat("/"));
							tf2.setText("");
						}
					}
					isnum=0;
				}
				catch(Exception e)
				{
					System.out.println("--> Error : "+e.getMessage());
					tf1.setText("");
					tf1.setText("Press AC ");
					tf2.setText("ERROR");
				}
			}
			else if(lab.equals("1")) {	
				isnum=1;
				isdot=1;
				tf2data=tf2.getText();
				tf2data=tf2data.concat("1");
				tf2.setText(tf2data);
			}
			else if(lab.equals("2")) {	
				isnum=1;
				isdot=1;
				tf2data=tf2.getText();
				tf2data=tf2data.concat("2");
				tf2.setText(tf2data);
			}
			else if(lab.equals("3")) {
				isnum=1;
				isdot=1;
				tf2data=tf2.getText();
				tf2data=tf2data.concat("3");
				tf2.setText(tf2data);
			}
			else if(lab.equals("*")) {
				try
				{
					if(isnum==1)
					{	isdot=1;
						if((tf1.getText()).equals(""))
						{
							tf1data=tf2.getText();
							tf1.setText(tf1data.concat("*"));
							tf2.setText("");
						}
						else
						{
							tf1data=tf1.getText();
							tf2data=tf2.getText();
							double a=Double.parseDouble(tf1data.substring(0,tf1data.length() - 1));
							double b=Double.parseDouble(tf2data);
							String sim=tf1data.substring(tf1data.length() - 1,tf1data.length());
							double c=1;
							if(sim.equals("/"))
							{	c=a/b;	}
							else if(sim.equals("*"))
							{	c=a*b;	}
							else if(sim.equals("-"))
							{	c=a-b;	}
							else if(sim.equals("+"))
							{	c=a+b;	}
							
							tf1.setText("");
							tf1.setText((Double.toString(c)).concat("*"));
							tf2.setText("");
						}
					}
					isnum=0;
				}
				catch(Exception e)
				{
					System.out.println("--> Error : "+e.getMessage());
					tf1.setText("");
					tf1.setText("Press AC ");
					tf2.setText("ERROR");
				}
			}
			else if(lab.equals("4")) {	
				isnum=1;
				isdot=1;
				tf2data=tf2.getText();
				tf2data=tf2data.concat("4");
				tf2.setText(tf2data);
			}
			else if(lab.equals("5")) {	
				isnum=1;
				isdot=1;
				tf2data=tf2.getText();
				tf2data=tf2data.concat("5");
				tf2.setText(tf2data);
			}
			else if(lab.equals("6")) {
				isnum=1;
				isdot=1;
				tf2data=tf2.getText();
				tf2data=tf2data.concat("6");
				tf2.setText(tf2data);
			}
			else if(lab.equals("+")) {
				try
				{
					if(isnum==1)
					{	isdot=1;
						if((tf1.getText()).equals(""))
						{
							tf1data=tf2.getText();
							tf1.setText(tf1data.concat("+"));
							tf2.setText("");
						}
						else
						{
							tf1data=tf1.getText();
							tf2data=tf2.getText();
							double a=Double.parseDouble(tf1data.substring(0,tf1data.length() - 1));
							double b=Double.parseDouble(tf2data);
							String sim=tf1data.substring(tf1data.length() - 1,tf1data.length());
							double c=1;
							if(sim.equals("/"))
							{	c=a/b;	}
							else if(sim.equals("*"))
							{	c=a*b;	}
							else if(sim.equals("-"))
							{	c=a-b;	}
							else if(sim.equals("+"))
							{	c=a+b;	}
							
							tf1.setText("");
							tf1.setText((Double.toString(c)).concat("+"));
							tf2.setText("");
						}
					}
					isnum=0;
				}
				catch(Exception e)
				{
					System.out.println("--> Error : "+e.getMessage());
					tf1.setText("");
					tf1.setText("Press AC ");
					tf2.setText("ERROR");
				}
			}
			else if(lab.equals("7")) {
				isnum=1;
				isdot=1;
				tf2data=tf2.getText();
				tf2data=tf2data.concat("7");
				tf2.setText(tf2data);
			}
			else if(lab.equals("8")) {
				isnum=1;
				isdot=1;
				tf2data=tf2.getText();
				tf2data=tf2data.concat("8");
				tf2.setText(tf2data);
			}
			else if(lab.equals("9")) {
				isnum=1;
				isdot=1;
				tf2data=tf2.getText();
				tf2data=tf2data.concat("9");
				tf2.setText(tf2data);
			}
			else if(lab.equals("-")) {	
				try
				{
					if(isnum==1)
					{	isdot=1;
						if((tf1.getText()).equals(""))
						{
							tf1data=tf2.getText();
							tf1.setText(tf1data.concat("-"));
							tf2.setText("");
						}
						else
						{
							tf1data=tf1.getText();
							tf2data=tf2.getText();
							double a=Double.parseDouble(tf1data.substring(0,tf1data.length() - 1));
							double b=Double.parseDouble(tf2data);
							String sim=tf1data.substring(tf1data.length() - 1,tf1data.length());
							double c=1;
							if(sim.equals("/"))
							{	c=a/b;	}
							else if(sim.equals("*"))
							{	c=a*b;	}
							else if(sim.equals("-"))
							{	c=a-b;	}
							else if(sim.equals("+"))
							{	c=a+b;	}
							
							tf1.setText("");
							tf1.setText((Double.toString(c)).concat("-"));
							tf2.setText("");
						}
					}
					isnum=0;
				}
				catch(Exception e)
				{
					System.out.println("--> Error : "+e.getMessage());
					tf1.setText("");
					tf1.setText("Press AC ");
					tf2.setText("ERROR");
				}
			}
			else if(lab.equals(".")) {	
				isnum=1;
				if(isdot==1)
				{
				tf2data=tf2.getText();
				tf2data=tf2data.concat(".");
				tf2.setText(tf2data);
				}
				isdot=0;
			}
			else if(lab.equals("0")) {	
				isnum=1;
				isdot=1;
				tf2data=tf2.getText();
				tf2data=tf2data.concat("0");
				tf2.setText(tf2data);
			}
			else if(lab.equals("=")) {	
				try
				{
					isdot=1;
					if((tf2.getText()).equals(""))
					{
						
					}
					else
					{
						if((tf1.getText()).equals(""))
						{	}
						else
						{
						tf1data=tf1.getText();
						tf2data=tf2.getText();
						double a=Double.parseDouble(tf1data.substring(0,tf1data.length() - 1));
						double b=Double.parseDouble(tf2data);
						String sim=tf1data.substring(tf1data.length() - 1,tf1data.length());
						double c=1;
						if(sim.equals("/"))
						{	c=a/b;	}
						else if(sim.equals("*"))
						{	c=a*b;	}
						else if(sim.equals("-"))
						{	c=a-b;	}
						else if(sim.equals("+"))
						{	c=a+b;	}
						tf2.setText(Double.toString(c));
						tf1.setText("");
						}
					}
				}
				catch(Exception e)
				{
					System.out.println("--> Error : "+e.getMessage());
					tf1.setText("");
					tf1.setText("Press AC ");
					tf2.setText("ERROR");
				}
			}
	}
}
public class MyCal {
	public static void main(String[] args) 
	{
		MakePanel mp=new MakePanel("ManGroove's  Calculator");
		mp.setVisible(true);
		mp.setBounds(150,100,1200,820);
	}
}