package application;

import endScene.EndScene;
import gameScene.CheckException;
import gameScene.GameScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.LogicGame;
import sharedObject.SharedObjectHolder;
import startScene.StartScene;

public class Main extends Application {
	public static final int displayX = 1080, displayY = 720;
	public static final int borderX = 220, borderY = 40;
	private static GameScene gameScene;
	private static AnimationTimer gameLoop;
	private static StateScene state;
	private BorderPane gameRoot;
	private static boolean gameStop;

	@Override
	public void init() {
		state = StateScene.SWAPSTARTSCENE;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("CP Engineerly");
		primaryStage.setResizable(true);
		primaryStage.setMaximized(true);
//		primaryStage.setAlwaysOnTop(true);
		primaryStage.show();
		gameStop = false;

		gameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				switch (getState()) {
				case SWAPSTARTSCENE: {
					StartScene.resetStartScene();
					primaryStage.setScene(StartScene.scene);
					setState(StateScene.STARTSCENE);
				}
				case STARTSCENE: {
					break;
				}
				case SWAPGAMESCENE: {
					gameRoot = new BorderPane();
					try {
						gameScene = new GameScene(gameRoot);
						LogicGame.resetLogicGame();
						primaryStage.setScene(gameScene);
						setState(StateScene.GAMESCENE);
						startMusicBGGameScene();
					} catch (CheckException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
				case GAMESCENE: {
					LogicGame.update();
					break;
				}
				case SWAPENDSCENE: {
					SharedObjectHolder.epicWinSound.play();
					setState(StateScene.ENDSCENE);
					break;
				}
				case ENDSCENE: {
					primaryStage.setScene(EndScene.scene);
					break;
				}
				}
			}
		};
		gameLoop.start();
	}

	@Override
	public void stop() {
		SharedObjectHolder.BGGameMusic.stop();
		SharedObjectHolder.epicWinSound.stop();
		setState(StateScene.DIE);
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

	public static GameScene getGameScene() {
		return gameScene;
	}

	public static AnimationTimer getGameLoop() {
		return gameLoop;
	}

	public static boolean isGameStop() {
		return gameStop;
	}

	public static void startMusicBGGameScene() {
		Thread musicThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (getState() == StateScene.GAMESCENE && !Main.isGameStop()) {
					if (!SharedObjectHolder.BGGameMusic.isPlaying()) {
						SharedObjectHolder.BGGameMusic.play();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				SharedObjectHolder.BGGameMusic.stop();
			}
		});

		musicThread.start();
	}

	public static void stopGame() {
		if (!gameStop) {
			gameLoop.stop();
			SharedObjectHolder.BGGameMusic.stop();
			gameStop = true;
		}
	}

	public static void startGame() {
		if (gameStop) {
			gameLoop.start();
			startMusicBGGameScene();
			gameStop = false;
		}
	}
}
