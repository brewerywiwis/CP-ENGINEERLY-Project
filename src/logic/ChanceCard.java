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
		Player nowPlayer = LogicGame.getPlayers().get(LogicGame.getTurnPlayer());
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
//					alert.setContentText(
//							"Player " + nowPlayer.getName() + " get card with " + drawAndEffect() + " number.");
					alert.setHeaderText("Player " + nowPlayer.getName() + " get Chance Card.");
					alert.setContentText(null);
					//
					ImageView img = new ImageView(SharedObjectHolder.chanceCardV);
					img.setFitHeight(300);
					img.setFitWidth(200);
					alert.getDialogPane().setGraphic(img);
					//

					SharedObjectHolder.fairySound.play();
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						SharedObjectHolder.buttonLight.play();
					}
					drawAndEffect();
				}
			});

		}
	}

	@Override
	public int drawAndEffect() {
		// TODO Auto-generated method stub
		System.out.println("DO CHANCE CARD DRAW");
		int n = this.pickCard();
		// prepare for implement effect each effect card
		switch (n) {
		case 0: {
			logic.LogicGame.getNowPlayer().payMoney(1400);
			logic.LogicGame.getNowPlayer().setNextField(6);
			break;
		}
		case 1: {
			logic.LogicGame.getNowPlayer().addMoney(200);
			break;
		}
		case 2: {
			logic.LogicGame.getNowPlayer().addMoney(1000);
			break;
		}
		case 3: {
			logic.LogicGame.getNowPlayer().payMoney(1300);
			break;
		}
		case 4: {
			logic.LogicGame.getNowPlayer().payMoney(4000);
			break;
		}
		case 5: {
			logic.LogicGame.getNowPlayer().payMoney(1200);
			break;
		}
		case 6: {
			logic.LogicGame.getNowPlayer().payMoney(3500);
			break;
		}
		case 7: {
			logic.LogicGame.getNowPlayer().payMoney(1250);
			break;
		}
		
		case 8: {
			logic.LogicGame.getNowPlayer().payMoney(1250);
			break;
		}
		case 9: {
			logic.LogicGame.getNowPlayer().payMoney(300);
			break;
		}
		}
		return n;
	}
}
