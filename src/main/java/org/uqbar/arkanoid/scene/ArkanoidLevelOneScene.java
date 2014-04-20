package org.uqbar.arkanoid.scene;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.Paddle;
import org.uqbar.arkanoid.components.StaticBlock;
import org.uqbar.arkanoid.components.strategies.AwardStaticBlockCollisionStrategy;

public class ArkanoidLevelOneScene extends ArkanoidLevelScene {
	
	@Override
	protected void initializeComponents() {
		this.addComponent(new StaticBlock(400, 30, -1, 0, 0));
		super.initializeComponents();
	}
	
	@Override
	protected void initializeBall() {
		this.setBall(new Ball());
		this.getBall().alignHorizontalCenterTo(this.getGame().getDisplayWidth()/2);
		this.getBall().alignBottomTo(this.getPaddleBlock().getY()-41);
		this.getBall().setSpeed(250);
		this.getBall().setAngle(-2.5);
		this.getBall().stop();
		this.addComponent(this.getBall());
	}
	
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
	}

	private void setRowOfBlocks(StaticBlock block) {
		this.addBlock(block);
		int priceCol = (int) (Math.random() * 7);
		for (int i = 0; i < 7; i++) {
			StaticBlock newBlock = new StaticBlock(block.getAppearance().getWidth(), block.getAppearance().getHeight(), block.getLife(),block.getX(),block.getY());
			newBlock.setX(block.getX() + block.getAppearance().getWidth());
			newBlock.setY(block.getY());
			if(i==priceCol)
			{
				newBlock.setCollisionStrategy(new AwardStaticBlockCollisionStrategy());
			}
			this.addBlock(newBlock);
			block = newBlock;
		}
	}
}