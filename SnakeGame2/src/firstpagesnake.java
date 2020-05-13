

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class ImagePan1 extends JPanel{

    private BufferedImage img;

    public ImagePan1() {
       try {                
          img = ImageIO.read(firstpagesnake.class.getResource("/img/back9.jpg"));
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
public class firstpagesnake extends ImagePan1 implements ActionListener,MouseListener 
{
	String lab;
	JButton play;
	JLabel mainname1,mainname2,mainname3,mainimg;
	public firstpagesnake() 
	{
		setLayout(null);
		setVisible(false);
		
		Font f1=new Font("Arial",Font.BOLD,80);
		Font f2=new Font("Arial",Font.PLAIN,15);
		Font f3=new Font("TimesRoman",Font.PLAIN,30);
	
		mainname1=new JLabel("Snake");
		mainname1.setForeground(Color.GRAY);
		mainname1.setBorder(null);
		mainname1.setLayout(null);
		mainname1.setBackground(Color.white);
		mainname1.setBounds(70,300,500,100);
		mainname1.setFont(f1);
		
		mainname2=new JLabel("Krase");
		mainname2.setForeground(Color.decode("#f5f5dc"));
		mainname2.setBorder(null);
		mainname2.setLayout(null);
		mainname2.setBackground(Color.white);
		mainname2.setBounds(900,300,400,100);
		mainname2.setFont(f1);
		
		mainname3=new JLabel("Kirtan Shah");
		mainname3.setForeground(Color.GRAY);
		mainname3.setBorder(null);
		mainname3.setLayout(null);
		mainname3.setBackground(Color.white);
		mainname3.setBounds(1080,00,400,50);
		mainname3.setFont(f2);
		
		mainimg=new JLabel();
		mainimg.setBorder(null);
		mainimg.setOpaque(false);
		mainimg.setLayout(null);
		mainimg.setBounds(180,200,200,200);
		mainimg.setIcon(new ImageIcon(firstpagesnake.class.getResource("/img/s1.png")));
		
		
		play=new JButton("Play");
		play.setLayout(null);
		play.setBounds(950,600,200,100);
		play.setBackground(Color.black);
		play.setForeground(Color.red);
		play.setFont(f3);
		play.setFocusable(false);
		play.setBorder(BorderFactory.createMatteBorder(4,2,4,2, Color.white));

		play.addActionListener(this);
		play.addMouseListener(this);
		

		add(play);
		add(mainname1);
		add(mainname2);
		add(mainname3);
		add(mainimg);
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		
		lab=ae.getActionCommand();
		
	}
	public void mouseClicked(MouseEvent e) 
	{  
		
	}  
	public void mouseEntered(MouseEvent e) 
	{  
		AbstractButton EventSource = (AbstractButton)e.getSource();
		if(EventSource.equals(play))
		{
			EventSource.setForeground(Color.white);
			EventSource.setBorder(BorderFactory.createMatteBorder(4,2,4,2, Color.red));
			//EventSource.setBorder(new OvalBorder1(0,0,Color.red,Color.white));
		}
		
	} 
	public void mouseExited(MouseEvent e) 
	{  
		AbstractButton EventSource = (AbstractButton)e.getSource();
		if(EventSource.equals(play))
		{
			EventSource.setForeground(Color.RED);
			EventSource.setBorder(BorderFactory.createMatteBorder(4,2,4,2, Color.white));
			
		}
		
	}  
	public void mousePressed(MouseEvent e) 
	{
		
	}  
	public void mouseReleased(MouseEvent e) 
	{
		
	} 
}
