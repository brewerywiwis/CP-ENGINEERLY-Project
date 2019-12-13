package gameScene;

import application.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class GameScene extends Scene {

	private BoardPane board;
	private BorderPane pane;

	public GameScene(Parent root) throws CheckException {
		super(root, Main.displayX, Main.displayY);
		board = new BoardPane();
		resetGame();
	}

	private void resetGame() throws CheckException {
		// TODO Auto-generated method stub
		try {
			BorderPane root = (BorderPane) getRoot();
			root.setCenter(board);
			pane = root;
		} catch (Exception e) {
			throw new CheckException("Please create BorderPane for root in GameScene");
		}
	}

	public BoardPane getBoard() {
		return board;
	}

	public BorderPane getPane() {
		return pane;
	}
}
