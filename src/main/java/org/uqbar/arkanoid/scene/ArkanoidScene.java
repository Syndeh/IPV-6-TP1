package org.uqbar.arkanoid.scene;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.Block;

import com.uqbar.vainilla.GameScene;

public class ArkanoidScene extends GameScene {

	private Ball ball;
	private Block movementBlock;

	public Ball getBall() {
		return this.ball;
	}

	public void setBall(Ball b) {
		this.ball = b;
		this.addComponent(b);
	}

	public Block getMovementBlock() {
		return movementBlock;
	}

	public void setMovementBlock(Block movementBlock) {
		this.movementBlock = movementBlock;
		this.addComponent(movementBlock);
	}
}