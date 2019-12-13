package logic;

import java.util.Random;

public class Dice {
	public Dice() {

	}

	public static int roll() {
		Random rand = new Random();
		return 1 + rand.nextInt(6);

	}
}
