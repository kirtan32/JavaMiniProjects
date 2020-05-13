
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class paintpanel extends JPanel implements ActionListener
{
	String lab;
	int[] x = new int[1000];
	int[] y=new int[1000];
	
	int width=1000;
	int height=600;
	
	boolean left=false;
	boolean right=false;
	boolean up=false;
	boolean down=false;
	
	Image mouth=new ImageIcon(paintpanel.class.getResource("/img/snk2.png")).getImage();
	
	Timer timer1;
	int delay=150;
	Image snakeimg=new ImageIcon(paintpanel.class.getResource("/img/snk1.png")).getImage();
	Image apple=new ImageIcon(paintpanel.class.getResource("/img/eat2.png")).getImage();
	
	//inititial length of snake;
	int dots=3;
	int score=0;
	int dotsize=25;
	boolean inGame=true;
	
	int Score=0;
	
	int[] posx;
	int[] posy;
	int posxlen,posylen;
	int applex=0,appley=0;
	Random ra;
	String data="";
	public paintpanel(int x,int y,int width,int height) 
	{
		this.width=width;
		this.height=height;
		
		posxlen=width/25;
		posylen=height/25;
		
		posx=new int[posxlen];
		posy=new int[posylen];
		
		ra=new Random();
		
		setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.white));
		
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		setVisible(true);
		setBounds(x,y,width,height);
		
		initGame();
		
	}
	public void initGame()
	{
		dots=3;
		for(int i=0;i<posxlen;i++)
		{
			posx[i]=25*i;
		}
		for(int j=0;j<posylen;j++)
		{
			posy[j]=j*25;
		}
		Score=0;
		generateApple();
		
		for(int i=0;i<dots;i++)
		{
			x[i]=200-(i*dotsize);
			y[i]=200;
		}
		
		timer1=new Timer(delay, this);
		timer1.start();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
//		g.setColor(Color.cyan);
//		g.drawRect(25, 20, 1150, 70);
//		
//		g.setColor(Color.white);
//		g.drawRect(25, 125, 1150, 600);
//		
		dopaint(g);
		
		//g.dispose();
	}
	
	public void dopaint(Graphics g)
	{
		
		
		if(inGame)
		{
			
			g.drawImage(apple,applex,appley,this);
			
			for(int i=0;i<dots;i++)
			{
				if(i==0)
				{
					g.drawImage(mouth,x[i],y[i],this);
				}
				else
				{
					g.drawImage(snakeimg,x[i],y[i],this);
				}
			}
		}
		else
		{
			gameOver(g);
		}
		Toolkit.getDefaultToolkit().sync();
	}
	
	public void generateApple()
	{
		applex=posx[ra.nextInt(posxlen)];
		appley=posy[ra.nextInt(posylen)];
		
	}
	
	private void checkApple() {

        if ((x[0] == applex) && (y[0] == appley)) {

            dots++;
            Score+=1;
            generateApple();
        }
    }
	
	private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("TimesRoman", Font.BOLD, 35);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (width - metr.stringWidth(msg)) / 2, height/2 - 50);
        g.drawString("Score: "+Score, (width - metr.stringWidth(msg))/2, height/2 + 10);
//        
//        String line="";
//        
//        try {
//            
//            BufferedReader bufferedReader = 
//                new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("img/score.txt")));
//
//            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//                data+=line;
//            }   
//
//            System.out.println(data);
//            // Always close files.
//            bufferedReader.close();         
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println(
//                "Unable to open file ");                
//        }
//        catch(IOException ex) {
//            System.out.println(
//                "Error reading file ");                  
//            // Or we could just do this: 
//            // ex.printStackTrace();
//        }
//        catch(Exception e)
//        {
//        	System.out.println(e.getMessage());
//        }
    }
	
	public void move()
	{
		for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (left) {
            x[0] -= dotsize;
        }

        if (right) {
            x[0] += dotsize;
        }

        if (up) {
            y[0] -= dotsize;
        }

        if (down) {
            y[0] += dotsize;
        }
	}

	 private void checkCollision() {

	        for (int z = dots; z > 0; z--) {

	            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
	                inGame = false;
	            }
	        }

	        if (y[0] >= height) {
	            inGame = false;
	        }

	        if (y[0] < 0) {
	            inGame = false;
	        }

	        if (x[0] >= width) {
	            inGame = false;
	        }

	        if (x[0] < 0) {
	            inGame = false;
	        }
	        
	        if(!inGame) {
	            timer1.stop();
	        }
	    }

	
	 @Override
	    public void actionPerformed(ActionEvent e) {

	        if (inGame) {

	            checkApple();
	            checkCollision();
	            move();
	        }

	        repaint();
	    }

	
	private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyPressed(KeyEvent e) {

	            int key = e.getKeyCode();

	            if ((key == KeyEvent.VK_LEFT) && (!right)) {
	                left = true;
	                up = false;
	                down = false;
	            }

	            if ((key == KeyEvent.VK_RIGHT) && (!left)) {
	                right = true;
	                up = false;
	                down = false;
	            }

	            if ((key == KeyEvent.VK_UP) && (!down)) {
	                up = true;
	                right = false;
	                left = false;
	            }

	            if ((key == KeyEvent.VK_DOWN) && (!up)) {
	                down= true;
	                right = false;
	                left = false;
	            }
	        }
	    }
}
