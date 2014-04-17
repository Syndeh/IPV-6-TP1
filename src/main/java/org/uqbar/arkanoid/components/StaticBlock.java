package org.uqbar.arkanoid.components;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.uqbar.arkanoid.components.strategies.CollisionStrategy;
import org.uqbar.arkanoid.components.strategies.StaticBlockCollisionStrategy;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.appearances.Rectangle;

public class StaticBlock extends Block {
	
	private CollisionStrategy<StaticBlock> collisionStrategy;
	private int life;
	private final Map<Integer,Color> mapColors;

	public StaticBlock(double width, double height,int life) {
		this.life = life;
		this.mapColors = this.generateMapsColors();
		this.collisionStrategy = new StaticBlockCollisionStrategy();
		this.setAppearance(new Rectangle(this.determineColor(), (int)width, (int)height));
	}
	
	private Map<Integer, Color> generateMapsColors() {
		Map<Integer, Color> map = new HashMap<Integer,Color>();
		map.put(1,Color.ORANGE);
		map.put(2,Color.MAGENTA);
		map.put(3,Color.BLUE);
		map.put(4,Color.YELLOW);
		map.put(5,Color.PINK);
		return map;
	}

	@Override
	public void update(DeltaState deltaState) {
		if(this.collideWith(this.getScene().getBall())){
			this.getCollisionStrategy().hit(this);
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
			return Color.BLACK;
		}
	}

	public boolean atBottomBorder(int centerX, int centerY) {
		return centerX > this.getX() && centerX < this.getAbsoluteRightSide() && centerY > this.getAbsoluteBottom(); 
	}

	public boolean atTopBorder(int centerX, int centerY) {
		return centerX > this.getX() && centerX < this.getAbsoluteRightSide() && centerY < this.getY(); 
	}

	public boolean atLeftBorder(int centerX, int centerY) {
		return centerY > this.getY() && centerY < this.getAbsoluteBottom() && centerX > this.getAbsoluteRightSide(); 
	}

	public boolean atRightBorder(int centerX, int centerY) {
		return centerY > this.getY() && centerY < this.getAbsoluteBottom() && centerX < this.getX(); 
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
		this.getScene().addPoint();
		if(this.getLife()<0){
			this.getScene().removeComponent(this);
		}else{
			this.setAppearance(new Rectangle(this.determineColor(), (int)this.getAppearance().getWidth(), (int)this.getAppearance().getHeight()));
		}
	}

	public int getLife() {
		return this.life;
	}

	public void setLife(int life) {
		this.life = life;
	}
}
