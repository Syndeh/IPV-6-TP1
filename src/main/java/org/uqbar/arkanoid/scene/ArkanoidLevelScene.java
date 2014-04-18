package org.uqbar.arkanoid.scene;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.arkanoid.components.Ball;
import org.uqbar.arkanoid.components.LivesCounter;
import org.uqbar.arkanoid.components.Paddle;
import org.uqbar.arkanoid.components.PointsCounter;
import org.uqbar.arkanoid.components.SpeedMeter;
import org.uqbar.arkanoid.components.StaticBlock;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;

public abstract class ArkanoidLevelScene extends GameScene {

	
	private LivesCounter livesCounter;
	private PointsCounter pointCounter;
	private SpeedMeter speedMeter;
	
	private Ball ball;
	private Paddle paddleBlock;
	private final List<StaticBlock> staticBlocks = new ArrayList<StaticBlock>();

	
	@Override
	public void onSetAsCurrent() {
		this.initializeComponents();
		super.onSetAsCurrent();
	}

	/**
	 * Ventana de ejecución para la inicialización de los componentes.
	 */
	protected void initializeComponents() {
		this.initializePaddleBlock();
		this.initializeBall();
		this.initializeBlocks();
		this.initializePointsCounter();
		this.initializeLivesCounter();
		this.initializeSpeedMeter();
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

	protected LivesCounter getLivesCounter() {
		return this.livesCounter;
	}

	protected void setLivesCounter(LivesCounter livesCounter) {
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
		this.initializeBall();
		this.initializePaddleBlock();
	}

	protected SpeedMeter getSpeedMeter() {
		return this.speedMeter;
	}

	protected void setSpeedMeter(SpeedMeter speedMeter) {
		this.speedMeter = speedMeter;
	}

	protected void addBlock(StaticBlock block) {
		this.staticBlocks.add(block);
		this.addComponent(block);
	}

	@Override
	public void removeComponent(GameComponent<?> component) {
		this.staticBlocks.remove(component);
		component.destroy();
		if(this.staticBlocks.isEmpty()) {
			this.resetComponents();
			this.getGame().setCurrentScene(new ArkanoidGameOverScene());
		}
		super.removeComponent(component);
	}
}
