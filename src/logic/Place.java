package logic;

public abstract class Place {
	private String name;
	private double price;
	private double toll;
	private Player owner;

	public Place(String name, Double price, Double toll) {
		this.name = name;
		this.price = price;
		this.toll = toll;
		this.owner = null;
	}

	public abstract boolean buyFrom(Player p);

	public abstract boolean canSell();

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public double getToll() {
		return toll;
	}

}
