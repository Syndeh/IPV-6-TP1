package org.uqbar.arkanoid.components.strategies;

import com.uqbar.vainilla.DeltaState;
import org.uqbar.arkanoid.components.Block;

public abstract class MovementStrategy<T extends Block> {

	public abstract void move(T gameComponent, DeltaState deltaState);
	
	protected boolean atRightBorder(T gameComponent) {
		return gameComponent.obtainAbsoluteX()>=gameComponent.getGame().getDisplayWidth() ;
	}
	
	protected boolean atLeftBorder(T gameComponent) {
		return gameComponent.getX() <= 0;
	}
	
}
