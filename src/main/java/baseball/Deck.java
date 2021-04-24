package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Deck {

	// TODO: constant
	public final int begin = 1;
	public final int end = 10;

	public Deck() {
	}

	private List<Integer> create() {
		int value = begin;
		int size = end - begin;

		Integer[] deck = new Integer[size];
		for (int i = 0; i < size; i++, value++) {
			deck[i] = value;
		}

		return Arrays.asList(deck);
	}

	private List<Integer> shuffle(List<Integer> deck) {
		Collections.shuffle(deck);
		return deck;
	}

	public final int[] draw() {
		List<Integer> deck = shuffle(create());

		int[] numbers = new int[3];
		for (int i = 0; i < 3; i++) {
			numbers[i] = deck.get(i);
		}

		return numbers;
	}

}
