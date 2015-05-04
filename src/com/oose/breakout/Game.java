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
import org.newdawn.slick.geom.Point;

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
			if(!blocks[i].isShattered()){
				blocks[i].getImage().draw(blocks[i].getX(),blocks[i].getY());
			}
		}
	}
	
	public void CreateBlocks(Block blocks[]) throws SlickException
	{
		int b = 0;
		//Double for-loop, create 5 rows and 5 columns of blocks
		for(int bRow = 0; bRow < 5; bRow++){ 
			for(int bCol = 0; bCol < 5; bCol++){
					blocks[b] = new Block(bCol * 90+95, bRow* 34+50); //Placement of each block with x and y position
					b++;											  //X position of blocks is placed with width of block:90, plus 5 for individual block spacing. 	
			}														  //Y position is placed with height of block: 34, plus 5 for individual block spacing.
		}															  //The value 82 is spacing of each row from the vertical screen borders.
	}																  //The value 50 is offset spacing for each column from top.
	
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
		
		for (int i = 0; i < 25; i++) {
			if(ball1.getRect().intersects(blocks[i].getRect())){
				
				int left = (int)ball1.getRect().getMinX();
                int height = (int)ball1.getRect().getHeight();
                int width = (int)ball1.getRect().getWidth();
                int top = (int)ball1.getRect().getMinY();
                
                Point rightPoint = new Point(left + width + 20, top);
                Point leftPoint = new Point(left - 20, top);
                Point topPoint = new Point(left, top - 20);
                Point bottomPoint = new Point(left, top + height + 20);
                
                if (!blocks[i].isShattered()) {
                    if (blocks[i].getRect().contains(rightPoint)) {
                        ball1.setXD(-1*ball1.getSpeed());
                    }

                    else if (blocks[i].getRect().contains(leftPoint)) {
                        ball1.setXD(ball1.getSpeed());
                    }

                    if (blocks[i].getRect().contains(topPoint)) {
                        ball1.setYD(ball1.getSpeed());
                    }

                    else if (blocks[i].getRect().contains(bottomPoint)) {
                        ball1.setYD(-1*ball1.getSpeed());
                    }

                    blocks[i].setShattered(true);
                }
                
				System.out.println("Collide with block");
			}
		}
	}

}
