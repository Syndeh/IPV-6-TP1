package org.uqbar.arkanoid.components.strategies;

import org.uqbar.arkanoid.components.LifeAward;
import org.uqbar.arkanoid.components.StaticBlock;

public class AwardStaticBlockCollisionStrategy extends
		StaticBlockCollisionStrategy {
	
	public AwardStaticBlockCollisionStrategy()
	{
		super();
	}
	@Override
	public void hit(StaticBlock block) {
		if(block.getLife()==1)
		{
			LifeAward award = new LifeAward();
			award.setX(block.getX());
			award.setY(block.getY());
			block.getScene().addLifeAward(award);
		}
		super.hit(block);

	}

	
}
