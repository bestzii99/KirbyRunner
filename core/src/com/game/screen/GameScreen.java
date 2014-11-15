package com.game.screen;

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
import com.game.controller.CoinController;
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
	float currentBgX;
	long lastTimeBg;
	int width = 1200;
	int height = 570;
	int cntTime = 0;
	float fadeTime = 1.0f;
	boolean isChange = false;

	GameRender renderer;
	GameInputProcessing controller;

	public static float stateTime = 0f;

	Texture bg_1;
	Texture bg_2;

	FileHandle fontFile = Gdx.files.internal("fonts/THSarabun.ttf");
	FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
	FreeTypeFontParameter param = new FreeTypeFontParameter();
	BitmapFont font;

	public GameScreen(final GameProject game){
		game.kirby = new Kirby();
		renderer = new GameRender(game);
		controller = new GameInputProcessing(game);
		game.enemyController = new EnemyController(game, this);
		game.coinController = new CoinController(game);

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
//		long id = Assets.sound_bg.play(0.5f);
		Assets.sound_bg.loop();	//Loop



		/**** count time use fade in-out (if cnt = 20 fade) ****/
		new Thread(){
			public void run(){

				while(true){
					try {
						Thread.sleep(1000);
						cntTime += 1;

						if(game.kirby.getHp() != 0) game.kirby.setScore(cntTime);	// add score

						System.out.println(cntTime);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}.start();
	}


	public void setFont(int size){
		param.size = size;
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		game.batch.begin();

		/**** fade in-out screen background and infinite loop background ****/
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
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					isChange = false;
				}
			}.start();
			isChange = true;
		}else if (cntTime == 1){
			bg_1 = Assets.bg_game_1;
		}else if (cntTime == 21){
			bg_1 = Assets.bg_game_2;			
		}else if(cntTime == 41){
			bg_1 = Assets.bg_game_3;
		}else if(cntTime == 61){
			bg_1 = Assets.bg_game_4;
		}else if(cntTime == 81){
			bg_1 = Assets.bg_game_5;
		}else if(cntTime == 101){
			bg_1 = Assets.bg_game_6;
		}else if(cntTime == 121){
			bg_1 = Assets.bg_game_7;
		}else if(cntTime == 141){
			bg_1 = Assets.bg_game_8;
		}else if(cntTime == 161){
			cntTime = 1;
		}

		/**** Draw Background****/ 
		game.batch.draw(bg_1, currentBgX-width, 0, width, height);
		game.batch.draw(bg_1, currentBgX, 0, width, height);
		
		/****  Check Infinite Loop Backround ****/
		if(currentBgX == 0){
			currentBgX = width;
		}
		
		font.setColor(Color.WHITE);		// color of  font
		font.draw(game.batch, "x " + game.kirby.getHp(), 100, 450);	// show HP
		font.draw(game.batch, "Score : " + game.kirby.getScore(), 440, 450);	// show score
		
		if(Gdx.input.isKeyJustPressed(Keys.D)){
			game.kirby.setHp(1);
		}
		
		game.batch.draw(Assets.hp, 40, 425);	// draw HP

		controller.processing();
		renderer.render();
		game.enemyController.processing();
		

		currentBgX -= game.kirby.getSpeed();	// run speed default = 4
		
		game.batch.end();		
		/**** End Render ****/

		/**** Frame rate ****/
		try {
			Thread.sleep((long)(1000/60-Gdx.graphics.getDeltaTime()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

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

}
