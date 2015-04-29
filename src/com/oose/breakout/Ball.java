package com.oose.breakout;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Ball extends Entity {
	Shape ball = null;
	
	Ball(){
		
		ball = new Circle(getX(), getY(),10);
		
		
	}
	public void move() throws SlickException{
		speed = 0.3F;
		setX(getX()+speed);
		setY(getY()+speed);
	}
	
	public void render(Graphics g, Color color)throws SlickException{
		g.setColor(color);
		g.fill(ball);
		
		
	}
}
