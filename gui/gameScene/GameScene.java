package gameScene;

import application.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class GameScene extends Scene {

	public GameScene(Parent root) throws CheckException {
		super(root, Main.displayX, Main.displayY);
		resetGame();
	}

	private void resetGame() throws CheckException {
		// TODO Auto-generated method stub
		try {
			BoardPane board = new BoardPane();
			BorderPane root = (BorderPane) getRoot();
			root.setCenter(board);
		} catch (Exception e) {
			throw new CheckException("Please create BorderPane for root in GameScene");
		}

	}
}
