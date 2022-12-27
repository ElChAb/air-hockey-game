package javaGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Paddle1 implements KeyListener{

	private int x = 210;
	private int y = 585;
	private GameBoard2 gameboard2;
	private GameBoard1 gameboard1;
	private int xa = 10 , ya = 10;
	BufferedImage paddle_image;
	

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

	public int getXa() {
		return xa;
	}

	public void setXa(int xa) {
		this.xa = xa;
	}

	public Paddle1(GameBoard2 gameboard2) {
		
		this.gameboard2 = gameboard2 ;
		
		try {
			
			paddle_image = ImageIO.read(new File ("BluePaddle.png"));
			
		} catch (IOException e) {
			System.out.println("not found...");
		}

	}
	
   public Paddle1(GameBoard1 gameboard1) {
		
		this.gameboard1 = gameboard1 ;
		
		try {
			
			paddle_image = ImageIO.read(new File ("BluePaddle.png"));
			
		} catch (IOException e) {
			System.out.println("not found...");
		}

	}

	
	public void paint(Graphics g) {
		
		
		Graphics2D g2 = (Graphics2D) g ;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawImage(paddle_image, x , y , null);
		
	}
	
	
	
	public BufferedImage getPaddle_image() {
		return paddle_image;
	}

	public void setPaddle_image(BufferedImage paddle_image) {
		this.paddle_image = paddle_image;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			if(x > 10 ) 
			{
				x -= xa;
			}
 		}
		
 		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
 			 
 			if(x < 410) 
 			{
				x += xa;
			}

 		}
 		
 		
       if(e.getKeyCode() == KeyEvent.VK_UP) {
    	   
			if(y > 320) 
			{
				y -= ya;
			}
 		}
       
 		if(e.getKeyCode() == KeyEvent.VK_DOWN) {	 
 			
			if(y < 585 )
			{
				y += ya;
			}
			
 		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean collision() {
		return gameboard2.puckobj.getBounds().intersects(getBounds());
		
	}
	
	public boolean collision1() {
		return gameboard1.puckobj.getBounds().intersects(getBounds());
		
	}
  
	
	 public Rectangle getBounds() {
			return new Rectangle(x,y,paddle_image.getWidth(),paddle_image.getHeight());
			
			}
	
	
	

	 

	 
	 
}

