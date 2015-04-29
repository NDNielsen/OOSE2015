package com.oose.breakout;

import org.newdawn.slick.Image;


public class Entity {
	protected float x = 0;
	protected float y = 0;
	protected Image entityImage;
	protected boolean isAlive;
	protected float speed;
	
	
	
	//Setters & Getters of entity
	public float getSpeed() {
		return speed;
	}
	public void setSPEED(int speed) {
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
	public Image getEntityImage() {
		return entityImage;
	}
	public void setEntityImage(Image entityImage) {
		this.entityImage = entityImage;
	}
	
	
	
}
