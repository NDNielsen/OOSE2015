package com.oose.breakout;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Player extends Entity{
	String paddle = "data/paddle2.png";
	
	public Player() throws SlickException{
		StartPos();
		setHeight(25);
		setWidth(125);
		Image = new Image(paddle);
		
	}
	
	//Needs to be placed in the Update in Game Class
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
	public void Render(){
		Image.draw(x, y,width,height);
	}
	
	//Sets the start position for the player
	public void StartPos(){
		x = 250;
		y = 550;
	}
}
