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
	
	Ball ball1 = null;
	
	Player player1 = null;
	Block blocks[] = new Block[25];
	GUI onScreenGUI = null;
	

	
	public Game(String gamename) {
		super(gamename);
		
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
		ball1 = new Ball(200,200);
		
		player1 = new Player();
		CreateBlocks(blocks);
		onScreenGUI = new GUI();
		

	}
	
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		gc.setMinimumLogicUpdateInterval(20);
		gc.setMaximumLogicUpdateInterval(60);
		ball1.move();

		player1.Movement(gc);
		CheckCollision();
		
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
		onScreenGUI.DrawGUI(g);
		
		for(int i = 0; i<blocks.length; i++){
			blocks[i].getImage().draw(blocks[i].getX(),blocks[i].getY());
		}
	}
	
	public void CreateBlocks(Block blocks[]) throws SlickException
	{
		int b = 0;
		//Double for-loop, create 5 rows and 5 columns of blocks
		for(int bRow = 0; bRow < 5; bRow++){ 
			for(int bCol = 0; bCol < 5; bCol++){
					blocks[b] = new Block(bCol * 95+82, bRow* 39+50); //placement of each block with x and y position
					b++;
			}
		}
	}
	
	public void CheckCollision(){
		if(ball1.getRect().intersects(player1.getRect())){
			System.out.println("Collision Detected");
			
			int paddleX = (int)player1.getRect().getMinX();
            int ballX = (int)ball1.getRect().getMinX();

            int first = paddleX + 62;
            int second = paddleX + 62;

            if (ballX < first) {
                ball1.setXD(-1*ball1.getSpeed());
                ball1.setYD(-1*ball1.getSpeed());
            }

            if (ballX> second) {
                ball1.setXD(ball1.getSpeed());
                ball1.setYD(-1*ball1.getSpeed());
            }
		}
		
		if(ball1.getRect().intersects(player1.getRect())){
			System.out.println("Collision Detected");
		}
		
	}

}
