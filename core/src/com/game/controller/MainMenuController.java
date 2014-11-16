package com.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.game.screen.GameScreen;
import com.game.screen.HighScoreScreen;
import com.game.screen.HowToPlayScreen;
import com.game.screen.MainMenuScreen;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class MainMenuController {
	
	GameProject game;
	MainMenuScreen mainMenuScreen;
	Rectangle pointer;
	public MainMenuController(GameProject game, MainMenuScreen screen){
		this.game = game;
		this.mainMenuScreen = screen;
		pointer = new Rectangle();
	}
	
	public void update(){
		pointer.set(Gdx.input.getX(), Gdx.input.getY(), 2, 2);
		if(pointer.overlaps(mainMenuScreen.startGame)){
			game.batch.draw(Assets.play_button_down, 170, 250);
			if(Gdx.input.isButtonPressed(0)){
				game.setScreen(new GameScreen(game));
			}
		}else if(pointer.overlaps(mainMenuScreen.howToPlay)){
			game.batch.draw(Assets.howTo_button_down,170, 170);
			if(Gdx.input.isButtonPressed(0)){
				game.setScreen(new HowToPlayScreen(game));
			}
		}else if(pointer.overlaps(mainMenuScreen.highScore)){
			game.batch.draw(Assets.highScore_button_down,170 ,25);
			if(Gdx.input.isButtonPressed(0)){
				game.setScreen(new HighScoreScreen(game));
			}
		}else if(pointer.overlaps(mainMenuScreen.exit)){
			game.batch.draw(Assets.exit_button_down,520 ,35);
			if(Gdx.input.isButtonPressed(0)){
				Gdx.app.exit();
			}
		}
		
	}
}
