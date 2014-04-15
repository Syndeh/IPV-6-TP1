package org.uqbar.arkanoid.components;

import java.awt.Color;
import java.awt.Graphics2D;

import org.uqbar.arkanoid.components.strategies.CollisionStrategy;
import org.uqbar.arkanoid.components.strategies.MovementStrategy;
import org.uqbar.arkanoid.scene.ArkanoidScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.colissions.CollisionDetector;

public class Block extends GameComponent<ArkanoidScene> {

	private MovementStrategy<Block> movementStrategy;
	private CollisionStrategy<Block> collisionStrategy;
	private double speed = 100;
	private int life=1;
	
	
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

		if(this.collideWithBall()){
			this.getCollisionStrategy().hit(this);
		}
		super.update(deltaState);
	}
	
	
	
	
	private boolean collideWithBall() {
		return CollisionDetector
				.INSTANCE
					.collidesCircleAgainstRect(this.getScene().getBall().getX(),
											this.getScene().getBall().getY(),
											this.getScene().getBall().radius,
											this.getX(),
											this.getY(),
											this.getAppearance().getWidth(),
											this.getAppearance().getHeight());
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

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public CollisionStrategy<Block> getCollisionStrategy() {
		return collisionStrategy;
	}

	public void setCollisionStrategy(CollisionStrategy<Block> collisionStrategy) {
		this.collisionStrategy = collisionStrategy;
	}
	
}
