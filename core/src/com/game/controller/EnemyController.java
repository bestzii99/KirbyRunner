package com.game.controller;

import java.util.ConcurrentModificationException;
import java.util.TreeMap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.object.Enemy;
import com.game.object.EnemyBox;
import com.game.object.Kirby;
import com.game.screen.GameScreen;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class EnemyController {

	private int y = 100;
	private int[][] arrayPosition = {
			{650, y},
			{850, y},
			{1050, y},
			{1350, y},
			{1190, y},
			{2050, y},
			{2150, y},
			{2411, y},
			};
	private TreeMap<Integer, Enemy> enemyList;
	GameProject game;
	GameScreen screen;
	private int objectId = 1;
	private int cntEnemy = 0;

	
	public EnemyController(GameProject game, GameScreen screen){
		this.game = game;
		this.screen = screen;
		enemyList = new TreeMap<Integer, Enemy>();
	}
	
	//public Texture ranStone(){
		//Texture[] arrayStone = {Assets.stone_1, Assets.stone_2, Assets.stone_3, Assets.stone_4};

		//return ;
		
	//}
	
	public void processing(){
		try{
			for(int id: getEnemy().keySet()){
				Enemy object = getEnemy().get(id);
				object.setPosition(object.getPosition().x - game.kirby.getSpeed(), object.getPosition().y);
				object.setBounds(object.getPosition().x+20, object.getPosition().y, object.getWidth()-20, object.getHeight());
				checkOverMap(getEnemy().get(id));
				
				game.batch.draw(Assets.stone_1, object.getPosition().x, object.getPosition().y);
				
				if(game.kirby.getBounds().overlaps(object.getBounds()) && !object.isHit() ){
					System.out.println("Overlap!");
					object.setHit(true);
					new Thread(){
						public void run(){
							for(int i=1; i<=10 ;i++){
								game.kirby.setState(Kirby.STATE_HURT);
//								game.batch.dr
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								game.kirby.setState(Kirby.STATE_RUN);
							}							
						}
						
					}.start();
					
				}
				
			}
			if(getEnemy().size() < 3){
				addEnemy();
			}
		}catch(ConcurrentModificationException e){
			
		}
	}
	
	public TreeMap<Integer, Enemy> getEnemy(){
		return enemyList;
	}
	
	private void checkOverMap (Enemy object){
		if(object.getPosition().x <= -150){
			removeEnemy(object.getId());
		}
	}
	
	public void addEnemy(){
		Enemy object = new EnemyBox();
		int ranPos = (int)(Math.random()*8);
		while(getEnemy().get(ranPos) != null){
			ranPos = (int)(Math.random()*8);
		}
		object.setPosition(arrayPosition[ranPos][0], arrayPosition[ranPos][1]);
		object.setId(ranPos);
		enemyList.put(ranPos, object);
		cntEnemy++;
	}
	
	public void removeEnemy(int id){
		enemyList.remove(id);
		cntEnemy--;
	}
}
