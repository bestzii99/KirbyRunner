package com.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;
import com.game.controller.GameInputProcessing;
import com.game.controller.GameRender;
import com.game.object.EnemyBox;
import com.game.object.Kirby;
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
	EnemyBox box;
	public static float stateTime = 0f;
	Texture bg_1;
	Texture bg_2;
	
	
	public GameScreen(GameProject game){
		this.game = game;
		game.kirby = new Kirby();
		renderer = new GameRender(game);
		controller = new GameInputProcessing(game);
		box = new EnemyBox();
		
		currentBgX = width;
		lastTimeBg = TimeUtils.nanoTime();
		bg_1 = Assets.bg_game_1;
		bg_2 = Assets.bg_game_1;
		new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(1000);
						cntTime += 1;
						System.out.println(cntTime);
						
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
		
		controller.processing();	
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
			
			
			
//			fadeTime -= 0.1f;
			isChange = true;
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
		}else{
			fadeTime = 0f;
		}
		
//		EnemyBox box;
		

		game.batch.draw(bg_1, currentBgX-width, 0, width, height);
		game.batch.draw(bg_1, currentBgX, 0, width, height);
		game.batch.draw(Assets.stone_1,box.getPosition().x, box.getPosition().y,50,45);
		renderer.render();
		
		game.batch.end();
		
		box.setPosition(box.getPosition().x-2, box.getPosition().y);
		box.setBounds(box.getPosition().x, box.getPosition().y, box.getWidth(), box.getHeight());
		if(game.kirby.getBounds().overlaps(box.getBounds())){
			System.out.println("Overlap!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		
	
		// move the separator each 1s
//		if(TimeUtils.nanoTime() - lastTimeBg > 100000000){
			// move the separator 50px
//			currentBgX -= 2;
			// set the current time to lastTimeBg
//			lastTimeBg = TimeUtils.nanoTime();
//		}

		// if the seprator reaches the screen edge, move it back to the first position
//		currentBgX -= 2;
//		if(currentBgX == -1200+760){
//			currentBgX = width;
//		}
		currentBgX -= 2;
		if(currentBgX == 0){
			currentBgX = width;
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
