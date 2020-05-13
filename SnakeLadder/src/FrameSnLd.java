

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

public class FrameSnLd extends JFrame implements ActionListener,MouseListener
{
	
	String lab;
	JButton cancel,mini;
	Container cont;
	FirstSnLd f1;
	FrontSnLd f2;
	FrameSnLd()
	{
		cont = getContentPane();
		cont.setLayout(null);
		setLayout(null);
		setBounds(300,100,1200,800);
		setUndecorated(true);
		setVisible(true);
		
		//reload=0;
		
		ImageIcon img = new ImageIcon(FrameSnLd.class.getResource("/img/snake7.jpg"));
		this.setIconImage(img.getImage());
		
		cancel=new JButton();
		cancel.setLayout(null);
		cancel.setBounds(10,10,15,15);
		cancel.setFocusable(false);
		cancel.setBackground(Color.black);
		cancel.setBorder(new LineBorder(Color.red,1));
		
		
		mini=new JButton();
		mini.setLayout(null);
		mini.setBounds(30,10,15,15);
		mini.setFocusable(false);
		mini.setBackground(Color.black);
		mini.setBorder(new LineBorder(Color.yellow,1));
		//mini.setIcon(new ImageIcon("img/mini.png"));
		
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		f2=new FrontSnLd();
		f2.setVisible(true);
		f2.setBorder(null);
		f2.setBounds(0,0,1200,800);
		
		f2.play.setActionCommand("Play");
		f2.play.addActionListener(this);
		
		
		cancel.setActionCommand("x");
		mini.setActionCommand("-");
		
		cancel.addActionListener(this);
		mini.addActionListener(this);
		cancel.addMouseListener(this);
		mini.addMouseListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(cancel);
		add(mini);
		add(f2);
		
		f2.setVisible(false);
		f2.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		lab=ae.getActionCommand();
		if(lab.equals("-"))
		{
			setState(this.ICONIFIED);
		}
		else if(lab.equals("x"))
		{
			this.dispose();
			System.exit(0);
		}
		else if(lab.equals("Play"))
		{
			if(f2.p1.getText().equals("") || f2.p2.getText().equals(""))
			{
				if(f2.p1.getText().equals(""))
				{
					f2.p1.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.red));
				}
				else
				{
					f2.p1.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.white));
				}
				
				if(f2.p2.getText().equals(""))
				{
					f2.p2.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.red));
				}
				else
				{
					f2.p2.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.white));
				}
			}
			else
			{
				f1=new FirstSnLd(f2.p1.getText(),f2.p2.getText());
				f1.setBounds(0,0,1200,800);
				cont.add(f1);
				
				
				f2.setVisible(false);
				
				f1.setVisible(true);
				f1.setBorder(null);
			}
			
		}
		
		
	}
	
	public void mouseClicked(MouseEvent e) 
	{  
		
    }  
    public void mouseEntered(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(cancel))
    	{
    		EventSource.setBackground(Color.red);
    	}
    	else if(EventSource.equals(mini))
    	{
    		EventSource.setBackground(Color.YELLOW);
    	}
    } 
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(cancel))
    	{
    		EventSource.setBackground(Color.black);
    	}
    	else if(EventSource.equals(mini))
    	{
    		EventSource.setBackground(Color.black);
    	}
    }  
    public void mousePressed(MouseEvent e) 
    {
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    } 


}
