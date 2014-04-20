package org.uqbar.arkanoid.game;

import java.awt.Dimension;

import org.uqbar.arkanoid.scene.ArkanoidLevelOneScene;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;


public class Arkanoid extends Game {

	public static void main(String[] args) throws Exception {
		new DesktopGameLauncher(new Arkanoid()).launch();
	}

	@Override
	protected void setUpScenes() {
		ArkanoidLevelOneScene scene = new ArkanoidLevelOneScene();		
		this.setCurrentScene(scene);
	}

	@Override
	public Dimension getDisplaySize() {
		return new Dimension(400, 600);
	}

	@Override
	public String getTitle() {
		return "Arkanoid";
	}

	@Override
	protected void initializeResources() {
	}

}
