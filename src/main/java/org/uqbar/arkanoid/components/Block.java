package org.uqbar.arkanoid.components;

import java.awt.Graphics2D;

import org.uqbar.arkanoid.components.strategies.MovementStrategy;
import org.uqbar.arkanoid.scene.ArkanoidScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public class Block extends GameComponent<ArkanoidScene> {

	private MovementStrategy<GameComponent<ArkanoidScene>> movementStrategy;
	private double speed = 50;
	
	
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		this.getMovementStrategy().move(this, deltaState);
		super.update(deltaState);
	}

	protected MovementStrategy<GameComponent<ArkanoidScene>> getMovementStrategy() {
		return movementStrategy;
	}

	protected void setMovementStrategy(
			MovementStrategy<GameComponent<ArkanoidScene>> movementStrategy) {
		this.movementStrategy = movementStrategy;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
