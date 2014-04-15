package org.uqbar.arkanoid.components;

import java.awt.Color;
import java.awt.Font;

import org.uqbar.arkanoid.scene.ArkanoidLevelScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Label;

public class SpeedMeter extends GameComponent<ArkanoidLevelScene> {
	
	private int lives;
	
	public SpeedMeter() {
		this.lives = 3;
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.ITALIC, 15), Color.DARK_GRAY, "Speed: " + 0 + " px/s"));
	}

	@Override
	public void update(DeltaState deltaState) {
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.ITALIC, 15), Color.DARK_GRAY, "Speed: " + this.getScene().getBall().getSpeed() + " px/s"));
		super.update(deltaState);
	}

	public int getLives() {
		return lives;
	}
	
	public void removeLife() {
		this.lives--;
	}
	
}
