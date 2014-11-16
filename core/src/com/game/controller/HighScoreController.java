package com.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.game.screen.HighScoreScreen;
import com.game.screen.MainMenuScreen;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class HighScoreController {
	GameProject game;
	HighScoreScreen highScoreScreen;
	Rectangle pointer;
	
	public HighScoreController(GameProject game, HighScoreScreen highScoreScreen){
		this.game = game;
		this.highScoreScreen = highScoreScreen;
		pointer = new Rectangle();
	}
	
	public void update(){
		pointer.set(Gdx.input.getX(), Gdx.input.getY(), 2, 2);
		if(pointer.overlaps(highScoreScreen.backToMainMenu)){
			game.batch.draw(Assets.back_button_down,10, 10, 100, 95);
			if(Gdx.input.isButtonPressed(0)){
				game.setScreen(new MainMenuScreen(game));
			}
		}
	}
}
