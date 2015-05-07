package com.oose.breakout;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GUI extends Entity {
	
	protected String hearts = "data/heart.png";
	
	/**
	 * Create a GUI instance
	 * At the moment this only shows the lives
	 * @throws SlickException
	 */
	public GUI() throws SlickException{
		Image = new Image(hearts);
		setX(5);
		setY(5);
		setWidth(30);
		setHeight(30);
		setLives(3);
	}
	
	/**
	 * Draw the GUI
	 * @param g
	 * @throws SlickException
	 */
	public void DrawGUI(Graphics g) throws SlickException{		
		for(int i = 0; i<getLives(); i++)
		{
			Image.draw(getX()+35*i,getY(),getWidth(),getHeight());
		}
	}
}

