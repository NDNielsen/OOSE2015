package com.oose.breakout;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Player extends Entity{
	String paddle = "data/paddle2.png";
	
	/**
	 * Create an instance of a player/paddle
	 * @throws SlickException
	 */
	public Player() throws SlickException{
		StartPos();
		setHeight(25);
		setWidth(125);
		Image = new Image(paddle);
		
	}
	
	//Needs to be placed in the Update in Game Class
	/**
	 * Controls the movement of the paddle with mouse coordinates as input
	 * Also stops the paddle from moving beyond the borders of the window
	 * @param gc
	 */
	public void Movement(GameContainer gc){
		setX(Mouse.getX());
		
		if(x <= 0){
			x = 0;
		}
		if(x + width >=640){
			x = 640 - width;
		}
	}
	
	//Needs to be placed in the Renderer in Game Class
	/**
	 * Draw the paddle
	 */
	public void Render(){
		Image.draw(x, y,width,height);
	}
	
	//Sets the start position for the player
	/**
	 * Reset the paddle to its initial location
	 */
	public void StartPos(){
		x = 250;
		y = 550;
	}
}
