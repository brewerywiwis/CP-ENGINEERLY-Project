package logic;

public class Land extends Asset {

	public Land(String name, int price) {
		super(name, price);
		this.owner = null;
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
		int price = calPrice();
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
