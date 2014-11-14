package com.game.object;

public abstract class Enemy extends ObjectBase {
	private int type;
	private boolean isHit = false;
	public static final int MAX = 12;
	public static final int STONE_1 = 1;
	public static final int STONE_2 = 2;
	public static final int STONE_3 = 3;
	public static final int STONE_4 = 4;
	public static final int STONE_5 = 5;
	public static final int STONE_6 = 6;
	public static final int BIRD_1 = 7;
	public static final int BIRD_2 = 8;
	public static final int BIRD_3 = 9;
	public static final int BIRD_4 = 10;
	public static final int BIRD_5 = 11;
	public static final int BIRD_6 = 12;
	
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
