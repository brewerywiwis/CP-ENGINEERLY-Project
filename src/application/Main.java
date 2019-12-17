package application;

import endScene.EndScene;
import gameScene.CheckException;
import gameScene.GameScene;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import logic.LogicGame;
import sharedObject.SharedObjectHolder;
import startScene.StartScene;

public class Main extends Application {
	public static final int displayX = 1080, displayY = 720;
	public static final int borderX = 220, borderY = 40;
	public static double centerXPosition;
	public static double centerYPosition;
	private static GameScene gameScene;
	private static AnimationTimer gameLoop;
	private static StateScene state;
	private static StackPane gameRoot;
	private static boolean gameStop;
	private static Stage pStage;

	@Override
	public void init() {
		state = StateScene.SWAPSTARTSCENE;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		pStage = primaryStage;
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
					SharedObjectHolder.BGGameMusic.stop();
					break;
				}
				case SWAPGAMESCENE: {
					gameRoot = new StackPane();
					try {
						gameScene = new GameScene(gameRoot);
						LogicGame.resetLogicGame();
						gameScene.setUpAssetShow();
						gameScene.setUpUserControl();
						gameScene.setUpLogDisplay();
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
					SharedObjectHolder.BGGameMusic.setVolume(LogicGame.getBGSound() * LogicGame.getMainSound());
					LogicGame.update();
					break;
				}
				case SWAPENDSCENE: {
					SharedObjectHolder.epicWinSound.play(LogicGame.getBGSound() * LogicGame.getMainSound());
					SharedObjectHolder.BGGameMusic.stop();
					setState(StateScene.ENDSCENE);
					break;
				}
				case ENDSCENE: {
					primaryStage.setScene(EndScene.scene);
					SharedObjectHolder.BGGameMusic.stop();
					break;
				}
				}
			}
		};
		gameLoop.start();
	}

	@Override
	public void stop() {
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
		SharedObjectHolder.BGGameMusic.setCycleCount(Integer.MAX_VALUE);
		SharedObjectHolder.BGGameMusic.play();
	}

	public static void stopGame() {
		if (!gameStop) {
			gameLoop.stop();
			SharedObjectHolder.BGGameMusic.pause();
			gameStop = true;
			Rectangle film = new Rectangle(gameScene.getWidth(), gameScene.getHeight(), Color.LIGHTGRAY);
			film.setOpacity(0.5);
			gameRoot.getChildren().add(film);
		}
	}

	public static void startGame() {
		if (gameStop) {
			gameLoop.start();
			SharedObjectHolder.BGGameMusic.play();
			gameStop = false;
			gameRoot.getChildren().remove(gameRoot.getChildren().size() - 1);
		}
	}

	public static double getCenterXPosition() {
		return pStage.getX() + pStage.getWidth() / 2d;
	}

	public static double getCenterYPosition() {
		return pStage.getY() + pStage.getHeight() / 2d;
	}

}
