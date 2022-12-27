package javaGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainMenu extends JFrame{
	
//	private static final long serialVersionUID = 1L;
	
	
	public void twoPlayer()
	{
        GameBoard2 game2 = new GameBoard2();	
		
		addKeyListener(game2);
		add(game2);

		setTitle("Hockey Game");
		setSize(500, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	public void onePlayer()
	{
        GameBoard1 game1 = new GameBoard1();	
		
		addKeyListener(game1);
		add(game1);

		setTitle("Hockey Game");
		setSize(500, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void onePlayerN()
	{
        NormalPlay game11 = new NormalPlay();	
		
		addKeyListener(game11);
		add(game11);

		setTitle("Hockey Game");
		setSize(500, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

	public void onePlayerH() {
		
        HardPlay game111 = new HardPlay();	
		
		addKeyListener(game111);
		add(game111);

		setTitle("Hockey Game");
		setSize(500, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	public MainMenu()
	{	
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MainMenu();
		
	}



}
