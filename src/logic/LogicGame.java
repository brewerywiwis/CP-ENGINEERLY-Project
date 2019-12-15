package logic;

import java.util.ArrayList;
import application.Main;
import application.StateScene;
import field.Field;
import gameScene.BoardPane;
import javafx.geometry.Bounds;
import sharedObject.IRenderableHolder;

public class LogicGame {

	private static int turnPlayer = 0;
	private static ArrayList<Player> players;
	private static int tick = 0;
	private static boolean changeTurn;

	static {
		players = new ArrayList<Player>();
		changeTurn = true;
		tick = 0;
		setUpPlayer();
		Main.getGameScene().setUpAssetShow();
	}

	public LogicGame() {
	}

	public static void update() {

		if (Main.getState() == StateScene.GAMESCENE) {
			updatePlayerPosition();
			Player nowPlayer = players.get(turnPlayer);
			if (!nowPlayer.isMove()) {
				nowPlayer.setNotMoveCount(nowPlayer.getNotMoveCount() - 1);
				nowPlayer.setNextField(nowPlayer.getCurrentField());
				turnPlayer = (turnPlayer + 1) % players.size();
				changeTurn = true;
			} else if (nowPlayer.getCurrentField() != nowPlayer.getNextField()) {
				if (tick == 18) {
					Bounds field = Main.getGameScene().getBoard().getFields()
							.get((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield())
							.localToScene(Main.getGameScene().getBoard().getFields()
									.get((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield())
									.getBoundsInLocal());
					Field g = Main.getGameScene().getBoard().getFields()
							.get((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield());

					double centerX = g.getWidth() / 2;
					double centerY = g.getHeight() / 2;

					nowPlayer.setLayoutX(field.getMinX() + nowPlayer.getCenterPx() + players.indexOf(nowPlayer) * (20));
					nowPlayer.setLayoutY(field.getMinY() + centerY - nowPlayer.getCenterPy());
					nowPlayer.setCurrentField((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield());

					nowPlayer.doAction();
//					Main.getGameScene().getBoard().getFields().get(nowPlayer.getCurrentField()).doAction();

					tick = 0;
				} else {
					tick++;
				}
				if (nowPlayer.getCurrentField() == nowPlayer.getNextField()) {
					turnPlayer = (turnPlayer + 1) % players.size();
					changeTurn = true;
				}
			}
		}
	}

	public static void setUpPlayer() {
		Player one = new Player("ONE", 500, IRenderableHolder.blackPawn);
		Player two = new Player("TWO", 500, IRenderableHolder.whitePawn);
		one.setNotMoveCount(3);
		players.add(one);
		players.add(two);
		for (int i = 0; i < players.size(); i++) {
			Bounds field = Main.getGameScene().getBoard().getFields().get(players.get(i).getCurrentField())
					.localToScene(Main.getGameScene().getBoard().getFields().get(players.get(i).getCurrentField())
							.getBoundsInLocal());
			Field g = Main.getGameScene().getBoard().getFields().get(players.get(i).getCurrentField());
			Main.getGameScene().getPane().getChildren().add(players.get(i));

			double centerX = g.getWidth() / 2;
			double centerY = g.getHeight() / 2;

			players.get(i).setLayoutX(field.getMinX() + players.get(i).getCenterPx() + i * (20));
			players.get(i).setLayoutY(field.getMinY() + centerY - players.get(i).getCenterPy());
		}
	}

	public static void updatePlayerPosition() {
		for (int i = 0; i < players.size(); i++) {
			Player nowPlayer = players.get(i);
			Bounds field = Main.getGameScene().getBoard().getFields()
					.get((nowPlayer.getCurrentField()) % BoardPane.getNumoffield())
					.localToScene(Main.getGameScene().getBoard().getFields()
							.get((nowPlayer.getCurrentField()) % BoardPane.getNumoffield()).getBoundsInLocal());
			Field g = Main.getGameScene().getBoard().getFields()
					.get((nowPlayer.getCurrentField()) % BoardPane.getNumoffield());
			double centerY = g.getHeight() / 2;
			if (nowPlayer.getLayoutX() != field.getMinX() + nowPlayer.getCenterPx() + players.indexOf(nowPlayer) * (20)
					|| nowPlayer.getLayoutY() != field.getMinY() + centerY - nowPlayer.getCenterPy()) {
				nowPlayer.setLayoutX(field.getMinX() + nowPlayer.getCenterPx() + players.indexOf(nowPlayer) * (20));
				nowPlayer.setLayoutY(field.getMinY() + centerY - nowPlayer.getCenterPy());
			}
		}
	}

	public static Player getNowPlayer() {
		return players.get(turnPlayer);
	}

	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static int getTurnPlayer() {
		return turnPlayer;
	}

	public static boolean getChangeTurn() {
		return changeTurn;
	}

	public static void setChangeTurn(boolean changeTurn) {
		LogicGame.changeTurn = changeTurn;
	}
}
