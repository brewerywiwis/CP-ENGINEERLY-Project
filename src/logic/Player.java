package logic;

import java.util.HashMap;

import field.Field;
import gameScene.BoardPane;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends ImageView {

	private static HashMap<Player, Integer> whereOfPlayer;
	private String name;
	private double money;
	private int turn;
	private int currentField;
	private int nextField;
	private double centerPx;
	private double centerPy;

	static {
		whereOfPlayer = new HashMap<Player, Integer>();
	}

	public Player(String name, double money, int turn, Image img) {
		this.name = name;
		this.money = money;
		this.turn = turn;
		setImage(img);
		Bounds playerBound = this.localToScene(this.getBoundsInLocal());
		centerPx = playerBound.getWidth() / 2;
		centerPy = playerBound.getHeight() / 2;
		currentField = 0;
		nextField = 0;
	}

	public boolean buy(Asset asset) {
		return asset.buyFrom(this);
	}

	public void moveTo(int numOfSquare) {
		setNextField((currentField + numOfSquare) % BoardPane.getNumoffield());
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public int getTurn() {
		return turn;
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

}
