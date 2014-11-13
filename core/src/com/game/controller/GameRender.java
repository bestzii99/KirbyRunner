package com.game.controller;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
//		game.batch.draw(keyFrame, game.kirby.getPosition().x, game.kirby.getPosition().y);
	}
}
