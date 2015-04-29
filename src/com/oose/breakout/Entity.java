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
	public void setSPEED(int _speed) {
		speed = _speed;
	}
	public boolean isIsAlive() {
		return isAlive;
	}
	public void setIsAlive(boolean _isAlive) {
		isAlive = _isAlive;
	}
	public float getPositionX() {
		return positionX;
	}
	public void setPositionX(float _positionX) {
		positionX = _positionX;
	}
	public float getPositionY() {
		return positionY;
	}
	public void setPositionY(float _positionY) {
		positionY = _positionY;
	}
	public Image getEntityImage() {
		return entityImage;
	}
	public void setEntityImage(Image _entityImage) {
		entityImage = _entityImage;
	}
	
	
	
}
