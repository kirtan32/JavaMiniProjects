import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BreakFrame extends JFrame implements ActionListener,MouseListener
{
	
	Container cont;
	int height,width,x,y;
	Breakpaint b1;
	String lab;
	BreakFrame(int x,int y,int width,int height)
	{
		cont = getContentPane();
		cont.setLayout(null);
		setLayout(null);
		//setUndecorated(true);
		

		ImageIcon img = new ImageIcon(BreakFrame.class.getResource("/img/icon1.jpeg"));
		this.setIconImage(img.getImage());
		
		this.height=height;
		this.width=width;
		this.x=x;
		this.y=y;
		
		//setBounds(x,y,width,height);
		setVisible(true);
		setLayout(null);
	
		b1=new Breakpaint(0,0,width,height);
		cont.add(b1);
		
		
		setLocationRelativeTo(null);
        setResizable(false);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}

	public void actionPerformed(ActionEvent ae)
	{
		
		lab=ae.getActionCommand();
		
	}
	
	public void mouseClicked(MouseEvent e) 
	{  
		AbstractButton EventSource = (AbstractButton)e.getSource();
		
	}  
	public void mouseEntered(MouseEvent e) 
	{  
		AbstractButton EventSource = (AbstractButton)e.getSource();
		
	} 
	public void mouseExited(MouseEvent e) 
	{  
		AbstractButton EventSource = (AbstractButton)e.getSource();
		
	}  
	public void mousePressed(MouseEvent e) 
	{
		
	}  
	public void mouseReleased(MouseEvent e) 
	{
		
	} 
}
