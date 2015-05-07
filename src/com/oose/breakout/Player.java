package com.oose.breakout;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Player extends Entity{
	protected byte lives = 3;
	private boolean leftInput = false, rightInput = false;
	public float spd;
	String paddle = "data/paddle2.png";
	
	public Player() throws SlickException{
		StartPos();
		spd = 30f;
		setSpeed(spd);
		setHeight(25);
		setWidth(125);
		Image = new Image(paddle);
		
	}
	
	//Needs to be placed in the Update in Game Class
	public void Movement(GameContainer gc){
		setX(Mouse.getX());
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
