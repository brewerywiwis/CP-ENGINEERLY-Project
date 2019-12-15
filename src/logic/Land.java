package logic;

public class Land extends Asset {

	private int houses;
	private int hotel;

	public Land(String name, int price) {
		super(name, price);
		this.houses = 0;
		this.hotel = 0;
		this.owner = null;
	}

	public int getHouses() {
		return houses;
	}

	public int getHotel() {
		return hotel;
	}

	@Override
	public boolean buyFrom(Player p) {
		// TODO Auto-generated method stub
		if (p.getMoney() >= this.price) {
			p.payMoney(this.price);
			p.addAsset(this);
			setOwner(p);
			return true;
		}
		return false;
	}

	@Override
	public boolean payFrom(Player p) {
		// TODO Auto-generated method stub
		double price = calPrice();
		if (p.getMoney() >= price) {
			p.payMoney(price);
			owner.addMoney(price);
			return true;
		} else {
			owner.addMoney(price);
			LogicGame.goodByeMyFriend(p);
			return false;
		}
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub

	}

}
