package logic;

public class House extends Building {
	
	private HouseSize size;

	public House(String name, Double price, Double toll, HouseSize size) {
		super(name, price, toll);
		this.size = size;
	}

	@Override
	public boolean buyFrom(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSell() {
		// TODO Auto-generated method stub
		return false;
	}

}
