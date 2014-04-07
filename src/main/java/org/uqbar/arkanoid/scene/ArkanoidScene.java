package org.uqbar.arkanoid.scene;

import org.uqbar.arkanoid.components.Ball;

import com.uqbar.vainilla.GameScene;

public class ArkanoidScene extends GameScene {

	private Ball ball;

	public Ball getBall() {
		return this.ball;
	}

	public void setBall(Ball b) {
		this.ball = b;
		this.addComponent(b);
	}
}