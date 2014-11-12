package com.game.object;


public class Kirby extends ObjectBase {
	
	private float hp = 10000f;
	private float speed = 10f;
	
	private int state = 1;
	public static final int STATE_RUN = 1;
	public static final int STATE_DEATH = 2;
	public static final int STATE_HURT = 3;
	public static final int STATE_JUMP = 4;
	
	
	public Kirby(){
		super();
		setPosition(100, 105);
		setWidth(50);
		setHeight(50);
		setBounds(getPosition().x, getPosition().y, getWidth(), getHeight());
	}
	
	public float getHp(){
		return hp;
	}
	
	public float getSpeed(){
		return speed;
	}
	
	public void setState(int state){
		this.state = state;
	}
	
	public int getState(){
		return state;
	}
	
}
