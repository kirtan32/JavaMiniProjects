import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class sam3 extends JFrame 
{
	Container cont;
	int height,width,x,y;
	paintpanel p1;
	sam3(int x,int y,int width,int height)
	{
		cont = getContentPane();
		cont.setLayout(null);
		setLayout(null);
		setUndecorated(true);
		

		ImageIcon img = new ImageIcon(secondpansnake.class.getResource("/img/s3.png"));
		this.setIconImage(img.getImage());
		
		this.height=height;
		this.width=width;
		this.x=x;
		this.y=y;
		
		//setBounds(x,y,width,height);
		setVisible(true);
		setLayout(null);
	
		p1=new paintpanel(0,0,width,height);
		cont.add(p1);
		
		setLocationRelativeTo(null);
        setResizable(false);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


public class secondpansnake extends JPanel implements ActionListener,MouseListener 
{
	String lab;
	sam3 sa1;
	JButton home,replay;
	JPanel top1;
	JLabel mainname1,mainname2;
	public secondpansnake() 
	{
		setLayout(null);
		setVisible(false);
		setBackground(Color.black);
		
		Font f1=new Font("TimesRoman",Font.BOLD,20);
		Font f2=new Font("Arial",Font.PLAIN,20);
		Font f3=new Font("TimesRoman",Font.BOLD,30);
		Font f4=new Font("Arial",Font.BOLD,30);
		
		top1=new JPanel();
		top1.setLayout(null);
		top1.setVisible(true);
		top1.setBounds(25,30,1150,70);
		top1.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.cyan));
		top1.setBackground(Color.BLACK);
		
		mainname1=new JLabel("Snake");
		mainname1.setForeground(Color.GRAY);
		mainname1.setBorder(null);
		mainname1.setLayout(null);
		mainname1.setBackground(Color.white);
		mainname1.setBounds(10,10,120,50);
		mainname1.setFont(f3);
		
		mainname2=new JLabel("Krase");
		mainname2.setForeground(Color.decode("#f5f5dc"));
		mainname2.setBorder(null);
		mainname2.setLayout(null);
		mainname2.setBackground(Color.white);
		mainname2.setBounds(120,10,100,50);
		mainname2.setFont(f4);
		
		
		home=new JButton("HOME");
		home.setBounds(950,10,150,50);
		//home.setOpaque(false);
		home.setBorder(null);
		//home.setContentAreaFilled(false);
		//home.setBorderPainted(false);
		home.setForeground(Color.black);
		home.setFocusable(false);
		home.setBackground(Color.yellow);
		home.addActionListener(this);
		home.addMouseListener(this);
		home.setFont(f2);
		
		replay=new JButton("REPLAY");
		replay.setBounds(750,10,150,50);
		//replay.setOpaque(false);
		replay.setBorder(null);
		//replay.setContentAreaFilled(false);
		//replay.setBorderPainted(false);
		replay.setForeground(Color.black);
		replay.setBackground(Color.GREEN);
		replay.setFocusable(false);
		replay.addActionListener(this);
		replay.addMouseListener(this);
		replay.setFont(f1);
		
		initPan();
		
		top1.add(home);
		top1.add(mainname1);
		top1.add(mainname2);
		top1.add(replay);
		add(top1);
	}
	public void initPan()
	{
		EventQueue.invokeLater(new Runnable() {
           @Override
            public void run() {                
               sa1 = new sam3(380,260,1150,600);
        	   //paintpanel pp1=new paintpanel(30,100,1150,600);
                sa1.setBounds(385,260,1150,600);
                //add(pp1);
                
            }
        });
		
//		p1=new paintpanel(30,125,1100,600);
////		p1.setLayout(null);
//		
//		add(p1);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		lab=ae.getActionCommand();
		if(lab.equals("REPLAY"))
		{
			sa1.setVisible(false);
			sa1.dispose();
			initPan();
		}
		else if(lab.equals("HOME"))
		{
			sa1.setVisible(false);
			sa1.dispose();
		}
	}
	public void mouseClicked(MouseEvent e) 
	{  
		
	}  
	public void mouseEntered(MouseEvent e) 
	{  
		AbstractButton EventSource = (AbstractButton)e.getSource();
		if(EventSource.equals(home))
		{
			EventSource.setForeground(Color.black);
			EventSource.setBackground(Color.cyan);
		}
		else if(EventSource.equals(replay))
		{
			EventSource.setForeground(Color.black);
			EventSource.setBackground(Color.cyan);
		}
		
	} 
	public void mouseExited(MouseEvent e) 
	{  
		AbstractButton EventSource = (AbstractButton)e.getSource();
		if(EventSource.equals(home))
		{
			EventSource.setForeground(Color.black);
			EventSource.setBackground(Color.yellow);
		}
		else if(EventSource.equals(replay))
		{
			EventSource.setForeground(Color.black);
			EventSource.setBackground(Color.GREEN);
		}
		
	}  
	public void mousePressed(MouseEvent e) 
	{
		
	}  
	public void mouseReleased(MouseEvent e) 
	{
		
	} 

}
