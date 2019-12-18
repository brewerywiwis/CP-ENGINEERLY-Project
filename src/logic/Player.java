package logic;

import java.util.ArrayList;
import java.util.Optional;
import application.Main;
import field.Field;
import field.HLandField;
import field.VLandField;
import gameScene.BoardPane;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import sharedObject.SharedObjectHolder;

public class Player extends ImageView implements Actionable {

	private ArrayList<Asset> assets;
	private String name;
	private int money;
	private Color color;
	private int currentField;
	private int nextField;
	private double centerPx;
	private double centerPy;
	private int notMoveCount;
	private boolean isBankrupt;

	public Player(String name, int money, Color color, Image img) {
		this.name = name;
		this.money = money;
		this.color = color;
		this.notMoveCount = 0;
		isBankrupt = false;
		setFitHeight(60);
		setFitWidth(33);
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

		Field field = Main.getGameScene().getBoard().getFields().get(getCurrentField());
		if (currentField == nextField) {
			if (field instanceof HLandField || field instanceof VLandField) {
				// doAction for Asset class
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
													"%d: Player %s can not buy %s because not have enough money.",
													n + 1, player.getName(), asset.getName()));

									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Information Dialog");
									alert.setContentText("Sorry, your money is not enough to buy this field. T-T");
									alert.setHeaderText(null);
									SharedObjectHolder.alertSound
											.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
									Optional<ButtonType> result = alert.showAndWait();
									if (result.get() == ButtonType.OK) {
										SharedObjectHolder.buttonLight
												.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
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
									alert.setHeaderText(String.format("Do you want to buy %s?", asset.getName()));
									alert.setContentText(null);
									SharedObjectHolder.alertSound
											.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
									((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("BUY");
									((Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("LATER");

									Optional<ButtonType> result = alert.showAndWait();
									if (result.get() == ButtonType.OK) {
										// ... user chose OK
										SharedObjectHolder.buttonLight
												.play(LogicGame.getEffectSound() * LogicGame.getMainSound());

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
													.add(String.format("%d: Player %s buy %s unsuccessfully.", n + 1,
															getName(), asset.getName()));

										}
									} else {
										// not buy
										SharedObjectHolder.buttonLight
												.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
									}
								}
							});
						}

					} else if (asset.getOwner() != this) {

						int n = Main.getGameScene().getLogDisplay().getSize();
						int prevMoney = this.getMoney();
						Player nowPlayer = this;
						if (asset.payFrom(nowPlayer)) {
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Information Dialog");
									alert.setContentText(String.format("Player %s pays tax to Player %s\n(%d -> %d).",
											getName(), asset.getOwner().getName(), prevMoney, getMoney()));
									alert.setHeaderText(null);

									SharedObjectHolder.babyCrySound
											.play(LogicGame.getEffectSound() * LogicGame.getMainSound());

									Optional<ButtonType> result = alert.showAndWait();
									if (result.get() == ButtonType.OK) {
										SharedObjectHolder.buttonLight
												.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
									}
								}
							});
							Main.getGameScene().getLogDisplay()
									.add(String.format("%d: Player %s pays tax to Player %s (%d -> %d).", n + 1,
											getName(), asset.getOwner().getName(), prevMoney, getMoney()));
						} else {
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.setTitle("Information Dialog");
									alert.setHeaderText(null);
									alert.setContentText(String.format("Player %s is bankrupt!", player.getName()));

									Optional<ButtonType> result = alert.showAndWait();
									if (result.get() == ButtonType.OK) {
										SharedObjectHolder.buttonLight
												.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
									}
								}
							});
							Main.getGameScene().getLogDisplay()
									.add(String.format("%d: Player %s is bankrupt.", n + 1, getName()));

						}
					} else if (asset.getOwner() == this) {
						// buy washer and gear
					}
					// doAction for Actionable
				} else if (field.getActionable() instanceof Deck) {
					int n = Main.getGameScene().getLogDisplay().getSize();
//					field.getActionable().doAction();
					
					if (player.isBankrupt) {

						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Information Dialog");
								alert.setHeaderText(null);
								alert.setContentText(String.format("Player %s is bankrupt!", player.getName()));

								Optional<ButtonType> result = alert.showAndWait();
								if (result.get() == ButtonType.OK) {
									SharedObjectHolder.buttonLight
											.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
								}
							}
						});

						Main.getGameScene().getLogDisplay()
								.add(String.format("%d: Player %s is bankrupt.", n + 1, getName()));
					}
				}
			} else {
				int n = Main.getGameScene().getLogDisplay().getSize();
				field.getActionable().doAction();
				if (player.isBankrupt) {

					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Information Dialog");
							alert.setHeaderText(null);
							alert.setContentText(String.format("Player %s is bankrupt!", player.getName()));

							Optional<ButtonType> result = alert.showAndWait();
							if (result.get() == ButtonType.OK) {
								SharedObjectHolder.buttonLight
										.play(LogicGame.getEffectSound() * LogicGame.getMainSound());
							}
						}
					});

					Main.getGameScene().getLogDisplay()
							.add(String.format("%d: Player %s is bankrupt.", n + 1, getName()));
				}

			}
		}
	}

	public void addMoney(int money) {
		this.money = (this.money + money >= 0) ? this.money + money : 0;
	}

	public void payMoney(int money) {
		this.money = (this.money - money >= 0) ? this.money - money : 0;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void addAsset(Asset asset) {
		assets.add(asset);
	}

	public ArrayList<Asset> getAssets() {
		return assets;
	}

	public int getMoney() {
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

	public boolean isBankrupt() {
		return isBankrupt;
	}

	public void setBankrupt(boolean isBankrupt) {
		this.isBankrupt = isBankrupt;
	}

}
