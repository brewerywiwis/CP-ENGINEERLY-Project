package gameScene;

import java.util.ArrayList;

import field.AssetShow;
import field.ControlField;
import field.LogDisplay;
import javafx.geometry.Pos;
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
import javafx.scene.paint.Color;
import logic.LogicGame;
import sharedObject.IRenderableHolder;

public class GameScene extends Scene {

	private BoardPane board;
	private BorderPane pane;
	private BorderPane bLeft;
	private BorderPane bRight;
	private ArrayList<AssetShow> assetShows;
	private ControlField controlField;
	private LogDisplay logDisplay;

	public GameScene(Parent root) throws CheckException {
		super(root);
		resetGame();
		BackgroundImage img = new BackgroundImage(IRenderableHolder.woodenBg, BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane.setBackground(new Background(img));
		bLeft = new BorderPane();
		bRight = new BorderPane();
		assetShows = new ArrayList<AssetShow>();
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

	public void setUpAssetShow() {
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
		bLeft.setBorder(new Border(
				new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		bRight.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		pane.setLeft(bLeft);
		pane.setRight(bRight);
	}

	public void setUpUserControl() {
		controlField = new ControlField();
		controlField.setAlignment(Pos.CENTER);
		bLeft.setCenter(controlField);
	}

	public void setUpLogDisplay() {
		logDisplay = new LogDisplay();
		bRight.setCenter(logDisplay);
	}

}
