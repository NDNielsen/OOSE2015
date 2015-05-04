package com.oose.breakout;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;

public class Game extends BasicGame
{
	static int sHeight = 640, sWidth = 720; 
	public float playerX = 250, playerY = 400, playerSpeed = 0.1f;
	private Image gameBackground = null;
	Block blocks[];

	
	
	public Game(String gamename) {
		super(gamename);
		blocks = new Block[20];
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
		

		//Create 20 blocks
				//int b = 0;
				//Double for-loop, create 5 rows and 5 columns of blocks
//				for(int bRow = 0; bRow < 5; bRow++){ 
//					for(int bCol = 0; bCol < 5; bCol++){
//						blocks[b] = new Block(i *, j*) //placement of each block with x and y position
//						b++;
//					}
//				}
		
		//ball1 = new Ball();

	}
	
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		ball1.move();
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//Renders the images
		gameBackground.draw();
		g.setColor(Color.white);
		g.drawString("BreakOut", 275, 200);
		player.draw(playerX, playerY);
		ball.draw(290, 365);
		
		

		//Check state of each block calling the isDestroyed method
		//Draw the blocks
		ball1.render(g, Color.blue);
	}
}
