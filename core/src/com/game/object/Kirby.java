package com.game.object;


public class Kirby extends ObjectBase {
	
	private int hp = 5;
	private int speed = 4;
	private int gravity = 7;
	private int state = 1;
	private boolean isAction = false;
	private boolean isAction2 = false;
	private boolean isActionJump1 = false;
	private boolean isActionJump2 = false;
	public static final int STATE_RUN = 1;
	public static final int STATE_DEATH = 2;
	public static final int STATE_HURT = 3;
	public static final int STATE_JUMP = 4;
	public static final int STATE_SPIN = 5;
//	public static final int STATE_SLIDE = 6;
	
	
	public void setHp(int hp) {
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
	
	public int getHp(){
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
	
	public boolean isActionJump1(){
		return isActionJump1;
	}
	
	public boolean isActionJump2(){
		return isActionJump2;
	}
	
	public void setActionJump1(boolean isActionJump){
		this.isActionJump1 = isActionJump;
	}
	
	public void setActionJump2(boolean isActionJump){
		this.isActionJump2 = isActionJump;
	}
}
