package org.uqbar.arkanoid.components;

import java.awt.Color;
import java.awt.Graphics2D;

import org.uqbar.arkanoid.components.strategies.MovementStrategy;
import org.uqbar.arkanoid.scene.ArkanoidScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.colissions.CollisionDetector;

public class Block extends GameComponent<ArkanoidScene> {

	private MovementStrategy<Block> movementStrategy;
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
			System.out.println("colisiono");
			double angle = this.obtainAngle(this.obtainCollisionPoint());
			double x = Math.sin(angle);
			double y = Math.cos(angle);
			double ySign = Math.signum(y);
			this.getScene().getBall().setI(x);
			this.getScene().getBall().setJ( (y)* -1 * ySign);
			this.getScene().getBall().goFaster(20);
		}
		super.update(deltaState);
	}
	
	
	public double obtainAngle(double x){
		
		double majorAngle = Math.PI/3;
		double minorAngle = Math.PI/3 * -1;
		
		return ((majorAngle - minorAngle)/this.getAppearance().getWidth()) * x + minorAngle;
	}
	
	public double obtainCollisionPoint(){
		double collisionPoint;
		if(this.getScene().getBall().getX()>=this.getX() 
				&& this.getScene().getBall().getX() + this.getScene().getBall().getAppearance().getWidth() < this.getX() + this.getAppearance().getWidth())
		{
			collisionPoint = this.getX() + this.getScene().getBall().radius - this.getX();
		}else if (this.getScene().getBall().getX() < this.getX()) {
			collisionPoint = 0;
		} else {
			collisionPoint = this.getAppearance().getWidth();
		}
		return collisionPoint;
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
	
}
