package com.oose.breakout;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Block extends Entity{
	
	public int blockWidth = 90;
	public int blockHeight = 34;
	public Image block = null;
	Block blocks[];
	blocks = new Block[25];
    
	public boolean emptyBlocks;
	protected String blockImg= "data/block.png"; 
	
			
	public Block(int blockPosX, int blockPosY) throws SlickException{
		//Initializes block image
		try {
			Image = new Image (blockImg);
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
	
	int b = 0;
	//Double for-loop, create 5 rows and 5 columns of blocks
	for(int bRow = 0; bRow < 5; bRow++){ 
		for(int bCol = 0; bCol < 5; bCol++){
				blocks[b] = new Block(bCol * 40+30, bRow* 10+50); //placement of each block with x and y position
				b++;
		}
	}

}//end: class Block



