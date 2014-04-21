package org.uqbar.arkanoid.appearences;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Rectangle;

public class RectangleWithBorder extends Rectangle {

	private Color color;
	
	public RectangleWithBorder(Color color, int width, int height) {
		super(color, width, height);
		this.setColor(color);

	}
	
	@Override
	public void render(GameComponent<?> component, Graphics2D graphics) {
		graphics.setColor(Color.WHITE);
		float thickness = 1;
		Stroke oldStroke = graphics.getStroke();
		graphics.setStroke(new BasicStroke(thickness,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER));
		graphics.drawRect((int) component.getX(), (int) component.getY()-1, (int)this.getWidth() , (int)this.getHeight() );
		graphics.setColor(this.getColor());
		graphics.setStroke(oldStroke);
		graphics.fillRect((int) component.getX(), (int) component.getY(), (int)this.getWidth()-1, (int)this.getHeight()-1);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Rectangle copy() {
		return new Rectangle(this.color,(int) this.getHeight(),(int) this.getWidth());
	}

	protected Color getColor() {
		return this.color;
	}

	protected void setColor(Color color) {
		this.color = color;
	}

}
