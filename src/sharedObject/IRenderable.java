package sharedObject;

import application.StateScene;
import javafx.scene.canvas.GraphicsContext;

public interface IRenderable {
	public int getZ();

	public boolean isVisible();

	public void setVisible(boolean b);

	public StateScene getState();

	public void draw(GraphicsContext gc);

}
