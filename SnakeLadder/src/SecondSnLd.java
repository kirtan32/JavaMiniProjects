import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SecondSnLd extends JPanel implements ActionListener,MouseListener
{
	String lab,pname1,pname2;
	int player;
	JLabel chance1,chance2,out1,out2,img1,img2;
	JLabel ply1,ply2;
	JButton dice1,dice2;
	String stringp1,stringp2;
	JButton replay;
	public SecondSnLd(String ss1,String ss2) 
	{
		setLayout(null);
		setVisible(false);
		
		Font f1=new Font("Arial",Font.BOLD,80);
		Font f2=new Font("Arial",Font.PLAIN,20);
		Font f3=new Font("TimesRoman",Font.BOLD,40);
		
		pname1=ss1;
		pname2=ss2;
		
		setBounds(800,0,400,800);
		setBackground(Color.black);
		setVisible(true);
		
		stringp1="Chance of Player "+pname1;
		stringp2="Chance of Player "+pname2;
		player=1;
		
		ply1=new JLabel(pname1);
		ply1.setBorder(null);
		ply1.setOpaque(false);
		ply1.setBounds(50,20,300,70);
		ply1.setForeground(Color.magenta);
		ply1.setFont(f3);
		
		ply2=new JLabel(pname2);
		ply2.setBorder(null);
		ply2.setOpaque(false);
		ply2.setBounds(50,400,300,70);
		ply2.setForeground(Color.CYAN);
		ply2.setFont(f3);
		
		chance1=new JLabel(stringp1);
		chance1.setBorder(null);
		chance1.setOpaque(false);
		chance1.setBounds(50,100,300,50);
		chance1.setForeground(Color.yellow);
		chance1.setFont(f2);
		
		out1=new JLabel("");
		out1.setBorder(null);
		out1.setOpaque(false);
		out1.setBounds(50,170,350,50);
		out1.setForeground(Color.GREEN);
		out1.setFont(f2);
		
		dice1=new JButton();
		dice1.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.magenta));
		dice1.setBounds(150,230,115,115);
		dice1.setIcon(new ImageIcon(SecondSnLd.class.getResource("/img/diceno6.jpg")));
		dice1.setActionCommand("dice1");
		dice1.addActionListener(this);
		dice1.addMouseListener(this);
		
		img1=new JLabel();
		img1.setBorder(null);
		img1.setOpaque(false);
		img1.setBounds(50,250,70,70);
		img1.setIcon(new ImageIcon(SecondSnLd.class.getResource("/img/token05.png")));
		
		chance2=new JLabel("");
		chance2.setBorder(null);
		chance2.setOpaque(false);
		chance2.setBounds(50,500,300,50);
		chance2.setForeground(Color.yellow);
		chance2.setFont(f2);
		
		out2=new JLabel("");
		out2.setBorder(null);
		out2.setOpaque(false);
		out2.setBounds(50,570,350,50);
		out2.setForeground(Color.green);
		out2.setFont(f2);
		
		dice2=new JButton();
		dice2.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.CYAN));
		dice2.setBounds(150,620,115,115);
		dice2.setIcon(new ImageIcon(SecondSnLd.class.getResource("/img/diceno6.jpg")));
		dice2.setActionCommand("dice2");
		dice2.addActionListener(this);
		dice2.addMouseListener(this);
		dice2.setEnabled(false);
		
		img2=new JLabel();
		img2.setBorder(null);
		img2.setOpaque(false);
		img2.setBounds(50,650,70,70);
		img2.setIcon(new ImageIcon(SecondSnLd.class.getResource("/img/token04.png")));
		
//		replay=new JButton("Replay");
//		replay.setLayout(null);
//		replay.setBounds(250,10,140,70);
//		replay.setBackground(Color.black);
//		replay.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
//		replay.setForeground(Color.white);
//		replay.setFont(f2);
//		replay.setFocusable(false);
//		
//		replay.addActionListener(this);
//		replay.addMouseListener(this);
//		
		
		
		add(ply1);
		add(ply2);
		add(chance1);
		add(chance2);
		add(out1);
		add(out2);
		add(dice1);
		add(dice2);
		add(img1);
		add(img2);
		//add(replay);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.white);
		g.drawLine(0, 400, 400, 400);
		
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
    	if(EventSource.equals(dice1))
    	{
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
    	}
    	else if(EventSource.equals(dice2))
    	{
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.white));
    	}
    	else if(EventSource.equals(replay))
    	{
    		EventSource.setBackground(Color.black);
    		EventSource.setForeground(Color.cyan);
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.cyan));
    	}
    } 
    public void mouseExited(MouseEvent e) 
    {  
    	AbstractButton EventSource = (AbstractButton)e.getSource();
    	if(EventSource.equals(dice1))
    	{
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.magenta));
    	}
    	else if(EventSource.equals(dice2))
    	{
    		EventSource.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.CYAN));
    	}
    	else if(EventSource.equals(replay))
    	{
    		EventSource.setBackground(Color.black);
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
