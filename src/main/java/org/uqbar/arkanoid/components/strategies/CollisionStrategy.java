package org.uqbar.arkanoid.components.strategies;

import org.uqbar.arkanoid.components.Block;

import com.uqbar.vainilla.sound.Sound;


public abstract class CollisionStrategy <T extends Block>{
	
	private Sound sound;
	
	protected void playSound() {
		this.sound.play(1);
	}
	
	public abstract void hit(T component);

	protected Sound getSound() {
		return sound;
	}

	protected void setSound(Sound sound) {
		this.sound = sound;
	}
	
}
