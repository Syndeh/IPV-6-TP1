package org.uqbar.arkanoid.scene;

import org.uqbar.arkanoid.components.PointsCounter;
import org.uqbar.arkanoid.components.ScreenMessage;

import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.sound.SoundBuilder;

public class ArkanoidWinnerScene extends GameScene {
	
	public ArkanoidWinnerScene(PointsCounter pointCounter) {
		this.addComponent(pointCounter);
	}

	@Override
	public void onSetAsCurrent() {
		this.initializeComponents();
		super.onSetAsCurrent();
	}

	/**
	 * Ventana de ejecución para la inicialización de los componentes.
	 */
	protected void initializeComponents() {
		this.addComponent(new ScreenMessage("Ganaste!"));
		new SoundBuilder().buildSound("/sounds/stage_clear.wav").play(1);
	}
	
}
