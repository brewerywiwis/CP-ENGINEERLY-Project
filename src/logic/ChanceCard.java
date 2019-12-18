package logic;

import java.util.Optional;

import application.Main;
import field.Field;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
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
			int cardNumber = drawAndEffect();
			System.out.println(cardNumber);
			
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(
							"Player " + nowPlayer.getName() + " get Chance Card with " + cardNumber + " number.");
					alert.setContentText(null);
					
					Image cardImage = null;
					if (cardNumber == 0) {
						cardImage = SharedObjectHolder.chance0;
					} else if (cardNumber == 1) {
						cardImage = SharedObjectHolder.chance1;
					} else if (cardNumber == 2) {
						cardImage = SharedObjectHolder.chance2;
					} else if (cardNumber == 3) {
						cardImage = SharedObjectHolder.chance3;
					} else if (cardNumber == 4) {
						cardImage = SharedObjectHolder.chance4;
					} else if (cardNumber == 5) {
						cardImage = SharedObjectHolder.chance5;
					} else if (cardNumber == 6) {
						cardImage = SharedObjectHolder.chance6;
					} else if (cardNumber == 7) {
						cardImage = SharedObjectHolder.chance7;
					} else if (cardNumber == 8) {
						cardImage = SharedObjectHolder.chance8;
					} else if (cardNumber == 9) {
						cardImage = SharedObjectHolder.chance9;
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
				}
			}
			break;
		}
		case 4: {
			nowPlayer.setNextField(17);
			field.Field field = Main.getGameScene().getBoard().getFields().get(17);
			Asset asset = (Asset) field.getActionable();
			showPayInformation(asset, nowPlayer, 4000);
			if (nowPlayer.getMoney() >= 4000) {
				nowPlayer.payMoney(4000);
			}else if (asset.getOwner() == null || nowPlayer==asset.owner || (asset.getOwner()!=null && nowPlayer.getMoney() >= asset.getPrice())){
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
				}
			}
			break;
		}
		case 6: {
			showPayInformation(null,nowPlayer, 3500);
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
				}
			}
			break;
		}

		}
		return n;
	}
}
