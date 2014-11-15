package com.game.object;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeSet;


public class Kirby extends ObjectBase {
	
	private int hp = 5;
	private int speed = 4;
	private int gravity = 7;
	private int state = 1;
	private int score = 0;
//	private int hignScore;
	private boolean isAction = false;
	private boolean isAction2 = false;
	private boolean isActionJump1 = false;
	private boolean isActionJump2 = false;
	public static final int STATE_RUN = 1;
	public static final int STATE_DEATH = 2;
	public static final int STATE_HURT = 3;
	public static final int STATE_JUMP = 4;
	public static final int STATE_SPIN = 5;
	
	
	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	public Kirby(){
		super();
		setPosition(100, 105);
		setWidth(50);
		setHeight(50);
		setBounds(getPosition().x, getPosition().y, getWidth(), getHeight());
	}
	
	public int getHp(){
		return hp;
	}
	
	public float getSpeed(){
		return speed;
	}
	
	public void setState(int state){
		this.state = state;
	}
	
	public int getState(){
		return state;
	}

	public boolean isAction() {
		// TODO Auto-generated method stub
		return isAction;
	}
	
	public void setAction_HurtJump(boolean action){ // check bug hurt and jump
		this.isAction = action;
	}

	public boolean isAction2() {
		// TODO Auto-generated method stub
		return isAction2;
	}
	public void setAction_SpinJump(boolean action){	// check bug spin and jump
		this.isAction2 = action;
	}
	
	public boolean isActionJump1(){
		return isActionJump1;
	}
	
	public boolean isActionJump2(){
		return isActionJump2;
	}
	
	public void setActionJump1(boolean isActionJump){
		this.isActionJump1 = isActionJump;
	}
	
	public void setActionJump2(boolean isActionJump){
		this.isActionJump2 = isActionJump;
	}

	public int getScore() {
		return score;
	}

	public void setScore(float f) {
		this.score += f;
	}



	public int HighScore(int hignScore) throws IOException {
		TreeSet<Integer> score = new TreeSet<Integer>();
		
//		File outFile = new File("HighScore.txt");
//		FileWriter fileWriter = new FileWriter(outFile);
//		BufferedWriter bufWriter = new BufferedWriter(fileWriter);
//		
//		String content = getScore()+"";
//		System.out.println(content);
//		bufWriter.write(content); 
//		bufWriter.newLine(); 
//		bufWriter.close();
		
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("HighScore.txt", true)))) {
		    out.println(getScore());
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
		}
		
		File inFile = new File("HighScore.txt");
		FileReader fileReader = new FileReader(inFile); 
		BufferedReader bufReader = new BufferedReader(fileReader); 
		String line; 
		while ((line = bufReader.readLine()) != null){
			score.add(Integer.parseInt(line));
		}
		bufReader.close(); //close
		
		return (Integer) score.last();
		
		
		
		
		
	}
	

}
