package org.uqbar.arkanoid.components;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.uqbar.arkanoid.components.strategies.CollisionStrategy;
import org.uqbar.arkanoid.components.strategies.StaticBlockCollisionStrategy;
import org.uqbar.arkanoid.utils.TetrisSpriteSheetHelper;

import com.uqbar.vainilla.DeltaState;

public class StaticBlock extends Block {
	
	private CollisionStrategy<StaticBlock> collisionStrategy;
	private int life;
	private final Map<Integer,Color> mapColors;
	private boolean isInCollision = false;

	public StaticBlock(double width, double height,int life, double x, double y) {
		this.life = life;
		this.mapColors = this.generateMapsColors();
		this.collisionStrategy = new StaticBlockCollisionStrategy();
		this.setX(x);
		this.setY(y);
		this.setWidth(width);
		this.setHeight(height);
		this.determineAppearance();
	}
	
	private void determineAppearance() {
		this.setAppearance(TetrisSpriteSheetHelper.getLargeBlock(this.determineColor()).scaleTo(this.getWidth(), this.getHeight()));
	}

	private Map<Integer, Color> generateMapsColors() {
		Map<Integer, Color> map = new HashMap<Integer,Color>();
		map.put(1,Color.GREEN);
		map.put(2,Color.CYAN);
		map.put(3,Color.BLUE);
		map.put(4,Color.YELLOW);
		map.put(5,Color.RED);
		return map;
	}

	@Override
	public void update(DeltaState deltaState) {
		if(this.collideWith(this.getScene().getBall()) && !this.isInCollision()){
			this.setInCollision(true);
			this.getCollisionStrategy().hit(this);
			this.setInCollision(false);
		}
		super.update(deltaState);
	}
	
	public double getAbsoluteBottom() {
		return this.getY() + this.getAppearance().getHeight();
	}
	

	public double getAbsoluteRightSide() {
		return this.getX() + this.getAppearance().getWidth();
	}
	
	private Color determineColor() {
		if(this.mapColors.containsKey(this.getLife())){
			return this.mapColors.get(this.getLife());
		}else{
			return Color.GRAY;
		}
	}

	public boolean atBottomBorder(int centerX, int centerY) {
		return 
//				centerX > this.getX() && 
//				centerX < this.getAbsoluteRightSide() && 
				centerY > this.getAbsoluteBottom(); 
	}

	public boolean atTopBorder(int centerX, int centerY) {
		return 
//				centerX > this.getX() &&
//				centerX < this.getAbsoluteRightSide() &&
				centerY < this.getY(); 
	}

	public boolean atLeftBorder(int centerX, int centerY) {
		return 
				centerY > this.getY() && 
				centerY < this.getAbsoluteBottom() && 
				centerX < this.getX();
//				&&
//				!this.atBottomBorder(centerX, centerY) &&
//				!this.atTopBorder(centerX, centerY);
	}

	public boolean atRightBorder(int centerX, int centerY) {
		return 
				centerY > this.getY() && 
				centerY < this.getAbsoluteBottom() && 
				centerX > this.getAbsoluteRightSide();
//				&&
//				!this.atBottomBorder(centerX, centerY) &&
//				!this.atTopBorder(centerX, centerY); 
	}
	
	public CollisionStrategy<StaticBlock> getCollisionStrategy() {
		return this.collisionStrategy;
	}

	public void setCollisionStrategy(
			CollisionStrategy<StaticBlock> collisionStrategy) {
		this.collisionStrategy = collisionStrategy;
	}

	public void reduceLife() {
		this.life--;
		if(this.getLife() == 0){
			this.getScene().removeComponent(this);
		}else if (this.getLife() > 0 ){
			this.determineAppearance();
			this.getScene().addPoint();                   
		}
	}

	public int getLife() {
		return this.life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public boolean isInCollision() {
		return this.isInCollision;
	}

	public void setInCollision(boolean isInCollision) {
		this.isInCollision = isInCollision;
	}
}
