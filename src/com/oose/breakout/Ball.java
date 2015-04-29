package com.oose.breakout;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.Graphics;

public class Ball extends Entity {
	Shape ball = null;
	
	Ball(int x, int y){
		positionX = x;
		positionY = y;
		ball = new Circle(positionX,positionY,10);
		
		
	}
	void move(){
		speed = 0.3F;
		positionX += speed;
		positionY += speed;
	}
	
	void render(Graphics g, Color color){
		g.setColor(color);
		g.fill(ball);
		
		
	}
}
