package com.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.game.screen.DeathScreen;
import com.game.screen.GameScreen;
import com.game.screen.HowToPlayScreen;
import com.game.screen.MainMenuScreen;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class DeathScreenController {
	
	GameProject game;
	DeathScreen deathScreen;
	Rectangle pointer;
	
	public DeathScreenController(GameProject game, DeathScreen deathScreen){
		pointer = new Rectangle();
		this.game = game;
		this.deathScreen = deathScreen;
	}
	public void update(){
		pointer.set(Gdx.input.getX(), Gdx.input.getY(), 2, 2);
		if(pointer.overlaps(deathScreen.restart)){
			game.batch.draw(Assets.restart_button_down, -65, 0);
			if(Gdx.input.isButtonPressed(0)){
				dispose();
				game.setScreen(new GameScreen(game));
			}
		}else if(pointer.overlaps(deathScreen.restartToMainMenu)){
			game.batch.draw(Assets.mainMenu_button_down, 370, 0);
			if(Gdx.input.isButtonPressed(0)){
				try {Thread.sleep(100);} catch (InterruptedException e) {}
				dispose();
				game.setScreen(new MainMenuScreen(game));
			}
		}
	}
	
	private void dispose(){
		game.dispose();
		Assets.sound_ending.dispose();
	}

}
