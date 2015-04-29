package com.oose.breakout;

import org.newdawn.slick.Image;


public class Entity {
	protected int positionX;
	protected int positionY;
	protected Image entityImage;
	protected boolean isAlive;
	public float speed;
	
	
	
	//Setters & Getters of entity
	public float getSpeed() {
		return speed;
	}
	public void setSPEED(int _speed) {
		speed = _speed;
	}
	public boolean isIsAlive() {
		return isAlive;
	}
	public void setIsAlive(boolean _isAlive) {
		isAlive = _isAlive;
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int _positionX) {
		positionX = _positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int _positionY) {
		positionY = _positionY;
	}
	public Image getEntityImage() {
		return entityImage;
	}
	public void setEntityImage(Image _entityImage) {
		entityImage = _entityImage;
	}
	
	
	
}
