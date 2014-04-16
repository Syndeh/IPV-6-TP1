package org.uqbar.arkanoid.components;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.uqbar.arkanoid.components.strategies.CollisionStrategy;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.appearances.Rectangle;

public class StaticBlock extends Block {
	
	private CollisionStrategy<StaticBlock> collisionStrategy;
	private int life;
	private final Map<Integer,Color> mapColors;

	public StaticBlock(int width, int height,Color color,int life) {
		this.life = life;
		this.mapColors = this.generateMapsColors();
		this.setAppearance(new Rectangle(color, width, height));
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
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
	@Override
	public void alignLeftTo(double x) {
		// TODO Auto-generated method stub
		super.alignLeftTo(x);
	}

	@Override
	public void alignRightTo(double x) {
		// TODO Auto-generated method stub
		super.alignRightTo(x);
	}

	@Override
	public void alignCloserBoundTo(GameComponent<?> target) {
		// TODO Auto-generated method stub
		super.alignCloserBoundTo(target);
	}

	@Override
	public void setAppearance(Appearance appearance) {
		// TODO Auto-generated method stub
		super.setAppearance(appearance);
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
		this.setAppearance(new Rectangle(this.determineColor(), (int)this.getAppearance().getWidth(), (int)this.getAppearance().getHeight()));
		//TODO destroy
	}

	public int getLife() {
		return this.life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	private Color determineColor() {
		if(this.getLife() <0 || this.getLife() > 5){
			return Color.BLACK;
		}else{
			return this.mapColors.get(this.getLife());
		}
	}
}
