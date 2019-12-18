package logic;

import java.util.Optional;

import application.Main;
import field.Field;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sharedObject.SharedObjectHolder;

public class CommunityChest extends Deck {

	public CommunityChest() {
		super();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		Player nowPlayer = LogicGame.getNowPlayer();
		if (nowPlayer.getCurrentField() == nowPlayer.getNextField()) {
			int n = Main.getGameScene().getLogDisplay().getSize();
			Main.getGameScene().getLogDisplay()
					.add(String.format("%d: Player %s is getting Community Chest card.", n + 1, nowPlayer.getName()));
			int cardNumber = drawAndEffect();
			System.out.println(cardNumber);
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText("Player " + nowPlayer.getName() + " get card with " + cardNumber + " number.");
					alert.setContentText(null);

					//
					Image cardImage = null;
					if (cardNumber == 0) {
						cardImage = SharedObjectHolder.chest0;
					} else if (cardNumber == 1) {
						cardImage = SharedObjectHolder.chest1;
					} else if (cardNumber == 2) {
						cardImage = SharedObjectHolder.chest2;
					} else if (cardNumber == 3) {
						cardImage = SharedObjectHolder.chest3;
					} else if (cardNumber == 4) {
						cardImage = SharedObjectHolder.chest4;
					} else if (cardNumber == 5) {
						cardImage = SharedObjectHolder.chest5;
					} else if (cardNumber == 6) {
						cardImage = SharedObjectHolder.chest6;
					} else if (cardNumber == 7) {
						cardImage = SharedObjectHolder.chest7;
					} else if (cardNumber == 8) {
						cardImage = SharedObjectHolder.chest8;
					} else if (cardNumber == 9) {
						cardImage = SharedObjectHolder.chest9;
					}
					ImageView img = new ImageView(cardImage);
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

		}
	}

	@Override
	public int drawAndEffect() {
		// TODO Auto-generated method stub
		System.out.println("DO COMMUNITY CHEST DRAW");
		Player nowPlayer = LogicGame.getNowPlayer();
		int n = this.pickCard();
		// prepare for implement effect each effect card
		switch (n) {
		case 0: {
			nowPlayer.setNextField(15);
			field.Field field = Main.getGameScene().getBoard().getFields().get(15);
			Asset asset = (Asset) field.getActionable();
			if (asset.owner != null && asset.owner != nowPlayer) {
				showPayAndAddInformation(asset, nowPlayer, 160);
				if (nowPlayer.getMoney() >= 160) {
					nowPlayer.payMoney(160);
					asset.owner.addMoney(160);
				} else {
					asset.owner.addMoney(160);
				}
			}
			break;
		}
		case 1: {
			nowPlayer.setNextField(11);
			field.Field field = Main.getGameScene().getBoard().getFields().get(11);
			Asset asset = (Asset) field.getActionable();
			if (asset.owner != null && asset.owner != nowPlayer) {
				showPayAndAddInformation(asset, nowPlayer, 100);
				if (nowPlayer.getMoney() >= 100) {
					nowPlayer.payMoney(100);
					asset.owner.addMoney(100);
				} else {
					asset.owner.addMoney(100);
				}
			}
			break;
		}
		case 2: {
			nowPlayer.moveTo(4);
			break;
		}
		case 3: {
			nowPlayer.moveTo(2);
			break;
		}
		case 4: {
			nowPlayer.moveTo(3);
			break;
		}
		case 5: {
			nowPlayer.setNextField(6);
			break;
		}
		case 6: {
			showAddInformation(nowPlayer, 1000);
			nowPlayer.addMoney(1000);
			break;
		}
		case 7: {
			showAddInformation(nowPlayer, 1000);
			nowPlayer.addMoney(1000);
			break;
		}
		case 8: {
			nowPlayer.setNextField(22);
			Field field = Main.getGameScene().getBoard().getFields().get(22);
			Asset asset = (Asset) field.getActionable();
			if (asset.owner != null && asset.owner != nowPlayer) {
				showPayAndAddInformation(asset, nowPlayer, 120);
				if (nowPlayer.getMoney() >= 120) {
					nowPlayer.payMoney(120);
					asset.owner.addMoney(120);
				} else {
					asset.owner.addMoney(120);
				}
			}
			break;
		}
		case 9: {
			nowPlayer.setNextField(19);
			Field field = Main.getGameScene().getBoard().getFields().get(19);
			Asset asset = (Asset) field.getActionable();
			if (asset.owner != null && asset.owner != nowPlayer) {
				showPayAndAddInformation(asset, nowPlayer, 150);
				if (nowPlayer.getMoney() >= 150) {
					nowPlayer.payMoney(150);
					asset.owner.addMoney(150);
				} else {
					asset.owner.addMoney(150);
				}
			}
			break;
		}
		}
		return n;
	}
}
