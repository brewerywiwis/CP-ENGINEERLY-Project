package logic;

public abstract class Asset implements Actionable {

	private String name;
	private int price;

	public Asset(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public abstract boolean buyFrom(Player p);
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public void calPrice() {
		//implement calculate of price(invoke by doAction)
	}
}
