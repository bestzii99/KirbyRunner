package com.game.controller;

import java.util.ConcurrentModificationException;
import java.util.TreeMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.game.object.Enemy;
import com.game.object.EnemyBox;
import com.game.screen.DeathScreen;
import com.game.screen.GameScreen;
import com.mygdx.game.Animation2;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class EnemyController {

	private int y = 100;	
	
	/*** List of Stone ***/
	private int[][] arrayPosition = {
			{650, y},
			{900, y},
			{1300, y},
			{1650, y},
			{2050, y},
			{2350, y},
			{3150, y}
	};	
	
	/*** List of Bird ***/
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
	private final int MAX_ENEMY = 4;
	
	public EnemyController(GameProject game, GameScreen screen){
		this.game = game;
		this.screen = screen;
		enemyList = new TreeMap<Integer, Enemy>();
	}
	
	public void processing(){		
		try{
			for(int id: getEnemy().keySet()){
				Enemy object = getEnemy().get(id);
				object.setPosition(object.getPosition().x - game.kirby.getSpeed(), object.getPosition().y);
				object.setBounds(object.getPosition().x+20, object.getPosition().y, object.getWidth()-20, object.getHeight());
				
				/*** Draw Item Plus HP >>> (CandyCane and Strawberry)***/
				checkOverMap(getEnemy().get(id));
				if((object.getType() == 8 || object.getType() == 10 ) && !object.isHit_Coin()){	
					
					TextureRegion keyFrame = null;
					switch(object.getType()){
						case 8 : 
//							keyFrame = Assets.coin.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
							game.batch.draw(Assets.candy, object.getPosition().x+180, 100, 32, 32);
							break;
						case 10 :
							keyFrame = Assets.strawberry.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
							game.batch.draw(keyFrame, object.getPosition().x+180, 100,32,32);
					}				
				}		
				
				/*** Check Overlap , If overlap plus HP ***/
				if( game.kirby.getBounds().overlaps(new Rectangle(object.getPosition().x+150, 100,32,32)) && (object.getType() == 8 || object.getType() == 10) && !object.isHit_Coin()){
					Assets.sound_hitObject.play();
					game.kirby.setHp(game.kirby.getHp()+1);
					System.out.println(game.kirby.getHp()+" <------ HP Plus");
					System.out.println("Get coin+++");
					
					object.setIsHit_Coin(true);			
					
				}
				
				/*** Set Screen to Death and Stop sound Background***/
				if(game.kirby.getHp() == 0){
					Gdx.app.log("Status", "Die");
					Assets.sound_bg.stop();
					game.setScreen(new DeathScreen(game));
				}
				
				/*** Check overlap, If overlap minus HP and set fade Screen color is Red  ***/
				if(game.kirby.getBounds().overlaps(object.getBounds()) && !object.isHit() ){
					Assets.sound_hurt.play();
//					Assets.sound_hitObject.dispose();
					// HP
					game.kirby.setHp(game.kirby.getHp()-1);
					System.out.println(game.kirby.getHp() + "<----- HP Minus");
					
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
					}.start();					
				}				
			}
			if(getEnemy().size() < MAX_ENEMY){
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
		boolean passed = false;
		int ranPos;
		boolean chk;
		do{
			ranPos = (int)(Math.random()*7);	// random x in array
			chk = true;
			for(int id: getEnemy().keySet()){
				Enemy enemy = getEnemy().get(id);
				if(object.getType() >= 7 && object.getType() <= 12){
					int x = arrayPosition2[ranPos][0];
					if( Math.abs(enemy.getPosition().x-x) <= 260 ){
						chk = false;
						break;
					}
				}
				else{
					int x = arrayPosition[ranPos][0];
					if( Math.abs(enemy.getPosition().x-x) <= 260 ){
						chk = false;
						break;
					}
				}
			}
			if(getEnemy().size() < 1){
				ranPos = (int)(Math.random()*7);
				passed = true;
				break;
			}
			if(chk) passed = true;
		}while(!passed);
		
		/*** check type Bird and create ***/
		if(object.getType() >= 7 && object.getType() <= 12)	 
			object.setPosition(arrayPosition2[ranPos][0], arrayPosition2[ranPos][1]);
		
		/*** check type Stone and create ***/
		else if(object.getType() >= 1 && object.getType() <= 6)
			object.setPosition(arrayPosition[ranPos][0],  game.kirby.getPosition().x+4);
		
		object.setId(objectId);
		System.out.println(object.getPosition().x + ", " + object.getPosition().y);
		enemyList.put(objectId++, object);		
		cntEnemy++;
	}
	
	public void removeEnemy(int id){
		enemyList.remove(id);
		cntEnemy--;
		
	}
	
	
	
}
