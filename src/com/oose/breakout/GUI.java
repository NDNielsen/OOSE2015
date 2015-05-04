package com.oose.breakout;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GUI extends Entity {
	
	String heart = "data/heart.png";
	Image[] Hearts = new Image[3];
	
	public GUI() throws SlickException{
		Image = new Image(heart);
		
	}
	
	public void DrawGUI(Graphics g){
		for(int i = 0; i <= Hearts.length; i++){
			//Hearts[i] = Image;
		}
	}
}
