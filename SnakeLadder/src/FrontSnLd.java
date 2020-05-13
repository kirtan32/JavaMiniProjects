import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ImagePan3 extends JPanel{

    private BufferedImage img;

    public ImagePan3() {
       try {                
          img = ImageIO.read(FrontSnLd.class.getResource("/img/wall.jpg"));
       } catch (IOException ex) 
       {
    	   System.out.println("Error : "+ex.getMessage());
       }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);          
    }
}

public class FrontSnLd extends ImagePan3 implements ActionListener,MouseListener
{
	String lab;
	JLabel mainname1,mainname2,name3;
	JButton play;
	JTextField p1,p2;
	JLabel pl1,pl2;
	int flag;
	FrontSnLd()
	{
		setLayout(null);
		setVisible(false);
		
		Font f1=new Font("Arial",Font.BOLD,80);
		Font f2=new Font("Arial",Font.PLAIN,20);
		Font f3=new Font("TimesRoman",Font.BOLD,30);
		
		mainname1=new JLabel("Snake");
		mainname1.setForeground(Color.MAGENTA);
		mainname1.setBorder(null);
		mainname1.setLayout(null);
		mainname1.setBackground(Color.white);
		mainname1.setBounds(100,100,500,100);
		mainname1.setFont(f1);
		
		name3=new JLabel("&");
		name3.setBackground(Color.ORANGE);
		name3.setBorder(null);
		name3.setLayout(null);
		name3.setForeground(Color.black);
		name3.setBounds(550,100,100,100);
		name3.setFont(f1);
		
		mainname2=new JLabel("Ladder");
		mainname2.setForeground(Color.cyan);
		mainname2.setBorder(null);
		mainname2.setLayout(null);
		mainname2.setBackground(Color.white);
		mainname2.setBounds(780,100,400,100);
		mainname2.setFont(f1);
		
		pl1=new JLabel("Player1:");
		pl1.setForeground(Color.black);
		pl1.setBorder(null);
		pl1.setOpaque(false);
		pl1.setLayout(null);
		pl1.setBounds(50,650,150,50);
		pl1.setFont(f3);
		
		p1=new JTextField();
		p1.setBounds(200,650,200,50);
		p1.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.white));
		p1.setForeground(Color.magenta);
		p1.setBackground(Color.DARK_GRAY);
		//p1.setOpaque(false);
		p1.setCaretColor(Color.magenta);
		p1.setFont(f2);
		
		pl2=new JLabel("Player2:");
		pl2.setForeground(Color.black);
		pl2.setBorder(null);
		pl2.setOpaque(false);
		pl2.setLayout(null);
		pl2.setBounds(450,650,150,50);
		pl2.setFont(f3);
		
		
		p2=new JTextField();
		p2.setBounds(650,650,200,50);
		p2.setBorder(BorderFactory.createMatteBorder(0,0,2,0, Color.white));
		p2.setForeground(Color.cyan);
		p2.setBackground(Color.DARK_GRAY);
		//p2.setOpaque(false);
		p2.setCaretColor(Color.cyan);
		p2.setFont(f2);
		
		play=new JButton("Play");
		play.setLayout(null);
		play.setBounds(950,650,200,100);
		play.setBackground(Color.black);
		play.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
		play.setForeground(Color.white);
		play.setFont(f3);
		play.setFocusable(false);
		
		play.addActionListener(this);
		play.addMouseListener(this);
		
		
		add(mainname1);
		add(mainname2);
		add(name3);
		add(play);
		add(pl1);
		add(p1);
		add(pl2);
		add(p2);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		lab=ae.getActionCommand();
		
	}
	
	public void mouseClicked(MouseEvent e) 
	{  
		AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(play))
    	{
    		EventSource.setBackground(Color.black);
    		EventSource.setForeground(Color.cyan);
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.cyan));
    	}
    }  
    public void mouseEntered(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(play))
    	{
    		EventSource.setBackground(Color.black);
    		EventSource.setForeground(Color.cyan);
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.cyan));
    	}
    } 
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(play))
    	{
    		//EventSource.setBackground(Color.yellow);
    		EventSource.setForeground(Color.white);
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
    	}
    }  
    public void mousePressed(MouseEvent e) 
    {
    	
    }  
    public void mouseReleased(MouseEvent e) 
    {
    	
    } 

	
}
