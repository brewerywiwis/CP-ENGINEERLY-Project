package logic;

import java.util.Optional;

import application.Main;
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

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int n = Main.getGameScene().getLogDisplay().getSize();
					Main.getGameScene().getLogDisplay()
							.add(String.format("%d: Player %s is getting Chance Card.", n + 1, nowPlayer.getName()));
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText("Player " + nowPlayer.getName() + " get Chance Card.");
					alert.setContentText(null);

					//
					ImageView img = new ImageView(SharedObjectHolder.chanceCardV);
					img.setFitHeight(300);
					img.setFitWidth(200);
					alert.getDialogPane().setGraphic(img);
					//

					SharedObjectHolder.fairySound.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						SharedObjectHolder.buttonLight.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
					}
				}
			});

			drawAndEffect();
		}
	}

	@Override
	public int drawAndEffect() {
		// TODO Auto-generated method stub
		System.out.println("DO CHANCE CARD DRAW");
		int n = this.pickCard();
		// prepare for implement effect each effect card
		switch (n) {
//		case 0: {
//			LogicGame.getNowPlayer().payMoney(1400);
//			LogicGame.getNowPlayer().setNextField(6);
//			break;
//		}
//		case 1: {
//			LogicGame.getNowPlayer().addMoney(200);
//			break;
//		}
//		case 2: {
//			LogicGame.getNowPlayer().addMoney(1000);
//			break;
//		}
//		case 3: {
//			LogicGame.getNowPlayer().payMoney(1300);
//			break;
//		}
//		case 4: {
//			LogicGame.getNowPlayer().payMoney(4000);
//			break;
//		}
//		case 5: {
//			LogicGame.getNowPlayer().payMoney(1200);
//			break;
//		}
//		case 6: {
//			LogicGame.getNowPlayer().payMoney(3500);
//			break;
//		}
//		case 7: {
//			LogicGame.getNowPlayer().payMoney(1250);
//			break;
//		}
//
//		case 8: {
//			LogicGame.getNowPlayer().payMoney(1250);
//			break;
//		}
//		case 9: {
//			LogicGame.getNowPlayer().payMoney(300);
//			break;
//		}
		}
		return n;
	}
}
