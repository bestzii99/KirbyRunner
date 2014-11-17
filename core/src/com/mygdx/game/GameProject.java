package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.controller.EnemyController;
import com.game.object.Kirby;
import com.game.screen.GameScreen;
import com.game.screen.MainMenuScreen;

public class GameProject extends Game implements ApplicationListener {
	public SpriteBatch batch;
	public Kirby kirby;
	public EnemyController enemyController;
	public boolean playing = false;

	public void create () {
		batch = new SpriteBatch();
		Assets.load();
		this.setScreen(new MainMenuScreen(this));
	}
	
	public void render () {
		super.render();
	}
}



