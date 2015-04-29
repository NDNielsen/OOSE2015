package com.oose.breakout;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Ball extends Entity {
	Shape ball = null;
	private float yDirection;
	private float xDirection;
	
	public Ball(){
		setSpeed(0.3F);
		yDirection = (-1)*getSpeed();
		xDirection = getSpeed();
		
		startPos();
		ball = new Circle(x, y,10);
	}
	
	public void startPos(){
		x = 200;
		y = 200;
	}
	
	public void move() throws SlickException{
		
		  x += xDirection;
	      y += yDirection;

	      if (x == 0) {
	        setXD(getSpeed());
	      }

	      if (x == 640) {
	        setXD((-1)*getSpeed());
	      }

	      if (y == 0) {
	        setYD(getSpeed());
	      }
	    }
	
	
	 public void setXD(float x){
	      xDirection = x;
	    }

	 public void setYD(float y){
	      yDirection = y;
	    }
	
	public void render(Graphics g, Color color)throws SlickException{
		g.setColor(color);
		g.fill(ball);
	}
}
