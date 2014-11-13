package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	
	public static Texture bg_game_1;
	public static Texture bg_game_2;
	public static Texture bg_game_3;
	public static Texture bg_game_4;
	public static Texture bg_game_5;
	public static Texture bg_game_6;
	public static Texture bg_game_7;
	public static Texture bg_game_8;
	
	public static Texture stone_1;
	public static Texture stone_2;
	public static Texture stone_3;
	public static Texture stone_4;
	
	public static Animation2 kirbyRun;
	public static Animation2 kirbyDeath;
	public static Animation2 kirbyHurt;
	public static Animation2 kirbyJump;
	public static Animation2 kirbySpin;
	public static Animation2 kirbySlide;

	
	public static TextureRegion loadSprite(String file){
		return new TextureRegion(new Texture(Gdx.files.internal(file)));
	}
	
	public static Texture loadTexture(String file){
		return new Texture(file);
	}
	
	public static void load(){
		bg_game_1 = loadTexture("BG/1_Morning.png");
		bg_game_2 = loadTexture("BG/2_Late_Morning.png");
		bg_game_3 = loadTexture("BG/3_Afternoon.png");
		bg_game_4 = loadTexture("BG/4_Late_Afternoon.png");
		bg_game_5 = loadTexture("BG/5_Evening.png");
		bg_game_6 = loadTexture("BG/6_Late_Evening.png");
		bg_game_7 = loadTexture("BG/7_Night.png");
		bg_game_8 = loadTexture("BG/8_Late_Night.png");
		
		stone_1 = loadTexture("Object/stone/Stone1.png");
		stone_2 = loadTexture("Object/stone/Stone2.png");
		stone_3 = loadTexture("Object/stone/Stone3.png");
		stone_4 = loadTexture("Object/stone/Stone4.png");
		
		
		
		kirbyRun = new Animation2(0.07f,
			loadSprite("Object/character_walk/Walk1.png"),
			loadSprite("Object/character_walk/Walk2.png"),
			loadSprite("Object/character_walk/Walk3.png"),
			loadSprite("Object/character_walk/Walk4.png"),
			loadSprite("Object/character_walk/Walk5.png"),
			loadSprite("Object/character_walk/Walk6.png"),
			loadSprite("Object/character_walk/Walk7.png"),
			loadSprite("Object/character_walk/Walk8.png"),
			loadSprite("Object/character_walk/Walk9.png"),
			loadSprite("Object/character_walk/Walk10.png")
			);
		
		kirbyJump = new Animation2(0.03f,
			loadSprite("Object/character_jump/Jump1.png"),
			loadSprite("Object/character_jump/Jump2.png"),
			loadSprite("Object/character_jump/Jump3.png"),
			loadSprite("Object/character_jump/Jump4.png"),
			loadSprite("Object/character_jump/Jump5.png"),
			loadSprite("Object/character_jump/Jump6.png"),
			loadSprite("Object/character_jump/Jump7.png"),
			loadSprite("Object/character_jump/Jump8.png")			
			);
		
		kirbySpin = new Animation2(0.1f,
			loadSprite("Object/character_spin/Spin1.png"),
			loadSprite("Object/character_spin/Spin2.png"),
			loadSprite("Object/character_spin/Spin3.png"),
			loadSprite("Object/character_spin/Spin4.png"),
			loadSprite("Object/character_spin/Spin5.png"),
			loadSprite("Object/character_spin/Spin6.png"),
			loadSprite("Object/character_spin/Spin7.png"),
			loadSprite("Object/character_spin/Spin8.png")		
			);
		
		kirbyHurt = new Animation2(0.3f,
				loadSprite("Object/character_hurt/Hurt1.png"),
				loadSprite("Object/character_hurt/Hurt1_Blur.png"),
				loadSprite("Object/character_hurt/Hurt2.png"),
				loadSprite("Object/character_hurt/Hurt2_Blur.png"),
				loadSprite("Object/character_hurt/Hurt3.png"),
				loadSprite("Object/character_hurt/Hurt3_Blur.png")
		);
		

	}
}
