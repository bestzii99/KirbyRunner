package com.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.math.Rectangle;
import com.game.controller.HighScoreController;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class HighScoreScreen extends ScreenBase {
	GameProject game;
	
	public Rectangle backToMainMenu;
	
	HighScoreController controller;
	
	FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
	FreeTypeFontParameter param = new FreeTypeFontParameter();
	BitmapFont font;
	
	
	public HighScoreScreen(GameProject game) {
		super();
		this.game = game;
		controller = new HighScoreController(game, this);
		backToMainMenu = new Rectangle(10, 375, 100, 95);
		
		param.size = 80;
		param.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^?.,/\\()&*_+-=;:'\"[]{}";
		font = generator.generateFont(param);
		
		
		
	}

	@Override
	public void render(float delta) {
		game.batch.begin();
		game.batch.draw(Assets.bg_game_5,0,0,640,480);
		game.batch.draw(Assets.highScoreScreen, 0, 0);
		game.batch.draw(Assets.back_button_up, 10, 10, 100, 95);
		
		font.setColor(Color.PURPLE);
		
		System.out.println(Gdx.input.getX()+ ", " +(480-Gdx.input.getY()));
		font.draw(game.batch, "9999999", 280, 265);
		
		controller.update();
		
		
		game.batch.end();
		
		
		System.out.println(Gdx.input.getX()+ ", " +Gdx.input.getY());		// x,y rectangle
//		System.out.println(Gdx.input.getX()+ ", " +(480-(Gdx.input.getY()))); 		// x,y texture
		
		

	}

	@Override
	public void resize(int width, int height) { }

	@Override
	public void show() { }

	@Override
	public void hide() { }

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void dispose() { }
	
	public void setFont(int size){ param.size = size; }

}
