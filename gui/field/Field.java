package field;

import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import logic.Actionable;

public abstract class Field extends BorderPane implements Actionable {

	protected Actionable actionable;
	protected Color color;

	public abstract void eventAction();

	public void doAction() {
		eventAction();
	}

	public Actionable getActionable() {
		return actionable;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	};

}
