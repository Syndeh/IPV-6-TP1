package org.uqbar.arkanoid.components.strategies;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.StaticBlock;

import com.uqbar.vainilla.sound.SoundBuilder;

public class StaticBlockCollisionStrategy extends CollisionStrategy<StaticBlock> {

	
	public StaticBlockCollisionStrategy(){
		this.setSound(new SoundBuilder().buildSound("/sounds/blop.wav"));
	}
	
	@Override
	public void hit(StaticBlock block) {
		Ball ball = block.getScene().getBall();
		this.playSound();
		if(block.atBottomBorder(ball.getCenterX(),ball.getCenterY())){
			ball.inverseHorizontalDirection();
			ball.setY(block.getAbsoluteBottom());
		}else if (block.atTopBorder(ball.getCenterX(),ball.getCenterY())){
			ball.inverseHorizontalDirection();
			ball.setY(block.getY() - ball.getRadius() * 2);
		}else if (block.atLeftBorder(ball.getCenterX(),ball.getCenterY())){
			ball.inverseVerticalDirection();
			ball.setX(block.getX() - ball.getRadius() * 2);
		}else if (block.atRightBorder(ball.getCenterX(),ball.getCenterY())){
			ball.inverseVerticalDirection();
			ball.setX(block.getAbsoluteRightSide());
		}else{
			ball.inverseVerticalDirection();
			ball.setY(block.getAbsoluteBottom());
		}
		block.reduceLife();
	}
}
