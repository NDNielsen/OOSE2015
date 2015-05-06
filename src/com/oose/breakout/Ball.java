package com.oose.breakout;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Ball extends Entity {
	private float yDirection;
	private float xDirection;
	public int r;
	public int scale;
	Sound wallHit = null;
	
	protected String ballfile = "data/ball.png";

	public Ball(int _x, int _y) throws SlickException{
		speed = 8f;
		setIsAlive(false);
		yDirection = -1*speed;
		xDirection = speed;
		
		startPos(_x,_y);
		r = 20;
		scale = 1;

		Image = new Image(ballfile);
		wallHit = new Sound("data/wallHit.ogg");
	}
	
	public void startPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void move() throws SlickException{		  
		  x += xDirection;
	      y += yDirection;

	      if (x <= 0) {
	        setXD(speed);
	        wallHit.play();
	      }

	      if (x+r*scale >= 640) {
	        setXD(-1*speed);
	        wallHit.play();
	      }

	      if (y <= 0) {
	        setYD(speed);
	        wallHit.play();
	      }
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
