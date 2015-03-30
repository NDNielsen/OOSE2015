package com.oose.breakout;


public class Player extends Entity{
	protected byte LIVES = 3;
	
	
	
	
	//Setters & Getters for Player
	public byte getLIVES() {
		return LIVES;
	}

	public void setLIVES(byte lIVES) {
		LIVES = lIVES;
	}
	
	
}
