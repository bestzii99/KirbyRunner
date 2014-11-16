package com.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.object.EnemyBox;
import com.game.object.Kirby;
import com.game.screen.GameScreen;
import com.mygdx.game.Animation2;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class GameInputProcessing {
	
	GameProject game;
	EnemyBox box;
	
	public GameInputProcessing(GameProject game){
		this.game = game;
	}
	
	public void processing(){
		if(game.kirby.getState() != Kirby.STATE_JUMP &&  game.kirby.getState() != Kirby.STATE_HURT){
			game.kirby.setState(Kirby.STATE_RUN);
			game.kirby.setAction_HurtJump(false);
			game.kirby.setBounds(game.kirby.getPosition().x, game.kirby.getPosition().x, 50, 50);
			
			/*** Create Animation dust***/
			TextureRegion keyFrame = null;
			keyFrame = Assets.dust.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
			game.batch.draw(keyFrame, game.kirby.getPosition().x-35, game.kirby.getPosition().y);
			
		}
		
		/*** Jump ***/
		if(Gdx.input.isKeyPressed(Keys.UP) && game.kirby.getState() != Kirby.STATE_JUMP && !game.kirby.isAction() && !game.kirby.isAction2()){
//			Assets.sound_hitObject.play();
			game.kirby.setState(Kirby.STATE_JUMP);
			
			game.kirby.setActionJump2(true);
			game.kirby.setAction_HurtJump(true);
			game.kirby.setAction_SpinJump(true);
			Assets.sound_jump.play();
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
		
		/*** Spin ***/
		else if(Gdx.input.isKeyPressed(Keys.DOWN) && game.kirby.getState() != Kirby.STATE_JUMP && !game.kirby.isAction2()){	
			game.kirby.setState(Kirby.STATE_SPIN);
			game.kirby.setAction_SpinJump(false);
			game.kirby.setBounds(game.kirby.getPosition().x, game.kirby.getPosition().x, 25, 25);
		}	
	}
}
