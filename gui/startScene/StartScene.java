package startScene;

import application.Main;
import application.StateScene;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import logic.LogicGame;
import sharedObject.SharedObjectHolder;

public class StartScene extends Scene {

	public static StartScene scene;
	private static BorderPane pane;
	private static int player;

	public StartScene(Parent p, double w, double h) {
		super(p, w, h);

		ImageView startButton = new ImageView(SharedObjectHolder.startButton);
		ImageView clickedStartButton = new ImageView(SharedObjectHolder.clickedStartButton);
		ImageView onePlayerButton = new ImageView(SharedObjectHolder.onePlayerButton);
		ImageView twoPlayerButton = new ImageView(SharedObjectHolder.twoPlayerButton);
		ImageView threePlayerButton = new ImageView(SharedObjectHolder.threePlayerButton);
		ImageView fourPlayerButton = new ImageView(SharedObjectHolder.fourPlayerButton);
		ImageView clickedOnePlayer = new ImageView(SharedObjectHolder.clickedOnePlayer);
		ImageView clickedTwoPlayer = new ImageView(SharedObjectHolder.clickedTwoPlayer);
		ImageView clickedThreePlayer = new ImageView(SharedObjectHolder.clickedThreePlayer);
		ImageView clickedFourPlayer = new ImageView(SharedObjectHolder.clickedFourPlayer);
		VBox vBox = new VBox();

		Button start_button = new Button("");
		start_button.setGraphic(startButton);
		start_button.setStyle("-fx-background-color: transparent");
		Button onePlayer = new Button("", onePlayerButton);
		Button twoPlayer = new Button("", twoPlayerButton);
		Button threePlayer = new Button("", threePlayerButton);
		Button fourPlayer = new Button("", fourPlayerButton);
		onePlayer.setStyle("-fx-background-color: transparent");
		twoPlayer.setStyle("-fx-background-color: transparent");
		threePlayer.setStyle("-fx-background-color: transparent");
		fourPlayer.setStyle("-fx-background-color: transparent");

		vBox.getChildren().addAll(start_button, onePlayer, twoPlayer, threePlayer, fourPlayer);
		vBox.setAlignment(Pos.CENTER);
		pane.setRight(vBox);
		BorderPane.setMargin(vBox, new Insets(100, 100, 100, 100));
		onePlayer.setVisible(false);
		twoPlayer.setVisible(false);
		threePlayer.setVisible(false);
		fourPlayer.setVisible(false);

		start_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				start_button.setGraphic(clickedStartButton);
				onePlayer.setVisible(true);
				twoPlayer.setVisible(true);
				threePlayer.setVisible(true);
				fourPlayer.setVisible(true);
				SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());

				onePlayer.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						onePlayer.setGraphic(clickedOnePlayer);
					}
				});
				onePlayer.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						onePlayer.setGraphic(onePlayerButton);

					}
				});
				twoPlayer.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						twoPlayer.setGraphic(clickedTwoPlayer);
					}
				});
				twoPlayer.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						twoPlayer.setGraphic(twoPlayerButton);

					}
				});
				threePlayer.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						threePlayer.setGraphic(clickedThreePlayer);
					}
				});
				threePlayer.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						threePlayer.setGraphic(threePlayerButton);

					}
				});
				fourPlayer.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						fourPlayer.setGraphic(clickedFourPlayer);
					}
				});
				fourPlayer.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						fourPlayer.setGraphic(fourPlayerButton);

					}
				});

				onePlayer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						player = 1;
						Main.setState(StateScene.SWAPGAMESCENE);
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				});

				twoPlayer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						player = 2;
						Main.setState(StateScene.SWAPGAMESCENE);
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				});

				threePlayer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						player = 3;
						Main.setState(StateScene.SWAPGAMESCENE);
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				});

				fourPlayer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						player = 4;
						Main.setState(StateScene.SWAPGAMESCENE);
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				});

			}
		});

		vBox.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				start_button.setGraphic(startButton);
				onePlayer.setVisible(false);
				twoPlayer.setVisible(false);
				threePlayer.setVisible(false);
				fourPlayer.setVisible(false);
			}
		});

		pane.setBackground(new Background(new BackgroundImage(SharedObjectHolder.startSceneBackground,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));

	}

	public static void resetStartScene() {
		pane = new BorderPane();
		scene = new StartScene(pane, Main.displayX, Main.displayY);
		SharedObjectHolder.epicWinSound.stop();
	}

	public static int getPlayer() {
		return player;
	}

}
