package com.game.controller;

import java.util.TreeMap;

import com.game.object.Enemy;
import com.game.object.EnemyBox;
import com.mygdx.game.GameProject;

public class EnemyController {
	
	private TreeMap<Integer, Enemy> enemyList;
	GameProject game;
	private int objectId = 1;
	private int cntEnemy = 0;

	
	public EnemyController(GameProject game){
		this.game = game;
		enemyList = new TreeMap<Integer, Enemy>();
	}
	
	public void processing(){
		for(int id: getEnemy().keySet()){
			checkOverMap(getEnemy().get(id));
		}
		if(getEnemy().size() <= 3){
			addEnemy();
		}
	}
	
	public TreeMap<Integer, Enemy> getEnemy(){
		return enemyList;
	}
	
	private void checkOverMap (Enemy object){
		if(object.getPosition().x <= -20){
			removeEnemy(object.getId());
		}
	}
	
	public void addEnemy(){
		Enemy object = new EnemyBox();
		object.setId(objectId++);
		enemyList.put(object.getId(), object);
		cntEnemy++;
	}
	
	public void removeEnemy(int id){
		enemyList.remove(id);
		cntEnemy--;
	}
}
