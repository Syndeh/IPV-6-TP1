package org.uqbar.arkanoid.components;

import java.awt.Color;

import org.uqbar.arkanoid.components.strategies.CollisionStrategy;
import org.uqbar.arkanoid.components.strategies.LateralMovementStrategy;
import org.uqbar.arkanoid.components.strategies.MovementStrategy;
import org.uqbar.arkanoid.components.strategies.VariableAngleCollisionStrategy;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Rectangle;

public class Paddle extends Block {

	private MovementStrategy<Paddle> movementStrategy;
	private CollisionStrategy<Paddle> collisionStrategy;
	private double speed = 100;
	
	public Paddle(int width, int height){
		this.setAppearance(new Rectangle(Color.RED, width, height));
		this.movementStrategy = new LateralMovementStrategy();
		this.collisionStrategy = new VariableAngleCollisionStrategy();
	}
	
	@Override
	public void update(DeltaState deltaState) {
		this.getMovementStrategy().move(this, deltaState);

		if(this.collideWith(this.getScene().getBall())){
			
			this.getCollisionStrategy().hit(this);
		}
	}
	
	public double obtainAbsoluteX() {
		return this.getX() + this.getAppearance().getWidth();
	}

	public double obtainAbsoluteY() {
		return this.getY() + this.getAppearance().getHeight();
	}

	protected MovementStrategy<Paddle> getMovementStrategy() {
		return this.movementStrategy;
	}

	protected void setMovementStrategy(
			MovementStrategy<Paddle> movementStrategy) {
		this.movementStrategy = movementStrategy;
	}

	public double getSpeed() {
		return this.speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public CollisionStrategy<Paddle> getCollisionStrategy() {
		return this.collisionStrategy;
	}

	public void setCollisionStrategy(CollisionStrategy<Paddle> collisionStrategy) {
		this.collisionStrategy = collisionStrategy;
	}
	
}
