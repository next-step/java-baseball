package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Deck {

	public static final int SIZE = 3;

	private static final int BEGIN = 1;
	private static final int END = 10;

	private List<Integer> deck;

	private Deck(List<Integer> deck) {
		this.deck = deck;
	}

	public static Deck createRandomDeck() {
		List<Integer> deck = draw();
		return new Deck(deck);
	}

	public static Deck createCustomDeck(List<Integer> deck) {
		return new Deck(deck);
	}

	public List<Integer> numbers() {
		return this.deck;
	}

	public static List<Integer> create() {
		List<Integer> digits = new ArrayList<>(END - BEGIN);
		for (int i = BEGIN; i < END; i++) {
			digits.add(i);
		}
		return digits;
	}

	public static void shuffle(List<Integer> digits) {
		Collections.shuffle(digits);
	}

	public static List<Integer> draw() {
		List<Integer> digits = create();
		shuffle(digits);
		return digits.subList(0, SIZE);
	}

}
