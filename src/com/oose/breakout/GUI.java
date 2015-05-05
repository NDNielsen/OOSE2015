package com.oose.breakout;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GUI extends Entity {
	
	String heart = "data/heart.png";
	Image[] Hearts = new Image[3];
	byte lives = 3;
	
	public GUI() throws SlickException{
			
		Hearts[0] = new Image(heart);
		Hearts[1] = new Image(heart);
		Hearts[2] = new Image(heart);

		
		x = 5;
		y = 5;
	}
	
	public void DrawGUI(Graphics g) throws SlickException{

		if(lives == 3){
			Hearts[0].draw(x,y,30,30);
			Hearts[1].draw(x+35,y,30,30);
			Hearts[2].draw(x+70,y,30,30);
		} else if(lives == 2){
			Hearts[0].draw(x,y,30,30);
			Hearts[1].draw(x+35,y,30,30);
		} else if(lives == 1){
			Hearts[0].draw(x,y,30,30);
		} else {
			System.out.println("No more life left!");
		}
	}
}

