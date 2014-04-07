package org.uqbar.arkanoid.components;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import org.uqbar.arkanoid.scene.ArkanoidScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;

public class Ball extends GameComponent<ArkanoidScene>{
	
	private final int radius = 15;
	private double speed = 50;
	private double x, y;
	
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
		this.move(this.x * advanced, this.y * advanced);
		this.checkRebound();
		super.update(deltaState);
	}
	
	private void checkRebound() {
		if(this.atBorder(this.getY(), this.getY() + this.radius * 2, this.getGame().getDisplayHeight())){
			this.y = this.y * -1;
			this.speed = this.speed +5;
		}else if (this.atBorder(this.getX(), this.getX() + this.radius * 2, this.getGame().getDisplayWidth())){
			this.x = this.x * -1;
			this.speed = this.speed +5;
		}
	}

	private boolean atBorder(double botton, double top, double extreme) {
		return botton <= 0 || extreme <= top;
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
		this.x = random.nextDouble() * 2 - 1;
		this.y = random.nextDouble() * 2 - 1;
		double m = Math.sqrt(this.x * this.x + this.y * this.y);
		this.x = this.x / m;
		this.y = this.y / m;
	}
}
