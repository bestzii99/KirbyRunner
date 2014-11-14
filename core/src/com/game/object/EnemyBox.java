package com.game.object;

public class EnemyBox extends Enemy{

	
	
	public EnemyBox() {
		super();
		setWidth(50);
		setHeight(45);
		setType(1+(int)(Math.random()*Enemy.MAX));		
	}
	

}
