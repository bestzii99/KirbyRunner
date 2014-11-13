package com.game.controller;

import java.util.ConcurrentModificationException;
import java.util.TreeMap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.object.Enemy;
import com.game.object.EnemyBox;
import com.game.object.Kirby;
import com.game.screen.GameScreen;
import com.mygdx.game.Animation2;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class EnemyController {

	private int y = 100;
	
	private int[][] arrayPosition = {
			/*{650, y},
			{850, y},
			{1050, y},
			{1350, y},
			{1190, y},
			{2050, y},
			{2150, y},
			{2411, y},
			};*/
			{650, y},
			{900, y},
			{1300, y},
			{1650, y},
			{2050, y},
			{2350, y},
			{3150, y}
	};	
	private int[][] arrayPosition2 = {
			{800,140},
			{1200,140},
			{1450,140},
			{1850,140},
			{2200,140},
			{2400,140},
			{3000,140}
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
				
//				game.batch.draw(Assets.stone_2, object.getPosition().x, object.getPosition().y);
				
//				game.batch.draw(Assets.bird.getKeyFrame(0f, Animation2.ANIMATION_LOOPING), object.getPosition().x, object.getPosition().y);
				
				if(game.kirby.getBounds().overlaps(object.getBounds()) && !object.isHit() ){
					// HP
					game.kirby.setHp(game.kirby.getHp()-1);
					System.out.println(game.kirby.getHp() + "<----- P");
					
					// OverLap					
					System.out.println("Overlap!");
					
					object.setHit(true);
					new Thread(){
						public void run(){
							for(int i=0;i<4;i++){
								
								try {
									game.batch.setColor(1f,0f,0f,1f);
									Thread.sleep(20);
									game.batch.setColor(1f,1f,1f,1f);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								game.batch.setColor(1f,1f,1f,1f);
							}							
						}
//							for(int i=1; i<=10 ;i++){
//								game.kirby.setState(Kirby.STATE_HURT);							
//								
//								try {									
//									Thread.sleep(120);
//								} catch (InterruptedException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//								game.kirby.setState(Kirby.STATE_RUN);
//							}
//						}						
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
		if(object.getPosition().x <= -60){
			removeEnemy(object.getId());
		}
	}
	
	boolean chk = false;
	public void addEnemy(){
		Enemy object = new EnemyBox();
		int ranPos = (int)(Math.random()*7);
		while(getEnemy().get(ranPos) != null){
			ranPos = (int)(Math.random()*7);
		}
		
/*		if(Math.abs(arrayPosition[ranPos][0] - arrayPosition2[ranPos][1]) > 150)
			 chk = true;*/
		
		if(object.getType() == 3 /*&& chk*/)
			object.setPosition(arrayPosition2[ranPos][0], arrayPosition2[ranPos][1]);
		else
			object.setPosition(arrayPosition[ranPos][0], arrayPosition[ranPos][1]);
		object.setId(ranPos);
		System.out.println(object.getPosition().x + ", " + object.getPosition().y);
		enemyList.put(ranPos, object);
		
		cntEnemy++;
	}
	
	public void removeEnemy(int id){
		enemyList.remove(id);
		cntEnemy--;
		
	}
	
	
	
}
