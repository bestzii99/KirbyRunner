package com.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.game.controller.MainMenuController;
import com.mygdx.game.Animation2;
import com.mygdx.game.Assets;
import com.mygdx.game.GameProject;

public class MainMenuScreen extends ScreenBase {
	GameProject game;
	MainMenuController controller;
	Texture bg_1;
	Texture bg_2;
	
	public Rectangle startGame;
	public Rectangle gameName;
	public Rectangle highScore;
	public Rectangle exit;
	public Rectangle howToPlay;
	private float stateTime;
	float currentBgX;
	
	int width = 1200;
	int height = 570;
	boolean isChange = false;
	int cntTime = 0;
	
	public MainMenuScreen(final GameProject game){
		this.game = game;
		
		bg_1 = bg_2 = Assets.bg_game_1;
		currentBgX = width;
		
		new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(1000);
						cntTime++;
					}catch (InterruptedException e) {}
				}
			}
		}.start();
		
		controller = new MainMenuController(game, this);
		
		/**
		 * create button
		 */
		gameName 	= new Rectangle(220, 20, 200, 70); 
		startGame	= new Rectangle(220, 180, 200, 50);
		howToPlay 	= new Rectangle(220, 260, 200, 50);
		highScore 	= new Rectangle(220, 400, 200, 50);
		exit 		= new Rectangle(540, 400, 200, 50);		
	}

	@Override
	public void render(float delta) {
		TextureRegion keyFrame = null;
		stateTime += Gdx.graphics.getDeltaTime();
		
//		System.out.println(Gdx.input.getX()+ ", " +Gdx.input.getY());
		System.out.println(Gdx.input.getX()+ ", " +(480-(Gdx.input.getY()))); 		// x,y texture
		
		game.batch.begin();
		
		/**** Draw Background****/ 
		game.batch.draw(bg_1, currentBgX-width, 0, width, height);
		game.batch.draw(bg_1, currentBgX, 0, width, height);
		
		/*** create button ***/
		game.batch.draw(Assets.logo, 213, 325/*, 200, 70*/);						// label 1, Project Name			
		game.batch.draw(Assets.play_button_up, 170, 250);					// label 2, Play			
		game.batch.draw(Assets.howTo_button_up, 170, 170);					// label 3, How To Play				
		game.batch.draw(Assets.highScore_button_up, 170, 25);				// label 4 High Score
		game.batch.draw(Assets.exit_button_up, 540, 35, 50, 50);			// label 4.1 Exit
		
		keyFrame = Assets.kirbyRun.getKeyFrame(stateTime, Animation2.ANIMATION_LOOPING);
		game.batch.draw(keyFrame, 320-30, 100);
		
		fade(); // fade in-out screen background and infinite loop background
		
		/****  Check Infinite Loop Background ****/
		if(currentBgX == 0)currentBgX = width;
		currentBgX -= 4;	// run speed default = 4
		
		controller.update();
		game.batch.end();	// batch end	
	
		frameRate();
	}
	
	public void frameRate(){
		/**
		 *  Frame rate
		 */
		try {
			Thread.sleep((long)(1000/60-Gdx.graphics.getDeltaTime()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	
	public void fade(){
		/**
		 *  fade in-out screen background and infinite loop background
		 */
		
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
	}

}
