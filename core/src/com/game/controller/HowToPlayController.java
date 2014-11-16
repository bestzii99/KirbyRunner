package com.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.game.screen.HowToPlayScreen;
import com.game.screen.MainMenuScreen;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class HowToPlayController {
	GameProject game;
	HowToPlayScreen howToPlayScreen;
	Rectangle pointer;
	public HowToPlayController(GameProject game, HowToPlayScreen howToPlayScreen){
		this.game = game;
		this.howToPlayScreen = howToPlayScreen;
		pointer = new Rectangle();
		
	}
	public void update(){
		pointer.set(Gdx.input.getX(), Gdx.input.getY(), 2, 2);
		
		if(pointer.overlaps(howToPlayScreen.back)){
			game.batch.draw(Assets.back_button_down,10,10,100,95);
			if(Gdx.input.isButtonPressed(0)){
				game.setScreen(new MainMenuScreen(game));
			}
		}
	}
}
