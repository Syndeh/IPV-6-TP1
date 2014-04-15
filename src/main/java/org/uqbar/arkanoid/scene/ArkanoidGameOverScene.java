package org.uqbar.arkanoid.scene;

import java.awt.Color;
import java.awt.Font;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Label;

public class ArkanoidGameOverScene extends GameScene {
	
	@Override
	public void onSetAsCurrent() {
		this.initializeComponents();
		super.onSetAsCurrent();
	}

	/**
	 * Ventana de ejecución para la inicialización de los componentes.
	 */
	protected void initializeComponents() {
		GameComponent<ArkanoidGameOverScene> label = new GameComponent<ArkanoidGameOverScene>();
		label.setAppearance(new Label(new Font(Font.SANS_SERIF, Font.BOLD, 30), Color.RED, "Game Over! :("));
		label.alignHorizontalCenterTo(this.getGame().getDisplayWidth()/2);
		label.alignVerticalCenterTo(this.getGame().getDisplayHeight()/2);
		this.addComponent(label);
	}
		
}
