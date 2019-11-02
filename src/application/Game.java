package application;

import java.util.Random;

import UI.BoardUI;
import UI.StartScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.LogicGame;
import sharedObject.IRenderableHolder;

public class Game extends Application {
	public static final int displayX = 1080, displayY = 720;
	public static final int borderX = 220, borderY = 40;
	private BorderPane root;
	private Button roll;
	private Canvas cv;
	private static GraphicsContext gc;
	private static Scene currentScene;
	public static StateScene state;

	@Override
	public void init() {
		state = StateScene.STARTSCENE;
		currentScene = StartScene.scene.getSc();
		cv = new Canvas(displayX, displayY);
		gc = cv.getGraphicsContext2D();
		root = new BorderPane();
		roll = new Button("ROLL");
		roll.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				Random random = new Random();
				int randomInt = random.nextInt(6) + 1;
				System.out.println(randomInt);
			}
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// root.getChildren().add(cv);
		// root.setCenter(IRenderableHolder.board);
		// root.setRight(roll);
		// currentScene = new Scene(root, displayX, displayY);

		AnimationTimer GameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				switch (state) {
				case STARTSCENE: {
					// StartScene.update();
					primaryStage.setScene(currentScene);
					break;
				}
				case GAMESCENE: {
					LogicGame.update();
					break;
				}
				case CURRENT: {
					break;
				}
				}
			}
		};
		primaryStage.setScene(currentScene);
		primaryStage.setTitle("CP Engineerly");
		primaryStage.setResizable(true);
		primaryStage.show();
		GameLoop.start();
	}

	public static GraphicsContext getGc() {
		return gc;
	}

	public static void setCurrentScene(Scene currentScene) {
		Game.currentScene = currentScene;
	}

	public static Scene getCurrentScene() {
		return currentScene;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
