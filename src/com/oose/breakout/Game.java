package com.oose.breakout;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;

public class Game extends BasicGame
{
	static int sHeight = 640, sWidth = 720; 
	private Image gameBackground = null;
	Block blocks[];
	Ball ball1 = null;
	Player player1 = null;

	
	public Game(String gamename) {
		super(gamename);
		blocks = new Block[25];
	}

	public static void main(String[] args)	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game("BreakOut 2015"));
			appgc.setDisplayMode(sHeight, sWidth, false);
			
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		gc.setShowFPS(false);
		gameBackground = new Image("data/bg.png");
		ball1 = new Ball();
		player1 = new Player();
		
		int b = 0;
		//Double for-loop, create 5 rows and 5 columns of blocks
		for(int bRow = 0; bRow < 5; bRow++){ 
			for(int bCol = 0; bCol < 5; bCol++){
					blocks[b] = new Block(bCol * 40+30, bRow* 10+50); //placement of each block with x and y position
					b++;
			}
		}

	}
	
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		ball1.move();
		player1.Movement(gc);
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//Renders the images
		gameBackground.draw();
		player1.CheckMovement(g);
		player1.Render();
		g.setColor(Color.white);
		g.drawString("BreakOut", 275, 200);
		ball1.render();
		
	}
}
