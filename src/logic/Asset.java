package logic;

public abstract class Asset implements Actionable {

	protected String name;
	protected int price;
	protected Player owner;

	public Asset(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public abstract boolean buyFrom(Player p);

	public abstract boolean payFrom(Player p);

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int calPrice() {
		// implement calculate of price(invoke by doAction)
		return price;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public boolean canBuy() {
		return owner == null ? true : false;
	}
}
