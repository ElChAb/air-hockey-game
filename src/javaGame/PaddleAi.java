package javaGame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PaddleAi {

	private int x = 210;
	private int y = 10;
	private GameBoard1 gameboard1;
	
	private int xa = 10 , ya = 10;
	BufferedImage paddle_image;
	double height ;
	double weight ;
	
	Puck puck = new Puck(gameboard1);
	
	
	// getters and setters till line 74
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
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

	public int getXa() {
		return xa;
	}

	public void setXa(int xa) {
		this.xa = xa;
	}
	
	public BufferedImage getPaddle_image() {
		return paddle_image;
	}

	public void setPaddle_image(BufferedImage paddle_image) {
		this.paddle_image = paddle_image;
	}
	
	
	
	
    // constructor
	public PaddleAi(GameBoard1 gameboard1) {
		
		this.gameboard1 = gameboard1 ;
		
		// add image
		try {			
			paddle_image = ImageIO.read(new File ("GreenPaddle.png"));
			
		} catch (IOException e) {
			System.out.println("not found...");
	  }

	}
	
	
	
	// insert image to frame
	public void paint(Graphics g) {
		
		
		Graphics2D g2 = (Graphics2D) g ;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.drawImage(paddle_image, x , y , null);
		
	}
		
		
	
	// check collision between puck and paddle
	public boolean collision() {
		return gameboard1.puckobj.getBounds().intersects(getBounds());		
	}
  
	
	//return bound of paddle image 
	 public Rectangle getBounds() {
			return new Rectangle(x , y , paddle_image.getWidth(),paddle_image.getHeight());		
	}
	 
	 
	public void move()
	{      
		// move paddle
           Thread thread = new Thread(new Runnable() {		
			@Override
			public void run() {
				
		
			}
		});
		
		thread.start();
		
		
		    x = x + xa;
		
		    // prevent puck get out 
			if(gameboard1.puckobj.getY() < 300) 
			{
				//supports x between 0-210	
			   if(gameboard1.puckobj.getX() >= 210)
			   {
				  if(x <= gameboard1.getNewPuckX()) 
				   {
			         xa = +10;
				   }
				  
			      else
				  {
					xa = -10;
				  }
				  
		        }
			
               //supports x between 0-210			
			   if(gameboard1.puckobj.getX() < 210)
			   {
				   if(x >= gameboard1.getNewPuckX())
				   {
			        xa = -10;
				   }
				   
				else 
				{
					xa = +10;
				}
				   
	     	   }
			
			}

            //prevent auto move
			else 
			{
				xa = 0;
			}

           //prevent out 	
			if(x > 400)
			{
			xa = -10 ;
		    }
			
		   if(x < 20 )
		   {
			xa = +10 ;
		   }
		
	}
	

	
	
	
}
