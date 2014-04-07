package org.uqbar.arkanoid.game;

import java.awt.Color;
import java.awt.Dimension;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.scene.ArkanoidScene;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;

public class Arkanoid extends Game {

	public static void main(String[] args) throws Exception {
		new DesktopGameLauncher(new Arkanoid()).launch();
	}

	@Override
	protected void initializeResources() {
	}

	@Override
	protected void setUpScenes() {
		ArkanoidScene scene = new ArkanoidScene();
		scene.setBall(new Ball(Color.BLUE));
		this.setCurrentScene(scene);
	}

	@Override
	public Dimension getDisplaySize() {
		return new Dimension(250, 400);
	}

	@Override
	public String getTitle() {
		return "Arkanoid";
	}

}
