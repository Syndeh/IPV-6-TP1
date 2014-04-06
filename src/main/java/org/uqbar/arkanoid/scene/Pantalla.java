package org.uqbar.arkanoid.scene;

import org.uqbar.arkanoid.components.Bolita;

import com.uqbar.vainilla.GameScene;

public class Pantalla extends GameScene {

	private Bolita bolita;

	public Bolita getBolita() {
		return this.bolita;
	}

	public void setBolita(Bolita b) {
		this.bolita = b;
		this.addComponent(b);
	}
}