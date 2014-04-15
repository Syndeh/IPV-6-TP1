package org.uqbar.arkanoid.scene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;

public abstract class ArkanoidLevelScene extends GameScene {

	protected GameComponent livesCounter;
	protected GameComponent pointCounter;
	
	@Override
	public void onSetAsCurrent() {
		this.initializeComponents();
		super.onSetAsCurrent();
	}

	/**
	 * Ventana de ejecución para la inicialización de los componentes.
	 */
	protected void initializeComponents() {
//		this.initializeLivesCounter();
//		this.initializePointsCounter();
	}
	
}
