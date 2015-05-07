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
	/**
	 * Get the width of the entity
	 * @return
	 */
	public float getWidth() {
		return width;
	}
	
	/**
	 * Set the width of the entity
	 * @param width
	 */
	public void setWidth(float width) {
		this.width = width;
	}
	
	/**
	 * Get the height of the entity
	 * @return
	 */
	public float getHeight() {
		return height;
	}
	
	/**
	 * Set the height of the entity
	 * @param height
	 */
	public void setHeight(float height) {
		this.height = height;
	}
	
	/**
	 * Get the speed of the entity
	 * @return
	 */
	public float getSpeed() {
		return speed;
	}
	
	/**
	 * Set the speed of the entity
	 * @param speed
	 */
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	/**
	 * Get the state of the entity
	 * @return
	 */
	public boolean getIsAlive() {
		return isAlive;
	}
	
	/**
	 * Set the state of the entity
	 * @param isAlive
	 */
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	/**
	 * Get the x position of the entity
	 * @return
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * Set the x position of the entity
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * Get the y position of the entity
	 * @return
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Set the y position of the entity
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * Get the image of the entity
	 * @return
	 */
	public Image getImage() {
		return Image;
	}
	
	/**
	 * Creates a rectangle from the position and size of the entity
	 * This is used to handle collision
	 * @return
	 */
	Rectangle getRect()
    {
      return new Rectangle(x, y, Image.getWidth(), Image.getHeight());
    }
	
	/**
	 * Get the amount of lives
	 * @return
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * Set the amount of lives
	 * @param lives
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}	
}
