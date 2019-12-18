package logic;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Random;

import application.Main;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import sharedObject.SharedObjectHolder;

public abstract class Deck implements Actionable {

	private Queue<Integer> deck;
	private final int numCard = 10;

	public Deck() {
		resetDeck();
	}

	public void resetDeck() {
		deck = createDeck();
		// shuffle();
	}

	// if deck non empty return int of card, return -99
	public int pickCard() {
		if (!deck.isEmpty()) {
			int numCard = deck.poll();
			deck.add(numCard);
			return numCard;
		} else {
			return -99;
		}
	}

	public void shuffle() {

		if (!deck.isEmpty()) {
			Integer[] sequence = new Integer[deck.size()];
			int n = deck.size();

			for (int i = 0; i < n; i++) {
				sequence[i] = deck.poll();
			}

			Random rand = new Random();

			for (int i = 0; i < numCard; i++) {

				// Random for remaining positions.
				int r = i + rand.nextInt(numCard - i);

				// swapping the elements
				int temp = sequence[r];
				sequence[r] = sequence[i];
				sequence[i] = temp;
			}

			for (int i = 0; i < sequence.length; i++) {
				deck.add(sequence[i]);
			}
		}

	}

	private Queue<Integer> createDeck() {
		Queue<Integer> newDeck = new LinkedList<Integer>();
		for (int i = 0; i < numCard; i++) {
			newDeck.add(i);
		}
		return newDeck;
	}

	public void showCard() {
		int n = deck.size();
		for (int i = 0; i < n; i++) {
			int ans = deck.poll();
			System.out.println(ans);
			deck.add(ans);
		}
	}

	public abstract int drawAndEffect();

	public static void showPayAndAddInformation(Asset asset, Player nowPlayer, int price) {
		int n = Main.getGameScene().getLogDisplay().getSize();
		int prevMoney = nowPlayer.getMoney();
		if (nowPlayer.getMoney() >= price) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setContentText(String.format("Player %s pays money to Player %s\n(%d -> %d).",
							nowPlayer.getName(), asset.getOwner().getName(), prevMoney, prevMoney - price));
					alert.setHeaderText(null);

					SharedObjectHolder.babyCrySound.play(LogicGame.getEffectSound() * LogicGame.getMainSound());

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				}
			});
			Main.getGameScene().getLogDisplay().add(String.format("%d: Player %s pays money to Player %s (%d -> %d).",
					n + 1, nowPlayer.getName(), asset.getOwner().getName(), prevMoney, prevMoney - price));
		}
	}

	public static void showPayInformation(Asset asset, Player nowPlayer, int price) {
		int n = Main.getGameScene().getLogDisplay().getSize();
		int prevMoney = nowPlayer.getMoney();
		if (nowPlayer.getMoney() >= price) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setContentText(String.format("Player %s pays %d\n(%d -> %d).", nowPlayer.getName(), price,
							prevMoney, prevMoney - price));
					alert.setHeaderText(null);

					SharedObjectHolder.babyCrySound.play(LogicGame.getEffectSound() * LogicGame.getMainSound());

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				}
			});
			Main.getGameScene().getLogDisplay().add(String.format("%d: Player %s pays %d (%d -> %d).", n + 1,
					nowPlayer.getName(), price, prevMoney, prevMoney - price));
		} else if (asset == null || asset.getOwner() == null || nowPlayer == asset.owner
				|| (asset.getOwner() != null && nowPlayer.getMoney() >= asset.getPrice())) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText(String.format("Player %s is bankrupt!", nowPlayer.getName()));
					SharedObjectHolder.alertSound.play(LogicGame.getEffectSound() * LogicGame.getMainSound());

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				}
			});
			Main.getGameScene().getLogDisplay()
					.add(String.format("%d: Player %s is bankrupt.", n + 1, nowPlayer.getName()));

		}
	}

	public static void showAddInformation(Player nowPlayer, int price) {
		int n = Main.getGameScene().getLogDisplay().getSize();
		int prevMoney = nowPlayer.getMoney();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setContentText(String.format("Player %s get %d\n(%d -> %d).", nowPlayer.getName(), price,
						prevMoney, prevMoney + price));
				alert.setHeaderText(null);

				SharedObjectHolder.treasureSound.play(LogicGame.getEffectSound() * LogicGame.getMainSound());

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
				}
			}
		});
		Main.getGameScene().getLogDisplay().add(String.format("%d: Player %s get %d (%d -> %d).", n + 1,
				nowPlayer.getName(), price, prevMoney, prevMoney + price));
	}

}
