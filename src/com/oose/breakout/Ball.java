package com.oose.breakout;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Ball extends Entity {
	Shape ball = null;
	
	Ball(){
		positionX = 100;
		positionY = 100;
		ball = new Circle(positionX,positionY,10);
		
		
	}
	void move() throws SlickException{
		speed = 0.3F;
		positionX = positionX + speed;
		positionY = positionY + speed;
	}
	
	void render(Graphics g, Color color)throws SlickException{
		g.setColor(color);
		g.fill(ball);
		
		
	}
}
