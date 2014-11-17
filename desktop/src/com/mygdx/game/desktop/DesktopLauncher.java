package com.mygdx.game.desktop;

import java.io.File;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.GameProject;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 640;
		config.height = 480;
		config.resizable= false;
		config.title = "Kirby Runner";
		config.addIcon("Object/icon/Kirbyball32x32.png",Files.FileType.Internal);
		new LwjglApplication(new GameProject(), config);
	}
}
