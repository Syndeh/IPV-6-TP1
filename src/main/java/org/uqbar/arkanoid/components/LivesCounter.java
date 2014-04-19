package org.uqbar.arkanoid.components;

import java.awt.Color;
import java.awt.Font;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Label;

public class LivesCounter extends GameComponent<GameScene> {
	
	private int lives;
	
	public LivesCounter() {
		this.lives = 3;
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.BOLD, 20), Color.BLACK, "Lives: " + this.getLives()));
	}

	@Override
	public void update(DeltaState deltaState) {
		this.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.BOLD, 20), Color.BLACK, "Lives: " + this.getLives()));
		super.update(deltaState);
	}

	public int getLives() {
		return lives;
	}
	
	public void addLife(){
		this.lives++;
	}
	
	public void removeLife() {
		this.lives--;
	}
	
}
