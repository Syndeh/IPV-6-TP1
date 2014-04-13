package org.uqbar.arkanoid.components.strategies;

import org.uqbar.arkanoid.components.Block;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.events.constants.Key;

public class LateralMovementStrategy extends MovementStrategy<Block> {

	@Override
	public void move(Block block, DeltaState deltaState) {
		
		double advanced = block.getSpeed() * deltaState.getDelta();
		if(deltaState.isKeyBeingHold(Key.RIGHT)){
			if(!this.atRightBorder(block))
			{
				block.move(advanced,0);
			}
		}
		if(deltaState.isKeyBeingHold(Key.LEFT)){
			if(!this.atLeftBorder(block))
			{
				block.move(-1*advanced,0);
			}
		}
	}

}
