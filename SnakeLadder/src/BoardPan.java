

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ImagePan2 extends JPanel{

    private BufferedImage img;

    public ImagePan2() {
       try {                
          img = ImageIO.read(BoardPan.class.getResource("/img/board1.png"));
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
public class BoardPan extends ImagePan2 implements ActionListener,MouseListener
{
	String lab;
	JButton[][] num;
	int[][] mat;
	BoardPan()
	{
		setLayout(null);
		setVisible(false);
		
		setBounds(0,0,800,800);
		setVisible(true);
		
		num=new JButton[10][10];
		mat=new int[10][10];
		
		for(int i=0;i<10;i++)
		{
			
			for(int j=0;j<10;j++)
			{
				num[i][j]=new JButton();
				num[i][j].setBounds(80*j,80*i,80,80);
				num[i][j].setBorder(null);
				num[i][j].setOpaque(false);
				num[i][j].setBackground(Color.GRAY);
				num[i][j].setIcon(null);
				
				add(num[i][j]);
			}
		}
		//num[9][0].setIcon(new ImageIcon(BoardPan.class.getResource("/img/comb2.png")));
		
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
