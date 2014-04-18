package org.uqbar.arkanoid.components;

import java.awt.Color;
import java.awt.Graphics2D;

import org.uqbar.arkanoid.scene.ArkanoidLevelScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;

public class Ball extends GameComponent<ArkanoidLevelScene>{
	
	private int radius = 10;
	private double speed = 150;
	private double i, j;
	private boolean isStopped = false;
	
	public Ball(Color color) {
		this.setAppearance(new Circle(color,2*this.radius));
	}
	
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		if(!this.isStopped())
		{
			double advanced = this.speed * deltaState.getDelta();
	
			this.move(this.i * advanced, this.j * advanced);
			this.checkRebound();
		}
		super.update(deltaState);
	}
	
	
	private void checkRebound() {
		if(this.atBottomBorder()){
			this.j = this.j * -1;
			this.setY(this.getGame().getDisplayHeight()- this.radius * 2);
			this.setAppearance(new Circle(Color.RED, this.radius *2));
			this.getScene().loseLife();
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

	private boolean atBottomBorder() {
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
	
	public void goFaster(double x){
		this.setSpeed(this.getSpeed()+x);
	}
	
	public void stop(){
		this.setStopped(true);
	}
	
	public void start(){
		this.setStopped(false);
	}
	
	public void setAngle(double pi) {
		this.setI(Math.cos(Math.PI * pi));
//		System.out.println(this.getI());
		this.setJ(Math.sin(Math.PI * pi));
//		System.out.println(this.getJ());
	}
	
	public int getCenterX(){
		return (int)this.getX() + this.getRadius();
	}
	
	public int getCenterY(){
		return (int)this.getY() + this.getRadius();
	}

	public double getI() {
		return this.i;
	}

	public void setI(double i) {
		this.i = i;
	}

	public double getJ() {
		return this.j;
	}

	public void setJ(double j) {
		this.j = j;
	}

	public double getSpeed() {
		return this.speed;
	}

	public int getRadius() {
		return this.radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public boolean isStopped() {
		return isStopped;
	}

	public void setStopped(boolean isStopped) {
		this.isStopped = isStopped;
	}
}
