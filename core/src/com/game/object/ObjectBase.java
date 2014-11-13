package com.game.object;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
 
public abstract class ObjectBase {
	private Vector2 position;
	private Rectangle bounds;
	private static int width;
	private static int height;
	private int id;
	public ObjectBase(){
		position = new Vector2();
		bounds = new Rectangle();
	}
	
	public static int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setPosition(float x, float y){
		position.set(x, y);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void setBounds(float x, float y, int width, int height){
		bounds.set(x, y, width, height);
	}
	
	public Rectangle getBounds(){
		return bounds;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
}
