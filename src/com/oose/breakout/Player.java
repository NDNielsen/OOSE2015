package com.oose.breakout;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Player extends Entity{
	protected byte lives = 3;
	private boolean leftInput = false, rightInput = false;
	public float spd;
	String paddle = "data/paddle.png";
	
	public Player() throws SlickException{
		StartPos();
		spd = 0.1f;
		setSpeed(spd);
		setHeight(25);
		setWidth(125);
		Image = new Image(paddle);
		
	}
	
	//Needs to be placed in the Update in Game Class
	public void Movement(GameContainer gc){
		Input input = gc.getInput();
		
		//Checks whether the player is going out of screen region (Left side)
		if(x <= 0 && input.isKeyDown(Input.KEY_LEFT)){
			setSpeed(0);
		} else {
			setSpeed(spd);
			
			// Right side
			if(x+width >= 640 && input.isKeyDown(Input.KEY_RIGHT)){
				setSpeed(0);
			} else {
				setSpeed(spd);
			}
		}
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			leftInput = true;
		} else {
			leftInput = false;
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			rightInput = true;
		} else {
			rightInput = false;
		}
	}
	
	//Needs to be placed in the Renderer in Game Class
	public void CheckMovement(Graphics g){
		if(leftInput){
			g.drawString("Left!", 200, 200);
			x = x - getSpeed();
		}
		
		if(rightInput){
			g.drawString("Right!", 380, 200);
			x = x + getSpeed();
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
	
	//Setters & Getters for Player
		public byte getLives() {
			return lives;
		}

		public void setLIVES(byte _lives) {
			lives = _lives;
		}
}
