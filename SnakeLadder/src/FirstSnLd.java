import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.charset.Charset;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class FirstSnLd extends JPanel implements ActionListener,MouseListener
{
	String lab;
	BoardPan b1;
	SecondSnLd s1;
	int player;
	boolean iscomb;
	String token1,token2,combtoken,pname1,pname2;
	
	Random ra;
	Hashtable<Integer, String> h1 = 
            new Hashtable<Integer, String>(); 
	Hashtable<String, String> snk = 
            new Hashtable<String, String>(); 
	Hashtable<String, String> lad = 
            new Hashtable<String, String>();
	
	int row1,col1,row2,col2;
	FirstSnLd(String ss1,String ss2)
	{
		setLayout(null);
		setVisible(false);
		setBackground(Color.black);
		
		pname1=ss1;
		pname2=ss2;
		
		ra=new Random();
		
		Font f1=new Font("Arial",Font.BOLD,80);
		Font f2=new Font("Arial",Font.PLAIN,20);
		Font f3=new Font("TimesRoman",Font.PLAIN,30);
		
		initpanels();
		
		token1="/img/token05.png";
		token2="/img/token04.png";
		combtoken="/img/comb2.png";
		
		h1.put(1,"/img/diceno1.jpg");//"/img/token05.png"
		h1.put(2,"/img/diceno2.jpg");
		h1.put(3,"/img/diceno3.jpg");
		h1.put(4,"/img/diceno4.jpg");
		h1.put(5,"/img/diceno5.jpg");
		h1.put(6,"/img/diceno6.jpg");
		
		initHash();
		
		
		s1.dice1.setActionCommand("dice1");
		s1.dice1.addActionListener(this);
		s1.dice2.setActionCommand("dice2");
		s1.dice2.addActionListener(this);
		
		add(b1);
		add(s1);
		
		
		initvalues();
		
	}
	public void initpanels()
	{
		b1=new BoardPan();
		b1.setVisible(true);
		
		s1=new SecondSnLd(pname1,pname2);
		s1.setVisible(true);
	}
	public void initvalues()
	{
		b1.num[9][0].setIcon(new ImageIcon(FirstSnLd.class.getResource(combtoken)));
		iscomb=true;
		player=1;
		
		row1=9;
		col1=0;
		row2=9;
		col2=0;
		
	}
	
	
	public void initHash()
	{
		snk.put("11", "80");
		snk.put("05", "62");
		snk.put("16", "35");
		snk.put("44", "97");
		snk.put("64", "94");
		snk.put("58", "96");
		
		lad.put("94", "65");
		lad.put("98", "49");
		lad.put("72", "51");
		lad.put("57", "15");
		lad.put("31", "12");
		lad.put("38", "09");
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		lab=ae.getActionCommand();
		if(lab.equals("dice1"))
		{
			int no=ra.nextInt(6) + 1;
			if(player==1)
			{
				s1.dice1.setEnabled(true);
				String img=h1.get(no);
				s1.dice1.setIcon(new ImageIcon(FirstSnLd.class.getResource(img)));
				int x=row1;
				int y=col1;
				if(row1%2==1)
				{
					if((col1+no)<10)
					{
						col1+=no;
					}
					else
					{
						if((row1-1)<0)
						{
							
						}
						else
						{
							row1-=1;
							col1=10-(no-(9-col1));
						}
					}
				}
				else
				{
					if((col1-no)<0)
					{
						if((row1-1)<0)
						{
						
						}
						else
						{
							row1-=1;
							col1=Math.abs(col1-no) - 1;
						}
					}
					else
					{
						col1-=no;
					}
					
				}
				
				dofor1(x, y);
				boolean isKeyPresent1 = snk.containsKey(""+row1+col1); 
				if(isKeyPresent1)
				{
					x=row1;
					y=col1;
					String sd=snk.get(""+row1+col1);
					row1=Integer.parseInt(sd.substring(0,1));
					col1=Integer.parseInt(sd.substring(1,2));
					byte[] emojiBytes = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xAB};
					String emojiAsString = new String(emojiBytes, Charset.forName("UTF-8"));
					s1.out1.setText("OOPs! Snake is Arrived"+emojiAsString);
					try 
					{
						Thread.sleep(100);
						dofor1(x, y);
						
					} catch (Exception e) 
					{
						System.out.println("Player1 in snake");
						
					}
				}
				boolean isKeyPresent2 = lad.containsKey(""+row1+col1); 
				if(isKeyPresent2)
				{
					x=row1;
					y=col1;
					String sd=lad.get(""+row1+col1);
					row1=Integer.parseInt(sd.substring(0,1));
					col1=Integer.parseInt(sd.substring(1,2));
					byte[] emojiBytes = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8D};
					String emojiAsString = new String(emojiBytes, Charset.forName("UTF-8"));
					s1.out1.setText("Yeah! Ladder "+emojiAsString);//U+1F631  \xF0\x9F\x98\xAB   \xF0\x9F\x98\x8D
					try 
					{
						Thread.sleep(100);
						dofor1(x, y);
						
					} catch (Exception e) 
					{
						System.out.println("Player1 in snake");
						
					}
				}
				  
				if(no==6)
				{
					if(x==row1 && y==col1)
					{
						player=2;
					}
					else
					{
					
						player=1;
						s1.chance1.setText("Congratulations! Spin Again");
					}
				}
				else
				{
					player=2;
					s1.dice1.setEnabled(false);
					s1.dice2.setEnabled(true);
					
					s1.out1.setText("");
					s1.out2.setText("");
					s1.chance1.setText("");
					s1.chance2.setText(s1.stringp2);
				}
			}
			if(iswins1())
			{
				alldisable();
				s1.out1.setText("Congratulations! "+s1.pname1+" You Won");
			}
			
		}
		else if(lab.equals("dice2"))
		{
			int no=ra.nextInt(6) + 1;
			if(player==2)
			{
				s1.dice2.setEnabled(true);
				String img=h1.get(no);
				s1.dice2.setIcon(new ImageIcon(FirstSnLd.class.getResource(img)));
				int x=row2;
				int y=col2;
				if(row2%2==1)
				{
					if((col2+no)<10)
					{
						col2+=no;
					}
					else
					{
						if((row2-1)<0)
						{
							
						}
						else
						{
							row2-=1;
							col2=10-(no-(9-col2));
						}
					}
				}
				else
				{
					if((col2-no)<0)
					{
						if((row2-1)<0)
						{
						
						}
						else
						{
							row2-=1;
							col2=Math.abs(col2-no) - 1;
						}
					}
					else
					{
						col2-=no;
					}
					
				}
				dofor2(x, y);
				boolean isKeyPresent1 = snk.containsKey(""+row2+col2); 
				if(isKeyPresent1)
				{
					x=row2;
					y=col2;
					String sd=snk.get(""+row2+col2);
					row2=Integer.parseInt(sd.substring(0,1));
					col2=Integer.parseInt(sd.substring(1,2));
					byte[] emojiBytes = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xAB};
					String emojiAsString = new String(emojiBytes, Charset.forName("UTF-8"));
					s1.out2.setText("OOPs! Snake is Arrived"+emojiAsString);
					try 
					{
						Thread.sleep(100);
						dofor2(x, y);
						
					} catch (Exception e) 
					{
						System.out.println("Player1 in snake");
						
					}
				}
				boolean isKeyPresent2 = lad.containsKey(""+row2+col2); 
				if(isKeyPresent2)
				{
					x=row2;
					y=col2;
					String sd=lad.get(""+row2+col2);
					row2=Integer.parseInt(sd.substring(0,1));
					col2=Integer.parseInt(sd.substring(1,2));
					byte[] emojiBytes = new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8D};
					String emojiAsString = new String(emojiBytes, Charset.forName("UTF-8"));
					s1.out2.setText("Yeah! Ladder "+emojiAsString);//U+1F631  \xF0\x9F\x98\xAB   \xF0\x9F\x98\x8D
					try 
					{
						Thread.sleep(100);
						dofor2(x, y);
						
					} catch (Exception e) 
					{
						System.out.println("Player1 in snake");
						
					}
				}
				
				if(no==6)
				{
					if(row2==x && col2==y)
					{
						player=1;
					}
					else
					{
						player=2;
						s1.chance2.setText("Congratulations! Spin Again");
					}
				}
				else
				{
					player=1;
					s1.dice2.setEnabled(false);
					s1.dice1.setEnabled(true);
					s1.chance2.setText("");
					s1.chance1.setText(s1.stringp1);
				}
			}
			if(iswins2())
			{
				alldisable();
				s1.out2.setText("Congratulations! "+s1.pname2+" You Won");
			}
		}
		
//		else if(lab.equals("replay"))
//		{
//			s1.setVisible(false);
//			b1.setVisible(false);
//			initpanels();
//			initvalues();
//			
//		}
	}
	
	public boolean iswins1()
	{
		if(row1==0 && col1==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean iswins2()
	{
		if(row2==0 && col2==0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public void alldisable()
	{
		s1.chance1.setText("");
		s1.out1.setText("");
		s1.dice1.setEnabled(false);
		
		s1.chance2.setText("");
		s1.out2.setText("");
		s1.dice2.setEnabled(false);
	}
	
	public void dofor1(int x,int y)
	{
		if(iscomb)
		{
			b1.num[x][y].setIcon(new ImageIcon(FirstSnLd.class.getResource(token2)));
			b1.num[row1][col1].setIcon(new ImageIcon(FirstSnLd.class.getResource(token1)));
			iscomb=false;
			
		}
		else
		{
			b1.num[x][y].setIcon(null);
			if(row1==row2 && col1==col2)
			{
				iscomb=true;
				b1.num[row1][col1].setIcon(new ImageIcon(FirstSnLd.class.getResource(combtoken)));
			}
			else
			{
				b1.num[row1][col1].setIcon(new ImageIcon(FirstSnLd.class.getResource(token1)));
			}
		}
		
	}
	public void dofor2(int x,int y)
	{
		if(iscomb)
		{
			b1.num[x][y].setIcon(new ImageIcon(FirstSnLd.class.getResource(token1)));
			b1.num[row2][col2].setIcon(new ImageIcon(FirstSnLd.class.getResource(token2)));
			iscomb=false;
			
		}
		else
		{
			b1.num[x][y].setIcon(null);
			if(row1==row2 && col1==col2)
			{
				iscomb=true;
				b1.num[row2][col2].setIcon(new ImageIcon(FirstSnLd.class.getResource(combtoken)));
			}
			else
			{
				b1.num[row2][col2].setIcon(new ImageIcon(FirstSnLd.class.getResource(token2)));
			}
		}
		
	}
	
	public String getEmojiByUnicode(int unicode){
	    return new String(Character.toChars(unicode));
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
