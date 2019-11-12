package gameScene;

import application.Game;
import application.StateScene;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;

public class BoardUI implements IRenderable {

	private int startX = Game.borderX, startY = Game.borderY;
	private boolean visible;
	private final StateScene state = StateScene.GAMESCENE;

	public BoardUI() {
		visible = true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 998;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return visible;
	}

	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		visible = b;
	}

	@Override
	public StateScene getState() {
		return state;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		int distanceY = Game.displayY - 2 * startY;
		int distanceX = Game.displayX - 2 * startX;
		for (int i = 0; i < 2; i++) {
			gc.fillRect(startX, startY + i * distanceY / 7, distanceX + 2, 2);
			gc.fillRect(startX + i * distanceX / 7, startY, 2, distanceY + 2);
		}
		for (int i = 1; i < 6; i++) {
			gc.fillRect(startX, startY + i * distanceY / 7, distanceX / 7, 2);
			gc.fillRect(Game.displayX - startX - distanceX / 7, startY + i * distanceY / 7, distanceX / 7, 2);
		}
		for (int i = 1; i < 6; i++) {
			gc.fillRect(startX + i * distanceX / 7, startY, 2, distanceY / 7);
			gc.fillRect(startX + i * distanceX / 7, Game.displayY - startY - distanceY / 7, 2, distanceY / 7);
		}
		for (int i = 0; i < 2; i++) {
			gc.fillRect(startX, Game.displayY - startY - i * distanceY / 7, distanceX + 2, 2);
			gc.fillRect(Game.displayX - startX - i * distanceX / 7, startY, 2, distanceY + 2);
		}
	}


}
