package startScene;

import application.Main;
import application.StateScene;
import gameScene.CheckException;
import gameScene.GameScene;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import sharedObject.IRenderableHolder;;

public class StartScene extends Scene {

	public static StartScene scene;
	private static BorderPane pane;
	static {
		pane = new BorderPane();
		scene = new StartScene(pane, Main.displayX, Main.displayY);

	}
	private static int player;

	public StartScene(Parent p, double w, double h) {
		super(p, w, h);

		ImageView startButton = new ImageView(IRenderableHolder.startButton);
		ImageView clickedStartButton = new ImageView(IRenderableHolder.clickedStartButton);
		ImageView onePlayerButton = new ImageView(IRenderableHolder.onePlayerButton);
		ImageView twoPlayerButton = new ImageView(IRenderableHolder.twoPlayerButton);
		ImageView threePlayerButton = new ImageView(IRenderableHolder.threePlayerButton);
		ImageView fourPlayerButton = new ImageView(IRenderableHolder.fourPlayerButton);
		ImageView clickedOnePlayer = new ImageView(IRenderableHolder.clickedOnePlayer);
		ImageView clickedTwoPlayer = new ImageView(IRenderableHolder.clickedTwoPlayer);
		ImageView clickedThreePlayer = new ImageView(IRenderableHolder.clickedThreePlayer);
		ImageView clickedFourPlayer = new ImageView(IRenderableHolder.clickedFourPlayer);
		Button start_button = new Button("");
		start_button.setGraphic(startButton);
		start_button.setStyle("-fx-background-color: transparent");

		pane.setRight(start_button);
		BorderPane.setMargin(start_button, new Insets(100, 100, 100, 100));
		start_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				start_button.setGraphic(clickedStartButton);
				ContextMenu context = new ContextMenu();
				MenuItem onePlayer = new MenuItem("", onePlayerButton);
				MenuItem twoPlayer = new MenuItem("", twoPlayerButton);
				MenuItem threePlayer = new MenuItem("", threePlayerButton);
				MenuItem fourPlayer = new MenuItem("", fourPlayerButton);
				context.getItems().addAll(onePlayer, twoPlayer, threePlayer, fourPlayer);
				context.setStyle("-fx-background-color: transparent");
				context.show(clickedStartButton, Side.BOTTOM, 0, 0);
	
				onePlayerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						twoPlayer.setGraphic(twoPlayerButton);
						onePlayer.setGraphic(clickedOnePlayer);
					}
				});
				clickedOnePlayer.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						onePlayer.setGraphic(onePlayerButton);

					}
				});
				twoPlayerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						onePlayer.setGraphic(onePlayerButton);
						threePlayer.setGraphic(threePlayerButton);
						twoPlayer.setGraphic(clickedTwoPlayer);
					}
				});
				clickedTwoPlayer.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						twoPlayer.setGraphic(twoPlayerButton);

					}
				});
				threePlayerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						twoPlayer.setGraphic(twoPlayerButton);
						fourPlayer.setGraphic(fourPlayerButton);
						threePlayer.setGraphic(clickedThreePlayer);
					}
				});
				clickedThreePlayer.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						threePlayer.setGraphic(threePlayerButton);

					}
				});
				fourPlayerButton.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						threePlayer.setGraphic(threePlayerButton);
						fourPlayer.setGraphic(clickedFourPlayer);
					}
				});
				clickedFourPlayer.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						fourPlayer.setGraphic(fourPlayerButton);

					}
				});

				clickedOnePlayer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						pane.setRight(startButton);
						BorderPane.setMargin(startButton, new Insets(100, 100, 100, 100));
						player = 1;
						Main.setState(StateScene.SWAPGAMESCENE);
					}
				});

				clickedTwoPlayer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						pane.setRight(startButton);
						BorderPane.setMargin(startButton, new Insets(100, 100, 100, 100));
						player = 2;
						Main.setState(StateScene.SWAPGAMESCENE);
					}
				});

				clickedThreePlayer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						pane.setRight(startButton);
						BorderPane.setMargin(startButton, new Insets(100, 100, 100, 100));
						player = 3;
						Main.setState(StateScene.SWAPGAMESCENE);
					}
				});

				clickedFourPlayer.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent e) {
						pane.setRight(startButton);
						BorderPane.setMargin(startButton, new Insets(100, 100, 100, 100));
						player = 4;
						Main.setState(StateScene.SWAPGAMESCENE);
					}
				});

			}
		});
		
		pane.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				start_button.setGraphic(startButton);
			}
		});

		pane.setBackground(new Background(new BackgroundImage(IRenderableHolder.startSceneBackground,
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false))));

	}

	public static int getPlayer() {
		return player;
	}

}
