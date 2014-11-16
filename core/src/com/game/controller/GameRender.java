package com.game.controller;

import com.badlogic.gdx.graphics.Texture;
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
				keyFrame = Assets.kirbyDeath.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
				break;
			case Kirby.STATE_HURT:
				keyFrame = Assets.kirbyHurt.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
				break;
			case Kirby.STATE_JUMP:
				keyFrame = Assets.kirbyJump.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
				break;
			case Kirby.STATE_SPIN:
				keyFrame = Assets.kirbySpin.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);
				break;
			default:
				break;
		}
		
		game.batch.draw(keyFrame, game.kirby.getPosition().x, game.kirby.getPosition().y);
		
		for(int id:game.enemyController.getEnemy().keySet()){
			Enemy enemy = game.enemyController.getEnemy().get(id);
			keyFrame = null;
			Texture texture = null;
			switch (enemy.getType()) {
				case Enemy.STONE_1:
					texture = Assets.stone_1;break;
				case Enemy.STONE_2:
					texture = Assets.stone_2;break;
				case Enemy.STONE_3:
					texture = Assets.stone_3;break;
				case Enemy.STONE_4:
					texture = Assets.stone_4;break;
				case Enemy.STONE_5:
					texture = Assets.stone_5;break;
				case Enemy.STONE_6:
					texture = Assets.stone_6;break;
				case Enemy.BIRD_1:
					keyFrame = Assets.phoenix.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);			
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					break;
				case Enemy.BIRD_2:
					keyFrame = Assets.phoenix.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					break;
				case Enemy.BIRD_3:
					keyFrame = Assets.bird.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					break;
				case Enemy.BIRD_4:
					keyFrame = Assets.bird.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					break;
				case Enemy.BIRD_5:
					keyFrame = Assets.nyanCat.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					break;
				case Enemy.BIRD_6:
					keyFrame = Assets.nyanCat.getKeyFrame(GameScreen.stateTime, Animation2.ANIMATION_LOOPING);					
					game.enemyController.getEnemy().get(id).setBounds(enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth(), enemy.getHeight());
					break;
			default:
				break;
			}
			if(keyFrame != null) game.batch.draw(keyFrame, enemy.getPosition().x, enemy.getPosition().y);
			else if (keyFrame == null)game.batch.draw(texture, enemy.getPosition().x, enemy.getPosition().y);
		}		
	}
}
