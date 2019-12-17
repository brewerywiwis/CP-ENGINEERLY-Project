package logic;

import java.util.Optional;

import application.Main;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import sharedObject.SharedObjectHolder;

public class CommunityChest extends Deck {

	public CommunityChest() {
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
							.add(String.format("%d: Player %s is getting card with %d number.", n + 1,
									nowPlayer.getName(), drawAndEffect()));
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
//					alert.setContentText(
//							"Player " + nowPlayer.getName() + " get card with " + drawAndEffect() + " number.");
					alert.setHeaderText(
							"Player " + nowPlayer.getName() + " get card with " + drawAndEffect() + " number.");
					alert.setContentText(null);
					ImageView img = new ImageView(SharedObjectHolder.chanceCardV);
					img.setFitHeight(300);
					img.setFitWidth(200);
					alert.getDialogPane().setGraphic(img);
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
		int n = this.pickCard();
		// prepare for implement effect each effect card
		switch (n) {
		case 0: {
			///
			break;
		}
		case 1: {
			///
			break;
		}
		}
		return n;
	}

}
