import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Breakpaint extends JPanel implements ActionListener
{
	
	boolean leftup;
	boolean leftdown;
	boolean rightup;
	boolean rightdown;
	
	int leftx,lefty,rightx,righty;
	
	Timer time;
	int delay=100;
	
	boolean inGame;
	
	boolean ballleft;
	boolean ballright;
	boolean ballup;
	boolean balldown;
	
	int ballx,bally;
	
	int flag=0;
	int win=0;
	Breakpaint(int x,int y,int width,int height)
	{
		
		setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.white));
		
		addKeyListener(new KeyMover());
		setBackground(Color.black);
		setFocusable(true);
		setVisible(true);
		setBounds(x,y,width,height);
		
		initGame();
	}
	
	public void initGame()
	{
		leftdown=false;
		leftup=false;
		rightdown=false;
		rightup=false;
		
		leftx=20;
		lefty=300;
		
		rightx=1070;
		righty=300;
		
		inGame=true;
		
		delay=50;
		
		ballleft=false;
		ballright=true;
		ballup=true;
		balldown=false;
		
		win=0;
		
		ballx=50;
		bally=150;
		
		time=new Timer(delay, this);
		time.start();
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		doPaint(g);
		
	}
	
	public void move()
	{
		if(leftup)
		{
			if(lefty==0)
			{
				lefty=0;
			}
			else
			{
				lefty-=10;
			}
		}
		if(leftdown)
		{
			if(lefty==600)
			{
				lefty=600;
			}
			else
			{
				lefty+=10;
			}
		}
		if(rightup)
		{
			if(righty==0)
			{
				righty=0;
			}
			else
			{
				righty-=10;
			}
		}
		if(rightdown)
		{
			if(righty==600)
			{
				righty=600;
			}
			else
			{
				righty+=10;
			}
		}
		
		if(ballright && ballup)
		{
			//System.out.println("rightup-->"+ballx+"  "+bally);
			if(bally==0)
			{
				ballup=false;
				balldown=true;
				ballx+=10;
				bally+=10;
			}
			else
			{
				//System.out.println("rightup-->"+ballx+"  "+bally);
				ballx+=10;
				bally-=10;
			}
			return;
		}
		if(ballright && balldown)
		{
			//System.out.println("rightdown-->"+ballx+"  "+bally);
			if(bally==690)
			{
				ballup=true;
				balldown=false;
				ballx+=10;
				bally-=10;
			}
			else
			{
				ballx+=10;
				bally+=10;
			}
			return;
		}
		if(ballleft && ballup)
		{
			//System.out.println("leftup-->"+ballx+"  "+bally);
			if(bally==0)
			{
				ballup=false;
				balldown=true;
				ballx-=10;
				bally+=10;
			}
			else
			{
				ballx-=10;
				bally-=10;
			}
			return;
		}
		if(ballleft && balldown)
		{
			//System.out.println("leftdown-->"+ballx+"  "+bally);
			if(bally==690)
			{
				ballup=true;
				balldown=false;
				ballx-=10;
				bally-=10;
			}
			else
			{
				ballx-=10;
				bally+=10;
			}
			return;
		}
		
	}
	
	public void checkWins()
	{
		if(ballx<=0)
		{
			inGame=false;
			win=1;
		}
		if(ballx>=1100)
		{
			inGame=false;
			win=0;
		}
		if(ballx==rightx)
		{
			if(bally>=righty && bally<=(righty+100))
			{
				ballright=false;
				ballleft=true;
				
			}
			
		}
		if(ballx==leftx)
		{
			if(bally>=lefty && bally<=(lefty+100))
			{
				ballright=true;
				ballleft=false;
			}
		}
	}
	
	public void doPaint(Graphics g)
	{
		if(inGame)
		{
			g.setColor(Color.DARK_GRAY);	
			g.drawLine(550, 0, 550, 700);
			g.drawLine(0, 350, 1100, 350);
			g.drawOval(350, 150, 400, 400);
			
			g.setColor(Color.white);
			g.fillOval(ballx, bally, 10, 10);
			
			g.setColor(Color.cyan);	
			g.fillRect(leftx, lefty, 10, 100);
			
			g.setColor(Color.magenta);
			g.fillRect(rightx, righty, 10, 100);
			
		}
		else
		{
			gameOver(g);
		}
		Toolkit.getDefaultToolkit().sync();
		
	}
	
	public void gameOver(Graphics g)
	{
		String msg = "Game Over";
        Font small = new Font("TimesRoman", Font.BOLD, 35);
        FontMetrics metr = getFontMetrics(small);

        int width=this.getWidth();
        int height=this.getHeight();
        
        g.setColor(Color.white);
        g.setFont(small);
        
        g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height/2 - 50);
        g.setColor(Color.ORANGE);
        if(win==0)
        {
        	g.drawString("Left Player Wins!", (width - metr.stringWidth(msg))/2 - 60, height/2  + 10);
        }
        else
        {
        	g.drawString("Right Player Wins!", (width - metr.stringWidth(msg))/2 - 60, height/2  + 10);
        }
        
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) 
	 {

		 if (inGame) 
		 {
			 
			 checkWins();
			 move(); 
			 
	         
	     }
		 
	     repaint();
	 
	 }
	 
	 public class KeyMover extends KeyAdapter 
	 {

	        @Override
	        public void keyPressed(KeyEvent e) {

	            int key = e.getKeyCode();

	            if ((key == KeyEvent.VK_Q) ) {
	               leftup=true;
	               leftdown=false;
	            }

	            if ((key == KeyEvent.VK_A) ) {
	               leftup=false;
	               leftdown=true;
	            }

	            if ((key == KeyEvent.VK_P) ) {
	                rightup=true;
	                rightdown=false;
	            }

	            if ((key == KeyEvent.VK_L)) {
	            	rightup=false;
	                rightdown=true;
	            }
//	            
//	            if(flag==0)
//	            {
//	            	System.out.println("in flag");
//	            	ballleft=false;
//	        		ballright=true;
//	        		ballup=true;
//	        		ballright=false;
//	        		flag=1;
//	            }
	        }
	        @Override

	        public void keyReleased(KeyEvent e) {

	        	int key = e.getKeyCode();

	            if ((key == KeyEvent.VK_Q) ) {
	               leftup=false;               
	            }

	            if ((key == KeyEvent.VK_A) ) {
	               leftdown=false;
	            }

	            if ((key == KeyEvent.VK_P) ) {
	                rightup=false;
	            }

	            if ((key == KeyEvent.VK_L)) {
	                rightdown=false;
	            }

	        }

	    }

}



