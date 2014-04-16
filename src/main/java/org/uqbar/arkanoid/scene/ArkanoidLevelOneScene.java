package org.uqbar.arkanoid.scene;

import java.awt.Color;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.Paddle;

public class ArkanoidLevelOneScene extends ArkanoidLevelScene {
	
	/**
	 * Color: Green
	 */
	@Override
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
	@Override
	protected void initializePaddleBlock() {
		
		int paddleWidth = this.getGame().getDisplayWidth()/4;
		int paddleHeight = 10;
		int initialX = this.getGame().getDisplayWidth() / 2 - paddleWidth / 2;
		int initialY = this.getGame().getDisplayHeight() - paddleHeight - 20;
		
		Paddle paddleBlock = new Paddle(paddleWidth, paddleHeight);
		paddleBlock.setX(initialX);
		paddleBlock.setY(initialY);
		paddleBlock.setSpeed(250);
		
		this.setPaddleBlock(paddleBlock);
		this.addComponent(paddleBlock);
	}

	@Override
	protected void initializeBlocks() {
		// TODO Auto-generated method stub
	}
}