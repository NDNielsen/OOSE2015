package com.oose.breakout;

import org.newdawn.slick.Image;


public class Entity {
	protected float positionX;
	protected float positionY;
	protected Image entityImage;
	protected boolean isAlive;
	public float speed;
	
	
	
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
	public float getPositionX() {
		return positionX;
	}
	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	public float getPositionY() {
		return positionY;
	}
	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}
	public Image getEntityImage() {
		return entityImage;
	}
	public void setEntityImage(Image entityImage) {
		this.entityImage = entityImage;
	}
	
	
	
}
