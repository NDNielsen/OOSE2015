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

	/**
	 * Create a ball with a set speed and size
	 * @param _x
	 * @param _y
	 * @throws SlickException
	 */
	public Ball(int _x, int _y) throws SlickException{
		//Set initial speed, state and direction.
		speed = 8f;
		setIsAlive(false);
		yDirection = -1*speed;
		xDirection = speed;

		//Set the initial position of the ball, size (r is radius value) and the variable for scale (not really used)
		startPos(_x,_y);
		r = 20;
		scale = 1;

		Image = new Image(ballfile);
		wallHit = new Sound("data/wallHit.ogg");
	}
	
	/**
	 * Reset the placement of the ball
	 * @param x
	 * @param y
	 */
	public void startPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Movement behavior of the ball. Also controls bouncing off the borders. 
	 * @throws SlickException
	 */
	public void move() throws SlickException{
		  //Add to the x and y variables to make the ball move
		  x += xDirection;
	      y += yDirection;
	      
	      //the following three if statements makes the ball go the other way if it hits a border
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
	
	/**
	 * Set the direction on the x axis
	 * @param x
	 */
	 public void setXD(float x){
	      xDirection = x;
	    }

	 /**
	 * Set the direction on the y axis
	 * @param x
	 */
	 public void setYD(float y){
	      yDirection = y;
	    }
	 
	/**
	 * Draw the image of the ball
	 * @throws SlickException
	 */
	public void render()throws SlickException{
		Image.draw(x,y,r*scale,r*scale);
	}
}
