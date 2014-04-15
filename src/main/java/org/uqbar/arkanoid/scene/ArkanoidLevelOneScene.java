package org.uqbar.arkanoid.scene;

import java.awt.Color;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.Block;
import org.uqbar.arkanoid.components.strategies.LateralMovementStrategy;
import org.uqbar.arkanoid.components.strategies.VariableAngleCollisionStrategy;

public class ArkanoidLevelOneScene extends ArkanoidLevelScene {
	
	/**
	 * Color: Green
	 */
	protected void initializeBall() {
		this.setBall(new Ball(Color.GREEN));
		this.getBall().alignHorizontalCenterTo(this.getGame().getDisplayWidth()/2);
		this.getBall().alignBottomTo(this.getPaddleBlock().getY()-100);
		this.getBall().setSpeed(250);
		this.getBall().setAngle(1.5);
		this.addComponent(this.getBall());
	}
	
	/**
	 * Color: Red
	 * Speed: 250
	 * Width: Display Width / 4
	 * Height: 10
	 * InitialX: (DisplayWidth / 2) - (Width / 2)
	 * InitialY: DisplayHeight - Height - 5
	 */
	protected void initializePaddleBlock() {
		
		int paddleWidth = this.getGame().getDisplayWidth()/4;
		int paddleHeight = 10;
		int initialX = this.getGame().getDisplayWidth() / 2 - paddleWidth / 2;
		int initialY = this.getGame().getDisplayHeight() - paddleHeight - 20;
		
		Block paddleBlock = new Block(paddleWidth, paddleHeight, new LateralMovementStrategy());
		paddleBlock.setX(initialX);
		paddleBlock.setY(initialY);
		paddleBlock.setSpeed(250);
		paddleBlock.setCollisionStrategy(new VariableAngleCollisionStrategy());
		
		this.setPaddleBlock(paddleBlock);
		this.addComponent(paddleBlock);
	}

	@Override
	protected void initializeBlocks() {
		// TODO Auto-generated method stub
	}
}