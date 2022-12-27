package javaGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Puck {

	
	private int x = 400;
	private int y = 300 ;
	private int ya , xa = 10;
	private BufferedImage puck_img ;
    GameBoard2 gameboard2 ;
    GameBoard1 gameboard1; 
	PaddleAi paddleAi ;
		
	
	public int getYa() {
		return ya;
	}

	public void setYa(int ya) {
		this.ya = ya;
	}


	public BufferedImage getPuck_img() {
		return puck_img;
	}

	
	public void setPuck_img(BufferedImage puck_img) {
		this.puck_img = puck_img;
	}


	public GameBoard2 getGameboard() {
		return gameboard2;
	}
	

	public void setGameboard(GameBoard2 gameboard2) {
		this.gameboard2 = gameboard2;
	}
	
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}

	
	public int getY() {
		return y;
	}

	
	public void setY(int y) {
		this.y = y;
	}


	public void paint(Graphics g) {


		Graphics2D g2 = (Graphics2D) g ;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.drawImage(puck_img, x, y, null);

	}



	public Puck(GameBoard2 gameboard2) {
		
		super();
		this.gameboard2 =gameboard2; 
		
		try {
			puck_img = ImageIO.read( new File("puck.png"));
		
		} catch (IOException e) {
			
			System.err.println("not found...!");
		}
		
	}
	
	
   public Puck(GameBoard1 gameboard1) {
		
		super();
		this.gameboard1 = gameboard1; 
		
		try {
			puck_img = ImageIO.read( new File("puck.png"));
		
		} catch (IOException e) {
			
			System.err.println("not found...!");
		}
		
	}
	
	
	 public Rectangle getBounds() {
			
		 return new Rectangle(x,y,puck_img.getHeight(),puck_img.getHeight());
			
	 }
	
	

	public void move() {
		
	   y  =	y + ya;
	   x = x + xa;
	      
	   if(x  > 430) {
		   
		   xa = -10;
		  
	   }
	   
	   if(x  < 20) {
		   xa = +10;
	   }
	   
	   

      
	   
	   
	   

	   
   }
		
}
	

	
