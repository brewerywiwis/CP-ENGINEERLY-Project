package logic;

import java.util.Optional;

import application.Main;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import sharedObject.IRenderableHolder;

public class SpecialAsset implements Actionable {

	private String name;
	private int type;

	public SpecialAsset(String name, int typeAsset) {
		this.name = name;
		this.type = typeAsset;
	}

	@Override
	public void doAction() {
		Player nowPlayer = LogicGame.getNowPlayer();
		switch (type) {
		// case 1: when player pass start point, add money to player
		case 1: {
			nowPlayer.addMoney(500);

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int n = Main.getGameScene().getLogDisplay().getSize();
					Main.getGameScene().getLogDisplay().add(
							String.format("%d: Player %s get 500 money from start point.", n + 1, nowPlayer.getName()));
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Player " + nowPlayer.getName() + " get 500 money from start point");
					IRenderableHolder.treasureSound.play();
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						IRenderableHolder.buttonLight.play();
					}
				}
			});

			break;
		}
		// case 2:living in registration room for 2 turn
		case 2: {
			if (nowPlayer.getCurrentField() == nowPlayer.getNextField()) {
				nowPlayer.setNotMoveCount(2);

				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						int n = Main.getGameScene().getLogDisplay().getSize();
						Main.getGameScene().getLogDisplay()
								.add(String.format("%d: Player %s is in registration room that can not move 2 turn.",
										n + 1, nowPlayer.getName()));
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Dialog");
						alert.setHeaderText(null);
						alert.setContentText("Player " + nowPlayer.getName() + " can not move for 2 turn");
						IRenderableHolder.alertSound.play();
						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK) {
							IRenderableHolder.buttonLight.play();
						}
					}
				});

			}
			break;
		}
		// case 3: nothing happen when pass or go into the field
		case 3: {
			if (nowPlayer.getCurrentField() == nowPlayer.getNextField())
				break;
		}
		// case 4: forcing player to go to registration room
		case 4: {
			if (nowPlayer.getCurrentField() == nowPlayer.getNextField()) {
				nowPlayer.setNextField(6);

				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						int n = Main.getGameScene().getLogDisplay().getSize();
						Main.getGameScene().getLogDisplay().add(String
								.format("%d: Player %s is going to registration room.", n + 1, nowPlayer.getName()));
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Dialog");
						alert.setHeaderText(null);
						alert.setContentText("Now, Player " + nowPlayer.getName()
								+ " go to registration room and can not move for 2 turn");
						IRenderableHolder.manPointLOLSound.play();
						Optional<ButtonType> result = alert.showAndWait();
						if (result.get() == ButtonType.OK) {
							IRenderableHolder.buttonLight.play();
						}
					}
				});

			}
			break;
		}
		}
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

}
