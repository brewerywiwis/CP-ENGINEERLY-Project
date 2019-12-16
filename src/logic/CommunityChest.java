package logic;

import application.Main;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
					alert.setContentText(
							"Player " + nowPlayer.getName() + " get card with " + drawAndEffect() + " number.");
					alert.showAndWait();
				}
			});

		}
	}

	@Override
	public int drawAndEffect() {
		// TODO Auto-generated method stub
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
