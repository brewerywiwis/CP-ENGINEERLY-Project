package logic;

public class House extends Building {

	public House(String name, Double price, Double toll) {
		super(name, price, toll);
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
