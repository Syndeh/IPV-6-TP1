package org.uqbar.arkanoid.components.strategies;

import com.uqbar.vainilla.DeltaState;
import org.uqbar.arkanoid.components.Paddle;

public abstract class MovementStrategy<T extends Paddle> {

	public abstract void move(T gameComponent, DeltaState deltaState);
	
	protected boolean atRightBorder(T gameComponent) {
		return gameComponent.obtainAbsoluteX()>=gameComponent.getGame().getDisplayWidth() ;
	}
	
	protected boolean atLeftBorder(T gameComponent) {
		return gameComponent.getX() <= 0;
	}
	
}
