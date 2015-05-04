package com.oose.breakout;

import javax.swing.ImageIcon;

import com.sun.prism.Image;

public class Block extends Entity{
	
	public int blockWidth = 90;
	public int blockHeight = 34;
	public Image block = null;
    
	boolean destroyed;
	
	//Initializes block image
	block = new Image("data/block.png"); 
			
	public Block(int blockPosX, int blockPosY){
		
		
		this.x = blockPosX;
		this.y = blockPosY;

		//blockWidth = entityImage;
		//blockHeight = entityImage;
		

		destroyed = false;
	}
	//State of block
	public boolean isDestroyed()
	{
		return destroyed;
	}
	
	public void setDestroyed(boolean destroyed)
	{
		this.destroyed = destroyed;
	}
	

}//end: class Block



