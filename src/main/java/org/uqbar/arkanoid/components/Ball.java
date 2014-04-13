package org.uqbar.arkanoid.components;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import org.uqbar.arkanoid.scene.ArkanoidScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;
import com.uqbar.vainilla.colissions.CollisionDetector;

public class Ball extends GameComponent<ArkanoidScene>{
	
	public final int radius = 10;
	private double speed = 150;
	private double i, j;
	
	public Ball(Color color) {
		this.setAppearance(new Circle(color,2*this.radius));
	}
	
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		double advanced = this.speed * deltaState.getDelta();

		if(this.collideWithBlock()){
			double angle = this.obtainAngle(this.obtainCollisionPoint());
			
			double x = Math.sin(angle);
			double y = Math.cos(angle);
			System.out.println("Sin x:" + x);
			
			double ySign = Math.signum(y);

			this.setI(x);

			System.out.println("I:" + this.getI());
			this.setJ( (y)* -1 * ySign);
			System.out.println("J:" + this.getJ());
			
			//this.setY(284);
			
		}
		this.move(this.i * advanced, this.j * advanced);
		this.checkRebound();
		super.update(deltaState);
	}
	
	public double obtainAngle(double x){
		
		double majorAngle = Math.PI/3;
		double minorAngle = Math.PI/3 * -1;
		
		return ((majorAngle - minorAngle)/this.getScene().getMovementBlock().getAppearance().getWidth()) * x + minorAngle;
	}
	
	public double obtainCollisionPoint(){
		double collisionPoint;
		if(this.getX()>=this.getScene().getMovementBlock().getX() 
				&& this.getX() + this.getAppearance().getWidth() < this.getScene().getMovementBlock().getX() + this.getScene().getMovementBlock().getAppearance().getWidth())
		{
			collisionPoint = this.getX() + this.radius - this.getScene().getMovementBlock().getX();
		}else if (this.getX() < this.getScene().getMovementBlock().getX()) {
			collisionPoint = 0;
		} else {
			collisionPoint = this.getScene().getMovementBlock().getAppearance().getWidth();
		}
		System.out.println(collisionPoint);
		return collisionPoint;
	}
	
	private boolean collideWithBlock() {
		return CollisionDetector
				.INSTANCE
					.collidesCircleAgainstRect(this.getX(),
											this.getY(),
											this.radius,
											this.getScene().getMovementBlock().getX(),
											this.getScene().getMovementBlock().getY(),
											this.getScene().getMovementBlock().getAppearance().getWidth(),
											this.getScene().getMovementBlock().getAppearance().getHeight());
	}
	
	private void checkRebound() {
		if(this.atBottonBorder()){
			this.j = this.j * -1;
			this.setY(this.getGame().getDisplayHeight()- this.radius * 2);
			//this.speed = this.speed +5;
			this.setAppearance(new Circle(Color.RED, this.radius *2));
		}else if (this.atTopBorder()){
			this.j = this.j * -1;
			this.setY(0);
		}else if (this.atLeftBorder()){
			this.i = this.i * -1;
			this.setX(0);
		}else if (this.atRightBorder()){
			this.i = this.i * -1;
			this.setX(this.getGame().getDisplayWidth() - this.radius * 2);
		}
	}

	private boolean atBottonBorder() {
		return  this.getGame().getDisplayHeight() <= this.obtainAbsoluteY();
	}

	private boolean atTopBorder() {
		return this.getY() <= 0;
	}
	
	private boolean atRightBorder() {
		return this.getGame().getDisplayWidth() <= this.obtainAbsoluteX();
	}
	private double obtainAbsoluteX() {
		return this.getX() + this.radius * 2;
	}

	private boolean atLeftBorder() {
		return this.getX() <= 0;
	}

	private double obtainAbsoluteY() {
		return this.getY() + this.radius * 2;
	}

	@Override
	public void onSceneActivated() {
		Random random = new Random();
		this.setX(random.nextInt(this.getGame().getDisplayWidth()));
		this.setY(random.nextInt(this.getGame().getDisplayHeight()));
		this.getVector(random);
		super.onSceneActivated();
	}

	private void getVector(Random random) {
		this.i = 2;//random.nextDouble() * 2 - 1;
		this.j = 1;//random.nextDouble() * 2 - 1;
		double m = Math.sqrt(this.i * this.i + this.j * this.j);
		this.i = this.i / m;
		this.j = this.j / m;
	}

	public double getI() {
		return i;
	}

	public void setI(double i) {
		this.i = i;
	}

	public double getJ() {
		return j;
	}

	public void setJ(double j) {
		this.j = j;
	}
}
