package org.uqbar.arkanoid.scene;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.Paddle;

import com.uqbar.vainilla.GameScene;

public class ArkanoidScene extends GameScene {

	private Ball ball;
	private Paddle movementBlock;

	public Ball getBall() {
		return this.ball;
	}

	public void setBall(Ball b) {
		this.ball = b;
		this.addComponent(b);
	}

	public Paddle getMovementBlock() {
		return movementBlock;
	}

	public void setMovementBlock(Paddle movementBlock) {
		this.movementBlock = movementBlock;
		this.addComponent(movementBlock);
	}
}