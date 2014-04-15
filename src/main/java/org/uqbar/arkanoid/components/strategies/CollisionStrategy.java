package org.uqbar.arkanoid.components.strategies;

import org.uqbar.arkanoid.components.Block;

public abstract class CollisionStrategy <T extends Block>{
	
	public abstract void hit(T component);
	
}
