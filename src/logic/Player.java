package logic;

public class Player {
	private String name;
	private double money;
	private int turn;

	public Player(String name, Double money, int turn) {
		this.name = name;
		this.money = money;
		this.turn = turn;
	}

	public boolean buy(Asset asset) {
		return asset.buyFrom(this);
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
}
