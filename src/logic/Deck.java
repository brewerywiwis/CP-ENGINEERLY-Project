package logic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public abstract class Deck implements Actionable {

	private Queue<Integer> deck;
	private final int numCard = 10;

	public Deck() {
		resetDeck();
	}

	public void resetDeck() {
		deck = createDeck();
		shuffle();
	}

	// if deck non empty return int of card, return -99
	public int pickCard() {
		if (!deck.isEmpty()) {
			int numCard = deck.poll();
			deck.add(numCard);
			return numCard;
		} else {
			return -99;
		}
	}

	public void shuffle() {

//		Queue<Integer> newDeck = new LinkedList<Integer>();
		if (!deck.isEmpty()) {
			Integer[] sequence = new Integer[deck.size()];
			int n = deck.size();

			for (int i = 0; i < n; i++) {
				sequence[i] = deck.poll();
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
				deck.add(sequence[i]);
			}
		}

	}

	private Queue<Integer> createDeck() {
		Queue<Integer> newDeck = new LinkedList<Integer>();
		for (int i = 0; i < numCard; i++) {
			newDeck.add(i);
		}
		return newDeck;
	}

	public void showCard() {
		int n = deck.size();
		for (int i = 0; i < n; i++) {
			int ans = deck.poll();
			System.out.println(ans);
			deck.add(ans);
		}
	}

	public abstract int drawAndEffect();
}
