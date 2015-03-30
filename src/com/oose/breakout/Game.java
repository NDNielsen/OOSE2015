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

public class Game extends BasicGame
{
	static int sHeight = 640, sWidth = 720; 
	public float playerX = 250, playerY = 400, playerSpeed = 0.1f;
	private Image ball = null, gameBackground = null, player = null; // block = null;
	public int blocksPerRow = 8; public int blockRows = 2; public int totalBlocks = 24;
	private boolean leftInput = false, rightInput = false;
	
	
	
	public Game(String gamename)
	{
		super(gamename);
	}

	
	
	
	public static void main(String[] args)
	{
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
		
		
		Player hero = new Player();
		hero.setPOSITION_X(50);
		hero.setPOSITION_Y(50);
		
	}
	
	
	
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		gc.setShowFPS(false);
		
		//Initializes images.
		ball = new Image("data/ball.png");
		gameBackground = new Image("data/bg.png");
		player = new Image("data/paddle.png");

	}
	
	
	
	
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			leftInput = true;
		} else {
			leftInput = false;
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			rightInput = true;
		} else {
			rightInput = false;
		}
	}

	
	
	
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//Renders the images
		gameBackground.draw();
		g.drawString("BreakOut", 275, 200);
		player.draw(playerX, playerY);
		ball.draw(290, 365);
		
		if(leftInput){
			g.drawString("Left!", 200, 200);
			playerX = playerX - playerSpeed;
		}
		
		if(rightInput){
			g.drawString("Right!", 380, 200);
			playerX = playerX + playerSpeed;
		}
	}
	
}