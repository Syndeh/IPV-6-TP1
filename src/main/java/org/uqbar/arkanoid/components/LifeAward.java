package org.uqbar.arkanoid.components;

import org.uqbar.arkanoid.scene.ArkanoidLevelScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;
import com.uqbar.vainilla.colissions.CollisionDetector;
import com.uqbar.vainilla.sound.SoundBuilder;

public class LifeAward extends GameComponent<ArkanoidLevelScene> {

	private double speed = 50;

	
	public LifeAward(){
		super(Sprite.fromImage("images/life.png").scale(0.5, 0.5),10,10);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		double advanced = this.getSpeed() * deltaState.getDelta();
		
		if(this.collideWithPaddle())
		{
			new SoundBuilder().buildSound("/sounds/life_up.wav").play(1);
			this.getScene().getLivesCounter().addLife();
			this.getScene().removeComponent(this);
		}else{
			this.move(0, advanced);
		}
		super.update(deltaState);
	}
	
	

	private boolean collideWithPaddle() {
		return CollisionDetector
				.INSTANCE
				.collidesCircleAgainstRect(this.getX(), 
										this.getY(), 
										this.getAppearance().getWidth()/2, 
										this.getScene().getPaddleBlock().getX(), 
										this.getScene().getPaddleBlock().getY(), 
										this.getScene().getPaddleBlock().getAppearance().getWidth(), 
										this.getScene().getPaddleBlock().getAppearance().getHeight());
	}

	private double getSpeed() {
		return speed;
	}


}
