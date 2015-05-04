package com.oose.breakout;

import javax.swing.ImageIcon;

import com.sun.prism.Image;

public class Block extends Entity{
	
	public int blockWidth = 90;
	public int blockHeight = 34;
	public Image block = null;
    
	boolean emptyBlocks;
	
	//Initializes block image
	block = new Image("data/block.png"); 
			
	public Block(int blockPosX, int blockPosY){
		
		
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



