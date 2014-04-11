package org.uqbar.arkanoid.components.strategies;

import com.uqbar.vainilla.GameComponent;

public abstract class MovementStrategy<GameComponentType extends GameComponent<?>> {

	public abstract void move(GameComponentType gameComponent, double xDirection, double yDirection, double advance);
	
	
}
