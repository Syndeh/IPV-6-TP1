package org.uqbar.arkanoid.components;

import java.awt.Color;

import org.uqbar.arkanoid.scene.ArkanoidLevelScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Circle;

import com.uqbar.vainilla.events.constants.Key;

public class Sight extends GameComponent<ArkanoidLevelScene> {

	private double speed=400;
	private double rotation = -1 *Math.PI/18;
	private int direction  = -1;
	
	public Sight(){
		this.setAppearance(new Circle(Color.RED, 4));
		
		
	}
	
	@Override
	public void update(DeltaState deltaState) {
		System.out.println("UPDATE");
		double advanced = this.speed * deltaState.getDelta();
		this.calcRotation(advanced/100);
		this.setX(this.getScene().getPaddleBlock().obtainXCenter() + Math.cos(this.rotation)*50 -2 );
		this.setY(this.getScene().getPaddleBlock().getY() + Math.sin(this.rotation)*50);

		if(deltaState.isKeyPressed(Key.SPACE)){
			
			this.getScene().getBall().setI(Math.cos(this.rotation));
			this.getScene().getBall().setJ(Math.sin(this.rotation));
			this.getScene().getBall().start();
			this.destroy();
		}
		
		super.update(deltaState);
	}

	private void calcRotation(double advanced) {
		if(this.direction==-1)
		{
			if(this.rotation>= (-17 * (Math.PI/18)))
			{
				this.rotation-=advanced;
			}else{
				this.direction=1;
			}
		}else{
			if(this.rotation<= (-1 * (Math.PI/18)))
			{
				this.rotation+=advanced;
			}else{
				this.direction=-1;
			}
		}
		
		
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
