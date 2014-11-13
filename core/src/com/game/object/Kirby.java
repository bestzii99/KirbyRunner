package com.game.object;


public class Kirby extends ObjectBase {
	
	private float hp = 10000f;
	private int speed = 4;
	private int gravity = 7;
	private int state = 1;
	private boolean isAction = false;
	private boolean isAction2 = false;
	public static final int STATE_RUN = 1;
	public static final int STATE_DEATH = 2;
	public static final int STATE_HURT = 3;
	public static final int STATE_JUMP = 4;
	public static final int STATE_SPIN = 5;
//	public static final int STATE_SLIDE = 6;
	
	
	public void setHp(float hp) {
		this.hp = hp;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

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

	public boolean isAction() {
		// TODO Auto-generated method stub
		return isAction;
	}
	
	public void setAction_HurtJump(boolean action){
		this.isAction = action;
	}

	public boolean isAction2() {
		// TODO Auto-generated method stub
		return isAction2;
	}
	public void setAction_SpinJump(boolean action){
		this.isAction2 = action;
	}
	
}
