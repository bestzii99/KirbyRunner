package com.game.object;

public class EnemyBird extends Enemy {
	public EnemyBird(){
		super();
		int y = 300;
		setPosition(300, y);
		setWidth(50);
		setHeight(45);
		setBounds(getPosition().x, getPosition().y, getWidth(), getHeight());
	}
}
