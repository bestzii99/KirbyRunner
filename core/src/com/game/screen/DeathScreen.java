package com.game.screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;


public class DeathScreen extends ScreenBase {
//	TreeSet<Integer> h_score = new TreeSet();
	
	GameProject game;
	public DeathScreen(GameProject game) {
		super();
		this.game = game;
		
	}
	@Override
	public void render(float delta) {
		game.batch.begin();
		game.batch.draw(Assets.gameover, 0, 0, 640, 480);
		font.setColor(Color.BLACK);
		Assets.sound_death.play();

		try {
			font.draw(game.batch, "High Score : " + game.kirby.HighScore(game.kirby.getScore()), 190, 150) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		font.draw(game.batch, "Score : " + game.kirby.getScore(), 190, 100);
		
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	
//	public int highScore(int score){		
//		h_score.add(score);
//		return h_score.last();
//	}
//	

	

}
