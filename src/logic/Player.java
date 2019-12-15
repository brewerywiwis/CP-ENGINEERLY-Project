package logic;

import java.util.HashMap;

import application.Main;
import gameScene.BoardPane;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends ImageView implements Actionable {

	private static HashMap<Player, Integer> whereOfPlayer;
	private String name;
	private double money;
	private int currentField;
	private int nextField;
	private double centerPx;
	private double centerPy;
	private int notMoveCount;
//	private boolean
	static {
		whereOfPlayer = new HashMap<Player, Integer>();
	}

	public Player(String name, double money, Image img) {
		this.name = name;
		this.money = money;
		this.notMoveCount = 0;
		setImage(img);
		Bounds playerBound = this.localToScene(this.getBoundsInLocal());
		centerPx = playerBound.getWidth() / 2;
		centerPy = playerBound.getHeight() / 2;
		currentField = 0;
		nextField = 0;
		whereOfPlayer.put(this, currentField);
	}

	public boolean buy(Asset asset) {
		return asset.buyFrom(this);
	}

	public void moveTo(int numOfSquare) {
		setNextField((currentField + numOfSquare) % BoardPane.getNumoffield());
		changeField(numOfSquare);
	}

	public void changeField(int numOfSquare) {
		whereOfPlayer.put(this, (currentField + numOfSquare) % BoardPane.getNumoffield());
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		Main.getGameScene().getBoard().getFields().get(getCurrentField()).doAction();
	}

	public void addMoney(double money) {
		this.money = (this.money + money >= 0) ? this.money + money : 0;
	}

	public void payMoney(double money) {
		this.money = (this.money - money >= 0) ? this.money - money : 0;
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
}
