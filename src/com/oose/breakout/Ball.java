package com.oose.breakout;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ball extends Entity {
	private float yDirection;
	private float xDirection;
	public int r;
	public int scale;
	
	protected String ballfile = "data/ball.png";

	public Ball() throws SlickException{
		setSpeed(8F);
		yDirection = -1*getSpeed();
		xDirection = getSpeed();
		
		startPos();
		r = 20;
		scale = 1;

		Image = new Image(ballfile);
	}
	
	public void startPos(){
		x = 200;
		y = 200;
	}
	
	public void move() throws SlickException{		  
		  x += xDirection;
	      y += yDirection;

	      if (x <= 0) {
	        setXD(getSpeed());
	      }

	      if (x+r*scale >= 640) {
	        setXD(-1*getSpeed());
	      }

	      if (y <= 0) {
	        setYD(getSpeed());
	      }
	      
	      //temporary function
	      if (y >= 700) {
		        setYD(-1*getSpeed());
		      }
	      //temporary function
	    }
	
	
	 public void setXD(float x){
	      xDirection = x;
	    }

	 public void setYD(float y){
	      yDirection = y;
	    }
	
	public void render()throws SlickException{
		Image.draw(x,y,r*scale,r*scale);
	}
}
