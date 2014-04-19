package org.uqbar.arkanoid.components;

import org.uqbar.arkanoid.scene.ArkanoidLevelScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.colissions.CollisionDetector;

public abstract class Block extends GameComponent<ArkanoidLevelScene> {

	private double width;
	private double height;
	
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
	
	public double obtainXCenter()
	{
		return this.getX() + this.getAppearance().getWidth() / 2;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
