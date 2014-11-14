package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.controller.CoinController;
import com.game.controller.EnemyController;
import com.game.object.Kirby;
import com.game.screen.GameScreen;

public class GameProject extends Game implements ApplicationListener {
	
	public SpriteBatch batch;
	public Kirby kirby;
	public EnemyController enemyController;
	public CoinController coinController;
	public void create () {
		batch = new SpriteBatch();
		Assets.load();
		this.setScreen(new GameScreen(this));
	}


	public void render () {
		super.render();
	}
}



