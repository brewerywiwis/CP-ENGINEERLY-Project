package endScene;

import application.Main;
import application.StateScene;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import logic.LogicGame;
import sharedObject.SharedObjectHolder;

public class EndScene extends Scene {

	public static EndScene scene;
	private static BorderPane pane;
	static {
		pane = new BorderPane();
		scene = new EndScene(pane);
	}

	public EndScene(Parent p) {
		super(p);
		// TODO Auto-generated constructor stub
		ImageView playAgain = new ImageView(SharedObjectHolder.playAgain);
		ImageView clickedPlayAgain = new ImageView(SharedObjectHolder.clickedPlayAgain);
		Button playAgainBt = new Button("");
		playAgainBt.setGraphic(playAgain);
		playAgainBt.setStyle("-fx-background-color: transparent");

		playAgainBt.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				playAgainBt.setGraphic(clickedPlayAgain);
			}
		});

		playAgainBt.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				playAgainBt.setGraphic(playAgain);
			}
		});

		playAgainBt.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Main.setState(StateScene.SWAPSTARTSCENE);
				SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
			}
		});
		pane.setCenter(playAgainBt);
		BorderPane.setAlignment(playAgainBt, Pos.BOTTOM_CENTER);
		BorderPane.setMargin(playAgainBt, new Insets(25, 25, 25, 25));

		Image bg;
		if (LogicGame.getWinnerName() == "ONE") {
			bg = SharedObjectHolder.playerOneWins;
		} else if (LogicGame.getWinnerName() == "TWO") {
			bg = SharedObjectHolder.playerTwoWins;
		} else if (LogicGame.getWinnerName() == "THREE") {
			bg = SharedObjectHolder.playerThreeWins;
		} else {
			bg = SharedObjectHolder.playerFourWins;
		}
		pane.setBackground(new Background(new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));
	}

}
