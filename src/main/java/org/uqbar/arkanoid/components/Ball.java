package org.uqbar.arkanoid.components;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import org.uqbar.arkanoid.scene.ArkanoidScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;

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

		this.move(this.i * advanced, this.j * advanced);
		this.checkRebound();
		super.update(deltaState);
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
	
	public void goFaster(double x){
		this.setSpeed(this.getSpeed()+x);
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

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
