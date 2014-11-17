package com.game.screen;

import java.awt.RenderingHints.Key;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.TimeUtils;
import com.game.controller.EnemyController;
import com.game.controller.GameInputProcessing;
import com.game.controller.GameRender;
import com.game.object.EnemyBox;
import com.game.object.Kirby;
import com.mygdx.game.Animation2;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class GameScreen extends ScreenBase {

	GameProject game;
	GameRender renderer;
	GameInputProcessing controller;
	
	float currentBgX;
	long lastTimeBg;
	int width = 1200;
	int height = 570;
	int cntTime = 0;
	float fadeTime = 1.0f;
	boolean isChange = false;

	public static float stateTime = 0f;

	Texture bg_1;
	Texture bg_2;

	FileHandle fontFile = Gdx.files.internal("fonts/THSarabun.ttf");
	FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
	FreeTypeFontParameter param = new FreeTypeFontParameter();
	BitmapFont font;

	public GameScreen(final GameProject game){
		super();
		game.kirby = new Kirby();
		renderer = new GameRender(game);
		controller = new GameInputProcessing(game);
		game.enemyController = new EnemyController(game, this);

		this.game = game;

		param.size = 45;
		param.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^?.,/\\()&*_+-=;:'\"[]{}";
		font = generator.generateFont(param);

		currentBgX = width;
		lastTimeBg = TimeUtils.nanoTime();

		/**** set screen1 and screen2 ****/
		bg_1 = Assets.bg_game_1;
		bg_2 = Assets.bg_game_1;

		/**** Sound Background****/
		Assets.sound_bg.loop();	//Loop
		game.playing = true;
		System.out.println("Aaa");
		/**** count time use fade in-out (if cnt = 20 fade) ****/
		new Thread(){
			public void run(){

				while(true){
					try {
						if(game.playing){
							Thread.sleep(1000);
							cntTime += 1;
	
							if(game.kirby.getHp() != 0) game.kirby.setScore(cntTime);	// add score
	
							System.out.println(cntTime);
						}else{
							cntTime = 0; // reset score
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}.start();
	}
	
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		
		game.batch.begin();
		backgroundLoop(); 	// fade in-out screen background and infinite loop background 

		/**** Draw Background****/ 
		game.batch.draw(bg_1, currentBgX-width, 0, width, height);
		game.batch.draw(bg_1, currentBgX, 0, width, height);
		
		font.setColor(Color.WHITE);		// color of  font
		font.draw(game.batch, "x " + game.kirby.getHp(), 100, 450);	// show HP
		font.draw(game.batch, "Score : " + game.kirby.getScore(), 435, 450);	// show score
		
		if(Gdx.input.isKeyJustPressed(Keys.D)) game.kirby.setHp(0);
		
		if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			cntTime = 0;
			game.playing = false;
			Assets.sound_bg.stop();
			game.setScreen(new MainMenuScreen(game));
		}
		
		controller.processing();
		renderer.render();
		game.enemyController.processing();
		game.batch.end(); // batch end

		/**** Frame rate ****/
		frameRate();
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
	
	private void frameRate(){
		try {
			Thread.sleep((long)(1000/60-Gdx.graphics.getDeltaTime()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void setFont(int size){
		param.size = size;
	}
	
	private void backgroundLoop(){
		if(cntTime%20 == 0 && !isChange && cntTime > 0){
			new Thread(){
				public void run(){					
					try {
						float fade_in = 1.0f;
						float fade_out = 0.1f;
						for(int i=1;i<=10;i++){
							game.batch.setColor(1.0f, 1.0f, 1.0f, fade_in);
							Thread.sleep(70);
							fade_in -= 0.1f;
						}
						game.batch.setColor(1.0f, 1.0f, 1.0f, 0.1f);
						Thread.sleep(70);
						for(int i=1;i<=10;i++){
							game.batch.setColor(1.0f, 1.0f, 1.0f, fade_out);
							Thread.sleep(100);
							fade_out += 0.1f;
						}					
					} catch (InterruptedException e) {}
					isChange = false;
				}
			}.start();
			isChange = true;
		}
		switch (cntTime) {
			case 1: bg_1 = Assets.bg_game_1; break;
			case 21: bg_1 = Assets.bg_game_2; break;
			case 41: bg_1 = Assets.bg_game_3; break;
			case 61: bg_1 = Assets.bg_game_4; break;
			case 81: bg_1 = Assets.bg_game_5; break;
			case 101: bg_1 = Assets.bg_game_6; break;
			case 121: bg_1 = Assets.bg_game_7; break;
			case 141: bg_1 = Assets.bg_game_8; break;
			case 161: cntTime = 1; break;
		}
		
		/****  Check Infinite Loop Backround ****/
		if(currentBgX == 0) currentBgX = width;
		
		currentBgX -= game.kirby.getSpeed();	// run speed default = 4
	}
	

	

}
