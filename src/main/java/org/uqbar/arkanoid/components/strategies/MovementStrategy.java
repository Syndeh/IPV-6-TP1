package org.uqbar.arkanoid.components.strategies;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public abstract class MovementStrategy<GameComponentType extends GameComponent<?>> {

	public abstract void move(GameComponentType gameComponent, DeltaState deltaState);
	
}
