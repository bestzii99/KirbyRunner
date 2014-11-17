package com.game.screen;

import com.badlogic.gdx.math.Rectangle;
import com.game.controller.CreditScreenController;
import com.game.controller.DeathScreenController;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class CreditScreen extends ScreenBase{
	GameProject game;
	public Rectangle backToMainMenu;
	CreditScreenController controller;
	
	public CreditScreen(GameProject game){
		super();
		this.game = game;
		controller = new CreditScreenController(game, this);
		backToMainMenu = new Rectangle(10, 375, 100, 95);
	}

	@Override
	public void render(float delta) {
		
		game.batch.begin();
		
		game.batch.draw(Assets.creditScreen,0,0);
		game.batch.draw(Assets.back_button_up,10, 10, 100, 95);
		
		controller.update();
		game.batch.end();
		
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void show() {}

	@Override
	public void hide() {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void dispose() {}
	

}

