package com.oose.breakout;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;


public class Entity {
	protected float x = 0, y = 0, width, height;
	protected int lives;
	protected Image Image;
	protected boolean isAlive;
	protected float speed;
	
	//Setters & Getters of entity
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public boolean getIsAlive() {
		return isAlive;
	}
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public Image getImage() {
		return Image;
	}
	
	Rectangle getRect()
    {
      return new Rectangle(x, y, Image.getWidth(), Image.getHeight());
    }
	
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}	
}
