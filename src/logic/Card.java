package logic;

import java.util.Random;
import java.util.Stack;

public abstract class Card {

	private Stack<Integer> deck;
	private final int numCard = 10;

	public Card() {
		resetDeck();
	}

	public void resetDeck() {
		deck = new Stack<Integer>();

		Integer[] sequence = new Integer[numCard];
		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = i;
		}
		Random rand = new Random();

		for (int i = 0; i < numCard; i++) {

			// Random for remaining positions.
			int r = i + rand.nextInt(numCard - i);

			// swapping the elements
			int temp = sequence[r];
			sequence[r] = sequence[i];
			sequence[i] = temp;
		}

		for (int i = 0; i < sequence.length; i++) {
			deck.push(sequence[i]);
		}

		// test shuffle deck//
//		while(!deck.empty()) {
//			System.out.println(deck.pop());
//		}

	}

	// if deck non empty return int of card, return -99
	public int pickCard() {
		if (!deck.empty()) {
			return deck.pop();
		} else {
			return -99;
		}
	};

	public abstract void doEffect(int n);
}
