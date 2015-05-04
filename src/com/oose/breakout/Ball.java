package com.oose.breakout;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ball extends Entity {
	private float yDirection;
	private float xDirection;
	public int r;
	public int scale;
	
	protected String ballfile = "data/ball.png";

	public Ball(int _x, int _y) throws SlickException{
		setSpeed(8F);
		yDirection = -1*getSpeed();
		xDirection = getSpeed();
		
		startPos(_x,_y);
		r = 20;
		scale = 1;

		Image = new Image(ballfile);
	}
	
	public void startPos(int _x, int _y){
		x = _x;
		y = _y;
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
	 
	 public float getYD()
	    {
	      return yDirection;
	    }
	
	public void render()throws SlickException{
		Image.draw(x,y,r*scale,r*scale);
	}
}
