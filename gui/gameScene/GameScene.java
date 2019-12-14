package gameScene;

import application.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.LogicGame;
import playerDisplay.AssetShow;
import sharedObject.IRenderableHolder;

public class GameScene extends Scene {

	private BoardPane board;
	private BorderPane pane;

	public GameScene(Parent root) throws CheckException {
		super(root);
		resetGame();
		BackgroundImage img = new BackgroundImage(IRenderableHolder.woodenBg, BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane.setBackground(new Background(img));
	}

	private void resetGame() throws CheckException {
		// TODO Auto-generated method stub
		try {

			/////////////////////////////////////////
			// init Game screen in 3 section 1assetShow 2board 3assetShow//
			pane = (BorderPane) getRoot();
			board = new BoardPane();
			pane.setCenter(board);
			/////////////////////////////////////

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

	public void setUpPlayer() {
		BorderPane h1 = new BorderPane();
		h1.setTop(new AssetShow(LogicGame.getPlayers().get(0)));
		h1.setBottom(new AssetShow(LogicGame.getPlayers().get(0)));
		BorderPane h2 = new BorderPane();
		h2.setTop(new AssetShow(LogicGame.getPlayers().get(0)));
		h2.setBottom(new AssetShow(LogicGame.getPlayers().get(0)));

		h1.setBorder(new Border(
				new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		h2.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		pane.setLeft(h1);
		pane.setRight(h2);

	}

}
