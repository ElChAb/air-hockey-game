package javaGame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.ColorChooserUI;

public class Main extends JFrame implements ActionListener, Runnable{

	JPanel panel , panel2, panel3;
	
	JButton btnStart, btnQuit, btnSet,
	btnOnePlayer, btnTwoPlayer, btnEasy ,
	btnNormal, btnHard, btnMainMenu, btnMainMenu2, startP;

	//green 777777777
	//pink 987654321
	//purple 111111111
	// red 333333333
	//light pink 666666666
	//sky blue 999999999
	//dark green 010101010
	//yellow  100000001
	//brown   500000001
	//light brown 070707070
	//kalbasi  450000000
	// green 490000000
	
	Color color = new Color(777777777);
	Color color2 = new Color(0);
	
	int x = 170 , y = 350, height = 150 , width = 50 ;
	
	
	boolean t = true ;
	
	BufferedImage mainbg , main;	
	
	Thread startTh;
	
	
	public void addNotify() {
		// TODO Auto-generated method stub
		super.addNotify();
		startTh = new Thread(this);
		startTh.start();
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g ;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
//		g2.drawImage(mainbg , 0 , 0 , null);
		g2.drawImage(main, 0, 0, 500, 350, null);

	}
	
	
	
	public Main()
	{
		
		
		
		 try {
				
			  mainbg = ImageIO.read(new File("mainBack.png"));
			  main = ImageIO.read(new File("7.jpg"));
				
			} catch (IOException e) {
			
				e.printStackTrace();
			}
				

		

		
		btnStart = new JButton();
	    btnStart.setText("Start");  
	    btnStart.setBounds(x, y , height, width);
	    btnStart.setBackground(color);
	   
	    btnSet = new JButton();
	    btnSet.setText("Setting");  
	    btnSet.setBounds(x, y+60 , height, width);
	    btnSet.setBackground(color);
	    
	    
	    btnQuit = new JButton();
	    btnQuit.setText("Quit");  
	    btnQuit.setBounds(x, y+120 ,  height, width);
	    btnQuit.setBackground(color);
	   
	    
	    
	    btnOnePlayer = new JButton();
	    btnOnePlayer.setText("1 Player");  
	    btnOnePlayer.setBounds(x, y , height, width);
	    btnOnePlayer.setBackground(color);
	   
	    
	    btnTwoPlayer = new JButton();
	    btnTwoPlayer.setText("2 Player");  
	    btnTwoPlayer.setBounds(x, y+60 , height, width);
	    btnTwoPlayer.setBackground(color);
	    
	    btnMainMenu = new JButton();
	    btnMainMenu.setText("Main Menu");  
	    btnMainMenu.setBounds(x, y+120 , height, width);
	    btnMainMenu.setBackground(color);
	    
	    
	    btnEasy = new JButton();
	    btnEasy.setText("Easy");  
	    btnEasy.setBounds(x, y ,  height, width);
	    btnEasy.setBackground(color);
	    
	    
	    btnNormal = new JButton();
	    btnNormal.setText("Normal");  
	    btnNormal.setBounds(x, y+60 ,  height, width);
	    btnNormal.setBackground(color);
	   
	    
	    btnHard = new JButton();
	    btnHard.setText("Hard");  
	    btnHard.setBounds(x, y+120 , height, width);
	    btnHard.setBackground(color);
	    	   		
	    
	    btnMainMenu2 = new JButton();
	    btnMainMenu2.setText("Main Menu");  
	    btnMainMenu2.setBounds(x, y+180 , height, width);
	    btnMainMenu2.setBackground(color);
	    btnMainMenu2.setVisible(false);
		
	    setTitle("Hockey Game");
		setSize(500, 700);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
		setVisible(true);
		
		listeners();
		
		panel = new JPanel();
		panel.setBounds(0, 0, 500, 700);
		panel.setLayout(null);
		panel.setBackground(color2);	
		panel.add(btnStart);
		panel.add(btnSet);
		panel.add(btnQuit);		
		panel.setVisible(true);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 500, 700);
		panel2.setLayout(null);
		panel2.setBackground(Color.black);
		panel2.add(btnOnePlayer);
		panel2.add(btnTwoPlayer);
	    panel2.add(btnMainMenu);		
		panel2.setVisible(false);
		
	    panel3 = new JPanel();
		panel3.setBounds(0, 0, 500, 700);
		panel3.setLayout(null);
		panel3.setBackground(Color.black);
		panel3.add(btnEasy);
		panel3.add(btnNormal);
	    panel3.add(btnHard);
	    panel3.add(btnMainMenu2);    
		panel3.setVisible(false);		
		
	    add(panel);	    
	   	add(panel2);
		add(panel3);	    	    
		
	}
	
	
    void listeners(){
		
    	btnStart.addActionListener(this);
    	btnSet.addActionListener(this);
        btnQuit.addActionListener(this);
    	btnOnePlayer.addActionListener(this);
        btnTwoPlayer.addActionListener(this);
    	btnEasy.addActionListener(this);
        btnNormal.addActionListener(this);
    	btnHard.addActionListener(this);
		btnMainMenu.addActionListener(this);
		btnMainMenu2.addActionListener(this);
//		startP.addActionListener(this);
		

	}


	
	
	
	
	public static void main(String[] args) {
		
		new Main();
		
		
	
	}

	@Override
	public void run() {
		
		 while(true)
		 {
			 repaint();
			 
			 try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		if(e.getSource() == startP)
//		{	
//			startP.setVisible(false);
//			panel.setVisible(true);		
//		}
		
		
		if(e.getSource() == btnStart)
		{					
			panel.setVisible(false);
			panel2.setVisible(true);		
		}
		
		
		if(e.getSource() == btnTwoPlayer)
		{	
			dispose();
			MainMenu menu2 = new MainMenu();
			menu2.twoPlayer();			
		}
		
		if(e.getSource() == btnOnePlayer)
		{	
			panel2.setVisible(false);
			panel3.setVisible(true);
			btnMainMenu2.setVisible(true);
				
		}
		
		if(e.getSource() == btnEasy)
		{
			dispose();
			MainMenu menu = new MainMenu();
			menu.onePlayer();
		}
		
		if(e.getSource() == btnMainMenu)
		{
			
			panel.setVisible(t);
			
		}
		
		
		
		if(e.getSource() == btnQuit)
		{
			System.exit(0);
		}
		
		
		if(e.getSource() == btnNormal)
		{
			dispose();
			MainMenu menu = new MainMenu();
			menu.onePlayerN();
		}
		
		
		if(e.getSource() == btnHard)
		{
			dispose();
			MainMenu menu = new MainMenu();
			menu.onePlayerH();
		}

		if(e.getSource() == btnMainMenu2)
		{	
			panel.setVisible(t);
			btnMainMenu2.setVisible(false);
		}
		
	}

}
