package logic;

public class ChanceCard extends Deck {

	public ChanceCard() {
		super();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		System.out.println("You are getting card with " + drawAndEffect() + " number.");
//		System.out.println("PLAYER is in ChanceCard field");
	}

	@Override
	public int drawAndEffect() {
		// TODO Auto-generated method stub
		int n = this.pickCard();
		// prepare for implement effect each effect card
		switch (n) {
		case 0: {
			///
			break;
		}
		case 1: {
			///
			break;
		}
		}
		return n;
	}
}
