package org.uqbar.arkanoid.components;

import java.awt.Graphics2D;

import org.uqbar.arkanoid.components.strategies.MovementStrategy;
import org.uqbar.arkanoid.scene.ArkanoidScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public class Block extends GameComponent<ArkanoidScene> {

	private MovementStrategy<GameComponent<ArkanoidScene>> movementStrategy;
	
	
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
	}
	
	@Override
	public void update(DeltaState deltaState) {

	}

	protected MovementStrategy<GameComponent<ArkanoidScene>> getMovementStrategy() {
		return movementStrategy;
	}

	protected void setMovementStrategy(
			MovementStrategy<GameComponent<ArkanoidScene>> movementStrategy) {
		this.movementStrategy = movementStrategy;
	}
	
}
