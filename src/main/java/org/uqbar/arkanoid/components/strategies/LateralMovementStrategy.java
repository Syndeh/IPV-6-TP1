package org.uqbar.arkanoid.components.strategies;

import org.uqbar.arkanoid.components.Paddle;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.Key;

public class LateralMovementStrategy extends MovementStrategy<Paddle> {

	@Override
	public void move(Paddle block, DeltaState deltaState) {
		
		double advanced = block.getSpeed() * deltaState.getDelta();
		if(deltaState.isKeyBeingHold(Key.RIGHT)){
			if(!this.atRightBorder(block))
			{
				block.move(advanced,0);
			}
			if(block.getScene().getBall().isStopped()){
			}
		}
		if(deltaState.isKeyBeingHold(Key.LEFT)){
			if(!this.atLeftBorder(block))
			{
				block.move(-1*advanced,0);
			}
		}
		if(block.getScene().getBall().isStopped())
		{
			block.getScene().getBall().setX(block.obtainXCenter() - block.getScene().getBall().getRadius());
			if(deltaState.isKeyPressed(Key.SPACE))
			{
				block.getScene().getBall().start();
			}
		}
	}

}
