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
	static {
		players = new ArrayList<Player>();
		Player one = new Player("ONE", 500, 1, IRenderableHolder.blackPawn);
		Player two = new Player("TWO", 500, 1, IRenderableHolder.whitePawn);
		players.add(one);
		players.add(two);
		for (int i = 0; i < players.size(); i++) {
			System.out.println(i);
			Bounds field = Main.gameScene.getBoard().getFields().get(players.get(i).getCurrentField()).localToScene(
					Main.gameScene.getBoard().getFields().get(players.get(i).getCurrentField()).getBoundsInLocal());
			Field g = Main.gameScene.getBoard().getFields().get(players.get(i).getCurrentField());
			Main.gameScene.getPane().getChildren().add(players.get(i));
			double centerX = g.getWidth() / 2;
			double centerY = g.getHeight() / 2;
			players.get(i).setLayoutX(field.getMinX() + players.get(i).getCenterPx() + i * (20));
			players.get(i).setLayoutY(field.getMinY() + centerY - players.get(i).getCenterPy());
			System.out.println(players.get(i).getName());
		}
		tick = 0;
	}

	// field.getMinX() + players.get(i).getCenterPx() + i * (20)
	// field.getMinX() + centerX - nowPlayer.getCenterPx()
	public LogicGame() {
	}

	public static void update() {
		if (Main.getState() == StateScene.GAMESCENE) {
			Player nowPlayer = players.get(turnPlayer);
			if (nowPlayer.getCurrentField() != nowPlayer.getNextField()) {
				if (tick == 18) {
					Bounds field = Main.gameScene.getBoard().getFields()
							.get((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield())
							.localToScene(Main.gameScene.getBoard().getFields()
									.get((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield())
									.getBoundsInLocal());
					Field g = Main.gameScene.getBoard().getFields()
							.get((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield());
					double centerX = g.getWidth() / 2;
					double centerY = g.getHeight() / 2;
					nowPlayer.setLayoutX(field.getMinX() + nowPlayer.getCenterPx() + players.indexOf(nowPlayer) * (20));
					nowPlayer.setLayoutY(field.getMinY() + centerY - nowPlayer.getCenterPy());
					nowPlayer.setCurrentField((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield());
					tick = 0;
				} else {
					tick++;
				}
				if (nowPlayer.getCurrentField() == nowPlayer.getNextField()) {
					Main.gameScene.getBoard().getFields().get(nowPlayer.getCurrentField()).doAction();
					turnPlayer = (turnPlayer + 1) % players.size();
				}
			}
		}
	}

	public static ArrayList<Player> getPlayers() {
		return players;
	}

	public static int getTurnPlayer() {
		return turnPlayer;
	}

}
