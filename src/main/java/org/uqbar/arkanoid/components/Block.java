package org.uqbar.arkanoid.components;

import org.uqbar.arkanoid.scene.ArkanoidLevelScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.colissions.CollisionDetector;

public abstract class Block extends GameComponent<ArkanoidLevelScene> {

	protected boolean collideWith(Ball ball) {
		return CollisionDetector
				.INSTANCE
					.collidesCircleAgainstRect(ball.getX(),
											ball.getY(),
											ball.getRadius(),
											this.getX(),
											this.getY(),
											this.getAppearance().getWidth(),
											this.getAppearance().getHeight());
	}
}
