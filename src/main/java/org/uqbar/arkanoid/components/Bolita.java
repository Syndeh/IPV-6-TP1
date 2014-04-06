package org.uqbar.arkanoid.components;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import org.uqbar.arkanoid.scene.Pantalla;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;

public class Bolita extends GameComponent<Pantalla>{
	
	private final int radius = 30;
	private final double speed = 30;
	private double i, j;
	
	public Bolita(Color color) {
		this.setAppearance(new Circle(color, 2 * this.radius));
	}
	
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		double advanced = this.speed * deltaState.getDelta();
		this.move(this.i * advanced, this.j * advanced);
		super.update(deltaState);
		this.fijarseRebote();
	}
	
	private void fijarseRebote() {
		if(this.enBorde(this.getY() + this.radius,0) || 
		   this.enBorde(this.getY() + this.radius, this.getAppearance().getHeight())){
			this.i = this.i * -1;
		}else if (this.enBorde(this.getX() + this.radius,this.getAppearance().getWidth()) || 
				  this.enBorde(this.getX() + this.radius, 0 )){
			this.j = this.j * -1;
		}
	}

	private boolean enBorde(double a, double b) {
		return this.radius/2 > Math.abs( a- b);
	}

	@Override
	public void onSceneActivated() {
		Random random = new Random();
		this.setX(random.nextDouble() * this.getGame().getDisplayWidth());
		this.setY(random.nextDouble() * this.getGame().getDisplayHeight());
		this.i = random.nextDouble() * 2 - 1;
		this.j = random.nextDouble() * 2 - 1;

		double m = Math.sqrt(this.i * this.i + this.j * this.j);

		this.i = this.i / m;
		this.j = this.j / m;

		super.onSceneActivated();
	}
}
