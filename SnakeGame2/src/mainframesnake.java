import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
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

public class mainframesnake extends JFrame implements ActionListener,MouseListener
{
	String lab;
	Container cont;
	JButton cancel,mini;
	firstpagesnake f1;
	secondpansnake s1;
	int height;
	int width;
	public mainframesnake(int width,int height) {
		
		this.height=height;
		this.width=width;
		
		cont = getContentPane();
		cont.setLayout(null);
		setLayout(null);
		setBounds(360,140,width,height);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
		//reload=0;
		
		ImageIcon img = new ImageIcon(mainframesnake.class.getResource("/img/s3.png"));
		this.setIconImage(img.getImage());
		
		cancel=new JButton();
		cancel.setLayout(null);
		cancel.setBounds(10,10,15,15);
		cancel.setFocusable(false);
		cancel.setBackground(Color.black);
		cancel.setBorder(new LineBorder(Color.red,1));
		//cancel.setIcon(new ImageIcon("img/cancel.png"));
		
		
		mini=new JButton();
		mini.setLayout(null);
		mini.setBounds(30,10,15,15);
		mini.setFocusable(false);
		mini.setBackground(Color.black);
		mini.setBorder(new LineBorder(Color.yellow,1));
		//mini.setIcon(new ImageIcon("img/mini.png"));
		
		f1=new firstpagesnake();
		f1.setLayout(null);
		f1.setVisible(true);
		f1.setBounds(0,0,width,height);
		
		
		
		cont.add(cancel);
		cont.add(mini);
		cont.add(f1);
		
		
		
		cancel.setActionCommand("x");
		mini.setActionCommand("-");
		
		cancel.addActionListener(this);
		mini.addActionListener(this);
		cancel.addMouseListener(this);
		mini.addMouseListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		f1.play.setActionCommand("Play");
		f1.play.addActionListener(this);
		
		
		
		f1.setVisible(false);
		f1.setVisible(true);
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
//			EventQueue.invokeLater(new Runnable() {
//	            @Override
//	            public void run() {                
//	                s1 = new paintpanel(1200, 750);  
//	                cont.add(s1);
//	                f1.setVisible(false);
//	    			s1.setVisible(true);
//	            }
//	        });
			
			s1 = new secondpansnake();
			s1.setBounds(0,0,width,height);
            cont.add(s1);
            f1.setVisible(false);
			s1.setVisible(true);
			
			s1.home.addActionListener(this);
			
			
		}
		else if(lab.equals("HOME"))
		{
			s1.setVisible(false);
			s1.sa1.dispose();
			s1=null;
			f1.setVisible(true);
		}
	}
	public void mouseClicked(MouseEvent e) 
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
