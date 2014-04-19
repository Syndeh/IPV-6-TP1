package org.uqbar.arkanoid.scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.LifeAward;
import org.uqbar.arkanoid.components.LivesCounter;
import org.uqbar.arkanoid.components.Paddle;
import org.uqbar.arkanoid.components.PointsCounter;
import org.uqbar.arkanoid.components.SpeedMeter;
import org.uqbar.arkanoid.components.StaticBlock;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Rectangle;

public abstract class ArkanoidLevelScene extends GameScene {

	
	private LivesCounter livesCounter;
	private PointsCounter pointCounter;
	private SpeedMeter speedMeter;
		
	private Ball ball;
	private Paddle paddleBlock;
	
	private List<LifeAward> lifeAwards = new ArrayList<LifeAward>();
	
	private final List<StaticBlock> blocks = new ArrayList<StaticBlock>();
	
	@Override
	public void onSetAsCurrent() {
		this.initializeComponents();
		super.onSetAsCurrent();
	}

	/**
	 * Ventana de ejecución para la inicialización de los componentes.
	 */
	protected void initializeComponents() {
		this.initializeBackground();
		this.initializePaddleBlock();
		this.initializeBall();
		this.initializeBlocks();
		this.initializePointsCounter();
		this.initializeLivesCounter();
		this.initializeSpeedMeter();
	}

	private void initializeBackground() {
		GameComponent<GameScene> background = new GameComponent<GameScene>(new Rectangle(Color.BLACK, this.getGame().getDisplayWidth(), this.getGame().getDisplayHeight()),0 ,0);
		this.addComponent(background);
	}

	protected abstract void initializePaddleBlock();
	
	protected abstract void initializeBall();
	
	protected abstract void initializeBlocks();

	private void initializePointsCounter() {
		this.setPointCounter(new PointsCounter());
		this.getPointCounter().alignHorizontalCenterTo(this.getGame().getDisplayWidth()/2);
		this.getPointCounter().setY(5);
		this.addComponent(this.getPointCounter());
	}
	
	private void initializeLivesCounter() {
		this.setLivesCounter(new LivesCounter());
		this.getLivesCounter().setX(5);
		this.getLivesCounter().setY(5);
		this.addComponent(this.getLivesCounter());
	}
	
	private void initializeSpeedMeter() {
		this.setSpeedMeter(new SpeedMeter());
		this.getSpeedMeter().setX(5);
		this.getSpeedMeter().setY(this.getGame().getDisplayHeight() - 20);
		this.addComponent(this.getSpeedMeter());
	}

	public Ball getBall() {
		return this.ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
		this.addComponent(ball);
	}

	public Paddle getPaddleBlock() {
		return this.paddleBlock;
	}

	public void setPaddleBlock(Paddle paddleBlock) {
		this.paddleBlock = paddleBlock;
		this.addComponent(this.paddleBlock);
	}
	
	protected PointsCounter getPointCounter() {
		return this.pointCounter;
	}

	protected void setPointCounter(PointsCounter pointCounter) {
		this.pointCounter = pointCounter;
	}
	
	public void addPoint() {
		this.getPointCounter().addPoint();
	}
	
	public void addPoints(int points) {
		this.getPointCounter().addPoints(points);
	}

	public LivesCounter getLivesCounter() {
		return this.livesCounter;
	}

	public void setLivesCounter(LivesCounter livesCounter) {
		this.livesCounter = livesCounter;
	}
	
	public void loseLife() {
		if (this.getLivesCounter().getLives() > 0) {
			this.getLivesCounter().removeLife();
			this.resetComponents();
		} else {
			this.getBall().destroy();
			this.getGame().setCurrentScene(new ArkanoidGameOverScene());
		}
	}

	protected void resetComponents() {
		this.getPaddleBlock().destroy();
		this.getBall().destroy();
		
		for (LifeAward lifeAward : this.getLifeAwards()) {
			lifeAward.destroy();
		}
		
		this.initializePaddleBlock();
		this.initializeBall();
	}

	protected SpeedMeter getSpeedMeter() {
		return this.speedMeter;
	}

	protected void setSpeedMeter(SpeedMeter speedMeter) {
		this.speedMeter = speedMeter;
	}

	protected void addBlock(StaticBlock block) {
		this.blocks.add(block);
		this.addComponent(block);
	}
	
	public void removeBlock(StaticBlock block) {
		this.blocks.remove(block);
		block.destroy();
		super.removeComponent(block);
		this.checkLevelPassed();
	}
	
	public void addLifeAward(LifeAward lifeAward){
		this.getLifeAwards().add(lifeAward);
		this.addComponent(lifeAward);
	}

	protected List<LifeAward> getLifeAwards() {
		return lifeAwards;
	}

	protected void setLifeAwards(List<LifeAward> lifeAwards) {
		this.lifeAwards = lifeAwards;
	}
	
	public void checkLevelPassed() {
		if( blocks.isEmpty() ) {
			// Ganaste!
			this.getBall().destroy();
			this.getGame().setCurrentScene(new ArkanoidWinnerScene());
		}
	}
}
