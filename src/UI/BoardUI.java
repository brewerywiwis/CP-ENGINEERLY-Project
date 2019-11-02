package UI;

import application.Game;
import javafx.scene.canvas.GraphicsContext;

public class BoardUI {

	private int startX = Game.borderX, startY = Game.borderY;
	private GraphicsContext gc = Game.getGc();

	public BoardUI() {
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
