package com.oose.breakout;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Ball extends Entity {
	Shape ball = null;
	public float posX;
	public float posY;
	
	Ball(){
		
		ball = new Circle(posX, posY,10);
		
		
	}
	void move() throws SlickException{
		speed = 0.3F;
		posX = posX + speed;
		posY = posY + speed;
	}
	
	void render(Graphics g, Color color)throws SlickException{
		g.setColor(color);
		g.fill(ball);
		
		
	}
}
