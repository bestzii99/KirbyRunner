package com.game.screen;

import java.awt.PointerInfo;
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
import com.badlogic.gdx.math.Rectangle;
import com.game.controller.DeathScreenController;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class DeathScreen extends ScreenBase {
	GameProject game;
	public Rectangle restart;
	public Rectangle restartToMainMenu;
	
	DeathScreenController controller;
	
	public DeathScreen(GameProject game) {
		super();
		this.game = game;
		Assets.sound_death.play();
		controller = new DeathScreenController(game, this);
		
//		new Thread(){
//			public void run(){
//				try {
//					Thread.sleep(5000);
//					Assets.sound_ending.play(0.5f);
//
//				} catch (InterruptedException e) { e.printStackTrace(); }
//			}
//		}.start();		
		
		restart = new Rectangle(7,425,160,50);		// draw button restrat
		restartToMainMenu = new Rectangle(440,420,160,50);		// draw button restrat to main menu
	}
	
	@Override
	public void render(float delta) {
		/***
		 *  check overlap button 
		 */
		System.out.println(Gdx.input.getX()+ ", " +Gdx.input.getY());		// x,y rectangle
//		System.out.println(Gdx.input.getX()+ ", " +(480-(Gdx.input.getY()))); 		// x,y texture
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		game.batch.begin();
		
		font.setColor(Color.BLACK);
		game.batch.draw(Assets.gameover, 0, 0, 640, 480);
		game.batch.draw(Assets.restart_button_up, -65, 0);	// draw button restart
		game.batch.draw(Assets.mainMenu_button_up, 370, 0);	// draw button restart menu
		
		/*** get HighScore from HighScore.txt***/
		try {
			font.draw(game.batch, "High Score : " + game.kirby.HighScore(game.kirby.getScore()), 160, 150) ;
		} catch (IOException e) { e.printStackTrace(); }
		font.draw(game.batch, "Score : " + game.kirby.getScore(), 250, 100);
		
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
