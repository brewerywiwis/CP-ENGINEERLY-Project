package application;

import gameScene.GameScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.LogicGame;
import startScene.StartScene;

public class Main extends Application {
	public static final int displayX = 1080, displayY = 720;
	public static final int borderX = 220, borderY = 40;
	private static StateScene state;
	
	public static StateScene getState() {
		return state;
	}

	public static void setState(StateScene state) {
		Main.state = state;
	}

	@Override
	public void init() {
		state = StateScene.STARTSCENE;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("CP Engineerly");
		primaryStage.setResizable(true);
		primaryStage.show();

		AnimationTimer GameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				switch (getState()) {
				case STARTSCENE: {
					primaryStage.setScene(StartScene.scene);
					setState(StateScene.CURRENT);
					break;
				}
				case GAMESCENE: {
					BorderPane bp = new BorderPane();
					Canvas cv = new Canvas(Game.displayX, Game.displayY);
					bp.getChildren().add(cv);
					Scene gs = new GameScene(bp, Game.displayX, Game.displayY);
					primaryStage.setScene(gs);
					setState(StateScene.CURRENT);
					break;
				}
				case CURRENT: {
					LogicGame.update();
					break;
				}
				}
			}
		};
		GameLoop.start();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
