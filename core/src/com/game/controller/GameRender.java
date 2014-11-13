package com.game.controller;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.object.Enemy;
import com.game.object.Kirby;
import com.game.screen.GameScreen;
import com.mygdx.game.Animation2;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class GameRender {
	
	GameProject game;

	
	public GameRender(GameProject game){
		this.game = game;
	}
	
	public void render(){
		TextureRegion keyFrame = null;
		
		switch (game.kirby.getState()) {
			case Kirby.STATE_RUN:
				keyFrame = Assets.kirbyRun.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
				break;
			case Kirby.STATE_DEATH:
				GameScreen.stateTime = 0f;
				keyFrame = Assets.kirbyDeath.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
				break;
			case Kirby.STATE_HURT:
//				GameScreen.stateTime = 0f;
				keyFrame = Assets.kirbyHurt.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
				break;
			case Kirby.STATE_JUMP:
//				GameScreen.stateTime = 0f;
				keyFrame = Assets.kirbyJump.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
				break;
			case Kirby.STATE_SPIN:
//				GameScreen.stateTime = 0f;
				keyFrame = Assets.kirbySpin.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
				break;
			default:
				break;
		}
		
		game.batch.draw(keyFrame, game.kirby.getPosition().x, game.kirby.getPosition().y);
		
		for(int id:game.enemyController.getEnemy().keySet()){
			Enemy enemy = game.enemyController.getEnemy().get(id);
			switch (enemy.getType()) {
				case 1:
				game.batch.draw(Assets.stone_1, enemy.getPosition().x, enemy.getPosition().y);
				break;
				case 2:
					game.batch.draw(Assets.stone_2, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case 4:
					game.batch.draw(Assets.stone_3, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case 3:
					keyFrame = Assets.bird.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					game.batch.draw(keyFrame, enemy.getPosition().x, enemy.getPosition().y);
					break;
			default:
				break;
			}
		}
//		game.batch.draw(keyFrame, game.kirby.getPosition().x, game.kirby.getPosition().y);
	}
}
