package org.uqbar.arkanoid.scene;

import java.awt.Color;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.Block;
import org.uqbar.arkanoid.components.strategies.LateralMovementStrategy;
import org.uqbar.arkanoid.components.strategies.VariableAngleCollisionStrategy;

public class ArkanoidLevelOneScene extends ArkanoidLevelScene {

	private Ball ball;
	private Block paddleBlock;

	@Override
	protected void initializeComponents() {
		this.initializeBall();	
		this.initializePaddleBlock();
	}
	
	private void initializeBall() {
		this.setBall(new Ball(Color.GREEN));
		this.addComponent(this.getBall());
	}
	
	private void initializePaddleBlock() {
		Block paddleBlock = new Block((double)(this.getGame().getDisplayWidth()/2-15), (double)(this.getGame().getDisplayHeight()-20), this.getGame().getDisplayWidth()/4, 10, new LateralMovementStrategy());
		paddleBlock.setSpeed(250);
		paddleBlock.setCollisionStrategy(new VariableAngleCollisionStrategy());
		this.setPaddleBlock(paddleBlock);
		this.addComponent(paddleBlock);
	}
	
	public Ball getBall() {
		return this.ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
		this.addComponent(ball);
	}

	public Block getPaddleBlock() {
		return paddleBlock;
	}

	public void setPaddleBlock(Block paddleBlock) {
		this.paddleBlock = paddleBlock;
		this.addComponent(this.paddleBlock);
	}
}