package com.game.object;

public class EnemyBox extends Enemy{

	public EnemyBox() {
		super();
		setPosition(300, 95);
		setWidth(50);
		setHeight(45);
		setBounds(getPosition().x, getPosition().y, getWidth(), getHeight());
	}
	

}
