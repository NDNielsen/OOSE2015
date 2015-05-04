package com.oose.breakout;

import javax.swing.ImageIcon;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Block extends Entity{
	
	public int blockWidth = 90;
	public int blockHeight = 34;
	public Image block = null;
    
	public boolean emptyBlocks;
	protected String blockImg= "data/block.png"; 
	
	
	
			
	public Block(int blockPosX, int blockPosY) throws SlickException{
		//Initializes block image
		try {
			entityImage = new Image (blockImg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.x = blockPosX;
		this.y = blockPosY;

		//blockWidth = entityImage;
		//blockHeight = entityImage;
		

		emptyBlocks = false;
	}
	//State of block
	public boolean isDestroyed()
	{
		return emptyBlocks;
	}
	
	public void setDestroyed(boolean emptyBlocks)
	{
		this.emptyBlocks = emptyBlocks;
	}
	

}//end: class Block



