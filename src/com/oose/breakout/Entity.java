package com.oose.breakout;

import org.newdawn.slick.Image;

public class Entity {
	protected int POSITION_X;
	protected int POSITION_Y;
	protected Image ENTITY_IMAGE;
	
	
	
	public int getPOSITION_X() {
		return POSITION_X;
	}
	public void setPOSITION_X(int pOSITION_X) {
		POSITION_X = pOSITION_X;
	}
	public int getPOSITION_Y() {
		return POSITION_Y;
	}
	public void setPOSITION_Y(int pOSITION_Y) {
		POSITION_Y = pOSITION_Y;
	}
	public Image getENTITY_IMAGE() {
		return ENTITY_IMAGE;
	}
	public void setENTITY_IMAGE(Image eNTITY_IMAGE) {
		ENTITY_IMAGE = eNTITY_IMAGE;
	}
	
	
}