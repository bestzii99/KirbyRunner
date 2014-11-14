package com.game.controller;

import java.util.TreeMap;

import com.game.object.EnemyCoin;
import com.mygdx.game.GameProject;

public class CoinController {
	
	GameProject game;
	private TreeMap<Integer, EnemyCoin> coins;
	
	public CoinController(GameProject game){
		this.game = game;
		this.coins = new TreeMap<Integer, EnemyCoin>();
	}
	
	public void update(){
		process();
	}
	
	public void render(){
		
	}
	
	public void addCoin(){
		EnemyCoin coin = new EnemyCoin();
		coin.getPosition().x = 650;
		coin.getPosition().y = 100;
		coin.getBounds().setPosition(coin.getPosition());
		
		boolean chk = true;
		
		if(coins.size() <= 1){
			while(true){
				for(int id: game.enemyController.getEnemy().keySet()){
					if(game.enemyController.getEnemy().get(id).getBounds().overlaps(coin.getBounds())){
						System.out.println("!!!");
					}
				}
			}
			//return;
		}
	}
	
	public void process(){
		for(int id:coins.keySet()){
			coins.get(id);
		}
		if(coins.size() <= 10){
			addCoin();
		}
		
	}
}
