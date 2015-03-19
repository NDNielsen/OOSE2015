package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame
{
	static int sHeight = 640, sWidth = 720; 
	public float playerX = 250, playerY = 400, playerSpeed = 0.1f;
	private Image ball = null, gameBackground = null, player = null, block = null;
	public int blocksPerRow = 8; public int blockRows = 2;
	//public Block blocks[] = new Block[NumBlocks_Rows]; //Create an array for blocks, holds the different blocks(block colors). Create a seperate block class script
	private boolean leftInput = false, rightInput = false;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
		//Initializes images.
		ball = new Image("data/ball.png");
		gameBackground = new Image("data/bg.png");
		player = new Image("data/paddle.png");
		block = new Image("data/block.png");
		
	}
	//*Create the blocks*
	public void createBlocks(){
		//Initializes Blocks
		
		
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

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("BreakOut 2015"));
			appgc.setDisplayMode(sHeight, sWidth, false);
			
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}