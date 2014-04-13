package org.uqbar.arkanoid.components;

import java.awt.Color;
import java.awt.Graphics2D;

import org.uqbar.arkanoid.components.strategies.MovementStrategy;
import org.uqbar.arkanoid.scene.ArkanoidScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Rectangle;

public class Block extends GameComponent<ArkanoidScene> {

	private MovementStrategy<Block> movementStrategy;
	private double speed = 100;
	
	public Block(double initialX, double initialY, int width, int height, MovementStrategy<Block> movementStrategy){
		super(new Rectangle(Color.RED, width, height),initialX,initialY);
		this.setMovementStrategy(movementStrategy);
	}
	
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		this.getMovementStrategy().move(this, deltaState);
		super.update(deltaState);
	}
	
	@Override
	public void onSceneActivated() {
		super.onSceneActivated();
	}
	
	public double obtainAbsoluteX() {
		return this.getX() + this.getAppearance().getWidth();
	}

	public double obtainAbsoluteY() {
		return this.getY() + this.getAppearance().getHeight();
	}

	protected MovementStrategy<Block> getMovementStrategy() {
		return movementStrategy;
	}

	protected void setMovementStrategy(
			MovementStrategy<Block> movementStrategy) {
		this.movementStrategy = movementStrategy;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
