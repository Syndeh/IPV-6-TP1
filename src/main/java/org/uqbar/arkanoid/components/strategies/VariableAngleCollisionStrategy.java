package org.uqbar.arkanoid.components.strategies;

import org.uqbar.arkanoid.components.Block;

public class VariableAngleCollisionStrategy extends CollisionStrategy<Block> {

	@Override
	public void hit(Block block) {
		double collisionPoint = this.obtainCollisionPoint(block);
		System.out.println("Punto Colision: " + collisionPoint);
		double angle = this.obtainAngle(block,collisionPoint);
		double x = Math.sin(angle);
		System.out.println("Sin x:" + x);
		double y = Math.cos(angle);
		double ySign = Math.signum(y);
		block.getScene().getBall().setI(x);
		block.getScene().getBall().setJ( (y)* -1 * ySign);
		block.getScene().getBall().goFaster(5);
		
	}
	
public double obtainAngle(Block block, double x){
		
		double majorAngle = Math.PI/3;
		double minorAngle = Math.PI/3 * -1;
		
		return ((majorAngle - minorAngle)/block.getAppearance().getWidth()) * x + minorAngle;
	}
	
	public double obtainCollisionPoint(Block block){
		double collisionPoint;
		if(block.getScene().getBall().getX()>=block.getX() 
				&& block.getScene().getBall().getX() + block.getScene().getBall().getAppearance().getWidth() < block.getX() + block.getAppearance().getWidth())
		{
			collisionPoint = block.getScene().getBall().getX() + block.getScene().getBall().radius - block.getX();
		}else if (block.getScene().getBall().getX() < block.getX()) {
			collisionPoint = 0;
		} else {
			collisionPoint = block.getAppearance().getWidth();
		}
		return collisionPoint;
	}
}
