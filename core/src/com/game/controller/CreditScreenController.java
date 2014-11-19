package com.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.game.screen.CreditScreen;
import com.game.screen.MainMenuScreen;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class CreditScreenController {
	GameProject game;
	CreditScreen creditScreen;
	Rectangle pointer;
	
	public CreditScreenController(GameProject game, CreditScreen creditScreen){
		pointer = new Rectangle();
		this.game = game;
		this.creditScreen = creditScreen;
	}
	
	public void update(){
		pointer.set(Gdx.input.getX(), Gdx.input.getY(), 2, 2);
		if(pointer.overlaps(creditScreen.backToMainMenu)){
			game.batch.draw(Assets.back_button_down,10, 10, 100, 95);
			if(Gdx.input.isButtonPressed(0)){
				game.setScreen(new MainMenuScreen(game));
			}
		}
	}
}
