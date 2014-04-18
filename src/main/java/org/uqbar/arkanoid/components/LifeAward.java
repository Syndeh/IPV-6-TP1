package org.uqbar.arkanoid.components;

import org.uqbar.arkanoid.scene.ArkanoidLevelScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

public class LifeAward extends GameComponent<ArkanoidLevelScene> {

	private double speed = 15;

	
	public LifeAward(){
		super(Sprite.fromImage("images/life.png").scale(0.5, 0.5),10,10);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		double advanced = this.getSpeed() * deltaState.getDelta();
		this.move(0, advanced);
		super.update(deltaState);
	}

	private double getSpeed() {
		return speed;
	}


}
