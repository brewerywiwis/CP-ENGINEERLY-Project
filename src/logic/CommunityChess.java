package logic;

public class CommunityChess extends Deck {

	public CommunityChess() {
		super();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		drawAndEffect();
	}

	@Override
	public void drawAndEffect() {
		// TODO Auto-generated method stub
		int n = this.pickCard();
		// prepare for implement effect each effect card
		switch (n) {
		case 0: {
			///
		}
		case 1: {
			///
		}
		}
	}

}
