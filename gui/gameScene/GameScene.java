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
import sharedObject.IRenderableHolder;

public class GameScene extends Scene {

	private BoardPane board;
	private BorderPane pane;

	public GameScene(Parent root) throws CheckException {
		super(root, Main.displayX, Main.displayY);
		resetGame();
		BackgroundImage img = new BackgroundImage(IRenderableHolder.woodenBg, BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane.setBackground(new Background(img));
	}

	private void resetGame() throws CheckException {
		// TODO Auto-generated method stub
		try {

			/////////////////////////////////////////
			BorderPane h1 = new BorderPane();
			h1.setTop(new Rectangle(200, 200));
			h1.setBottom(new Rectangle(200, 200));
			BorderPane h2 = new BorderPane();
			h2.setTop(new Rectangle(200, 200));
			h2.setBottom(new Rectangle(200, 200));
			
			h1.setBorder(new Border(
					new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
			h2.setBorder(new Border(
					new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

			// init Game screen in 3 section 1assetShow 2board 3assetShow//
			pane = (BorderPane) getRoot();
			board = new BoardPane();
			pane.setCenter(board);
			pane.setLeft(h1);
			pane.setRight(h2);
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

}
