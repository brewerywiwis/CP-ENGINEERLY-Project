package logic;

import java.util.Random;

public class Dice {
	public Dice() {

	}

	public static int roll() {
		Random rand = new Random();
		int n = 1 + rand.nextInt(6);
		n += 1 + rand.nextInt(6);
		n += 1 + rand.nextInt(6);
		n += 1 + rand.nextInt(6);

		return n % 5 + 1;
	}
}
