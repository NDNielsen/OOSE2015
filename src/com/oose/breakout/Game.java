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
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Point;

public class Game extends BasicGame
{
	static int sHeight = 640, sWidth = 720; 
	private Image gameBackground = null;
	Input input = null;
	Ball ball1 = null;
	int startX = 250, startY = 500;
	Player player1 = null;
	Block blocks[] = new Block[25];
	GUI onScreenGUI = null;
	float vol;
	int score;
	int finalScore;
	int level;;
	
	static Sound backgroundMusic = null;
	static Sound explosion = null;
	static Sound collision = null;
	static Sound levelUp = null;
	static Sound release = null;
	static Sound hurt = null;
	static Sound gameOver = null;
	
	static AppGameContainer appgc;
	
	public Game(String gamename) {
		super(gamename);
		
	}

	public static void main(String[] args)	{
		try
		{
			backgroundMusic = new Sound("data/music3.ogg");
			explosion = new Sound("data/explosion.ogg");
			collision = new Sound("data/Collision.ogg");
			levelUp = new Sound("data/levelUp.ogg");
			release = new Sound("data/release.ogg");
			hurt = new Sound("data/hurt.ogg");
			gameOver = new Sound("data/gameover.ogg");
			backgroundMusic.loop(1f, 0.2f);
			
			appgc = new AppGameContainer(new Game("BreakOut 2015"));
			appgc.setDisplayMode(sHeight, sWidth, false);
			appgc.setVSync(true);
			appgc.setMouseGrabbed(true);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
	
	/**
	 * The GameContainer method creates the visible objects in the game. 
	 * Initialization of values for volume, start score, final score of each level, and start level.  
	 */
	@Override
	public void init(GameContainer gc) throws SlickException {
		gc.setShowFPS(false);
		gameBackground = new Image("data/bg2.png");
		ball1 = new Ball(startX,startY);
		input = gc.getInput();
		player1 = new Player();
		CreateBlocks(blocks);
		onScreenGUI = new GUI();
		
		vol = 0.2f;
		
		score = 0;
		finalScore = 0;
		level = 1;
	}
	
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		gc.setMinimumLogicUpdateInterval(20);
		gc.setMaximumLogicUpdateInterval(60);
		ball1.move();

		player1.Movement(gc);
		CheckCollision();
		ballDeath();
		gameOver();
		IfEmptyBlocks();
		System.out.println(ball1.getSpeed());
		
		if(input.isKeyDown(input.KEY_ESCAPE)){
			appgc.exit();
		}
	}
	@Override
	/**
	 * The render method draws the graphics of the game
	 */
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//Renders the images
		gameBackground.draw();
		player1.Render();
		g.setColor(Color.white);
		g.drawString("BreakOut", 275, 200);
		onScreenGUI.DrawGUI(g);
		g.drawString("Score " + (score + finalScore), 500, 0);	//Draw increment of score
		g.drawString("Level " + level, 400, 0);	//Draw increment of level
		
		if(onScreenGUI.getLives() != 0)
			ball1.render();
		
		if(ball1.getIsAlive() == false && onScreenGUI.getLives() != 0){
			g.drawString("Press LEFT MOUSE to launch", player1.getX()-50, 600);
		}
		
		if(onScreenGUI.getLives() == 0){
			g.setColor(Color.red);
			g.drawString("GAME OVER! PRESS LEFT MOUSE TO RETRY", player1.getX()-95, 600);
		}
		//For-loop: Draws the blocks with image, if the blocks are not shattered (destroyed)
		for(int i = 0; i<blocks.length; i++){
			if(!blocks[i].isShattered()){
				blocks[i].getImage().draw(blocks[i].getX(),blocks[i].getY());
			}
		}
	}
	
	/**
	 * Stop music, play game over sound and give the user the option to retry
	 * @throws SlickException
	 */
	public void gameOver() throws SlickException{
		if(onScreenGUI.getLives() == 0){
			if(!gameOver.playing()){
				gameOver.play(1,vol);
				backgroundMusic.stop();
				vol = 0;
			}
			if(input.isMouseButtonDown(input.MOUSE_LEFT_BUTTON)){
				backgroundMusic.loop(1,0.2f);
				appgc.reinit();
			}
			
		}
	}
		
	/**
	 * Create 25 blocks divided in 5 rows and 5 columns
	 * @param blocks
	 * @throws SlickException
	 */
	public void CreateBlocks(Block blocks[]) throws SlickException
	{
		int b = 0;
		for(int bRow = 0; bRow < 5; bRow++){ 
			for(int bCol = 0; bCol < 5; bCol++){
					blocks[b] = new Block(bCol * 90+95, bRow* 34+50); //Placement of each block with x and y position
					b++;											  //X position of blocks is placed with width of block:90.	
			}														  //Y position is placed with height of block: 34.
		}															  //The value 95 is spacing of each row from the vertical screen borders.
	}																  //The value 50 is offset spacing for each column from top.
	

	/**
	 * set isAlive to false when the ball drops below the paddle
	 * lock the ball to the paddle position if isAlive is false
	 * set isAlive true again if the mouse is clicked, releasing the ball 
	 */
	public void ballDeath(){
		if(ball1.getY() > player1.getY()+50){
			onScreenGUI.setLives(onScreenGUI.getLives()-1);
			ball1.startPos(startX, startY);
			ball1.setIsAlive(false);
			hurt.play();
		}
		
		if(ball1.getIsAlive() == false){
			ball1.setX(player1.getX()+52);
			ball1.setY(player1.getY()-40);
		}
		
		if(ball1.getIsAlive() == false && input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			ball1.setIsAlive(true);
			ball1.setSpeed(4f+8*level/2);
			release.play();
		}
	}
	
	/**
	 * All collision between objects are handled here
	 */
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
                collision.play();
            }

            if (ballX> second) {
                ball1.setXD(ball1.getSpeed());
                ball1.setYD(-1*ball1.getSpeed());
                collision.play();
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
                        explosion.play();
                    }

                    else if (blocks[i].getRect().contains(leftPoint)) {
                        ball1.setXD(ball1.getSpeed());

                        explosion.play();
                    }

                    if (blocks[i].getRect().contains(topPoint)) {
                        ball1.setYD(ball1.getSpeed());

                        explosion.play();
                    }

                    else if (blocks[i].getRect().contains(bottomPoint)) {
                        ball1.setYD(-1*ball1.getSpeed());

                        explosion.play();
                    }

                    blocks[i].setShattered(true);
                    
                }
                
				System.out.println("Collide with block");
			}
		}

	}
	
	/**
	 * Reset the blocks when all blocks have been destroyed
	 * Add 1 to level
	 * Score is calculated from the amount of blocks destroyed
	 * @throws SlickException
	 */
	public void IfEmptyBlocks() throws SlickException
	{	
		int i = 0;
		for(int l = 0, j = 0; l<25; l++){
			if(blocks[l].isShattered()){
				j ++;
				i = j;
			}
			
			if(j == 25 ){
				finalScore += i * 50;
				level +=1;
				ball1.startPos(320,500);
				ball1.setIsAlive(false);
				CreateBlocks(blocks);
				levelUp.play();
			}
		}
		score = i*50;
	}//end:IfEmptyBlocks
}
