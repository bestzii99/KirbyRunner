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
		this.game = game;
		this.deathScreen = deathScreen;
		pointer = new Rectangle();
	}
	public void update(){
		pointer.set(Gdx.input.getX(), Gdx.input.getY(), 2, 2);
		if(pointer.overlaps(deathScreen.restart)){
			game.batch.draw(Assets.restart_button_down,10, 15);
			if(Gdx.input.isButtonPressed(0)){
				game.dispose();
				game.setScreen(new GameScreen(game));
				Assets.sound_ending.dispose();
				
			}
		}else if(pointer.overlaps(deathScreen.restartToMainMenu)){
			if(Gdx.input.isButtonPressed(0)){
				game.dispose();
				try {Thread.sleep(100);} catch (InterruptedException e) {}
				game.setScreen(new MainMenuScreen(game));
				Assets.sound_death.dispose();
				game.dispose();
				


			}
		}
	}

}
