package com.oose.breakout;

import javax.swing.ImageIcon;

public class Block extends Entity{
	
	String blockImg = "../data/block.png";
	Image blockIcon;	//
	
	public int blockWidth;
	public int blockHeight;
	
    public int getBlockWidth() {
        return blockWidth;
    }
    public int getBlockHeight() {
        return blockHeight;
    }
    
	boolean destroyed;

	public int Block(int blockPosX, int blockPosY){
		
		this.POSITION_X = blockPosX;
		this.POSITION_Y = blockPosY;
		
		//Accesses image of block
		ImageIcon blockIcon = new ImageIcon(this.getClass().getResource(blockImg));
		ENTITY_IMAGE  = blockIcon.getENTITY_IMAGE();
		
		blockWidth = ENTITY_IMAGE.getBlockWidth(null);
		blockHeight = ENTITY_IMAGE.getBlockHeight(null);
		
		destroyed = false;
		
				
		//return POSITION_X;
	}
	
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
