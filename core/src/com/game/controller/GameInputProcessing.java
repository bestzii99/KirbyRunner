package com.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.game.object.EnemyBox;
import com.game.object.Kirby;
import com.mygdx.game.GameProject;

public class GameInputProcessing {
	
	GameProject game;
	EnemyBox box;
	
	public GameInputProcessing(GameProject game){
		this.game = game;
	}
	
	public void processing(){
		if(game.kirby.getState() != Kirby.STATE_JUMP && game.kirby.getState() != Kirby.STATE_RUN && game.kirby.getState() != Kirby.STATE_HURT){
			game.kirby.setState(Kirby.STATE_RUN);
			game.kirby.setAction_HurtJump(false);
			game.kirby.setBounds(game.kirby.getPosition().x, game.kirby.getPosition().x, 50, 50);
		}
		
		
		if(Gdx.input.isKeyPressed(Keys.SPACE) && game.kirby.getState() != Kirby.STATE_JUMP && !game.kirby.isAction() && !game.kirby.isAction2()){
			game.kirby.setState(Kirby.STATE_JUMP);
			game.kirby.setActionJump2(true);
			game.kirby.setAction_HurtJump(true);
			game.kirby.setAction_SpinJump(true);
//			game.kirby.setActionJump2(false);
//			boolean inAction = true;
//			new Thread(){
//				public void run(){
//					for(int i=1;i<=45;i++){
//						try {
//							Thread.sleep(20);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						if( && Gdx.input.isKeyPressed(Keys.SPACE)){
//							System.out.println("Jump!");
//							new Thread(){
//								public void run(){
//									for(int i = 1; i<=20; i++){
//										try {
//											Thread.sleep(20);
//										} catch (InterruptedException e) {
//											e.printStackTrace();
//										}
//										game.kirby.setPosition(game.kirby.getPosition().x, game.kirby.getPosition().y+game.kirby.getGravity());
//										game.kirby.setBounds(game.kirby.getPosition().x, game.kirby.getPosition().y, Kirby.getWidth(), Kirby.getHeight());
//									}
//									for(int i=1; i<=20; i++){
//										try {
//											Thread.sleep(20); 
//										} catch (InterruptedException e) {
//											e.printStackTrace();
//										}
//										game.kirby.setPosition(game.kirby.getPosition().x, game.kirby.getPosition().y-game.kirby.getGravity());
//										game.kirby.setBounds(game.kirby.getPosition().x, game.kirby.getPosition().y, Kirby.getWidth(), Kirby.getHeight());
//									}
//									game.kirby.setState(Kirby.STATE_RUN);
//									game.kirby.setAction_HurtJump(false);
//									game.kirby.setAction_SpinJump(false);
//								}
//							}.start();
//							
//						}
//					}
//				}
//			}.start();
			new Thread(){
				public void run(){
					for(int i = 1; i<=20; i++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						game.kirby.setPosition(game.kirby.getPosition().x, game.kirby.getPosition().y+game.kirby.getGravity());
						game.kirby.setBounds(game.kirby.getPosition().x, game.kirby.getPosition().y, Kirby.getWidth(), Kirby.getHeight());
					}
					for(int i=1; i<=20; i++){
						try {
							Thread.sleep(20); 
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						game.kirby.setPosition(game.kirby.getPosition().x, game.kirby.getPosition().y-game.kirby.getGravity());
						game.kirby.setBounds(game.kirby.getPosition().x, game.kirby.getPosition().y, Kirby.getWidth(), Kirby.getHeight());
					}
					game.kirby.setState(Kirby.STATE_RUN);
					game.kirby.setAction_HurtJump(false);
					game.kirby.setAction_SpinJump(false);
				}
			}.start();		
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN) && game.kirby.getState() != Kirby.STATE_JUMP && !game.kirby.isAction2()){			
			game.kirby.setState(Kirby.STATE_SPIN);
			game.kirby.setAction_SpinJump(false);
			game.kirby.setBounds(game.kirby.getPosition().x, game.kirby.getPosition().x, 25, 25);
		
		}
		
	}
}
