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
	int x=0;
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
				case Enemy.STONE_1:
				game.batch.draw(Assets.stone_1, enemy.getPosition().x, enemy.getPosition().y);
				break;
				case Enemy.STONE_2:
					game.batch.draw(Assets.stone_2, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case Enemy.STONE_3:
					game.batch.draw(Assets.stone_3, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case Enemy.STONE_4:
					game.batch.draw(Assets.stone_4, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case Enemy.STONE_5:
					game.batch.draw(Assets.stone_5, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case Enemy.STONE_6:
					game.batch.draw(Assets.stone_6, enemy.getPosition().x, enemy.getPosition().y);
					break;
					
					
					
				case Enemy.BIRD_1:
					keyFrame = Assets.phoenix.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					game.batch.draw(keyFrame, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case Enemy.BIRD_2:
					keyFrame = Assets.phoenix.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					game.batch.draw(keyFrame, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case Enemy.BIRD_3:
					keyFrame = Assets.bird.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					game.batch.draw(keyFrame, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case Enemy.BIRD_4:
					keyFrame = Assets.bird.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					game.batch.draw(keyFrame, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case Enemy.BIRD_5:
					keyFrame = Assets.nyanCat.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					game.batch.draw(keyFrame, enemy.getPosition().x, enemy.getPosition().y);
					break;
				case Enemy.BIRD_6:
					keyFrame = Assets.nyanCat.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					game.batch.draw(keyFrame, enemy.getPosition().x, enemy.getPosition().y);
					break;
					
			default:
				break;
			}
		}
		
		
		keyFrame = Assets.coin.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
		game.batch.draw(keyFrame, x, 100);
		
	}
}
