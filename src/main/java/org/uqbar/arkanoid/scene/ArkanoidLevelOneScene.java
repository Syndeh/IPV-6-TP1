package org.uqbar.arkanoid.scene;

import java.awt.Color;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.Paddle;
import org.uqbar.arkanoid.components.StaticBlock;
import org.uqbar.arkanoid.components.strategies.AwardStaticBlockCollisionStrategy;

public class ArkanoidLevelOneScene extends ArkanoidLevelScene {
	
	/**
	 * Color: Green
	 */
	@Override
	protected void initializeBall() {
		this.setBall(new Ball(Color.GREEN));
		this.getBall().alignHorizontalCenterTo(this.getGame().getDisplayWidth()/2);
		this.getBall().alignBottomTo(this.getPaddleBlock().getY()-41);
		this.getBall().setSpeed(250);
		this.getBall().setAngle(-2.5);
		this.getBall().stop();
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
		int paddleHeight = 20;
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
		this.addComponent(new StaticBlock(400, 30, -1, 0, 0));
		this.setRowOfBlocks(new StaticBlock(50, 20, 4, 0, 100));
		this.setRowOfBlocks(new StaticBlock(50, 20, 3, 0, 150));
		this.setRowOfBlocks(new StaticBlock(50, 20, 2, 0, 200));
//		this.addBlock(new StaticBlock(10, 400, 5, 390, 30));
	}

	private void setRowOfBlocks(StaticBlock block) {
		this.addBlock(block);
		for (int i = 0; i < 7; i++) {
			StaticBlock newBlock = new StaticBlock(block.getAppearance().getWidth(), block.getAppearance().getHeight(), block.getLife(),block.getX(),block.getY());
			newBlock.setX(block.getX() + block.getAppearance().getWidth());
			newBlock.setY(block.getY());
			if(i==1)
			{
				newBlock.setCollisionStrategy(new AwardStaticBlockCollisionStrategy());
			}
			this.addBlock(newBlock);
			block = newBlock;
		}
	}
}