package org.uqbar.arkanoid.components.strategies;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.Paddle;

import com.uqbar.vainilla.sound.SoundBuilder;

public class VariableAngleCollisionStrategy extends CollisionStrategy<Paddle> {

	public VariableAngleCollisionStrategy()
	{
		this.setSound(new SoundBuilder().buildSound("/sounds/impact.wav"));
	}
	
	@Override
	public void hit(Paddle block) {
		Ball ball = block.getScene().getBall();
		this.playSound();
		double collisionPoint = this.obtainCollisionPoint(block,ball);
		double angle = this.obtainAngle(block,collisionPoint);
		double x = Math.sin(angle);

		double y = Math.cos(angle);
		double ySign = Math.signum(y);
		ball.setI(x);
		ball.setJ( (y)* -1 * ySign);
		ball.goFaster(5);
		
	}
	


public double obtainAngle(Paddle block, double x){
		
		double majorAngle = Math.PI/3;
		double minorAngle = Math.PI/3 * -1;
		
		return ((majorAngle - minorAngle)/block.getAppearance().getWidth()) * x + minorAngle;
	}
	
	public double obtainCollisionPoint(Paddle block,Ball ball){
		double collisionPoint;
		if(ball.getX()>=block.getX() 
				&& ball.getX() + ball.getAppearance().getWidth() < block.getX() + block.getAppearance().getWidth())
		{
			collisionPoint = ball.getX() + ball.getRadius() - block.getX();
		}else if (ball.getX() < block.getX()) {
			collisionPoint = 0;
		} else {
			collisionPoint = block.getAppearance().getWidth();
		}
		return collisionPoint;
	}
}
