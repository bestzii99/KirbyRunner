package com.game.object;

public abstract class Enemy extends ObjectBase {
	private int type;
	private boolean isHit = false;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public boolean isHit() {
		return isHit;
	}
	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}
	
	
}
