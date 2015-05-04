package com.oose.breakout;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Player extends Entity{
	protected byte lives = 3;
	private boolean leftInput = false, rightInput = false;
	String paddle = "data/paddle.png";
	
	public Player() throws SlickException{
		StartPos();
		setSpeed(0.1f);
		Image = new Image(paddle);
		
	}
	
	//Needs to be placed in the Update in Game Class
	public void Movement(GameContainer gc){
		Input input = gc.getInput();
		
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
	
	public void Render(){
		Image.draw(x, y);
	}
	
	public void StartPos(){
		x = 250;
		y = 400;
	}
	
	//Setters & Getters for Player
		public byte getLives() {
			return lives;
		}

		public void setLIVES(byte _lives) {
			lives = _lives;
		}
}
