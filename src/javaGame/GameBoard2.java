package javaGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.http.WebSocket.Listener;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard2 extends JPanel implements  KeyListener , ActionListener{

	private Thread puckThread ,thread2 ;
	private BufferedImage background_img ,  gameoverImage ;
	private int score1 = 0 , score2 = 0 ;	
	private boolean play = true;
	private JButton btnRestart , btnMain;
		
	
	public BufferedImage getGameoverImage() {
		return gameoverImage;
	}

	public void setGameoverImage(BufferedImage gameoverImage) {
		this.gameoverImage = gameoverImage;
	}
	

	Puck puckobj = new Puck(this);
	Paddle1 paddle1obj = new Paddle1(this);
	Paddle2 paddle2obj = new Paddle2(this);
	
	
	

	public Thread getPuckThread() {
		return puckThread;
	}


	public void setPuckThread(Thread puckThread) {
		this.puckThread = puckThread;
	}

	public BufferedImage getBackground_img() {
		return background_img;
	}


	public void setBackground_img(BufferedImage background_img) {
		this.background_img = background_img;
	}
	

	public Puck getPuckobj() {
		return puckobj;
	}


	public void setPuckobj(Puck puckobj) {
		this.puckobj = puckobj;
	}



	public Paddle1 getPaddle1obj() {
		return paddle1obj;
	}


	public void setPaddle1obj(Paddle1 paddleobj) {
		this.paddle1obj = paddle1obj;
	}
	
	public Paddle2 getPaddle2obj() {
		return paddle2obj;
	}

	public void setPaddle2obj(Paddle2 paddle2obj) {
		this.paddle2obj = paddle2obj;
	}
	
		

    public  void runGame() {
		  		    	
		puckThread = new Thread(new Runnable() {
					
			@Override
			public void run() {
				puckobj.setYa(+10);
				
				while(play) {
					
					repaint();
					move();					
					
					try 
					{
						Thread.sleep(50);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			
				
			}
			
		});
		
	    thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				btnRestart = new JButton();
				btnRestart.setBounds(180, 330, 130, 50);
				btnRestart.setForeground(Color.white);
				btnRestart.setText("Restart");  	    
			    btnRestart.setBackground(Color.DARK_GRAY);
			    
			    btnMain = new JButton();
				btnMain.setForeground(Color.white);
				btnMain.setText("Main Menu");  
				btnMain.setBounds(180, 390 , 130, 50);
				btnMain.setBackground(Color.DARK_GRAY);					
				
				add(btnRestart);
				add(btnMain);
				
			    listener();		   											
		   }
			
	   });
	  	
		puckThread.start();	 
	   	
    }
		

	public  void addNotify() {
		
    	super.addNotify();
        runGame();
	 }
 
    
	@SuppressWarnings("deprecation")
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g ;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.drawImage(background_img, 0 , 0 , null);
		
		puckobj.paint(g2);
		paddle1obj.paint(g2);
		paddle2obj.paint(g2);
		
		
		g2.setColor(Color.BLACK);
		Font scoreFont = new Font("arial",Font.BOLD,15);
		g2.setFont(scoreFont);
		g2.drawString("Green:"+" " + score2, 390 , 310);
		g2.drawString("Blue:"+"    " + score1 , 390 , 340);
		
		
		if (score2 == 5) 
		{
			puckThread.stop();					
			g2.drawImage(gameoverImage, 180 , 170 , null);
			Font font = new Font("Calibri Light",Font.BOLD,30);
			g2.setFont(font);
			g2.setColor(Color.GREEN);
			g2.drawString("Green won...", 180, 310);
			thread2.start();
			
		}
		
		else if (score1 == 5)
		{
			puckThread.stop();
			g2.drawImage(gameoverImage, 180 , 170 , null);
			Font font = new Font("Calibri Light",Font.BOLD,30);
			g2.setFont(font);
			g2.setColor(Color.blue);
			g2.drawString("Blue won...", 180 , 310);				
			thread2.start();
			
		}	
		
		if(puckobj.getY() > 630)
		{						
			Font font = new Font("arial",Font.BOLD,100);
			g2.setFont(font);
			g2.setColor(Color.BLACK);
			g2.drawString("Goal", 100, 350);
			score2 ++;						
			puckobj.setY(300);        
		}
		
		if(puckobj.getY() < -20)
		{		
			
			Font font = new Font("arial",Font.BOLD,100);
			g2.setFont(font);
			g2.setColor(Color.BLACK);
			g2.drawString("GOAL!", 100, 350);
			score1 ++;			
			puckobj.setY(300);
	       
		}
		    
	}
	

	public void checkCollision() {

		if(paddle1obj.collision() == true) {
							
				puckobj.setYa(-10);
		
		   }
		
		
		if (paddle2obj.collision() == true) {
			
				puckobj.setYa(+10);
	
		     }
	
	}
			
	
	public void move() {
		
		puckobj.move();
		checkCollision();
        
	}
	
	
	
	public GameBoard2() {	
			
		
		
		try {
			background_img = ImageIO.read( new File("Hockey_backgr.jpg"));
			gameoverImage = ImageIO.read(new File("game_over.png"));
			
			
		} catch (IOException e) {
			System.err.println("not found image...!");
		}
	
			
	}

		
	
	private void listener() {
		
		btnRestart.addActionListener(this);
		btnMain.addActionListener(this);
		
	}
	
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		paddle1obj.keyPressed(e);
		paddle2obj.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == btnRestart)
		{			
			MainMenu menu = new MainMenu();
			menu.twoPlayer();					
		}
		
		if(e.getSource() == btnMain)
		{		
			Main.main(null);			
		}
		
		
	}
	

}

