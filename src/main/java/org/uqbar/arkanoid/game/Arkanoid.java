package org.uqbar.arkanoid.game;

import java.awt.Color;
import java.awt.Dimension;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.Block;
import org.uqbar.arkanoid.components.strategies.LateralMovementStrategy;
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
		scene.setMovementBlock(this.BuildMovementBlock());
		this.setCurrentScene(scene);
	}

	private Block BuildMovementBlock() {
		Block movementBlock = new Block((double)(100-15), (double)(500-15), 50, 10, new LateralMovementStrategy());
		return movementBlock;
	}

	@Override
	public Dimension getDisplaySize() {
		return new Dimension(200, 500);
	}

	@Override
	public String getTitle() {
		return "Arkanoid";
	}

}
