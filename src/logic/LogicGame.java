package logic;

import java.util.ArrayList;
import application.Main;
import application.StateScene;
import field.Field;
import field.HLandField;
import field.VLandField;
import gameScene.BoardPane;
import javafx.geometry.Bounds;
import sharedObject.SharedObjectHolder;
import startScene.StartScene;

public class LogicGame {

	private static double mainSound = 1.0;
	private static double BGSound = 1.0;
	private static double effectSound = 1.0;
	private static String winnerName;
	private static int turnPlayer = 0;
	private static ArrayList<Player> players;
	private static int tick = 0;
	private static boolean changeTurn;
	private final static int startX = 15;

	public LogicGame() {
	}

	public static void update() {
		updatePlayerPosition();

		if (Main.getState() == StateScene.GAMESCENE && !Main.isGameStop()) {
			Player nowPlayer = players.get(turnPlayer);
			if (!nowPlayer.isMove()) {
				nowPlayer.setNotMoveCount(nowPlayer.getNotMoveCount() - 1);
				nowPlayer.setNextField(nowPlayer.getCurrentField());
				turnPlayer = (turnPlayer + 1) % players.size();
				changeTurn = true;
			} else if (nowPlayer.getCurrentField() != nowPlayer.getNextField()) {
				if (tick == 30) {
					Bounds field = Main.getGameScene().getBoard().getFields()
							.get((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield())
							.localToScene(Main.getGameScene().getBoard().getFields()
									.get((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield())
									.getBoundsInLocal());
					Field g = Main.getGameScene().getBoard().getFields()
							.get((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield());

					double centerY = g.getHeight() / 2;

					SharedObjectHolder.footstepSound.play(effectSound * mainSound);
					nowPlayer.setLayoutX(
							field.getMinX() + nowPlayer.getCenterPx() + players.indexOf(nowPlayer) * (20) - startX);
					nowPlayer.setLayoutY(field.getMinY() + centerY - nowPlayer.getCenterPy());
					nowPlayer.setCurrentField((nowPlayer.getCurrentField() + 1) % BoardPane.getNumoffield());
					
//					Main.getGameScene().getBoard().getFields().get(nowPlayer.getCurrentField()).doAction();
					
					System.out.println(nowPlayer.getCurrentField());
					System.out.println(nowPlayer.getMoney());
					nowPlayer.doAction();
					System.out.println(nowPlayer.getMoney());
					System.out.println("---------");
					Main.getGameScene().update();
					tick = 0;
				} else {
					tick++;
				}
				if (nowPlayer.getCurrentField() == nowPlayer.getNextField()) {
					turnPlayer = (turnPlayer + 1) % players.size();
					changeTurn = true;
				}
			}
			if (players.size() == 1) {
				winnerName = players.get(0).getName();
				Main.setState(StateScene.SWAPENDSCENE);
			}
		}
	}

	public static void setUpPlayer() {
		int n = StartScene.getPlayer();
		players = new ArrayList<Player>();
		if (n == 1) {
			players.add(
					new Player("ONE", 15000, SharedObjectHolder.characterColors.get(1), SharedObjectHolder.yellowPawn));
		}
		if (n == 2) {
			players.add(
					new Player("ONE", 15000, SharedObjectHolder.characterColors.get(1), SharedObjectHolder.yellowPawn));
			players.add(
					new Player("TWO", 15000, SharedObjectHolder.characterColors.get(2), SharedObjectHolder.pinkPawn));

		} else if (n == 3) {
			players.add(
					new Player("ONE", 15000, SharedObjectHolder.characterColors.get(1), SharedObjectHolder.yellowPawn));
			players.add(
					new Player("TWO", 15000, SharedObjectHolder.characterColors.get(2), SharedObjectHolder.pinkPawn));
			players.add(
					new Player("THREE", 2000, SharedObjectHolder.characterColors.get(3), SharedObjectHolder.bluePawn));
		} else if (n == 4) {
			players.add(
					new Player("ONE", 15000, SharedObjectHolder.characterColors.get(1), SharedObjectHolder.yellowPawn));
			players.add(
					new Player("TWO", 15000, SharedObjectHolder.characterColors.get(2), SharedObjectHolder.pinkPawn));
			players.add(
					new Player("THREE", 15000, SharedObjectHolder.characterColors.get(3), SharedObjectHolder.bluePawn));
			players.add(
					new Player("FOUR", 15000, SharedObjectHolder.characterColors.get(0), SharedObjectHolder.blackPawn));
		}
		for (int i = 0; i < players.size(); i++) {
			Bounds field = Main.getGameScene().getBoard().getFields().get(players.get(i).getCurrentField())
					.localToScene(Main.getGameScene().getBoard().getFields().get(players.get(i).getCurrentField())
							.getBoundsInLocal());
			Field g = Main.getGameScene().getBoard().getFields().get(players.get(i).getCurrentField());
			Main.getGameScene().getPane().getChildren().add(players.get(i));

			double centerY = g.getHeight() / 2;

			players.get(i).setLayoutX(field.getMinX() + players.get(i).getCenterPx() + i * (20) - startX);
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
					- startX || nowPlayer.getLayoutY() != field.getMinY() + centerY - nowPlayer.getCenterPy()) {
				nowPlayer.setLayoutX(
						field.getMinX() + nowPlayer.getCenterPx() + players.indexOf(nowPlayer) * (20) - startX);
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

	// when bankrupt or lose the game use this method
	public static void goodByeMyFriend(Player player) {
		player.setVisible(false);
		players.remove(player);
		for (int i = 0; i < player.getAssets().size(); i++) {
			player.getAssets().get(i).setOwner(null);
		}
		for (int i = 0; i < Main.getGameScene().getBoard().getFields().size(); i++) {
			Field nowField = Main.getGameScene().getBoard().getFields().get(i);
			if (nowField.getActionable() instanceof Asset) {
				Asset asset = (Asset) nowField.getActionable();
				if (asset.getOwner() == null) {
					if (nowField instanceof HLandField) {
						HLandField hLandField = (HLandField) nowField;
						hLandField.setOwnerColor();
					} else if (nowField instanceof VLandField) {
						VLandField vLandField = (VLandField) nowField;
						vLandField.setOwnerColor();
					}
				}
			}
		}
		player.setMoney(0);
		for (int i = 0; i < Main.getGameScene().getAssetShows().size(); i++) {
			if (Main.getGameScene().getAssetShows().get(i).getPlayer() == player) {
				Main.getGameScene().getAssetShows().get(i).setUpBankruptPlayer();
			}
		}
		SharedObjectHolder.bankruptSound.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
	}

	public static void resetLogicGame() {
		mainSound = 1.0;
		BGSound = 1.0;
		effectSound = 1.0;
		changeTurn = true;
		tick = 0;
		turnPlayer = 0;
		setUpPlayer();
	}

	public static String getWinnerName() {
		return winnerName;
	}

	public static double getMainSound() {
		return mainSound;
	}

	public static void setMainSound(double mainSound) {
		LogicGame.mainSound = mainSound;
	}

	public static double getBGSound() {
		return BGSound;
	}

	public static void setBGSound(double bGSound) {
		BGSound = bGSound;
	}

	public static double getEffectSound() {
		return effectSound;
	}

	public static void setEffectSound(double effectSound) {
		LogicGame.effectSound = effectSound;
	}
}
