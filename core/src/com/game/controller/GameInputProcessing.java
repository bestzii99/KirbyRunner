package com.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.game.object.Kirby;
import com.mygdx.game.GameProject;

public class GameInputProcessing {
	
	GameProject game;
	
	public GameInputProcessing(GameProject game){
		this.game = game;
	}
	
	public void processing(){
		if(Gdx.input.isKeyPressed(Keys.SPACE) && game.kirby.getState() != Kirby.STATE_JUMP){
			game.kirby.setState(Kirby.STATE_JUMP);
			new Thread(){
				public void run(){
					for(int i = 1; i<=20; i++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						game.kirby.setPosition(game.kirby.getPosition().x, game.kirby.getPosition().y+5);
						game.kirby.setBounds(game.kirby.getPosition().x, game.kirby.getPosition().y, Kirby.getWidth(), Kirby.getHeight());
					}
					for(int i=1; i<=20; i++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						game.kirby.setPosition(game.kirby.getPosition().x, game.kirby.getPosition().y-5);
						game.kirby.setBounds(game.kirby.getPosition().x, game.kirby.getPosition().y, Kirby.getWidth(), Kirby.getHeight());
					}
					game.kirby.setState(Kirby.STATE_RUN);
				}
			}.start();
		}
	}
}
