package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import application.Main;
import field.Field;
import field.HLandField;
import field.VLandField;
import gameScene.BoardPane;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sharedObject.IRenderableHolder;

public class Player extends ImageView implements Actionable {

	private ArrayList<Asset> assets;
	private String name;
	private double money;
	private Color color;
	private int currentField;
	private int nextField;
	private double centerPx;
	private double centerPy;
	private int notMoveCount;

	public Player(String name, double money, Color color, Image img) {
		this.name = name;
		this.money = money;
		this.color = color;
		this.notMoveCount = 0;
		setImage(img);
		Bounds playerBound = this.localToScene(this.getBoundsInLocal());
		centerPx = playerBound.getWidth() / 2;
		centerPy = playerBound.getHeight() / 2;
		currentField = 0;
		nextField = 0;
		assets = new ArrayList<Asset>();
	}

	public boolean buy(Asset asset) {
		return asset.buyFrom(this);
	}

	public void moveTo(int numOfSquare) {
		setNextField((currentField + numOfSquare) % BoardPane.getNumoffield());
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		Player player = this;

		// doAction for Actionable
		Main.getGameScene().getBoard().getFields().get(getCurrentField()).doAction();

		// doAction for Asset class
		Field field = Main.getGameScene().getBoard().getFields().get(getCurrentField());
		if (currentField == nextField && (field instanceof HLandField || field instanceof VLandField)) {
			if (field.getActionable() instanceof Asset) {
				Asset asset = (Asset) field.getActionable();
				if (asset.canBuy()) {
					if (getMoney() < asset.price) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								int n = Main.getGameScene().getLogDisplay().getSize();

								Main.getGameScene().getLogDisplay()
										.add(String.format(
												"%d: Player %s can not buy %s because not have enough money .", n + 1,
												player.getName(), asset.getName()));

								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Information Dialog");
								alert.setContentText("Sorry, your money is not enough to buy this field. T-T");
								alert.setHeaderText(null);
								IRenderableHolder.alertSound.play();
								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									IRenderableHolder.buttonLight.play();
								}
							}
						});
					} else {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.setTitle("Confirmation Dialog");
								alert.setHeaderText("Do you want to buy this field?");
								alert.setContentText(null);
								IRenderableHolder.alertSound.play();
								((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("BUY");
								((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("LATER");

								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									// ... user chose OK
									IRenderableHolder.buttonLight.play();

									int n = Main.getGameScene().getLogDisplay().getSize();
									if (asset.buyFrom(player)) {

										if (field instanceof HLandField) {
											HLandField hLandField = (HLandField) field;
											hLandField.setOwnerColor();
										} else if (field instanceof VLandField) {
											VLandField vLandField = (VLandField) field;
											vLandField.setOwnerColor();
										}

										Main.getGameScene().getLogDisplay()
												.add(String.format("%d: Player %s buy %s successfully.", n + 1,
														getName(), asset.getName()));
										Main.getGameScene().update();

									} else {

										Main.getGameScene().getLogDisplay()
												.add(String.format("%d: Player %s is buying %s unsuccessfully.", n + 1,
														getName(), asset.getName()));

									}
								} else {
									// not buy
									IRenderableHolder.buttonLight.play();
								}
							}
						});
					}

				} else if (asset.getOwner() != this) {
					int n = Main.getGameScene().getLogDisplay().getSize();
					double prevMoney = this.getMoney();
					if (asset.payFrom(this)) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Information Dialog");
								alert.setContentText(String.format("Player %s pays tax to Player %s\n(%f -> %f).",
										getName(), asset.getOwner().getName(), prevMoney, getMoney()));
								alert.setHeaderText(null);

								IRenderableHolder.babyCrySound.play();

								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									IRenderableHolder.buttonLight.play();
								}
							}
						});
						Main.getGameScene().getLogDisplay()
								.add(String.format("%d: Player %s pays tax to Player %s (%f -> %f).", n + 1, getName(),
										asset.getOwner().getName(), prevMoney, getMoney()));
					} else {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Information Dialog");
								alert.setHeaderText(null);
								alert.setContentText(String.format("Player %s is bankrupt!", player.getName()));
								IRenderableHolder.alertSound.play();

								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									IRenderableHolder.buttonLight.play();
								}
							}
						});
						Main.getGameScene().getLogDisplay()
								.add(String.format("%d: Player %s is bankrupt.", n + 1, getName()));

					}
				} else if (asset.getOwner() == this) {
					// buy washer and gear
				}
			}
		}

	}

	public void addMoney(double money) {
		this.money = (this.money + money >= 0) ? this.money + money : 0;
	}

	public void payMoney(double money) {
		this.money = (this.money - money >= 0) ? this.money - money : 0;
	}

	public void addAsset(Asset asset) {
		assets.add(asset);
	}

	public ArrayList<Asset> getAssets() {
		return assets;
	}

	public double getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public int getCurrentField() {
		return currentField;
	}

	public void setCurrentField(int currentField) {
		this.currentField = currentField;
	}

	public int getNextField() {
		return nextField;
	}

	public void setNextField(int nextField) {
		this.nextField = nextField;
	}

	public double getCenterPx() {
		return centerPx;
	}

	public double getCenterPy() {
		return centerPy;
	}

	public int getNotMoveCount() {
		return notMoveCount;
	}

	public void setNotMoveCount(int notMoveCount) {
		this.notMoveCount = notMoveCount >= 0 ? notMoveCount : 0;
	}

	public boolean isMove() {
		return notMoveCount > 0 ? false : true;
	}

	public Color getColor() {
		return color;
	}

}
