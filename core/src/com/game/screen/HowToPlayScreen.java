package com.game.screen;

import com.badlogic.gdx.math.Rectangle;
import com.game.controller.HowToPlayController;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class HowToPlayScreen extends ScreenBase{
	
	GameProject game;
	HowToPlayController controller;
	
	public Rectangle back;
	
	public HowToPlayScreen(GameProject game){
		this.game = game;
		controller = new HowToPlayController(game, this);
		back = new Rectangle(10,375,100,95); 
	}

	@Override
	public void render(float delta) { 
		game.batch.begin();
		
		// draw HowToPlay Screen and Button Back
		game.batch.draw(Assets.howToPlay,0,0);
		game.batch.draw(Assets.back_button_up,10,10,100,95);
		
		controller.update();
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) { }

	@Override
	public void show() {
		
	}

	@Override
	public void hide() { }

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void dispose() { }
}
