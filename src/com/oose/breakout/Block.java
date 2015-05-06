package com.oose.breakout;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Block extends Entity{
	

	public Image block = null;
	
	
	public boolean shattered;
	protected String blockImg= "data/block.png"; 
	
	/**
	 * Setting width and height for blocks, holds position of each block with parameters	
	 * @param blockPosX
	 * @param blockPosY
	 * @throws SlickException
	 */
	public Block(int blockPosX, int blockPosY) throws SlickException{
		setWidth(95);		
		setHeight(39);		
	    
		//Initializes block image
		try {
			Image = new Image (blockImg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.x = blockPosX;
		this.y = blockPosY;

		shattered = false;
	}
	//State of block
	public boolean isShattered()
	{
		return shattered;
	}
	
	public void setShattered(boolean shattered)
	{
		this.shattered = shattered;
	}
}//end: class Block



