package application;

import gameScene.CheckException;
import gameScene.GameScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.ChanceCard;
import logic.LogicGame;
import startScene.StartScene;

public class Main extends Application {
	public static final int displayX = 1080, displayY = 720;
	public static final int borderX = 220, borderY = 40;
	private static StateScene state;
	private BorderPane gameRoot;

	public static StateScene getState() {
		return state;
	}

	public static void setState(StateScene state) {
		Main.state = state;
	}

	@Override
	public void init() {
		state = StateScene.STARTSCENE;
		ChanceCard cc = new ChanceCard();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("CP Engineerly");
		primaryStage.setResizable(true);

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
					gameRoot = new BorderPane();
					try {
						primaryStage.setScene(new GameScene(gameRoot));
					} catch (CheckException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		primaryStage.setAlwaysOnTop(true);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
