package application;

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
import sharedObject.IRenderableHolder;

public class Game extends Application {
	public static final int displayX = 1080, displayY = 720;
	private BorderPane root;
	private Button roll;
	private Canvas cv;
	private static GraphicsContext gc;
	private static Scene currentScene;

	@Override
	public void init() {
		cv = new Canvas(displayX, displayY);
		root = new BorderPane();
		roll = new Button("ROLL");
		roll.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				System.out.println("roll!");
				// implement dice roll method
			}
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		gc = cv.getGraphicsContext2D();
		root.getChildren().add(cv);
		root.setCenter(IRenderableHolder.board);
		root.setRight(roll);
		currentScene = new Scene(root, displayX, displayY);

		primaryStage.setScene(currentScene);
		primaryStage.setTitle("CP Engineerly");
		primaryStage.setResizable(true);
		primaryStage.show();

		AnimationTimer GameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {

			}
		};
		GameLoop.start();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
