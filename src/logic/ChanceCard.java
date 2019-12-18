package logic;

import java.util.Optional;

import application.Main;
import field.Field;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import sharedObject.SharedObjectHolder;

public class ChanceCard extends Deck {

	public ChanceCard() {
		super();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		Player nowPlayer = LogicGame.getNowPlayer();
		if (nowPlayer.getCurrentField() == nowPlayer.getNextField()) {
			int n = Main.getGameScene().getLogDisplay().getSize();
			Main.getGameScene().getLogDisplay()
					.add(String.format("%d: Player %s is getting Chance Card.", n + 1, nowPlayer.getName()));

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText("Player " + nowPlayer.getName() + " get Chance Card.");
					alert.setContentText(null);
					ImageView img = new ImageView(SharedObjectHolder.chanceCardV);
					img.setFitHeight(460);
					img.setFitWidth(325);
					alert.getDialogPane().setGraphic(img);
					//

					SharedObjectHolder.fairySound.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				}
			});
			System.out.println(drawAndEffect());

			drawAndEffect();
		}
	}

	@Override
	public int drawAndEffect() {
		// TODO Auto-generated method stub
		System.out.println("DO CHANCE CARD DRAW");
		Player nowPlayer = LogicGame.getNowPlayer();
		int n = this.pickCard();
		// prepare for implement effect each effect card
		switch (n) {
		case 0: {
			nowPlayer.setNextField(22);
			field.Field field = Main.getGameScene().getBoard().getFields().get(22);
			Asset asset = (Asset) field.getActionable();
			if (asset.owner != null && asset.owner != nowPlayer) {
				showPayAndAddInformation(asset, nowPlayer, 1400);
				if (nowPlayer.getMoney() >= 1400) {
					nowPlayer.payMoney(1400);
					asset.owner.addMoney(1400);
				} else {
					asset.owner.addMoney(1400);
					LogicGame.goodByeMyFriend(nowPlayer);
				}
			}
			break;
		}
		case 1: {
			showAddInformation(nowPlayer, 200);
			nowPlayer.addMoney(200);
			nowPlayer.setNextField(1);
			break;
		}
		case 2: {
			showAddInformation(nowPlayer, 1000);
			nowPlayer.addMoney(1000);
			break;
		}
		case 3: {
			nowPlayer.setNextField(11);
			field.Field field = Main.getGameScene().getBoard().getFields().get(11);
			Asset asset = (Asset) field.getActionable();
			if (asset.owner != null && asset.owner != nowPlayer) {
				showPayAndAddInformation(asset, nowPlayer, 1300);
				if (nowPlayer.getMoney() >= 1300) {
					nowPlayer.payMoney(1300);
					asset.owner.addMoney(1300);
				} else {
					asset.owner.addMoney(1300);
					LogicGame.goodByeMyFriend(nowPlayer);
				}
			}
			break;
		}
		case 4: {
			showPayInformation(nowPlayer, 4000);
			nowPlayer.setNextField(17);
			if (nowPlayer.getMoney() >= 4000) {
				nowPlayer.payMoney(4000);
			} else {
				LogicGame.goodByeMyFriend(nowPlayer);
			}
			break;
		}
		case 5: {
			nowPlayer.setNextField(21);
			field.Field field = Main.getGameScene().getBoard().getFields().get(21);
			Asset asset = (Asset) field.getActionable();
			if (asset.owner != null && asset.owner != nowPlayer) {
				showPayAndAddInformation(asset, nowPlayer, 1200);
				if (nowPlayer.getMoney() >= 1200) {
					nowPlayer.payMoney(1200);
					asset.owner.addMoney(1200);
				} else {
					asset.owner.addMoney(1200);
					LogicGame.goodByeMyFriend(nowPlayer);
				}
			}
			break;
		}
		case 6: {
			showPayInformation(nowPlayer, 3500);
			if (nowPlayer.getMoney() >= 3500) {
				nowPlayer.payMoney(3500);
			} else {
				LogicGame.goodByeMyFriend(nowPlayer);
			}
			break;
		}
		case 7: {
			nowPlayer.setNextField(19);
			field.Field field = Main.getGameScene().getBoard().getFields().get(19);
			Asset asset = (Asset) field.getActionable();
			if (asset.owner != null && asset.owner != nowPlayer) {
				showPayAndAddInformation(asset, nowPlayer, 1250);
				if (nowPlayer.getMoney() >= 1250) {
					nowPlayer.payMoney(1250);
					asset.owner.addMoney(1250);
				} else {
					asset.owner.addMoney(1250);
					LogicGame.goodByeMyFriend(nowPlayer);
				}
			}
			break;
		}

		case 8: {
			nowPlayer.setNextField(11);
			field.Field field = Main.getGameScene().getBoard().getFields().get(11);
			Asset asset = (Asset) field.getActionable();
			if (asset.owner != null && asset.owner != nowPlayer) {
				showPayAndAddInformation(asset, nowPlayer, 400);
				if (nowPlayer.getMoney() >= 400) {
					nowPlayer.payMoney(400);
					asset.owner.addMoney(400);
				} else {
					asset.owner.addMoney(400);
					LogicGame.goodByeMyFriend(nowPlayer);
				}
			}
			break;
		}
		case 9: {
			nowPlayer.setNextField(20);
			field.Field field = Main.getGameScene().getBoard().getFields().get(20);
			Asset asset = (Asset) field.getActionable();
			if (asset.owner != null && asset.owner != nowPlayer) {
				showPayAndAddInformation(asset, nowPlayer, 300);
				if (nowPlayer.getMoney() >= 300) {
					nowPlayer.payMoney(300);
					asset.owner.addMoney(300);
				} else {
					asset.owner.addMoney(300);
					LogicGame.goodByeMyFriend(nowPlayer);
				}
			}
			break;
		}

		}
		return n;
	}

	public void showPayAndAddInformation(Asset asset, Player nowPlayer, int price) {
		int n = Main.getGameScene().getLogDisplay().getSize();
		double prevMoney = nowPlayer.getMoney();
		if (nowPlayer.getMoney() >= price) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setContentText(String.format("Player %s pays money to Player %s\n(%f -> %f).",
							nowPlayer.getName(), asset.getOwner().getName(), prevMoney, prevMoney - price));
					alert.setHeaderText(null);

					SharedObjectHolder.babyCrySound.play(LogicGame.getEffectSound() * LogicGame.getMainSound());

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				}
			});
			Main.getGameScene().getLogDisplay().add(String.format("%d: Player %s pays money to Player %s (%f -> %f).",
					n + 1, nowPlayer.getName(), asset.getOwner().getName(), prevMoney, prevMoney - price));
		} else {
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

	public void showPayInformation(Player nowPlayer, int price) {
		int n = Main.getGameScene().getLogDisplay().getSize();
		double prevMoney = nowPlayer.getMoney();
		if (nowPlayer.getMoney() >= price) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setContentText(String.format("Player %s pays %d\n(%f -> %f).", nowPlayer.getName(), price,
							prevMoney, prevMoney - price));
					alert.setHeaderText(null);

					SharedObjectHolder.babyCrySound.play(LogicGame.getEffectSound() * LogicGame.getMainSound());

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				}
			});
			Main.getGameScene().getLogDisplay().add(String.format("%d: Player %s pays %d (%f -> %f).", n + 1,
					nowPlayer.getName(), price, prevMoney, prevMoney - price));
		} else {
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

	public void showAddInformation(Player nowPlayer, int price) {
		int n = Main.getGameScene().getLogDisplay().getSize();
		double prevMoney = nowPlayer.getMoney();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setContentText(String.format("Player %s receives %d\n(%f -> %f).", nowPlayer.getName(), price,
						prevMoney, prevMoney + price));
				alert.setHeaderText(null);

				SharedObjectHolder.treasureSound.play(LogicGame.getEffectSound() * LogicGame.getMainSound());

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
				}
			}
		});
		Main.getGameScene().getLogDisplay().add(String.format("%d: Player %s receives %d (%f -> %f).", n + 1,
				nowPlayer.getName(), price, prevMoney, prevMoney + price));
	}
}
