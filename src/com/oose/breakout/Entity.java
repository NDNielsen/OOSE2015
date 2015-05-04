package com.oose.breakout;

import org.newdawn.slick.Image;


public class Entity {
	protected float x = 0, y = 0, width, height;
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
	public boolean isIsAlive() {
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
	
	
	
//	public void setEntityImage(Image entityImage) {
//		this.entityImage = entityImage;
//	}
	
	
	
}
