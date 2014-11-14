package com.game.object;

public class EnemyBox extends Enemy{

	
	
	public EnemyBox() {
		super();
//		int x = 800+(int)(Math.random()*2000);
//		int[] array = {320, 640};
//		int x = array[(int) (Math.random()*2)];
		int x = 650;
		setPosition(x, 100);
		setWidth(50);
		setHeight(45);
		setBounds(getPosition().x, getPosition().y, getWidth(), getHeight());
		setType(1+(int)(Math.random()*4));

		
	}
	

}
