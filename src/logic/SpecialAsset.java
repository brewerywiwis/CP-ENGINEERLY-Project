package logic;

public class SpecialAsset implements Actionable {

	private String name;
	private int type;

	public SpecialAsset(String name, int typeAsset) {
		this.name = name;
		this.type = typeAsset;
	}

	@Override
	public void doAction() {
		Player nowPlayer = LogicGame.getNowPlayer();
		switch (type) {
		// case 1: when player pass start point, add money to player
		case 1: {
			nowPlayer.addMoney(500);
			break;
		}
		// case 2:living in registration room for 2 turn
		case 2: {
			if (nowPlayer.getCurrentField() == nowPlayer.getNextField())
				nowPlayer.setNotMoveCount(2);
			break;
		}
		// case 3: nothing happen when pass or go into the field
		case 3: {
			if (nowPlayer.getCurrentField() == nowPlayer.getNextField())
				break;
		}
		// case 4: forcing player to go to registration room
		case 4: {
			if (nowPlayer.getCurrentField() == nowPlayer.getNextField()) {
				nowPlayer.setNextField(6);
			}
			break;
		}
		}
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

}
