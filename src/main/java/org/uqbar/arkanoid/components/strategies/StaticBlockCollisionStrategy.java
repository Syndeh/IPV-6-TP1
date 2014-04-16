package org.uqbar.arkanoid.components.strategies;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.StaticBlock;

public class StaticBlockCollisionStrategy extends CollisionStrategy<StaticBlock> {

	@Override
	public void hit(StaticBlock block) {
		Ball ball = block.getScene().getBall();
		if(this.atBottomBorder()){
			ball.setJ(ball.getJ() * -1);
			ball.setY(block.getAbsoluteBottom());
		}else if (this.atTopBorder()){
			ball.setJ(ball.getJ() * -1);
			ball.setY(block.getY() - ball.getRadius() * 2);
		}else if (this.atLeftBorder()){
			ball.setI(ball.getI() * -1);
			ball.setX(block.getX() - ball.getRadius() * 2);
		}else if (this.atRightBorder()){
			ball.setI(ball.getI() * -1);
			ball.setX(block.getAbsoluteRightSide());
		}
		block.reduceLife();
	}

	private boolean atLeftBorder() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean atRightBorder() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean atTopBorder() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean atBottomBorder() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
