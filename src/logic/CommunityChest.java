package logic;

public class CommunityChest extends Deck {

	public CommunityChest() {
		super();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		System.out.println("You are getting card with " + drawAndEffect() + " number.");

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
