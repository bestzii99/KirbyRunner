package com.game.screen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		
		// draw Background, Back Button and HighScore 
		game.batch.draw(Assets.highScoreScreen, 0, 0);
		game.batch.draw(Assets.back_button_up, 10, 10, 100, 95);
		
		font.setColor(Color.TEAL);
		// read HighScore from highScore.txt
		try { font.draw(game.batch,showHighScore(), 280, 265); } 
		catch (IOException e) { e.printStackTrace(); }
		
		controller.update();
		game.batch.end();
		
//		System.out.println(Gdx.input.getX()+ ", " +Gdx.input.getY()+"   << x,y rectangle");		// x,y rectangle
//		System.out.println(Gdx.input.getX()+ ", " +(480-(Gdx.input.getY()))+"    << x,y texture"); 		// x,y texture

	}

	@Override
	public void resize(int width, int height) { }

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
	
	public void setFont(int size){ param.size = size; }
	
	private String showHighScore() throws IOException{
		File inFile = new File("HighScore.txt");
		FileReader fileReader = new FileReader(inFile); 
		BufferedReader bufReader = new BufferedReader(fileReader); 
		String line = bufReader.readLine(); 	
		bufReader.close();
		return line;
	}

}
