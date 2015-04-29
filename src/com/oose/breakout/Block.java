package com.oose.breakout;

import javax.swing.ImageIcon;

import com.sun.prism.Image;

public class Block extends Entity{
	
	String blockImg = "../data/block.png";
	//String blockImg = "../src/com.oose.breakout/block.png";
	Image blockIcon;	
	
	public int blockWidth = 90;
	public int blockHeight = 34;
    
	boolean destroyed;

	public Block(int blockPosX, int blockPosY){
		
		this.POSITION_X = blockPosX;
		this.POSITION_Y = blockPosY;
		
		//Accesses image of block
		ImageIcon blockIcon = new ImageIcon(this.getClass().getResource(blockImg));
		ENTITY_IMAGE  = blockIcon;
		
		blockWidth = ENTITY_IMAGE;
		blockHeight = ENTITY_IMAGE;
		
		destroyed = false;
		
				
		//return POSITION_X;
	}
	//State of brick
	public boolean isDestroyed()
	{
		return destroyed;
	}
	
	public void setDestroyed(boolean destroyed)
	{
		this.destroyed = destroyed;
	}
	
//	public void CreateBlocks(){
	
//	int blockStartX, blockStartY = blockOffset; 
//	for(int bRow = 0; bRow < blockRows; bRow++){
//		blockStartX = blockOffset;
//		
//	}
//}
	
}//end: class Block
