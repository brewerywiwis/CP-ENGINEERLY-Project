package application;

import gameScene.CheckException;
import gameScene.GameScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.LogicGame;
import startScene.StartScene;

public class Main extends Application {
	public static final int displayX = 1080, displayY = 720;
	public static final int borderX = 220, borderY = 40;
	public static GameScene gameScene;
	private static StateScene state;
	private BorderPane gameRoot;

	@Override
	public void init() {
		state = StateScene.STARTSCENE;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("CP Engineerly");
		primaryStage.setResizable(true);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.show();

		AnimationTimer GameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				switch (getState()) {
				case STARTSCENE: {
					primaryStage.setScene(StartScene.scene);
					break;
				}
				case SWAPGAMESCENE: {
					gameRoot = new BorderPane();
					try {
						gameScene = new GameScene(gameRoot);
						primaryStage.setScene(gameScene);
						setState(StateScene.GAMESCENE);
					} catch (CheckException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
				case GAMESCENE: {
					LogicGame.update();
				}
				}
			}
		};
		GameLoop.start();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static StateScene getState() {
		return state;
	}

	public static void setState(StateScene state) {
		Main.state = state;
	}
}
