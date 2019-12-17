package gameScene;

import java.util.ArrayList;
import field.AssetShow;
import field.InGameMenu;
import field.LogDisplay;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import logic.LogicGame;
import sharedObject.SharedObjectHolder;

public class GameScene extends Scene {

	private BoardPane board;
	private BorderPane pane;
	private BorderPane bLeft;
	private BorderPane bRight;
	private ArrayList<AssetShow> assetShows;
	private InGameMenu inGameMenu;
	private LogDisplay logDisplay;

	public GameScene(Parent root) throws CheckException {
		super(root);
		resetGame();
		BackgroundImage img = new BackgroundImage(SharedObjectHolder.woodenBg, BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane.setBackground(new Background(img));
		bLeft = new BorderPane();
		bRight = new BorderPane();

		try {
			StackPane sRoot = (StackPane) getRoot();
			sRoot.getChildren().add(pane);
		} catch (Exception e) {
			throw new CheckException("Please create StackPane for root in GameScene");
		}

	}

	private void resetGame() throws CheckException {
		// TODO Auto-generated method stub
		pane = new BorderPane();
		board = new BoardPane();
		pane.setCenter(board);
	}

	public void setUpAssetShow() {
		assetShows = new ArrayList<AssetShow>();
		for (int i = 0; i < LogicGame.getPlayers().size(); i++) {
			assetShows.add(new AssetShow(LogicGame.getPlayers().get(i)));
			if (i == 0) {
				bLeft.setTop(assetShows.get(i));
			} else if (i == 1) {
				bRight.setTop(assetShows.get(i));
			} else if (i == 2) {
				bLeft.setBottom(assetShows.get(i));
			} else if (i == 3) {
				bRight.setBottom(assetShows.get(i));
			}
		}
		pane.setLeft(bLeft);
		pane.setRight(bRight);
	}

	public void setUpUserControl() {
		inGameMenu = new InGameMenu();
		inGameMenu.setAlignment(Pos.CENTER);
		bLeft.setCenter(inGameMenu);
	}

	public void setUpLogDisplay() {
		logDisplay = new LogDisplay();
		bRight.setCenter(logDisplay);
	}

	public void update() {
		for (int i = 0; i < assetShows.size(); i++) {
			assetShows.get(i).update();
		}
	}

	public BoardPane getBoard() {
		return board;
	}

	public BorderPane getPane() {
		return pane;
	}

	public LogDisplay getLogDisplay() {
		return logDisplay;
	}

	public ArrayList<AssetShow> getAssetShows() {
		return assetShows;
	}
}
