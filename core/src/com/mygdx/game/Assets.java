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
	public static Texture stone_5;
	public static Texture stone_6;
	
	public static Texture hp;
	
	public static Texture gameover;
	public static Texture candy;
	
	public static Animation2 kirbyRun;
	public static Animation2 kirbyDeath;
	public static Animation2 kirbyHurt;
	public static Animation2 kirbyJump;
	public static Animation2 kirbySpin;
	public static Animation2 kirbySlide;
	
	public static Animation2 bird;
	public static Animation2 phoenix;
	public static Animation2 nyanCat;
	
	public static Animation2 coin;
	public static Animation2 dust;
	public static Animation2 strawberry;
	
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
		stone_5 = loadTexture("Object/stone/Stone5.png");
		stone_6 = loadTexture("Object/stone/Stone6.png");
		
		hp = loadTexture("Object/HP/HP.png");
		
		gameover = loadTexture("BG/GameOverr.png");
		candy = loadTexture("Object/candy/candycane.png");
		
		
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
		
		kirbyHurt = new Animation2(0.2f,
				loadSprite("Object/character_hurt/Hurt1.png"),
				loadSprite("Object/character_hurt/Hurt1_Blur.png"),
				loadSprite("Object/character_hurt/Hurt2.png"),
				loadSprite("Object/character_hurt/Hurt2_Blur.png"),
				loadSprite("Object/character_hurt/Hurt3.png"),
				loadSprite("Object/character_hurt/Hurt3_Blur.png")
				);
		
		bird = new Animation2(0.1f,
				loadSprite("Object/bird/Twitter-bird1.png"),
				loadSprite("Object/bird/Twitter-bird2.png"),
				loadSprite("Object/bird/Twitter-bird3.png"),
				loadSprite("Object/bird/Twitter-bird4.png")
				);
		
		phoenix = new Animation2(0.1f,
				loadSprite("Object/phoenix/Phoenix1.png"),
				loadSprite("Object/phoenix/Phoenix2.png"),
				loadSprite("Object/phoenix/Phoenix3.png"),
				loadSprite("Object/phoenix/Phoenix4.png"),
				loadSprite("Object/phoenix/Phoenix5.png"),
				loadSprite("Object/phoenix/Phoenix6.png"),
				loadSprite("Object/phoenix/Phoenix7.png"),
				loadSprite("Object/phoenix/Phoenix8.png"),
				loadSprite("Object/phoenix/Phoenix9.png"),
				loadSprite("Object/phoenix/Phoenix10.png"),
				loadSprite("Object/phoenix/Phoenix11.png"),
				loadSprite("Object/phoenix/Phoenix12.png"),
				loadSprite("Object/phoenix/Phoenix13.png"),
				loadSprite("Object/phoenix/Phoenix14.png"),
				loadSprite("Object/phoenix/Phoenix15.png"),
				loadSprite("Object/phoenix/Phoenix16.png")
				);
		
		nyanCat = new Animation2(0.1f,
				loadSprite("Object/nyancat/NyanCat1.png"),
				loadSprite("Object/nyancat/NyanCat2.png"),
				loadSprite("Object/nyancat/NyanCat3.png"),
				loadSprite("Object/nyancat/NyanCat4.png"),
				loadSprite("Object/nyancat/NyanCat5.png"),
				loadSprite("Object/nyancat/NyanCat6.png")
				);
		
		coin = new Animation2(0.1f,
				loadSprite("Object/coin/Coin1.png"),
				loadSprite("Object/coin/Coin2.png"),
				loadSprite("Object/coin/Coin3.png"),
				loadSprite("Object/coin/Coin4.png"),
				loadSprite("Object/coin/Coin5.png"),
				loadSprite("Object/coin/Coin6.png"),
				loadSprite("Object/coin/Coin7.png")
				);
		
		dust = new Animation2(0.1f,
				loadSprite("Object/Dust/Dust1.png"),
				loadSprite("Object/Dust/Dust2.png"),
				loadSprite("Object/Dust/Dust3.png"),
				loadSprite("Object/Dust/Dust4.png"),
				loadSprite("Object/Dust/Dust5.png"),
				loadSprite("Object/Dust/Dust6.png")
				);
		
		strawberry = new Animation2(0.01f,
				loadSprite("Object/Strawberry/1.png"),
				loadSprite("Object/Strawberry/2.png"),
				loadSprite("Object/Strawberry/3.png"),
				loadSprite("Object/Strawberry/4.png"),
				loadSprite("Object/Strawberry/5.png"),
				loadSprite("Object/Strawberry/6.png"),
				loadSprite("Object/Strawberry/7.png"),
				loadSprite("Object/Strawberry/8.png"),
				loadSprite("Object/Strawberry/9.png"),
				loadSprite("Object/Strawberry/10.png"),
				loadSprite("Object/Strawberry/11.png"),
				loadSprite("Object/Strawberry/12.png"),
				loadSprite("Object/Strawberry/13.png"),
				loadSprite("Object/Strawberry/14.png"),
				loadSprite("Object/Strawberry/15.png"),
				loadSprite("Object/Strawberry/16.png"),
				loadSprite("Object/Strawberry/17.png"),
				loadSprite("Object/Strawberry/18.png"),
				loadSprite("Object/Strawberry/19.png"),
				loadSprite("Object/Strawberry/20.png"),
				loadSprite("Object/Strawberry/21.png"),
				loadSprite("Object/Strawberry/22.png"),
				loadSprite("Object/Strawberry/23.png"),
				loadSprite("Object/Strawberry/24.png"),
				loadSprite("Object/Strawberry/25.png"),
				loadSprite("Object/Strawberry/26.png")
				);
	}
}
