package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

	public Deck() {
	}

	private List<Integer> create() {
		int value = 1;

		Integer[] deck = new Integer[9];
		for (int i = 0; i < 9; i++, value++) {
			deck[i] = value;
		}

		return Arrays.asList(deck);
	}

	private List<Integer> shuffle(List<Integer> deck) {
		Collections.shuffle(deck);
		return deck;
	}

	public int[] draw() {
		List<Integer> deck = shuffle(create());

		int[] numbers = new int[3];
		for (int i = 0; i < 3; i++) {
			numbers[i] = deck.get(i);
		}

		return numbers;
	}

}
